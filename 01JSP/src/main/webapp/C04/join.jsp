<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!--  
		UserDto객체에 전달받은 파라미터(userid,password)를 저장
		request에  setAttribute로 userDto 저장("userDto",userDto);
		validationCheck.jsp 로 forwarding
-->
<%@page import="C04.UserDto" %>
<%
	//userDto 객체 생성
	String userid = request.getParameter("userid");
	String password = request.getParameter("password");
	
	UserDto userDto = new UserDto(userid,password,"ROLE_USER");

	//request 내장객체 userDto 추가
	request.setAttribute("userDto", userDto);
	
	// 에러 미발생시 dbUtils.jsp 로 해당 내용 Forwarding
	request.setAttribute("url","/join");	//DB 요청 처리
	request.setAttribute("serviceNo",1); 	// ServiceNo C : 1 R : 2 U : 3 D : 4
	
	//forwarding 
	request.getRequestDispatcher("./validationCheck.jsp").forward(request,response);
%>