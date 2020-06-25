package com.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface CommandProcess {
	// 이 인터페이스를 가지면 아래의 메서드를 반드시 가진다. 
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable; // 모든 exception을 다 잡아들인다 
	
}
