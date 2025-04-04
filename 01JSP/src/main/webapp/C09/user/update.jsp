<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@page import="C04.UserDto,C09.DBUtils,java.util.*"%>

<%
 String userid = request.getParameter("userid");
 String password = request.getParameter("password");
 String role = request.getParameter("role");
 

 
 //서비스 실행(db update)
int result = DBUtils.getInstance().updateUser(new UserDto(userid,password,role)); 
 
 

		 
	//이동(redirect or forwarding or scrpit 코드 처리(location.href=)
	if (result > 0)
		out.println("<script>alert('update 성공');location.href='./selectAll.jsp'</script>");
	else
		out.println("<script>alert('update 실패');location.href='history.go(-1)'</script>");


%>


    
    
