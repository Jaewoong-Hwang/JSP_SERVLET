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
			<%@include file="/resources/layouts/jsp/topHeader.jsp" %>
			<!-- nav -->
			<%@include file="/resources/layouts/jsp/nav.jsp" %>
		</header>
		<main  class="layout">
				<h1>JOIN</h1>
		</main>
		
		
		<!-- footer -->
		<%@include file="/resources/static/jsp/footer.jsp" %>
	</div>

	<form action="${pageContext.request.contextPath}/user/create" method="post">
		USERNAME : <input name="username" /><br/>
		PASSWORD : <input name="password" /><br/>
		<button>회원가입</button>
	</form>
	<div>
		${username_err}
	</div>
</body>
</html>