package Domain.Dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;

import Domain.Dto.BookReplyDto;

public class BookReplyDaoImpl extends Dao {

	
	//싱글톤 패턴처리
	private static BookReplyDaoImpl instance;
	private BookReplyDaoImpl() throws Exception {
		System.out.println("[DAO] BookReplyDaoImpl init...");		
	};
	public static BookReplyDaoImpl getInstance() throws Exception {
		if(instance==null)
			instance = new BookReplyDaoImpl();
		return instance;
	}
	
	public int insert(BookReplyDto dto) throws Exception {
		try {
			//connection  get
			connectionItem = connectionPool.getConnection();
			Connection conn = connectionItem.getConn();
			
			pstmt = conn.prepareStatement("insert into tbl_reply values(null,?,?,?,?)");
			pstmt.setString(1, dto.getBookCode());
			pstmt.setString(2, dto.getUsername());
			pstmt.setString(3, dto.getContents());
			pstmt.setTimestamp(4, Timestamp.valueOf(dto.getCreateAt() ));
			

			return pstmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
			throw new SQLException("BOOKDAO's INSERT SQL EXCEPTION!!");
		}finally {
			try {pstmt.close();}catch(Exception e2) {}
			//connection release
			connectionPool.releaseConnection(connectionItem);
		}
	}
	
}
