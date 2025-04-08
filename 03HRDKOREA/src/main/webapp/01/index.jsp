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
	overflow: auto;
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
		<%@page import= "java.time.LocalDate,java.time.format.DateTimeFormatter,java.text.NumberFormat" %>
		<%
		List<TeacherDto> list = DBUtils.getInstance().selectAllTeacher();
		%>
		

		<main>
			<h2>강사조회</h2>
			<table>

				<tr>

					<th>강사코드</th>
					<th>강사명</th>
					<th>강의명</th>
					<th>수강료</th>
					<th>강사자격취득일</th>


				</tr>
				<%
				for (TeacherDto teacherDto : list) {
				%>

				<tr>

					<td><%=teacherDto.getTEACHER_CODE()%></td>
					<td><%=teacherDto.getTEACHER_NAME()%></td>
					<td><%=teacherDto.getCLASS_NAME()%></td>
					
					<%
					Integer price = teacherDto.getCLASS_PRICE();
				
					NumberFormat nf = NumberFormat.getCurrencyInstance( Locale.KOREA );
					out.println("<td>"+nf.format(price)+"</td>");
					
					%>
					
					<%-- <td><%=teacherDto.getCLASS_PRICE()%></td> --%>

					<%
					
					String date= teacherDto.getTEACHER_REGIST_DATE();
					//입력 포맷(yyMMdd)
					DateTimeFormatter infmt = DateTimeFormatter.ofPattern("yyyyMMdd");
					LocalDate myBirth = LocalDate.parse(date, infmt);
					//출력 포맷(yyyy년MM월dd일생)
					DateTimeFormatter outfmt = DateTimeFormatter.ofPattern("yyyy년MM월dd일");
					out.println("<td>" + myBirth.format(outfmt) + "</td>");
					%>
					<%-- <td><%=teacherDto.getTEACHER_REGIST_DATE()%></td> --%>

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