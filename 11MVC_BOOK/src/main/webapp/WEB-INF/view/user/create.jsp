<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<!-- link -->
	<%@include file="/resources/layouts/link.jsp" %>
	
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div class="wrapper">
		<header>
			<!-- topHeader -->
			<%@include file="/resources/layouts/topHeader.jsp" %>
			<!-- nav -->
			<%@include file="/resources/layouts/nav.jsp" %>
		</header>
		<main  class="layout">
		
			<h1>USER JOIN</h1>
			<form action="${pageContext.request.contextPath}/user/create" method="post">
				USERNAME : <input name="username" /><br/>
				PASSWORD : <input name="password" /><br/>
				<button>회원가입</button>
			</form>
			<div>
				${username_err}
			</div>
		</main>
		
		
		<!-- footer -->
		<%@include file="/resources/layouts/footer.jsp" %>
	</div>

	
</body>
</html>







