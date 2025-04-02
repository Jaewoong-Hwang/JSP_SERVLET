<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     	<%
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String Page02Value = (String)request.getAttribute("02Page");
		String Page03Value = (String)request.getAttribute("03Page");
		System.out.println("----------RESULT-------------");
		System.out.println("username : " + username);
		System.out.println("password : " + password);
		System.out.println("Page02Value : " + Page02Value);
		System.out.println("Page03Value : " + Page03Value);
		System.out.println("-----------------------------");
		
	%>      
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>RESULT PAGE</h1>
	<%=username %><br/>
	<%=password %><br/>
	<%=Page02Value %><br/>
	<%=Page03Value %><br/>
</body>
</html>