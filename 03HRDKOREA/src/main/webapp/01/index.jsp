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
	min-height: 25px !important;
	max-height: 25px !important;
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
		<%@include file="/layouts/Header.jsp" %>
		
		<!--  -->
		<%@include file="/layouts/Nav.jsp" %>
		
		<main>
			<h2>강사조회</h2>
			<!--  -->
			<table>
				<tr>
					<th>강사코드</th>
					<th>강사명</th>
					<th>강의명</th>
					<th>수강료</th>
					<th>강사자격취득일</th>
				</tr>
				<%@page import="java.text.DecimalFormat,Utils.*,java.util.*,java.time.*,java.time.format.*" %>		
				<%
				  List<TeacherDto> list = DBUtils.getInstance().selectAllTeacher();
				%>
				<%
				 for(TeacherDto dto : list)
				 {
				%>
				<tr>
					<td><%=dto.getTeacher_code() %></td>
					<td><%=dto.getTeacher_name() %></td>
					<td><%=dto.getClass_name() %></td>
					 
					<%
						int price = dto.getClass_price();
						DecimalFormat fmt = new DecimalFormat("#,###");
					%>
	
					<td><%="\\"+fmt.format(price) %></td>
					
					<%
						String date = dto.getTeacher_regist_date();
						//INFMT
						DateTimeFormatter inFmt = DateTimeFormatter.ofPattern("yyyyMMdd");
						LocalDate localDate = LocalDate.parse(date,inFmt);
						//OUTFMT
						DateTimeFormatter outFmt = DateTimeFormatter.ofPattern("yyyy년MM월dd일");
						out.print("<td>"+localDate.format(outFmt)+"</td>");
						
					%>
					<%-- <td><%=dto.getTeacher_regist_date() %></td> --%>
				</tr>
				<%	 
				 }
				%>

			</table>
		</main>
		
		<!--  -->
		<%@include file="/layouts/Footer.jsp" %>
	
	</div>

</body>
</html>