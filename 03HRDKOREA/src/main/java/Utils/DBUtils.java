package Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

	// 강사테이블조회
	public List<TeacherDto> selectAllTeacher() throws Exception {
		String sql = "select * from TBL_TEACHER_202201";
		pstmt = conn.prepareStatement(sql);

		rs = pstmt.executeQuery();
		List<TeacherDto> list = new ArrayList();
		TeacherDto dto = null;
		if (rs != null) {

			while (rs.next()) {
				// 코드 추가해주세요 -
				dto = new TeacherDto();
				dto.setTeacher_code(rs.getString(1));
				dto.setTeacher_name(rs.getString(2));
				dto.setClass_name(rs.getString(3));
				dto.setClass_price(rs.getInt(4));
				dto.setTeacher_regist_date(rs.getString(5));
				list.add(dto);
			}

		}

		return list;
	}

	public List<MemberDto> selectAllMember() throws Exception {
		String sql = "select * from TBL_MEMBER_202201";
		pstmt = conn.prepareStatement(sql);

		rs = pstmt.executeQuery();
		List<MemberDto> list = new ArrayList();
		MemberDto dto = null;
		if (rs != null) {

			while (rs.next()) {
				// 코드 추가해주세요 -
				dto = new MemberDto();
				dto.setC_no(rs.getString(1));
				dto.setC_name(rs.getString(2));
				dto.setPhone(rs.getString(3));
				dto.setAddress(rs.getString(4));
				dto.setGrade(rs.getString(5));
				list.add(dto);
			}

		}
		rs.close();
		pstmt.close();
		return list;
	}

	public List<ClassDto> selectAllClass() throws Exception {
		String sql = "select * from TBL_CLASS_202201";
		pstmt = conn.prepareStatement(sql);

		rs = pstmt.executeQuery();
		List<ClassDto> list = new ArrayList();
		ClassDto dto = null;
		if (rs != null) {

			while (rs.next()) {
				// 코드 추가해주세요 -
				dto = new ClassDto();
				dto.setRegist_month(rs.getString(1));
				dto.setC_no(rs.getString(2));
				dto.setClass_area(rs.getString(3));
				dto.setTuition(rs.getString(4));
				dto.setTeacher_code(rs.getString(5));
				list.add(dto);
			}

		}
		rs.close();
		pstmt.close();
		return list;
	}

	public int insertClass(ClassDto classDto) throws Exception {
		pstmt = conn.prepareStatement("insert into TBL_CLASS_202201 values(?,?,?,?,?)");
		
		pstmt.setString(1, classDto.getRegist_month());
		pstmt.setString(2, classDto.getC_no());
		pstmt.setString(3, classDto.getClass_area());
		pstmt.setString(4, classDto.getTuition());
		pstmt.setString(5, classDto.getTeacher_code());
		int result = pstmt.executeUpdate();

		conn.commit();

		pstmt.close();
		return result;
	}
}
