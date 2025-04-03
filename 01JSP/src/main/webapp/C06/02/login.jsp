<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%
	String username = request.getParameter("username");
	String password = request.getParameter("password");
	// 파라미터 유효성 체크
	if(username.isEmpty()){
		//out.println("<script>alert('username을 입력하세요');location.href='./login_form.jsp'</script>");
		request.setAttribute("username_msg","username을 입력하세요");				
	}
	if(password.isEmpty()){
		//out.println("<script>alert('password을 입력하세요');location.href='./login_form.jsp'</script>");
		request.setAttribute("password_msg","password을 입력하세요");
	}	
	
	if(username.isEmpty()||password.isEmpty()){
		request.getRequestDispatcher("./login_form.jsp").forward(request, response);
		return ;
	}
	
	//01 ID 확인(DB 조회 - 생략)
	if(!username.equals("admin")){
		request.setAttribute("username_msg","해당 ID는 존재하지않습니다");
		//request.setAttribute("password_msg","");
		request.getRequestDispatcher("./login_form.jsp").forward(request, response);
		return ;
	}
	//02 PW 확인(일치여부 확인)
	if(!password.equals("1234")){
		request.setAttribute("password_msg","패스워드가 일치하지 않습니다");
		request.getRequestDispatcher("./login_form.jsp").forward(request, response);
		return ;
	}	
	
	//03 사용자 상태정보(인증됨)를 Session 저장
	session.setAttribute("isAuth", true);
	session.setAttribute("role", "ROLE_ADMIN");
	session.setMaxInactiveInterval(30); //30초 (기본 1800초 :30분)
	//04 로그인 처리후 MAIN PAGE REDIRECT
	out.println("<script> alert('로그인 성공! MAIN page로 이동합니다.');location.href='main.jsp'</script>");
	
	
	
%>