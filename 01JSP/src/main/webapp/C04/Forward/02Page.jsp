<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 	<%
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		System.out.println("----------02PAGE-------------");
		System.out.println("username : " + username);
		System.out.println("password : " + password);
		System.out.println("-----------------------------");
		
		request.setAttribute("02Page", "02PageValue");
		/* FORWARDING */
		request.getRequestDispatcher("./03Page.jsp").forward(request,response);
		
	%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>02PAGE</h1>
	USERNAME : <%=username %><br>
	PASSWORD : <%=password %><br>
</body>
</html>