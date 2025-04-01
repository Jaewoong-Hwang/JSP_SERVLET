<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <% 
/*  문자셋 설정 */
	request.setCharacterEncoding("UTF-8");
	response.setContentType("text/html; charset=UTF-8");
	%>
    
      <%
    
    	String col1 = request.getParameter("col1");
    	String col2 = request.getParameter("col2");
    	String col3 = request.getParameter("col3");
    	String col4 = request.getParameter("col4");
    	String style = request.getParameter("style");
    	
    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<nav style="<%=style%>">
	
	 <div><%=col1 %></div>
	 <div><%=col2 %></div>
	 <div><%=col3 %></div>
	 <div><%=col4 %></div>
	
	
	</nav>




</body>
</html>