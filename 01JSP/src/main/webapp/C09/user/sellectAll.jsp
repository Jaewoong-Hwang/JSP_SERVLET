<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@page import="C04.UserDto,C09.DBUtils,java.util.*"%>


<%
DBUtils dbUtils = DBUtils.getInstance();
List<UserDto> list = dbUtils.selectAllUser();
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!--  
		
			1 selectAllUser 를 이용해서 table 의 해당 user 정보 표시
			2 selectAllUser 에 컬럼을 추가해서 해당 컬럼의 수정 버튼을 만들어보세요
			3 selectAllUser 에 컬럼을 추가해서 해당 컬럼의 삭제 버튼을 만들어보세요
			4 수정버튼을 클릭하면 수정페이지로 이동(update.jsp)
			5 삭제버튼을 클릭하면 삭제페이지로 이동(delete.jsp)
		
		-->


	총인원 :
	<%=list.size()%><br />

	<table>
		<tr>
			<th>계정</th>
			<th>패스워드</th>
			<th>역할</th>
			<th>수정</th>
			<th>삭제</th>
		</tr>
		<%
		for (UserDto dto : list) {
		%>

		<tr>
			<td><%=dto.getUserid()%></td>
			<td><%=dto.getPassword()%></td>
			<td><%=dto.getRole()%></td>
			<td><a href="./update_form.jsp?userid=<%=dto.getUserid()%>">수정하기</a></td>
			<td><a href="./delete.jsp?userid=<%=dto.getUserid()%>">삭제하기</a></td>
		</tr>

		<%
		}
		%>



	</table>









</body>
</html>