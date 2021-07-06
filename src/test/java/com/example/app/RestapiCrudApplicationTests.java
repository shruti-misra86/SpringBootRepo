package com.example.app;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.model.Student;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class RestapiCrudApplicationTests {
	@Autowired
	private MockMvc mockMvc;

	protected <T> T mapFromJson(String json, Class<T> clazz)
			throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.readValue(json, clazz);
	}

	protected String mapToJson(Object obj) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(obj);
	}

	/*
	 * @Test public void testGetName() throws Exception {
	 * mockMvc.perform(get("/getName")).andExpect(status().isOk()).andExpect(
	 * jsonPath("$.name").value("Shruti")); }
	 * 
	 * @Test public void testCreateStudent() throws Exception { String uri =
	 * "/saveStudent"; Student s = new Student();
	 * 
	 * s.setName("lila"); s.setCollegeName("xavier"); s.setCgpa(9.00); String
	 * inputJson = mapToJson(s); MvcResult mvcResult = mockMvc.perform(
	 * MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE
	 * ).content(inputJson)) .andReturn();
	 * 
	 * int status = mvcResult.getResponse().getStatus();
	 * System.out.println("status - " + status); assertEquals("200",
	 * String.valueOf(status));
	 * 
	 * String mssg = JsonPath.read(mvcResult.getResponse().getContentAsString(),
	 * "$.msg"); System.out.println("message - " + mssg); assertEquals(mssg,
	 * "success");
	 * 
	 * }
	 */
	@Test
	public void testGetStudent() throws Exception {
		String uri = "/getStudents";

		MvcResult mvcResult = mockMvc
				.perform(MockMvcRequestBuilders.get(uri).contentType(MediaType.APPLICATION_JSON_VALUE)).andReturn();

		int status = mvcResult.getResponse().getStatus();
		System.out.println("status - " + status);
		assertEquals("200", String.valueOf(status));
		String content = mvcResult.getResponse().getContentAsString();
		System.out.println(content);
		Student student[] = mapFromJson(content, Student[].class);
		assertTrue(student.length > 0);
	}

	@Test
	public void testGetStudentById() throws Exception {
		String uri = "/getStudent/5";

		MvcResult mvcResult = mockMvc
				.perform(MockMvcRequestBuilders.get(uri).contentType(MediaType.APPLICATION_JSON_VALUE)).andReturn();

		int status = mvcResult.getResponse().getStatus();
		System.out.println("status - " + status);
		assertEquals("200", String.valueOf(status));
		String content = mvcResult.getResponse().getContentAsString();
		System.out.println(content);
		String name = JsonPath.read(mvcResult.getResponse().getContentAsString(), "$.name");
		System.out.println("--" + name);
		assertEquals(name, "xyz");
	}

}
