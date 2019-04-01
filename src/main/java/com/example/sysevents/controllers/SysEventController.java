package com.example.sysevents.controllers;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.sysevents.entity.SysEvent;
import com.example.sysevents.service.SysEventService;
import com.example.sysevents.utils.ExampleBuilder;
import com.example.sysevents.utils.GridHelper;

@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
@RequestMapping("/sysevent")
public class SysEventController {

	Logger logger = LoggerFactory.getLogger(SysEventController.class);
	
	@Autowired
	SysEventService service;
	
	@RequestMapping("/")
	public Page<SysEvent> list(@RequestParam Map<String, Object> params) {
		logger.debug("Inside list" );
		Page<SysEvent> returns = null;
		Pageable options  = GridHelper.getPageOptions(params);

		try {
	
		Example<SysEvent> example = ExampleBuilder.buildExample(params);
		returns = service.list(example, options);
		}
		catch(Exception ex) {
			logger.debug("exception is"+ ex.getMessage());
		}
		
		logger.debug("return list");
		return returns;
		
	}

}
