package Controller.book;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.SubController;
import Domain.Dto.BookDto;
import Domain.Service.BookServiceImpl;

public class BookListController implements SubController{

	private HttpServletRequest req;
	private HttpServletResponse resp;
	
	private BookServiceImpl bookService;
	
	public BookListController() throws Exception {
		//bookService=BookServiceImpl.getInstance();
		
	}

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		this.req = req;
		this.resp = resp;
		System.out.println("[SC] BookListController execute..");
		
		try {
		String uri = req.getMethod();
		if(uri.equals("GET")) {
			req.getRequestDispatcher("/WEB-INF/view/book/list.jsp").forward(req, resp);
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
		boolean isJoin =  userService.userJoin(userDto);
	
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
			
		}
		
		private boolean isValid(BookDto bookDto) {
			if(bookDto.getBookCode()==null || bookDto.getBookCode().length()<=4){
				req.setAttribute("bookcode_err", "bookcode의 길이는 최소 5자 이상이어야 합니다.");
				System.out.println("[INVALID] bookcode의 길이는 최소 5자 이상이어야 합니다.");
				return false;
			}
			if(bookDto.getBookCode().matches("^[0-9].*")) {
				System.out.println("[INVAILD] bookcode의 첫문자로 숫자가 들어올 수 없습니다.");
				req.setAttribute("bookcode_err", "bookcode의 첫문자로 숫자가 들어올 수 없습니다" );
				return false;
				
			}
		
			
			
			
			return true;
			
		}
		
		
		
		// 예외처리함수
		public void exceptionHandler(Exception e) {
			req.setAttribute("status", false);
			req.setAttribute("message", e.getMessage());
			req.setAttribute("exception", e);
	}

}
