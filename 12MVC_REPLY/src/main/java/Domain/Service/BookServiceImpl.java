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
	
	
	public Map<String, Object> getAllBooks(Criteria criteria) throws Exception{
		Map<String,Object> response = new LinkedHashMap();
		
		
		if(criteria.getType()==null || criteria.getType().isEmpty())
		{
			int offset = (criteria.getPageno()-1) * criteria.getAmount();	
			
			//페이지별 건수 
			List<BookDto> list =  bookDao.selectAll(offset,criteria.getAmount());
			
			//PageDto
			long totalCount = bookDao.count();
			PageDto pageDto = new PageDto(totalCount,criteria);
			System.out.println("Service pageDto : " + pageDto);
			
			if(list.size()>0) {
				response.put("status", true);
				response.put("list", list);
				response.put("pageDto", pageDto);
			}else {
				response.put("status", false);
			}
		}
		else
		{
			int offset = (criteria.getPageno()-1) * criteria.getAmount();
			//페이지별 건수 
			int amount = criteria.getAmount();
			String type = criteria.getType();
			String keyword = criteria.getKeyword();
			List<BookDto> list =  bookDao.selectAll(offset,amount,type,keyword);
			
			//PageDto
			long totalCount = bookDao.count(criteria);
			PageDto pageDto = new PageDto(totalCount,criteria);
			System.out.println("Service pageDto : " + pageDto);
			
			if(list.size()>0) {
				response.put("status", true);
				response.put("list", list);
				response.put("pageDto", pageDto);
			}else {
				response.put("status", false);
			}
			
		}
		
		
		return response;
	}
	
	
	
	public Map<String, Object> getBook(String bookCode) throws Exception{
		
		Map<String, Object> response = new LinkedHashMap();
		
		BookDto bookDto =  bookDao.select(bookCode);
		
		if(bookDto == null)
			response.put("status", false);
		else {
			response.put("status", true);
			response.put("bookDto", bookDto);
		}
		
		return response;
	}
	public boolean modifyBook(BookDto bookDto) throws Exception{
		
		int result = bookDao.update(bookDto);

		return result>0;
	}
	
	public boolean removeBook(String bookCode) throws Exception{
		
		int result = bookDao.delete(bookCode);

		return result>0;
	}
	
	
}
