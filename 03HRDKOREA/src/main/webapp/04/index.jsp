<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
:root {
	
}

html {
	
}

* {
	box-sizing: border-box;
}

body {
	padding: 0;
	margin: 0;
}

ul {
	list-style: none;
	margin: 0;
	padding: 0;
}

a {
	text-decoration: none;
	color: black;
}

.wrapper {
	
}

.wrapper>header {
	height: 80px;
}

.wrapper>nav {
	height: 50px;
}

.wrapper>main {
	height: calc(100vh - 80px - 50px - 80px);
	overflow:auto;
}

.wrapper>main h2 {
	text-align: center;
	font-size: 1.8rem;
	font-weight: 400;
}

.wrapper>main table {
	border: 1px solid;
	border-collapse: collapse;
	min-width: 500px;
	min-height: 350px;
	margin: 0 auto;
}

.wrapper>main table th, .wrapper>main table td {
	min-width: 80px !important;
	min-height: 35px !important;
	border: 1px solid;
	text-align: center;
}

.wrapper>main table th {
	background-color: lightgray;
}

.wrapper>footer {
	height: 80px;
}
</style>

</head>
<body>

	<div class="wrapper">
		<!--  -->
		<%@include file="/layouts/Header.jsp"%>

		<!--  -->
		<%@include file="/layouts/Nav.jsp"%>
		<%@page import="Utils.*,java.util.*"%>
		<%
			List<SubVoteDto> list = DBUtils.getInstance().selectAllVote2();
		%>


		<main>
			<h2>후보자등수</h2>
			<table>
				<tr>
					<th>후보번호</th>
					<th>성명</th>
					<th>총투표건수</th>
				</tr>
				<%
				for(SubVoteDto dto : list){
				%>
				<tr>
				
					<td><%=dto.getM_no() %></td>
					<td><%=dto.getM_name() %></td>
					<td><%=dto.getCount() %></td>
					
				
				</tr>
				<%
				} 
				%>
			</table>
			
		</main>

		<!--  -->
		<%@include file="/layouts/Footer.jsp"%>

	</div>

</body>
</html>