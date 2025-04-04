<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
if (session.getAttribute("isAuth") != null) {
	out.println("<script>alert('이미 로그인 상태입니다.');location.href='./main.jsp'</script>");
	response.sendRedirect("./main.jsp");
}
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
label {
	font-size: .8rem;
}

span {
	font-size: .5rem;
	color: red;
}
</style>
</head>
<body>


	<h1>LOGIN FORM</h1>
	<div style="min-height: 25px; font-size: .8rem; color: orange">
		${param.message}</div>
	<form action="${pageContext.request.contextPath}/C07/03/login.jsp"
		method="post">
		<div>
			<label>아이디 :</label>
			<span>${username_msg}</span> <br /> 
			<input type="text" name="username" value="${cookie.username!=null? cookie.username.value:''}"/>
		</div>
		<div>
			<label>패스워드 :</label>
			<span>${password_msg}</span> <br /> 
			<input type="password" name="password"  value="${cookie.password!=null? cookie.password.value:'' }"/>
		</div>
		<div>
			<input type="checkbox" id="idSave" name="idSave" ${cookie.idchk != null? 'checked' : ''} /> 
			<label for="idSave">ID저장</label>
			<input type="checkbox" id="pwSave" name="pwSave" ${cookie.pwchk !=null? 'checked' : '' }/> 
			<label for="pwSave">PW저장</label>

		</div>

		<div>
			<button>로그인</button>
		</div>

	</form>

</body>
</html>