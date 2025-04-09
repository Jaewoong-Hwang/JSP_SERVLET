<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
    <%@page import="Utils.*" %>
      <!-- 파라미터 받기  -->
  
    
    <!-- 파라미터 받기(액션태그) -:userBean -->
    <jsp:useBean id="classDto" class="Utils.ClassDto" scope="request"/>
    <jsp:setProperty name="classDto" property="*"/>
    
    
    <%
    	System.out.println(classDto);
    	int result = DBUtils.getInstance().insertClass(classDto);
    	if(result>0){
    		String code="<script>";
    		code +="alert('수강신청 완료!');";
    		code +="location.href='../index.jsp'";
    		code +="</script>";
    		
    		out.println(code);
    		
    	}
    	else{
    		
    		String code="<script>";
    		code +="alert('수강신청 완료!')";
    		code +="location.href='./index.jsp'";
    		code +="</script>";
    		
    		out.println(code);
    	}
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>