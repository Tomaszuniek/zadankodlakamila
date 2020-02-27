package com.example.demo;

import com.example.demo.controller.Controller;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.Nested;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.util.NestedServletException;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = Controller.class)
class ZadankoApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void jsonTest() throws Exception{
		Integer size = 10;
		MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/generate/json/{size}", size)).andDo(print()).andExpect(status().isOk()).andExpect(jsonPath("$", hasSize(size))).andReturn();


	}

	@Test
	public void endpoint1Test()  throws Exception{
		this.mockMvc.perform(MockMvcRequestBuilders.get("/generate/json/{size}", 10)).andDo(print());
		MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/endpoint1")).andDo(print()).andExpect(status().isOk()).andReturn();
		String actualResponseBody = mvcResult.getResponse().getContentAsString();
		List<String> result = Arrays.asList(actualResponseBody.split("\\s*,\\s*"));
		assertThat(result.get(0)).isEqualTo("type");
		assertThat(result.get(1)).isEqualTo("_id");
		assertThat(result.get(2)).isEqualTo("name");
		assertThat(result.get(3)).isEqualTo("latitude");
		assertThat(result.get(4)).isEqualTo("longitude");
		System.out.println(result);

	}


	@Test
	public void endpoint2Test() throws Exception{
		this.mockMvc.perform(MockMvcRequestBuilders.get("/generate/json/{size}", 10)).andDo(print());
		String polecenia = "fullName,name,longitude,     latitude";
		polecenia = polecenia.replaceAll("\\s","");
		MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/endpoint2/{polecenia}", polecenia)).andDo(print()).andExpect(status().isOk()).andReturn();

		String actualResponseBody2 = mvcResult.getResponse().getContentAsString();

		List<String> result2= Arrays.asList(actualResponseBody2.split(","));

		List<String> resultPolecenie = Arrays.asList(polecenia.split(","));

		for(String a : result2){
			System.out.println(a);
		}

		/*for(String a : resultPolecenie){
			System.out.println(a);
		}*/

		for(int i = 0; i < resultPolecenie.size(); i++){
			assertThat(result2.get(i)).isEqualTo(resultPolecenie.get(i));
		}



	}

	@Test
	public void endpoint2Test2() throws  Exception{
		NestedServletException illegalArgumentException = Assertions.assertThrows(NestedServletException.class, () -> {
			this.mockMvc.perform(MockMvcRequestBuilders.get("/generate/json/{size}", 10)).andDo(print());
			String polecenia = "id_, type, longitude, latitude, name, fullName, chuj";
			polecenia = polecenia.replaceAll("\\s", "");
			MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/endpoint2/{polecenia}", polecenia)).andDo(print()).andExpect(status().isOk()).andReturn();

		});


		assertThat(illegalArgumentException.getCause().getClass()).isEqualTo(IllegalArgumentException.class);

	}
}
