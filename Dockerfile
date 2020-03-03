FROM openjdk:8
ADD target/spring-docker-zadanko.jar spring-docker-zadanko.jar
EXPOSE 8085
ENTRYPOINT ["java", "-jar", "spring-docker-zadanko.jar"] 