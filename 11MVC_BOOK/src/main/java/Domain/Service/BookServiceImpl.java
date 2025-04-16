package Domain.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import Domain.Dao.BookDao;
import Domain.Dao.BookDaoImpl;
import Domain.Dto.BookDto;

public class BookServiceImpl {

	//
	private BookDao bookDao;
	
	//싱글톤 패턴
	private static BookServiceImpl instance;
	private BookServiceImpl() throws Exception{	
		bookDao = BookDaoImpl.getInstance();
	}
	public static BookServiceImpl getInstance() throws Exception{
		if(instance==null)
			instance = new BookServiceImpl();
		return instance;
	}
	
	
	//TX 처리 + 비즈니스 유효성검사(도서추가 -)
	public boolean bookRegistration(BookDto bookDto) throws Exception{
		
		int result = bookDao.insert(bookDto);
		
		return result>0;
		
	}
	
	public Map<String,Object> getAllBooks() throws Exception {
		Map<String,Object> response = new LinkedHashMap();
		
		List<BookDto> list =  bookDao.selectAll();
		if(list.size()>0) {
			response.put("status", true);
			response.put("list", list);
		}else {
			response.put("status", false);
		}

		return response;
	}
	
	
}
