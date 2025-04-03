<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

	<style>
		label{font-size : .8rem;}
		span{font-size:.5rem; color:red;}
	</style>
</head>
<body>


<h1>LOGIN FORM</h1>
<div style="min-height:25px;font-size:.8rem;color:orange">
	${param.message}
</div>
<form action="${pageContext.request.contextPath}/C06/02/login.jsp" method="post">
	<div>
		<label>아이디 :</label><span>${username_msg}</span> <br/>
		<input type="text"  name="username"/>
	</div>
	<div>
		<label>패스워드 :</label><span>${password_msg}</span> <br/>
		<input type="text"  name="password"/>
	</div>
	<div>
		<button>로그인</button>
	</div>
	
</form>

</body>
</html>