<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     	<%
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String Page02Value = (String)request.getAttribute("02Page");
		System.out.println("----------03PAGE-------------");
		System.out.println("username : " + username);
		System.out.println("password : " + password);
		System.out.println("Page02Value : " + Page02Value);
		System.out.println("-----------------------------");
		
		/* FORWARDING */
		request.setAttribute("03Page", "03Page's Value");
		request.getRequestDispatcher("./04Result.jsp").forward(request,response);
	%>  
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>03PAGE</h1>

</body>
</html>