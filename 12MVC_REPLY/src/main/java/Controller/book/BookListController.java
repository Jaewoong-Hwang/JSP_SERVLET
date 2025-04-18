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

public class BookListController implements SubController{
	private HttpServletRequest req;
	private HttpServletResponse resp;
	
	private BookServiceImpl bookService;

	public BookListController() throws Exception{
		this.bookService = BookServiceImpl.getInstance();
	}
	
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		this.req = req;
		this.resp = resp;
		System.out.println("[SC] BookListController execute..");
	
		try {

			//파라미터 
			String pageno = req.getParameter("pageno");
			String amount = req.getParameter("amount");
			String type = req.getParameter("type");
			String keyword =req.getParameter("keyword");
			
			Criteria criteria=null;
			if(pageno==null) {
				criteria =new Criteria();	//pageno=1,amount=10,type=null,keyword=null
			}else {
				
				criteria =new Criteria(pageno,10,type,keyword);
			}
			
			//입력값
			
			//서비스
			Map<String,Object> serviceResponse =  bookService.getAllBooks(criteria);
			Boolean status = (Boolean)serviceResponse.get("status");
			PageDto pageDto = (PageDto)serviceResponse.get("pageDto");
			
			//뷰
			if(status) {
				List<BookDto> list = (List<BookDto>)serviceResponse.get("list");
				req.setAttribute("list", list);
				req.setAttribute("pageDto", pageDto);
			}
			
			req.getRequestDispatcher("/WEB-INF/view/book/list.jsp").forward(req, resp);
			
			
			
	
		}catch(Exception e) {
			e.printStackTrace();
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
