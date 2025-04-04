<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<!-- 
		EL(Expression Language) : 내장객체의 Scope 참조
		pageScope : 현재 JSP 페이지 내에서만 사용가능한 속성/기능 (관련 내장객체 : pageContext)
		requestScope : 하나의 요청 처리동안	(관련 내장객체 : request)
		sessionScope : 일정기간 동안(지정된 혹은 기본값) (관련 내장객체 : session)
		applicationScope : 사바종료시 동안 (관련 내장 객체 application)
		
	
	 -->
	 
	 <%@page import="C04.UserDto" %>
	 <%
	 
	 pageContext.setAttribute("P_ATTR", "P_ATTR_VALUE");
	 request.setAttribute("R_ATTR", "R_ATTR_VALUE");
	 session.setAttribute("S_ATTR", "S_ATTR_VALUE");
	 application.setAttribute("A_ATTR", "A_ATTR_VALUE");
	 
	 
	// pageContext.setAttribute("DUP", "PAGECONTEXT VALUE");
	// request.setAttribute("DUP", "REQUEST VALUE");
	 //session.setAttribute("DUP", "SESSION VALUE");
	 application.setAttribute("DUP", "APPLICATION VALUE");
	 
	

	 %>
	 
	 
	 
	 
	 
	<!--EL:PARAM -->
	USERNAME : ${param.username}<br/>		<!--  param의 경우에는 reuquestScope에서 가져옴-->
	PASSWORD : ${param.password}<br/>
	<hr/>
	
	
	<!-- EL : ATTRIBUTE  -->
	PAGECONTEXT's ATTR : ${P_ATTR}<br/>
	PAGECONTEXT's ATTR : ${pageScope.P_ATTR}<br/>
	REQUEST's ATTR : ${R_ATTR}<br/>
	REQUEST's ATTR : ${requestScope.R_ATTR}<br/>
	SESSION's ATTR : ${S_ATTR}<br/>
	SESSION's ATTR : ${sessionScope.S_ATTR}<br/>
	APPLICATION's ATTR : ${A_ATTR}<br/>
	APPLICATION's ATTR : ${applicationScope.A_ATTR}<br/>
	
	<hr/>
	<!-- EL : ATTRIBITE(중복값)  -->
 	DUPLICATED VALUE : ${DUP}<br/>
	<hr/>
	<!--EL : OBJECT  -->
	<%
	UserDto userDto = new UserDto("user1", "1234", "ROLE_USER");
	 request.setAttribute("userDto", userDto);
	 %>
	 
	표현식 : <%=userDto.getUserid() %><br/>
	EL : ${userDto.userid}<br/>   <!-- setAttribute를 해야지 사용가능 -->
	
	
	<!--EL : 연산자  -->
	연산: <%=1+1 %><br/>
	EL : ${1+1}<br/>
	EL : ${1+"1"}<br/>  <!-- 알아서 파싱해줌 -->
	
	<hr/>
	<!-- NULL CHECK -->
	NULL : ${null}<br/>
	empty NULL : ${empty null}<br/>
	empty NULL : ${empty ""}<br/>
	empty NULL : ${empty "a"}<br/>
	
	<%-- <%request.setAttribute("TEST", "test"); %> --%>
	empty null : ${empty TEST}<br/>
	empty not null : ${!empty TEST}<br/>
	
	
	
</body>
</html>