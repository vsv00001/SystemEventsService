package com.example.sysevents.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.sysevents.entity.SysEvent;
import com.example.sysevents.repository.SysEventRepository;

@Service
public class SysEventService {

	@Autowired
	SysEventRepository repo;
	
	public Page<SysEvent> list(Example<SysEvent> example,Pageable options) {
		Page<SysEvent> returns = null;
		if(example == null) {
			returns = repo.findAll(options);
		}
		else {
			returns = repo.findAll(example, options);
		}
		return returns;
	}

}
