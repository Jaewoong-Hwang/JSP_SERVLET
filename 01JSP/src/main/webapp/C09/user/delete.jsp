<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@page import="C04.UserDto,C09.DBUtils,java.util.*" %>    
<%
	String userid = request.getParameter("userid");
	
	int result =  DBUtils.getInstance().deleteUser(userid);
	
	//Re + FR
	response.sendRedirect("./selectAll.jsp");
%>    
