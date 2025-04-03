<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" errorPage="./errors.jsp"%>

<!--속성/기능추가  -->
<%@page import="java.sql.*,C04.*"%>
<%!//속성/기능 추가가능
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String id = "system";
	private String pw = "1234";

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	private void getConnection() throws Exception {
		if (conn == null) {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, id, pw);
		}
	}

	private int insert(UserDto userDto) throws Exception {

		pstmt = conn.prepareStatement("insert into TBL_USER values(?,?,?)");
		pstmt.setString(1, userDto.getUserid());
		pstmt.setString(2, userDto.getPassword());
		pstmt.setString(3, userDto.getRole());
		int result = pstmt.executeUpdate();

		conn.commit();

		pstmt.close();

		return result;

	}
	
	private UserDto selectOne(String userid) throws Exception{
		pstmt = conn.prepareStatement("select * from TBL_USER where userid='"+userid+"'");
		rs =  pstmt.executeQuery();
		UserDto userDto=null;
		if(rs!=null){
			if(rs.next()){
				userDto = new UserDto();
				userDto.setUserid(userid);
				userDto.setPassword(rs.getString("password"));
				userDto.setRole(rs.getString("role"));			
			}
		}
		rs.close();
		pstmt.close();
		return userDto;
	}
	
	%>

<!-- Service 함수 -->
<%
	/* 요청 정보확인 */
	String url = (String) request.getAttribute("url"); //
	Integer serviceNo = (Integer) request.getAttribute("serviceNo");
	System.out.println("URL : " + url);
	System.out.println("SERVICENO : " + serviceNo);
	
	if (url.contains("/join")) {
		getConnection();
	
		UserDto userDto = (UserDto) request.getAttribute("userDto");
	
		if (insert(userDto) > 0) {
			response.sendRedirect("login_form.jsp"); //redirect 다수 사용시 return 예약어 사용
			return;
		}
	
	}
	if (url.contains("/myinfo")) {
		request.setAttribute("isConfirm",true);
		
		getConnection();
		String userid = request.getParameter("userid");
		UserDto userDto = selectOne(userid);
		request.setAttribute("myinfo-result", userDto);	
		request.getRequestDispatcher("./myinfo.jsp").forward(request,response); //forwarding 처리 - !
		return ;
		
	
	}
%>



