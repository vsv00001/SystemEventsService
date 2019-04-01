package com.example.sysevents.controllers;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.sysevents.entity.SysEvent;
import com.example.sysevents.service.SysEventService;

@RunWith(SpringRunner.class)
@WebMvcTest
public class SysEventControllerTest {

	@Autowired
	MockMvc mockMvc;

	@MockBean
	SysEventService sysEventService;
		
			
	  @Test
	   public void list() throws Exception {
	      String uri = "/sysevent/";
	      Example<SysEvent> example = null;
	      Pageable options = new PageRequest(0, 10);
	      List<SysEvent> content = new ArrayList<SysEvent>();
	      content.add(new SysEvent("3273bf58-bf03-5cc2-b13b-9101b084ad44",new Date(),"DEBUG","UI","User login success"));
	      
	      Page<SysEvent> pages = new PageImpl(content, options,1) ;
	
	      Mockito.when(sysEventService.list(example, options)).thenReturn(pages);
	      
	      RequestBuilder requestBuilder = MockMvcRequestBuilders
					.post(uri)
					.accept(MediaType.APPLICATION_JSON)
					.contentType(MediaType.APPLICATION_JSON);

		 MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		 
			
		 MockHttpServletResponse response = result.getResponse();
		 JSONObject jsonObj = null;
		 
		 try {
		 JSONParser parser = new JSONParser();
		  jsonObj = (JSONObject) parser.parse(response.getContentAsString());
		 
		 }
		 catch(Exception e) {
			e.printStackTrace();
		 }
		
	     assertTrue((Long) jsonObj.get("totalElements") == 1);      

	   }
}
