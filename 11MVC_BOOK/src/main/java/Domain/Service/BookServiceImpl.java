package Domain.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import Domain.Dao.BookDao;
import Domain.Dao.BookDaoImpl;
import Domain.Dto.BookDto;
import Domain.Dto.Criteria;
import Domain.Dto.PageDto;

public class BookServiceImpl {

	//
	private BookDao bookDao;

	// 싱글톤 패턴
	private static BookServiceImpl instance;

	private BookServiceImpl() throws Exception {
		bookDao = BookDaoImpl.getInstance();
	}

	public static BookServiceImpl getInstance() throws Exception {
		if (instance == null)
			instance = new BookServiceImpl();
		return instance;
	}

	// TX 처리 + 비즈니스 유효성검사(도서추가 -)
	public boolean bookRegistration(BookDto bookDto) throws Exception {

		int result = bookDao.insert(bookDto);

		return result > 0;

	}

	public Map<String, Object> getAllBooks() throws Exception {
		Map<String, Object> response = new LinkedHashMap();

		List<BookDto> list = bookDao.selectAll();
		if (list.size() > 0) {
			response.put("status", true);
			response.put("list", list);
		} else {
			response.put("status", false);
		}

		return response;
	}

	public Map<String, Object> getAllBooks(Criteria criteria) throws Exception {
		Map<String, Object> response = new LinkedHashMap();

		// 오프셋 값
		int offset = (criteria.getPageno() - 1) * criteria.getAmount();
		// 페이지별 건수
		List<BookDto> list = bookDao.selectAll(offset, criteria.getAmount());

		// pageDto
		long totalcount = bookDao.count();
		PageDto pageDto = new PageDto(totalcount, criteria);

		if (list.size() > 0) {
			response.put("status", true);
			response.put("list", list);
			response.put("pageDto", pageDto);
		} else {
			response.put("status", false);
		}

		return response;
	}

	public Map<String, Object> getBook(String bookCode) throws Exception {
		Map<String, Object> response= new LinkedHashMap();
		
		BookDto bookDto = bookDao.select(bookCode);
		
		if(bookDto ==null)
			response.put("status",false);
		else {
		response.put("status",true);
		response.put("bookDto",bookDto);
		}
		return response;
	}

	public boolean modifyBook(BookDto bookDto) throws Exception {
		
		
		int bookDto2 = bookDao.update(bookDto);
		
		
		return bookDto2 > 0;
		
	}

}
