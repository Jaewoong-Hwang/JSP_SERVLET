<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
    <%@page import="Utils.*" %>
      <!-- 파라미터 받기  -->
    <%
    
    	request.setCharacterEncoding("UTF-8");
    	response.setCharacterEncoding("UTF-8");
    	response.setContentType("text/html; charset=UTF-8");
    	
    	String jumin = request.getParameter("v_jumin");
    	String name= request.getParameter("v_name");
    	String no = request.getParameter("m_no");
    	String time = request.getParameter("v_time");
    	String area = request.getParameter("v_area");
    	String confirm = request.getParameter("v_confirm");
    
    	VoteDto voteDto = new VoteDto(jumin,name,no,time,area,confirm);
    	System.out.println("voteDto:"+voteDto);
    	
    %>
    
    <!-- 파라미터 받기(액션태그) -:userBean -->
    <jsp:useBean id="voteDto2" class="Utils.VoteDto" scope="request"/>
    <jsp:setProperty name="voteDto2" property="*"/>
    
    <%
    	System.out.println("voteDto2:"+voteDto2);
    	int result = DBUtils.getInstance().insertVote(voteDto2);
    	
    	if(result>0){
    		out.print("<script>alert('투표성공!')</script>");
    		request.getRequestDispatcher("./read.jsp").forward(request,response);
    	}else{
    		out.println("<script>alert('투표 실패! 다시하세요');location.href='./index.jsp'</script>");
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