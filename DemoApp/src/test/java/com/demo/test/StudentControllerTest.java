package com.demo.test;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.demo.controller.StudentController;
import com.demo.model.Student;
import com.demo.services.StudentService;


@RunWith(SpringRunner.class)
@WebMvcTest(value = StudentController.class)
@WithMockUser
public class StudentControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private StudentService studentService;

	@Test
	public void retrieveAllTest() throws Exception {
		List<Student> stuList = new ArrayList<Student>();
		Student s1 =new Student(2,"aravind",15,"aravind@gmail.com");
		stuList.add(s1);
		
		Mockito.when(studentService.getAll()).thenReturn(stuList);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/student/getall").accept(
				MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		System.out.println(result.getResponse());
		String expected = "[{\"id\":2,\"name\":\"aravind\",\"age\":15,\"emailAddress\":\"aravind@gmail.com\"}]";

		JSONAssert.assertEquals(expected, result.getResponse()
				.getContentAsString(), false);
	}

}