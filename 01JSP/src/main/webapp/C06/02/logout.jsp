<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	session.invalidate(); 

out.println("<script> alert('LOGOUT 성공! LOGIN PAGE로 이동합니다.');location.href='./login_form.jsp?message=Logout_Successful'</script>");

%>