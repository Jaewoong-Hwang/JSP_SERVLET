<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="top-header layout  bg-success text-light">
	<ul class="user-block">
		<!-- login -->
		<%
			Boolean isAuth = session.getAttribute("isAuth")!=null ? (Boolean)session.getAttribute("isAuth"):null;
			if(isAuth==null)
			{
		%>
				<li>
					<a href="${pageContext.request.contextPath}/user/login">
							<span class="material-symbols-outlined">person</span>
					</a>
				</li>
		<%		
			}
			else
			{
		%>		
				<!-- logout -->
				<li>
					${username}
				</li>
				<li>
					<a href="${pageContext.request.contextPath}/user/logout">
							<span class="material-symbols-outlined">logout</span>
					</a>
				</li>	
		<%
			}
		%>
	</ul>
</div>