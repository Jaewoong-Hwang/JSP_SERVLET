<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%@ page import = "java.io.*" %>
<%

	//response.sendRedirect("./02Request.jsp");
		//response.sendError(HttpServletResponse.SC_REQUEST_TIMEOUT);
		
		//404 Error
		//response.sendError(HttpServletResponse.SC_NOT_FOUND,"해당 페이지를 찾을 수가 없습니다");
		//403 Error
		//response.sendError(HttpServletResponse.SC_FORBIDDEN,"접근 금지됨!");
		//502 Error
		//response.sendError(HttpServletResponse.SC_BAD_GATEWAY,"서버 장애 발생!");

		/* 새로고침 */
		//response.setIntHeader("Refresh", 3);
		
		/*OutStream 추출  */
		/* ServletOutputStream bout = response.getOutputStream();
		bout.write('a');
		bout.write(98);
		bout.flush();
		bout.close(); */
		
		PrintWriter o = response.getWriter();
		o.write("<h1>HELLOWORLD</h1>");
		
%>

<%@page import = "java.util.*" %>
<%=new Date() %>
</body>
</html>