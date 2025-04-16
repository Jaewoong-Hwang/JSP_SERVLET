package Controller.book;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.SubController;
import Domain.Dto.BookDto;
import Domain.Service.BookServiceImpl;

public class BookCreateController implements SubController {

	private HttpServletRequest req;
	private HttpServletResponse resp;
	
	private BookServiceImpl bookService;
	
	public BookCreateController() throws Exception {
		//bookService=BookServiceImpl.getInstance();
		
	}

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		this.req = req;
		this.resp = resp;
		System.out.println("[SC] BookCreateController execute..");
		
		try {
		String uri = req.getMethod();
		if(uri.equals("GET")) {
			req.getRequestDispatcher("/WEB-INF/view/book/create.jsp").forward(req, resp);
			return;
		}
		//파라미터
		String bookCode = req.getParameter("bookCode");
		String bookName = req.getParameter("bookName");
		String publisher = req.getParameter("publisher");
		String isbn = req.getParameter("isbn");
		//입력값 검증
		BookDto bookDto = new BookDto(bookCode,bookName,publisher,isbn);
		boolean isOk = isValid(bookDto);
		if(!isOk) {
			
			req.getRequestDispatcher("/WEB-INF/view/book/create.jsp").forward(req, resp);
			return;
			
		}
		//서비스
		//boolean isJoin =  userService.userJoin(userDto);
	
		//뷰
		if(isJoin) {
			resp.sendRedirect(req.getContextPath()+"/index.do");
		}else {
			req.getRequestDispatcher("/WEB-INF/view/user/join.jsp").forward(req, resp);
		}
		
		
	}catch(Exception e) {
		exceptionHandler(e);
		try {
			req.getRequestDispatcher("/WEB-INF/view/user/error.jsp").forward(req, resp);
		}catch(Exception e2) {}
	}
			
		
	
		
			
			
			
		
		
		
		
		// 예외처리함수
		public void exceptionHandler(Exception e) {
			req.setAttribute("status", false);
			req.setAttribute("message", e.getMessage());
			req.setAttribute("exception", e);
	}
}
