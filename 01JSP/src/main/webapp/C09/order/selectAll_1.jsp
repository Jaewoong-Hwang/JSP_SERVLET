<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!--
	품목별 총합 (총합별 내림차순)
	select CATEGORY,sum(price*quantity) from tbl_order
	group by CATEGORY
	having sum(price*quantity) >=50000
	order by sum(price*quantity) desc;
-->
<%@page import="C04.UserDto,C09.*,java.util.*,java.time.format.DateTimeFormatter"%>
<%
List<OrderDto> list = DBUtils.getInstance().selectAllOrder();
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>품목별 총액 (50000만원 이상)</h1>
	<%

	%>
	<table>
		<tr>
			<th>품목</th>
			<th>총합</th>
		</tr>

		<%
		for (OrderDto orderDto : list) {
		%>
			<tr>
				<th><%=orderDto.getCATEGORY() %></th>
				<th><%=orderDto.getSUM() %></th>
			</tr>
		<%
		}
		%>

	</table>
	
	<h1>날짜별 구매 총평균</h1>
	<!--  
		select order_date, round(avg(price*quantity),2)
		from tbl_order
		group by order_date;
	-->
	<%
		List<OrderDto2> list2 = DBUtils.getInstance().selectAllOrder2();
	%>
	<table>
		<tr>
			<th>날짜</th>
			<th>평균</th>
		</tr>
		
		<%
			for(OrderDto2 dto : list2)
			{
				//yyyy.MM.dd
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");
		%>
			<tr>
				<td><%=dto.getOrder_date().format(formatter) %></td>
				<td><%=dto.getAverage() %></td>
			</tr>
		<%		
			}
		%>

		
	</table>




</body>
</html>
