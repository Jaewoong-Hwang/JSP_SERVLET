<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.sql.*" %>

<%
request.setCharacterEncoding("UTF-8");

// 사용자 입력 받기
String userid = request.getParameter("userid");
String password = request.getParameter("password");
String username = request.getParameter("username");

// 유효성 체크
boolean hasError = false;
if (userid == null || userid.trim().isEmpty()) {
    out.println("ID를 입력하세요.<br>");
    hasError = true;
}
if (password == null || password.trim().isEmpty()) {
    out.println("PW를 입력하세요.<br>");
    hasError = true;
}
if (username == null || username.trim().isEmpty()) {
    out.println("이름을 입력하세요.<br>");
    hasError = true;
}
if (hasError) {
    return;
}

// JDBC 연결 정보
String driver = "oracle.jdbc.driver.OracleDriver";
String url = "jdbc:oracle:thin:@localhost:1521:XE";
String dbUser = "system";      // Oracle 사용자 계정
String dbPassword = "1234"; // Oracle 사용자 비밀번호

Connection conn = null;
PreparedStatement pstmt = null;
ResultSet rs = null;


try {
    Class.forName(driver); // 드라이버 로드
    conn = DriverManager.getConnection(url, dbUser, dbPassword);

    
    // 1. 중복 ID 확인 쿼리
    String checkSql = "SELECT COUNT(*) FROM member WHERE user_id = ?";
    pstmt = conn.prepareStatement(checkSql);
    pstmt.setString(1, userid);
    rs = pstmt.executeQuery();

    boolean isDuplicate = false;
    if (rs.next()) {
        int count = rs.getInt(1);
        if (count > 0) {
            isDuplicate = true;
        }
    }

    rs.close();
    pstmt.close();

    if (isDuplicate) {
        out.println("<script>alert('이미 존재하는 계정입니다.'); location.href='join_form.jsp';</script>");
        return;
    }
    
    // INSERT SQL 실행
    String sql = "INSERT INTO member (user_id, user_pw, user_name) VALUES (?, ?, ?)";
    pstmt = conn.prepareStatement(sql);
    pstmt.setString(1, userid);
    pstmt.setString(2, password);
    pstmt.setString(3, username);

    int result = pstmt.executeUpdate();

    if (result > 0) {
        out.println("회원가입 성공!");
    } else {
        out.println("회원가입 실패!");
    }

} catch (Exception e) {
    e.printStackTrace();
    out.println("오류 발생: " + e.getMessage());
} finally {
    try { if (pstmt != null) pstmt.close(); } catch (Exception e) {}
    try { if (conn != null) conn.close(); } catch (Exception e) {}
}


	session.setAttribute("isAuth", true);
	session.setAttribute("role", "ROLE_ADMIN");
	session.setMaxInactiveInterval(30);
	out.println("<script> alert('login page로 이동합니다.');location.href='login.jsp'</script>");

	
%>
