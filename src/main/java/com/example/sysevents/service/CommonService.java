package com.example.sysevents.service;

import org.springframework.stereotype.Service;

@Service
public class CommonService {

	public void commonService(String svcName) {
		System.out.println("calling from "+svcName);
	}
}
