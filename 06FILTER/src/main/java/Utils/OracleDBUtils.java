package Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class OracleDBUtils {
	
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String id = "system";
	private String pw = "1234";
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;	
	
	//싱글톤 
	private static OracleDBUtils instance;
	private OracleDBUtils() throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn = DriverManager.getConnection(url, id, pw);
	}
	public static OracleDBUtils getInstance() throws Exception {
		if(instance==null)
			instance = new OracleDBUtils();
		return instance;
	}
	
	public int insert(UserDto userDto) throws Exception {
		pstmt = conn.prepareStatement("insert into tbl_user values(?,?,?)");
		pstmt.setString(1,userDto.getUsername());
		pstmt.setString(2,userDto.getPassword());
		pstmt.setString(3,userDto.getRole());
		
		int result =  pstmt.executeUpdate();
		
		pstmt.close();
		return result;
	}
	
	public UserDto selectOne(String username) throws Exception {
		pstmt = conn.prepareStatement("select * form tbl_user where username=?");
		rs = pstmt.executeQuery();
		UserDto userDto = null;
		if(rs!=null) {
			rs.next();
			userDto = new UserDto(rs.getString(1),rs.getString(2),rs.getString(3));
		}
		return userDto;
	}

}







