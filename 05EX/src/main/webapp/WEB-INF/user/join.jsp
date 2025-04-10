<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>JOIN PAGE</h1>
	<form action="${pageContext.request.contextPath}/join.do" method="post">
		<input name="username" /><br/>
		<input name="password" /><br/>
		<button>회원가입</button>
	</form>

</body>
</html>