<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="C09.*,C09.DBUtils,java.util.*,java.time.format.DateTimeFormatter"%>
    
    <%
    List<OrderDto3> list = DBUtils.getInstance().selectAllOrder3();
    %>
<!--  
	INNER JOIN
	
	select u.addr,o.ORDER_DATE, sum(o.PRICE*o.QUANTITY)
	from tbl_user u
	join tbl_order o
	on u.userid=o.userid
	group by u.addr,o.ORDER_DATE
	order by  u.addr asc , sum(o.PRICE*o.QUANTITY) desc
	;


	select *
	from tbl_user
	left outer join tbl_order
	on tbl_user.userid=tbl_order.userid
	where tbl_order.userid is null;
-->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<h1>지역+날짜별 구매총액</h1>
		<table>
			<tr>
				<th>지역</th>
				<th>날짜</th>
				<th>총액</th>
			</tr>
			<%
			for(OrderDto3 dto : list){
				
				//yyyy.MM.dd
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");
			%>
			<tr>
				<td><%=dto.getADDR() %></td>
				<td><%=dto.getORDER_DATE().format(formatter) %></td>
				<td><%=dto.getSUM() %></td>
			</tr>
			<%
			} 
			%>		
		</table>


</body>
</html>