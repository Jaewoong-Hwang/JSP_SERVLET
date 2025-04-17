package Domain.Dao;

import java.sql.SQLException;
import java.util.List;

import Domain.Dto.BookDto;
import Domain.Dto.UserDto;

public interface BookDao {

	int insert(BookDto bookDto) throws Exception;

	int update(BookDto bookDto) throws Exception;

	int delete(String bookCode) throws Exception;
	//단건조회

	UserDto select(UserDto userDto) throws SQLException;
	//다건조회
	public List<BookDto> selectAll() throws Exception;

	public List<BookDto> selectAll(int offset, int amount) throws Exception;
	
	public long count() throws Exception;

	BookDto select(String bookCode) throws Exception;

	List<BookDto> selectAll(int offset, int amount, String type, String keyword) throws Exception;
}