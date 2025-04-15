<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>



	<div class="wrapper">
		<header>
			<!-- topHeader -->
			<%@include file="/resources/layouts/jsp/topHeader.jsp"%>
			<!-- nav -->
			<%@include file="/resources/layouts/jsp/nav.jsp"%>
		</header>
		<main class="layout">
	</div>
	<h1>USER LOGIN</h1>
	<form action="${pageContext.request.contextPath}/user/login"
		method="post">
		USERNAME : <input name="username" /><br /> 
		PASSWORD : <input name="password" /><br />
		<button>로그인</button>
	</form>
	<div>${username_err}</div>
	</main>


	<!-- footer -->
	<%@include file="/resources/static/jsp/footer.jsp"%>

</body>
</html>