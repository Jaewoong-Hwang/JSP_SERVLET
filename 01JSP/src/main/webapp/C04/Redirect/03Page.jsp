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
		
		String hobby=request.getParameter("hobby");
		System.out.println("hobby : " + hobby);
		/* REDIRECt */
		response.sendRedirect("./04Result.jsp");
		
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