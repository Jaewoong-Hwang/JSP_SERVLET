package Controller.book;

import java.io.PrintWriter;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Controller.SubController;
import Domain.Dto.BookReplyDto;
import Domain.Service.BookServiceImpl;

public class BookReplyCreateController implements SubController{
	private HttpServletRequest req;
	private HttpServletResponse resp;	
	
	private BookServiceImpl bookService;

	public BookReplyCreateController() throws Exception{
		this.bookService = BookServiceImpl.getInstance();
	}

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		this.req = req;
		this.resp = resp;
		System.out.println("[SC] BookReplyCreateController execute..");
		
		try {
		
			//파라미터
			String bookCode = req.getParameter("bookCode");
			String username = null;
			String contents = req.getParameter("contents");
			LocalDateTime createAt = LocalDateTime.now();
			
			HttpSession session = req.getSession();
			username = (String)session.getAttribute("username");
			if(username==null)
				throw new ServletException("로그인이 필요합니다!");
			
			BookReplyDto dto = new BookReplyDto(-1,bookCode,username,contents,createAt);
			//유효성
			if(!isValid(dto))
				;
			
			//서비스
			boolean isAdded=bookService.bookReplyAdd(dto);
			
			//뷰 (JSON Data 전달)
			if(isAdded) {
				PrintWriter out = resp.getWriter();
				out.println("{\"message\":\"success!!!\"}");
			}else {
				PrintWriter out = resp.getWriter();
				out.println("{\"message\":\"fail...\"}");
			}
				
			
		}catch(Exception e) {
			exceptionHandler(e);
			try {
				req.getRequestDispatcher("/WEB-INF/view/book/error.jsp").forward(req, resp);
			}catch(Exception e2) {}
		}

	}

	private boolean isValid(BookReplyDto dto) {
		// TODO Auto-generated method stub
		return true;
	}

	
	// 예외처리함수
	public void exceptionHandler(Exception e) {
		req.setAttribute("status", false);
		req.setAttribute("message", e.getMessage());
		req.setAttribute("exception", e);
	}
}
