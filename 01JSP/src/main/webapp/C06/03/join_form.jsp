<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
	
	    
<% 

	if(session.getAttribute("isAuth")!=null){
		out.println("<script>alert('이미 로그인 상태입니다.');location.href='./main.jsp'</script>");
		response.sendRedirect("./main.jsp");
	}

%>    
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>JOGIN FORM</h1>
	<div style="min-height: 25px; font-size: .8rem; color: orange">
		${param.message}</div>

	<form action="${pageContext.request.contextPath}/C06/03/join.jsp" method="post">
		<input type="text"name="userid" /><br>
		<input type="text"name="password" /><br> 
		<input type="text" name="username" /><br> 
		<input type="submit" value="회원가입" />
	</form>


</body>
</html>