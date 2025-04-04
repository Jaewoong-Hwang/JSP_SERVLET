package C09;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import C04.UserDto;

public class DBUtils {

	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String id = "system";
	private String pw = "1234";

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	// 싱글톤
	private static DBUtils instance;

	private DBUtils() throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn = DriverManager.getConnection(url, id, pw);

	}

	public static DBUtils getInstance() throws Exception {
		if (instance == null)
			instance = new DBUtils();
		return instance;
	}

	// 3-4
	public int insertUser(UserDto userDto) throws Exception {
		pstmt = conn.prepareStatement("insert into tbl_user values(?,?,?)");
		pstmt.setString(1, userDto.getUserid());
		pstmt.setString(2, userDto.getPassword());
		pstmt.setString(3, userDto.getRole());
		int result = pstmt.executeUpdate();

		conn.commit();

		pstmt.close();
		return result;

	}

	public List<UserDto> selectAllUser() throws Exception {
		pstmt = conn.prepareStatement("select * from TBL_USER");
		rs = pstmt.executeQuery();
		List<UserDto> list = new ArrayList();
		UserDto userDto = null;

		if (rs != null) {
			while (rs.next()) {
				userDto = new UserDto();
				userDto.setUserid(rs.getString("userid"));
				userDto.setPassword(rs.getString("password"));
				userDto.setRole(rs.getString("role"));
				list.add(userDto);
			}
		}
		conn.commit();
		rs.close();
		pstmt.close();
		return list;

	}

	public UserDto selectOneUser(String userid) throws Exception {
		pstmt = conn.prepareStatement("select * from TBL_USER where userid=?");
		pstmt.setString(1, userid);
		rs = pstmt.executeQuery();

		UserDto userDto = null;
		if (rs != null) {
			if (rs.next()) {
				userDto = new UserDto();
				userDto.setUserid(rs.getString("userid"));
				userDto.setPassword(rs.getString("password"));
				userDto.setRole(rs.getString("role"));
			}
		}
		conn.commit();
		rs.close();
		pstmt.close();
		return userDto;
	}
	public int updateUser(UserDto userDto) throws Exception {
		pstmt = conn.prepareStatement("update TBL_USER set password=?, role=? where userid=?");
		pstmt.setString(1, userDto.getPassword());
		pstmt.setString(2, userDto.getRole());
		pstmt.setString(3, userDto.getUserid());
		int result = pstmt.executeUpdate();

		conn.commit();

		pstmt.close();
		return result;

	}

}
