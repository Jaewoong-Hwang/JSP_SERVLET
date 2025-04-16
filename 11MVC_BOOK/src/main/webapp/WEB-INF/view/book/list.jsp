<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<!-- link -->
	<%@include file="/resources/layouts/link.jsp" %>
	
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div class="wrapper">
		<header>
			<!-- topHeader -->
			<%@include file="/resources/layouts/topHeader.jsp" %>
			<!-- nav -->
			<%@include file="/resources/layouts/nav.jsp" %>
		</header>
		<main  class="layout">
			<h1>/BOOK/LIST</h1>
			<!-- 게시물 필터처리(전체/이름/출판사/ISBN  -->
			<section>
			
			</section>
			
			<!-- 게시물 표시  -->
			<section>
				<div>
					PAGE : <span>1</span> / <span>100</span> (현재페이지 / 전체페이지)
				</div>
				<table class="table">
					<thead>
						<tr>
							<th class="bg-dark text-light">도서코드</th>
							<th class="bg-dark text-light">도서명</th>
							<th class="bg-dark text-light">출판사</th>
							<th class="bg-dark text-light">ISBN</th>
						</tr>
					</thead>
					<tbody>
						<!--  -->
						<%@page import="java.util.*,Domain.Dto.*" %>
						<%
							List<BookDto> list = request.getAttribute("list")!=null?(List<BookDto>)request.getAttribute("list"):null;
							if(list==null)
								out.println("<td colspan=4>조회할 데이터가 없습니다</td>");
							else
							{
								for(BookDto dto : list)
								{
						%>
								<tr>
									<td><%=dto.getBookCode()%></td>
									<td><%=dto.getBookName()%></td>
									<td><%=dto.getPublisher()%></td>
									<td><%=dto.getIsbn()%></td>
								</tr>
								
						<%		
								}
							}
						%>

						
					</tbody>
					
					<tfoot>
						<tr>
							<td colspan=3>
								<nav aria-label="Page navigation example">
								  <ul class="pagination">
								    <li class="page-item">
								      <a class="page-link" href="#" aria-label="Previous">
								        <span aria-hidden="true">&laquo;</span>
								      </a>
								    </li>
								    <li class="page-item"><a class="page-link" href="#">1</a></li>
								    <li class="page-item"><a class="page-link" href="#">2</a></li>
								    <li class="page-item"><a class="page-link" href="#">3</a></li>
								    <li class="page-item">
								      <a class="page-link" href="#" aria-label="Next">
								        <span aria-hidden="true">&raquo;</span>
								      </a>
								    </li>
								  </ul>
								</nav>
							
							</td>
							<td>
								<!-- 글쓰기 -->
								<a href="javascript:void(0)" class="btn btn-success">도서등록</a>
								<!-- 처음으로 -->
								<a href="javascript:void(0)" class="btn btn-secondary">처음으로</a>
							</td>
						</tr>
						
					</tfoot>
				</table>
			</section>
		</main>
		
		
		<!-- footer -->
		<%@include file="/resources/layouts/footer.jsp" %>
	</div>

	
</body>
</html>







