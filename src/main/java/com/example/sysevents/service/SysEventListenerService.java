package com.example.sysevents.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

import com.example.sysevents.entity.SysEvent;
import com.example.sysevents.repository.SysEventRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@EnableBinding(Sink.class)
public class SysEventListenerService {
	
	Logger logger = LoggerFactory.getLogger(SysEventListenerService.class);
	
	@Autowired
	SysEventRepository repo;
	
	@StreamListener(target=Sink.INPUT)
	public void handleSysEvent(String msg) {
		logger.debug("inside handleSysEvent");
		ObjectMapper mapper = new ObjectMapper();
		List<SysEvent> events = null;
		try 
		{
		events = mapper.readValue(msg, new TypeReference<List<SysEvent>>() { });
		
		}
		catch(Exception ex) {
			logger.debug("exception in converting msg to events : "+ ex.getMessage());
		}
		
		for(SysEvent event : events) {
			repo.save(event);
		}
		
		logger.debug("finished handleSysEvent");
	}
}
