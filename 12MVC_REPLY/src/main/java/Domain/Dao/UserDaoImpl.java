package Domain.Dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import Domain.Dto.UserDto;



public class UserDaoImpl extends Dao implements UserDao{

	//싱글톤 패턴처리
	private static UserDao instance;
	private UserDaoImpl() throws Exception {
		System.out.println("[DAO] UserDaoImpl init...");		
	};
	public static UserDao getInstance() throws Exception {
		if(instance==null)
			instance = new UserDaoImpl();
		return instance;
	}
	
	//CRUD 
	@Override
	public int insert(UserDto userDto) throws Exception {
		try {
			
			connectionItem = connectionPool.getConnection();
			Connection conn = connectionItem.getConn();
			
			pstmt = conn.prepareStatement("insert into tbl_user values(?,?,?)");
			pstmt.setString(1, userDto.getUsername());
			pstmt.setString(2, userDto.getPassword());
			pstmt.setString(3, "ROLE_USER");
			
			//Connection release
			connectionPool.releaseConnection(connectionItem);
			
			return pstmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
			throw new SQLException("USERDAO's INSERT SQL EXCEPTION!!");
		}finally {
			try {pstmt.close();}catch(Exception e2) {}
		}
	}
	
 
	@Override
	public int update(UserDto userDto) throws SQLException {

		return 0;
	}
 
	@Override
	public int delete(UserDto userDto) throws SQLException {
//		try {
//			pstmt = conn.prepareStatement("");
//			
//			return pstmt.executeUpdate();
//			
//		}catch(SQLException e) {
//			e.printStackTrace();
//			throw new SQLException("USERDAO's DELETE SQL EXCEPTION!!");
//		}finally {
//			try {pstmt.close();}catch(Exception e2) {}
//		}
		return 0;
	}
	//단건조회
 
	@Override
	public UserDto select(String username) throws Exception{	
		try {
			
			connectionItem = connectionPool.getConnection();
			Connection conn = connectionItem.getConn();
			
			pstmt = conn.prepareStatement("select * from tbl_user where username=?");	
			pstmt.setString(1, username);
			rs = pstmt.executeQuery();
			
			UserDto userDto = null;
			if(rs!=null && rs.next()) 
				userDto = new UserDto(rs.getString(1),rs.getString(2),rs.getString(3));
				
			//Connection release
			connectionPool.releaseConnection(connectionItem);
			
			return userDto;
			
		}catch(SQLException e) {
			e.printStackTrace();
			throw new SQLException("USERDAO's INSERT SQL EXCEPTION!!");
		}finally {
			try {pstmt.close();}catch(Exception e2) {}
		}
	}
	
	//다건조회
 
	@Override
	public List<UserDto> selectAll() {	
		return null;
	}	
	
	

}



