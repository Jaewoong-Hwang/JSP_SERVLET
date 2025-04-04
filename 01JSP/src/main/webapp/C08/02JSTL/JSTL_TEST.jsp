<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    	<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<!-- 변수 선언  -->
<c:set var="num" value="123" />
<!-- 변수 출력 -->
<c:out value="${num}" />

<hr>

<!-- 배열지정 -->
<c:set var="arr" value="${[10,20,30,40,50]}" />
<c:out value="${arr}" /> <br/>
<c:out value="${arr[1]}" />0

<!-- IF -->
<c:set var="flag" value="true" />
<c:if test="${empty flag}" >
	<c:out value="flag empty..." />
</c:if>
<c:if test="${not empty flag}" >
	<c:out value="flag  : ${flag}" />
</c:if>

<hr>
<!-- CHOOSE WHEN  -->
	<c:set var="str" value="d" />
	<c:choose>
		<c:when test="${str eq 'a' }">
			<c:out value="[CHOOSE] A" />
		</c:when>
		<c:when test="${str eq 'b' }">
			<c:out value="[CHOOSE] B" />
		</c:when>	
		<c:when test="${str eq 'c' }">
			<c:out value="[CHOOSE] C" />
		</c:when>
		<c:otherwise>
			<c:out value="[CHOOSE] ETC" />
		</c:otherwise>
	</c:choose>

	<hr>

<!-- foreach -->
	<c:set var="end" value="15" />
	<c:forEach var="i" begin="1" end="${end}" step="2">
		<c:out value="${i}"/> |
	</c:forEach>
	
	<!-- fn:length -->
<hr>
<%@page import="java.util.*" %>
<%
	List<String> listTest = new ArrayList();
	listTest.add("test1");
	listTest.add("test2");
	listTest.add("test3");
	listTest.add("test4");
	listTest.add("test5");
	request.setAttribute("listTest", listTest);
%>
<c:set var="str1" value="TEST1234" />
FN:LENGTH : ${fn:length(listTest)} <br>


</body>
</html>