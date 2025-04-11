package Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Utils.MysqlDbUtils;
import Utils.UserDto;

@WebServlet("/join.do")
public class Join extends HttpServlet{
	
	private MysqlDbUtils dbutils;
	
	
	@Override
	public void init() throws ServletException {
		try {
			dbutils = MysqlDbUtils.getInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//GET - 	/join.do - /WEB-INF/user/join.jsp 연결
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("GET /join.do");
		req.getRequestDispatcher("/WEB-INF/user/join.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("POST /join.do");
		//파라미터 받기
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		//유효성(생략)
		
		//처리작업(DB저장)
		int result=0;
		try {
			result = dbutils.insert(new UserDto(username,password,"ROLE_USER"));
		
		} catch (Exception e) {
			e.printStackTrace();
		}

		//뷰
		if(result>0) {
			resp.sendRedirect(req.getContextPath()+"/login.do");
		}else {
			req.getRequestDispatcher("/WEB-INF/user/join.jsp").forward(req, resp);
		}
	}

	
	//POST - /join.do - 회원가입처리(username,password 받아 DBUtils를 이용한 DB INSERT)
	//테이블 : tbl_user(요청 파라미터에 맞게 적절히 생성)
	//성공시 - /login.do 로 리다이렉트
	//실패시 - /join.do 로 포워딩
	
	
}
