package com.example.sysevents.utils;

import java.util.Map;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;

import com.example.sysevents.entity.SysEvent;

public class ExampleBuilder {
	public enum Operator {
		EQUALS, NOTEQUALS;
	}

	private static final String PARAM_VALUE = "paramValue";
	private static final String PARAM_OPERATOR = "paramOperator";

	Operator operator;

	public static Example<SysEvent> buildExample(Map<String, Object> params) {
		String paramOperator = (String) params.get(PARAM_OPERATOR);
		String paramValue = (String) params.get(PARAM_VALUE);
		SysEvent event = new SysEvent();
		
		if(paramValue != null) {
			event.setType(paramValue.toUpperCase());
		}

		Example<SysEvent> example = null;
		ExampleMatcher matcher = null;
		if (paramValue != null && paramOperator != null) {
			switch (paramOperator.toUpperCase()) {
			case "EQUALS":
				matcher = ExampleMatcher.matchingAll().withMatcher("type", ExampleMatcher.GenericPropertyMatchers.exact());
				break;
			case "STARTSWITH":
				matcher = ExampleMatcher.matchingAll().withMatcher("type", ExampleMatcher.GenericPropertyMatchers.startsWith());
				break;
			case "ENDSWITH":
				matcher = ExampleMatcher.matchingAll().withMatcher("type", ExampleMatcher.GenericPropertyMatchers.endsWith());
				break;
			case "CONTAINS":
				matcher = ExampleMatcher.matchingAll().withMatcher("type", ExampleMatcher.GenericPropertyMatchers.contains());
				break;
			default:
				break;
			}

			example = Example.of(event, matcher);
		}
		return example;
	}

}
