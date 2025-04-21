package Domain.Dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;

import Domain.Dto.BookDto;
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
	public List<BookReplyDto> selectAll(String bookCode)  throws Exception{
		List<BookReplyDto> list = new LinkedList();
		BookReplyDto dto = null;
		try {
			//connection  get
			connectionItem = connectionPool.getConnection();
			Connection conn = connectionItem.getConn();		
			pstmt = conn.prepareStatement("select * from tbl_reply where bookCode=? order by no desc");
			pstmt.setString(1, bookCode);
			
			rs=pstmt.executeQuery();
			if(rs!=null) {
				
				while(rs.next()) {
					dto = new BookReplyDto();
						dto.setNo(rs.getInt(1));
						dto.setBookCode(rs.getString(2));
						dto.setUsername(rs.getString(3));
						dto.setContents(rs.getString(4));
						dto.setCreateAt(rs.getTimestamp(5).toLocalDateTime());
					
					list.add(dto);
				}
			}
			return list;		
		}catch(SQLException e) {
			e.printStackTrace();
			throw new SQLException("BOOKDAO's SELECT SQL EXCEPTION!!");
		}finally {
			try {pstmt.close();}catch(Exception e2) {}
			//connection release
			connectionPool.releaseConnection(connectionItem);	
		}
	}
	
	
	public long count(String bookCode) throws Exception{
		long count=0;
		try {
			//connection  get
			connectionItem = connectionPool.getConnection();
			Connection conn = connectionItem.getConn();
			
			pstmt = conn.prepareStatement("select count(*) from tbl_reply where bookCode=?");
			pstmt.setString(1, bookCode);
			
			rs=pstmt.executeQuery();
			
			if(rs!=null&& rs.next())
				count = rs.getLong(1);
				
			return count;	
			
		}catch(SQLException e) {
			e.printStackTrace();
			throw new SQLException("BOOKDAO's SELECT SQL EXCEPTION!!");
		}finally {
			try {pstmt.close();}catch(Exception e2) {}
			//connection release
			connectionPool.releaseConnection(connectionItem);	
		}
		
	}
	
	
}
