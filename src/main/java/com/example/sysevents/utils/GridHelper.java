package com.example.sysevents.utils;

import java.util.Map;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
public final class GridHelper {
	private static final String PARAM_PAGE_SIZE = "pageSize";
	private static final String PARAM_FIRST_ROW = "startRow";
	
	
	public static Pageable getPageOptions(Map<String, Object> params) {
		
		String pageSizeVal = (String) params.get(PARAM_PAGE_SIZE) != null ?  (String) params.get(PARAM_PAGE_SIZE) : "10" ;
		String firstRowVal = (String) params.get(PARAM_FIRST_ROW) != null ? (String) params.get(PARAM_FIRST_ROW) : "0";
		
		Integer pageSize = Integer.parseInt(pageSizeVal);
		Integer pageNum = Integer.parseInt(firstRowVal) / pageSize;
		
		return new PageRequest(pageNum, pageSize);
		
	}
}
