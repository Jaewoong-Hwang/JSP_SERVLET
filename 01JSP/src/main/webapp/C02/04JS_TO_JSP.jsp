<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%!
		boolean isInit=true;
	%>
	<%
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String role = request.getParameter("role");
		String flag = request.getParameter("flag");
		System.out.println("FLAG : " + flag);
		System.out.println("isInit = " + isInit);
		if(flag!=null && flag.equals("true")){
			isInit=false;
		}
			
	
	%>
	USERNAME :
	<%=username%><br> PASSWORD :
	<%=password%><br> ROLE :
	<%=role%><br>

	<form action="04JS_TO_JSP.jsp" name="myForm">
		<input name="username" type="hidden" /> 
		<input name="password" type="hidden" /> <input name="role" type="hidden" /> 
		<input name="flag" value="true" type="hidden" />
	</form>

	<script>
		const form = document.myForm;
		const flag = '<%=isInit%>';
		console.log("flag",flag);
		if(flag == 'true'){
			form.username.value = "홍길동";
			form.password.value = "1234";
			form.role.value = "ROLE_USER";
			form.submit();
		}
	</script>
	
</body>
</html>