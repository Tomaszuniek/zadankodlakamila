package com.example.demo;

import com.example.demo.controller.Controller;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = Controller.class)
class ZadankoApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void jsonTest()  throws Exception{
		Integer size = 10;
		MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/generate/json/{size}", size)).andDo(print()).andExpect(status().isOk()).andExpect(jsonPath("$", hasSize(size))).andReturn();
		String actualResponseBody = mvcResult.getResponse().getContentAsString();
		JSONParser parser = new JSONParser();
		JSONArray json = (JSONArray) parser.parse(actualResponseBody);
		assertThat(json).hasSize(size);
		System.out.println(actualResponseBody);

	}

	@Test
	public void endpoint1Test()  throws Exception{

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
	public void endpoint2Test()  throws Exception{

		String polecenia = "id_, type, longitude, latitude, name, fullName, chuj";

		MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/endpoint2/{polecenia}", polecenia)).andDo(print()).andExpect(status().isOk()).andReturn();

		String actualResponseBody2 = mvcResult.getResponse().getContentAsString();

		List<String> result2= Arrays.asList(actualResponseBody2.split(",|;"));

		List<String> resultPolecenie = Arrays.asList(polecenia.split(",|;"));

		for(int i = 0; i < resultPolecenie.size(); i++){
			assertThat(result2.get(i)).isEqualTo(resultPolecenie.get(i));
		}

		System.out.println(result2);

	}



}
