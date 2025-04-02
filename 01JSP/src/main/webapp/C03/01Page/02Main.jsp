<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
    <%
    	String name = request.getParameter("name");
    	String age = request.getParameter("age");
    	String addr = request.getParameter("addr");
    	if(name.isEmpty())
    		throw new Exception("이름을 입력하세요");
    	if(age.isEmpty())
    		throw new Exception("나이를 입력하세요");
    	if(addr.isEmpty())
    		throw new Exception("주소를 입력하세요");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	이름 : <%=name %><br>
	나이 : <%=age %><br>
	주소 : <%=addr %><br>
</body>
</html>