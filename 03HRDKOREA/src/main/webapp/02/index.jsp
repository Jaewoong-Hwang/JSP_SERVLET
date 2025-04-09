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

<%@page import="java.util.*,Utils.*" %>
<%

//모든 회원정보 가져오기
List<MemberDto> member_list=DBUtils.getInstance().selectAllMember();

%>
	
	<div class="wrapper">
		<!--  -->
		<%@include file="/layouts/Header.jsp" %>
		
		<!--  -->
		<%@include file="/layouts/Nav.jsp" %>
		
		<main>
		<h2>수강신청</h2>
		
		<form action="./create.jsp" name="registForm">
		<table>
		
		<tr>
		
			<td>수강월</td>
			<td><input name="resgist_month"/></td>
		
		</tr>
		<tr>
		
			<td>회원명</td>
			<td>
			<select name="c_name">
			<%
			
			for(MemberDto dto : member_list)
			{
			%>
				<option value=<%=dto.getC_name() %>><%=dto.getC_name() %></option>
			
			
			<%
			}
			%>
			</select>
			
			
			</td>
		
		</tr>
		<tr>
		
			<td>회원번호</td>
			<td><input name="c_no"/></td>
		
		</tr>
		<tr>
		
			<td>강의장소</td>
			<td><input name="class_area"/></td>
		
		</tr>
		<tr>
		
			<td>강의명</td>
			<td>
			<input type="hidden" name="teacher_code"/>
			</td>
		
		</tr>
		<tr>
		
			<td>수강료</td>
			<td><input name="tuition"/></td>
		
		</tr>
		<tr>
		
			<td colspan=2>
				<button type="submit">수강신청</button>
				<button type="reset">다시쓰기</button>
			</td>
			
		
		
		</tr>
		
		</table>
		
		
		
		</form>
		
		</main>
		
		<!--  -->
		<%@include file="/layouts/Footer.jsp" %>
	
	</div>
	
	<script>
	const form=document.registFrom;
	//Select onchange Event
	form.c_name.addEventListener('change',function(e){
		console.log(e.target.value);
	})
	
	</script>

</body>
</html>