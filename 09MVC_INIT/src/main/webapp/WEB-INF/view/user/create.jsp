<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/user/create"
		method="post">
		USERNAME : <input name="username" /><br /> 
		PASSWORD : <input name="password" /><br />
		<button>회원가입</button>
	</form>
<div>
${username_err}

</div>
</body>
</html>