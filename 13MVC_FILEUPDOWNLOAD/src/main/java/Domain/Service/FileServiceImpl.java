package Domain.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Domain.Dao.UserDaoImpl;
import Domain.Dao.ConnectionPool.ConnectionPool;

public class FileServiceImpl {
	// 싱글톤 패턴
	private static FileServiceImpl instance;

	private FileServiceImpl() throws Exception {

		System.out.println("[SERVICE] FileServiceImpl init...");
	};

	public static FileServiceImpl getInstance() throws Exception {
		if (instance == null)
			instance = new FileServiceImpl();
		return instance;
	}
	
	public boolean upload(HttpServletRequest req, HttpServletResponse resp) {
		
		
		return false;
	}
}
