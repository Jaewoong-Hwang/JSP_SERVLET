<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%

 System.out.println("pageContext : " + pageContext); //pageContext는 bean이 담겨있는 영역임
	System.out.println("pageContext's get request : " + pageContext.getRequest());
	System.out.println("pageContext's get response : " + pageContext.getResponse());
	System.out.println("pageContext's get session : " + pageContext.getSession());
	System.out.println("pageContext's get application : " + pageContext.getServletContext());
	
	
	System.out.println("project path:" + pageContext.getServletContext().getContextPath()); 
	

%>

	<!-- 표현식 -->
	<%=pageContext.getServletContext().getContextPath()%>

	<!--EL -->
	PROJECT PATH(EL) : ${ pageContext.request.contextPath } <!--!!!!!!중요!!!!  -->


</body>
</html>