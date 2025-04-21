package Controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.book.BookCreateController;
import Controller.book.BookDeleteController;
import Controller.book.BookListController;
import Controller.book.BookReadController;
import Controller.book.BookReplyCreateController;
import Controller.book.BookReplyListController;
import Controller.book.BookUpdateController;
import Controller.user.AdminMainController;
import Controller.user.ManagerMainController;
import Controller.user.UserCreateController;
import Controller.user.UserLoginController;
import Controller.user.UserLogoutController;
import Controller.user.UserMainController;
import file.ListController;
import file.UploadController;

//@WebServlet("/")
@MultipartConfig  //여러 리퀘트에 분할 해서 전달

(
		fileSizeThreshold=1024*1024*10, //10MB 업로드 파일이 10MB 이상이 될 때 임시경로(temp)에 저장
		maxFileSize=1024*1024*50, //50MB 업로드 파일의 최대 크기
		maxRequestSize=1024*1024*100 // 100MB request전체의 크기
		
		
		)

public class FrontController extends HttpServlet {
	// 서브컨트롤러 저장 자료구조("/endPoint":서브컨트롤러객체)
	private Map<String, SubController> map = new HashMap();

	@Override
	public void init(ServletConfig config) throws ServletException {

		ServletContext context = config.getServletContext();
		try {
			// 기본
			map.put("/", new HomeController());
			map.put("/index.do", new HomeController());
			// ROLE별 메인
			map.put("/user/user", new UserMainController());
			map.put("/user/manager", new ManagerMainController());
			map.put("/user/admin", new AdminMainController());
			
			// 인증(/user/*) - 회원CRUD , 로그인 , 로그아웃
			map.put("/user/create", new UserCreateController());
			map.put("/user/login", new UserLoginController());
			map.put("/user/logout", new UserLogoutController());
			
			
			// 도서(/book/*) - 도서CRUD
			map.put("/book/list", new BookListController());
			map.put("/book/create", new BookCreateController());
			map.put("/book/read", new BookReadController());
			map.put("/book/update", new BookUpdateController());
			map.put("/book/delete", new BookDeleteController());
			
			map.put("/book/reply/create", new BookReplyCreateController());
			map.put("/book/reply/list", new BookReplyListController());
			
			
			//FILE
			map.put("/file/upload", new UploadController());
			map.put("/file/list", new ListController());
			
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException("서브컨트롤러 등록오류");
		}

	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			
			System.out.println("[FC] service...");
			String endPoint = req.getServletPath(); // ProjectPath 제외 EndPoint만
			System.out.println("[FC] endpoint .." + endPoint);
			SubController controller = map.get(endPoint); // 요청사항을 처리할 SubController get
			controller.execute(req, resp);
			
		} catch (Exception e) {
			e.printStackTrace();
			exceptionHandler(e,req);
			req.getRequestDispatcher("/WEB-INF/view/error.jsp").forward(req, resp);
		}
	}

	// 예외처리함수
	public void exceptionHandler(Exception e,HttpServletRequest req) {
		
		req.setAttribute("status", false);
		req.setAttribute("message", e.getMessage());
		req.setAttribute("exception", e);
	}

}
