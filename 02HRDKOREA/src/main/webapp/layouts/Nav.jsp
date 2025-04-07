<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	
	<style>
		nav{
			background-color:lightgray;
		}
		nav>ul{
			display:flex;
			justify-content:left;
		}
		nav>ul>li{
			padding : 5px 20px;
		}
	</style>
	
	<nav>
		<ul>
			<li><a href="${pageContext.request.contextPath}/01/index.jsp">후보조회</a></li>
			<li><a href="${pageContext.request.contextPath}/02/index.jsp">투표하기</a></li>
			<li><a href="${pageContext.request.contextPath}/03/index.jsp">투표검수조회</a></li>
			<li><a href="${pageContext.request.contextPath}/04/index.jsp">후보자등수</a></li>
			<li><a href="${pageContext.request.contextPath}">홈으로</a></li>
		</ul>
	</nav>
	
	
	
	
	
	
	
	