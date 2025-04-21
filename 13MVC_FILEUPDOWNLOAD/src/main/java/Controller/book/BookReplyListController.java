package Controller.book;

import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import Controller.SubController;
import Domain.Dto.BookReplyDto;
import Domain.Service.BookServiceImpl;

public class BookReplyListController implements SubController{
	private HttpServletRequest req;
	private HttpServletResponse resp;
	
	private BookServiceImpl bookService;

	public BookReplyListController() throws Exception{
		this.bookService = BookServiceImpl.getInstance();
	}
	
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		this.req = req;
		this.resp = resp;
		System.out.println("[SC] BookServiceImpl execute..");
	
		try {
			
			//파라미터 
			String bookCode =req.getParameter("bookCode");
			
			//입력값
			if(!isValid(bookCode))
				;
			
			//서비스
			List<BookReplyDto> serviceResponse =  bookService.getAllBookReply(bookCode);
			long cnt = bookService.bookReplyCount(bookCode);
			
			Map<String,Object> responseEntity = new LinkedHashMap();
			responseEntity.put("replyCnt", cnt);
			responseEntity.put("replyList", serviceResponse);
			
			//뷰(Data 전달 JSON)
			resp.setContentType("application/json");
			ObjectMapper objectMapper= new ObjectMapper();
			
			objectMapper.registerModule(new JavaTimeModule());
			objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
			
			String JsonData = objectMapper.writeValueAsString(responseEntity);
			
			PrintWriter out = resp.getWriter();
			out.write(JsonData);
			
	
		}catch(Exception e) {
			e.printStackTrace();
			exceptionHandler(e);
			try {
				req.getRequestDispatcher("/WEB-INF/view/book/error.jsp").forward(req, resp);
			}catch(Exception e2) {}
		}

	}

	
	private boolean isValid(String bookCode) {
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
