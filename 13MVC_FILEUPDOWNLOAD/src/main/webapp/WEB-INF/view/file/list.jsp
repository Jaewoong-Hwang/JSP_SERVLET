<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>FILE LIST</h1>
	<%@page import="java.util.*,java.io.*" %>
	<%
		Map<String,List<File>> map= request.getAttribute("map")!=null?
									(Map<String,List<File>>)request.getAttribute("map")		
									:null;
	
	if(map!=null)
	{
			for(String folder : map.keySet())
			{
			
	%>
	
			<h3><%=folder %></h3>
	
	<% 
			
				List<File> list = map.get(folder);
				for(File file : list)
				{
	%>

				<a href="${pageContext.request.contextPath }/file/download?folder=<%=folder%>&filename=<%=file.getName()%>"><%=file.getName() %></a><br/>
				<!-- 경로정보는 DB 에 넣는 것이 바람직하다.  -->
	<% 			
					
				}
				
				out.println("<hr/>");
				
			} 
		}
	%>
	
	<h3>폴더명</h3>
	
	<a href="javascript:void(0)">파일2</a>
</body>
</html>