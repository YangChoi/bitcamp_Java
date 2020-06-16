package com.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface CommandProcess {
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable; // 모든 exceptionㅇ르 다 잡아들인다 
	
}
