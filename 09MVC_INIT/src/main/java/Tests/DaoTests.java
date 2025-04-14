package Tests;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import Domain.UserDao;
import Domain.UserDaoImpl;
import Domain.Dto.UserDto;

class DaoTests {

	
	@Test
	@Disabled
	void test() throws Exception {
		UserDao userDao = UserDaoImpl.getInstance();
	
		userDao.insert(new UserDto("user1234","1234","ROLE_USER"));
	}

}
