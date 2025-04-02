<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
//에러 미발생시 dbUtils.jsp 로 해당 내용 Forwarding
request.setAttribute("url", "/join"); //DB 요청처리 insert
request.setAttribute("serviceNo", 2); //ServiceNo C : 1 R : 2 U : 3 D : 4

request.getRequestDispatcher("./validationCheck.jsp").forward(request, response);
%>