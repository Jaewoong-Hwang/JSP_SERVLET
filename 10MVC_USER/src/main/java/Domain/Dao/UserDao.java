package Domain.Dao;

import java.sql.SQLException;
import java.util.List;

import Domain.Dto.UserDto;



public interface UserDao {

	int insert(UserDto userDto) throws Exception;

	int update(UserDto userDto) throws SQLException;

	int delete(UserDto userDto) throws SQLException;
	//단건조회

	UserDto select(String username) throws Exception;
	//다건조회

	List<UserDto> selectAll();

}