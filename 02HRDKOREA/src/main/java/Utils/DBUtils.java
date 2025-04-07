package Utils;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;



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
	
	public List<MemberDto> selectAllMember() throws Exception{
//		<!-- 
//		select M.M_NO,M.M_NAME,P.P_NAME,M.P_SCHOOL,m.m_jumin,M.M_CITY,P.P_TEL1,P.P_TEL2,p.p_tel3
//		from tbl_member_202005 M
//		join tbl_party_202005 p
//		on m.p_code=p.p_code; -->
		
		
		String sql=""
				+ "select M.M_NO,M.M_NAME,P.P_NAME,M.P_SCHOOL,m.m_jumin,M.M_CITY,P.P_TEL1,P.P_TEL2,p.p_tel3"
				+ " from tbl_member_202005 M"
				+ " join tbl_party_202005 p"
				+ " on m.p_code=p.p_code";
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		List<MemberDto> list= new ArrayList();
		MemberDto dto = null;
		
		if(rs!=null) {
			while(rs.next()) {
				dto = new MemberDto();
				dto.setM_no(rs.getString(1));
				dto.setM_name(rs.getString(2));
				dto.setP_name(rs.getString(3));
				dto.setP_school(rs.getString(4));
				dto.setM_jumin(rs.getString(5));
				dto.setM_city(rs.getString(6));
				dto.setP_tel1(rs.getString(7));
				dto.setP_tel2(rs.getString(8));
				dto.setP_tel3(rs.getString(9));
				list.add(dto);
				
			}
			
			
		}
		pstmt.close();
		rs.close();		
		return null;
		
		
	}


}
