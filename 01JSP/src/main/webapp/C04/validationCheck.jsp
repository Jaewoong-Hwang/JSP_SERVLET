<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="./errors.jsp"%>

<%@page import="C04.*" %>
<%

	// request로부터 전달받은 userDto 값 꺼내서  System.out 확인
	// 받은 username,password 값이 null인지여부를 체크(String API trim()  + isEmpty() 이용)
	// 에러발생시 처리되는 페이지로 전달(error.jsp)
	
	
	//url선별 serviceNo 선별 -> 유효성체크 
	

	
	String url = (String)request.getAttribute("url");
	Integer serviceNo = (Integer)request.getAttribute("serviceNo");
	
	if(url.contains("/join")){
		// /join 
		UserDto userDto = (UserDto)request.getAttribute("userDto");
		isValid(userDto);
	}else if(url.contains("/myinfo")){
		// /myinfo
		String userid = request.getParameter("userid");
		isValid(userid);
	}
	
	request.getRequestDispatcher("./dbUtils.jsp").forward(request,response);
%>

<%! 
	void isValid(UserDto userDto) throws Exception{
		System.out.println("[VALIDATION CHECK] userDto : " + userDto);
		if(userDto == null)
			throw new Exception("userDto가 NULL 입니다..");
		if(userDto.getUserid().trim().isEmpty())
			throw new Exception("userid를 입력하세요..");
		if(userDto.getPassword().trim().isEmpty())
			throw new Exception("password를 입력하세요..");
		if(userDto.getRole().trim().isEmpty())
			throw new Exception("기본 역할(ROLE_USER)이 지정되지 않았습니다..");
	}

	void isValid(String userid) throws Exception{
		if(userid.trim().isEmpty())
			throw new Exception("userid를 입력하세요..");
	}
%>


