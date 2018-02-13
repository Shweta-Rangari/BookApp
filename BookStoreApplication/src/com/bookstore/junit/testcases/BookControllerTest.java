package com.bookstore.junit.testcases;

import java.io.File;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.http.MediaType;

import com.bookstore.model.Book;
import com.bookstore.utility.ApplicationConstants;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.response.Response;

@RunWith(JUnit4.class)

public class BookControllerTest {

	@Before
	public void setup() {
		RestAssured.baseURI = ApplicationConstants.BASE_URI;
	}

	@Test
	public void testSaveBook() throws Exception {

		Book dto = new Book();
		dto.setAuthors("AuthorName");
		dto.setCode("111");
		dto.setName("BookName");
		dto.setPrice("900");

		File dataFile = new File(ApplicationConstants.FILE_PATH);
		Response r = RestAssured.given().multiPart(dataFile).formParam(ApplicationConstants.NAME, dto.getName())
				.formParam(ApplicationConstants.AUTHOR, dto.getAuthors()).formParam(ApplicationConstants.CODE, dto.getCode())
				.formParam(ApplicationConstants.PUBLISHEDON, "09/02/2018").formParam(ApplicationConstants.PRICE, dto.getPrice())
				.contentType(MediaType.MULTIPART_FORM_DATA_VALUE).when().post(ApplicationConstants.SAVE_BOOK);

		String body = r.getBody().asString();
		System.out.println(body);

	}

	@Test
	public void testDeleteBook() throws Exception {
		String bookId = "5";
		Response r = RestAssured.when().delete("/delete/" + bookId);

		String body = r.getBody().asString();
		System.out.println(body);

	}

	@Test
	public void testGetBookList() throws Exception {

		Response r = RestAssured.when().get(ApplicationConstants.DEFAULT);
		String body = r.getBody().asString();
		System.out.println(body);

	}

	public byte[] converObjectToJson(Object obj) throws JsonProcessingException {

		ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsBytes(obj);
	}
}
