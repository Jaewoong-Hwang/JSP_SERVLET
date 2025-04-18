<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<nav class="layout navbar navbar-expand-lg navbar-light bg-light">
  <div class="" style="width:100%;display:flex;">
    <a class="navbar-brand" href="${pageContext.request.contextPath}">HOME</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">

        <li class="nav-item">
          <a class="nav-link" href="${pageContext.request.contextPath}/book/list">도서</a>
        </li>
        
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            Dropdown
          </a>
          <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
            <li><a class="dropdown-item" href="#">Action</a></li>
            <li><a class="dropdown-item" href="#">Another action</a></li>
            <li><hr class="dropdown-divider"></li>
            <li><a class="dropdown-item" href="#">Something else here</a></li>
          </ul>
        </li>
        <li class="nav-item">
          <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Disabled</a>
        </li>
      </ul>
     
     
     
     <%@page import="Domain.Dto.*" %>
     <%
 		PageDto pageDto_nav = request.getAttribute("pageDto") != null ? (PageDto) request.getAttribute("pageDto") : null;
     	System.out.println("NAV ! : " + pageDto_nav);
     	Integer pageno_nav = null;
     	if(pageDto_nav !=null){
     		pageno_nav =  pageDto_nav.getCriteria().getPageno();
     	}
     %>
     	
      <form class="d-flex"  action="${pageContext.request.contextPath}/book/list" >
      	<select name="type">
      		<option selected>-</option>
      		<option value="bookCode">도서코드</option>
      		<option value="bookName">도서명</option>
      		<option value="publisher">출판사</option>
      		<option value="isbn">ISBN</option>
      	</select>
        <input  name="keyword" class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
        <% 
        if(pageno_nav!=null)
        {
        %>
        	<input type="hidden" name="pageno" value="<%=pageno_nav %>" />
        <%
        }
        %>
        <button class="btn btn-outline-success" type="submit" >Search</button>
      </form>
      
    </div>
  </div>
</nav>