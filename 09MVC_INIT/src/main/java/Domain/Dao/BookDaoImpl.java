//package Domain.Dao;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.List;
//
//import Ch38.Domain.Dao.ConnectionPool.ConnectionItem;
//import Ch38.Domain.Dao.ConnectionPool.ConnectionPool;
//import Ch38.Domain.Dto.BookDto;
//import Ch38.Domain.Dto.UserDto;
//
//public class BookDaoImpl implements BookDao {
//	//DB Attr
////	private Connection conn;
//	private PreparedStatement pstmt;
//	private ResultSet rs;
//	
////	private String id="root";
////	private String pw="1234";
////	private String url="jdbc:mysql://localhost:3306/bookDB";
//	
//	private ConnectionPool connectionPool;
//	private ConnectionItem connectionItem;
//	
//	
//	//싱글톤
//	
//	private static BookDao instance;
//	private BookDaoImpl() throws ClassNotFoundException, SQLException {
////		Class.forName("com.mysql.cj.jdbc.Driver");
////		conn = DriverManager.getConnection(url,id,pw);
//		connectionPool = ConnectionPool.getInstance();
//		System.out.println("UserDaoImpl DB Connection Success");
//		
//	};
//	public static BookDao getInstance() throws ClassNotFoundException, SQLException {
//		if(instance==null)
//			instance=new BookDaoImpl();
//		return instance;
//	}
//	
//	//CRUD 
//	 
//	@Override
//	public int insert(BookDto bookDto) throws Exception {
//		try {
//			//connection  get
//			connectionItem = connectionPool.getConnection();
//			Connection conn = connectionItem.getConn();
//			
//			pstmt = conn.prepareStatement("insert into tbl_book values(?,?,?,?)");
//			pstmt.setString(1, bookDto.getBookCode());
//			pstmt.setString(2, bookDto.getBookName());
//			pstmt.setString(3, bookDto.getPublisher());
//			pstmt.setString(4, bookDto.getIsbn());
//			
//			//connection release
//			connectionPool.releaseConnection(connectionItem);
//			
//			return pstmt.executeUpdate();
//			
//		}catch(SQLException e) {
//			e.printStackTrace();
//			throw new SQLException("BOOKDAO's INSERT SQL EXCEPTION!!");
//		}finally {
//			try {pstmt.close();}catch(Exception e2) {}
//		}
//	}
//	
// 
//	@Override
//	public int update(UserDto userDto) throws SQLException {
//		return 0;
//	}
// 
//	@Override
//	public int delete(UserDto userDto) throws SQLException {
//		return 0;
//	}
//	//단건조회
// 
//	@Override
//	public UserDto select(UserDto userDto) {	
//		return null;
//	}
//	//다건조회
// 
//	@Override
//	public List<UserDto> selectAll() {	
//		return null;
//	}	
//
//}
//
//
//
//
