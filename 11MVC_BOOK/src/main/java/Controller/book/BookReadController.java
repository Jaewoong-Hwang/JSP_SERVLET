package Controller.book;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.SubController;
import Domain.Dto.BookDto;
import Domain.Dto.Criteria;
import Domain.Dto.PageDto;
import Domain.Service.BookServiceImpl;

public class BookReadController implements SubController{
	private HttpServletRequest req;
	private HttpServletResponse resp;
	
	private BookServiceImpl bookService;

	public  BookReadController() throws Exception{
		this.bookService = BookServiceImpl.getInstance();
	}
	
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		this.req = req;
		this.resp = resp;
		System.out.println("[SC]  BookReadController execute..");
		

		try {

			//파라미터 
			
		
			
			
				
			req.getRequestDispatcher("/WEB-INF/view/book/read.jsp").forward(req, resp);
			//입력값
			
			//서비스
		
			//뷰
			
			
			req.getRequestDispatcher("/WEB-INF/view/book/read.jsp").forward(req, resp);
			
			
			
	
		}catch(Exception e) {
			exceptionHandler(e);
			try {
				req.getRequestDispatcher("/WEB-INF/view/book/error.jsp").forward(req, resp);
			}catch(Exception e2) {}
		}

	}

	
	private boolean isValid(BookDto bookDto) {
		return true;
	}
	
	// 예외처리함수
	public void exceptionHandler(Exception e) {
		req.setAttribute("status", false);
		req.setAttribute("message", e.getMessage());
		req.setAttribute("exception", e);
	}
}
