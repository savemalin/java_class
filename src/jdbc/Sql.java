package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Sql {
	private Connection getDBConnection() {
		Connection con = null; // 접속 정보 저장
		String url = "jdbc:oracle:thin:@//localhost:1521/xe"; // 접속할 DB 아이피 및 포트
		String userid = "SYS AS SYSDBA"; // 접속할 DB의 아이디
		String userpw = "807malin"; // 접속할 DB의 비밀번호

		try {
			Class.forName("oracle.jdbc.OracleDriver"); // 드라이버선언
			con = DriverManager.getConnection(url, userid, userpw);

		} catch (ClassNotFoundException e) { // 드라이버 예외
			e.printStackTrace();
			System.out.println("드라이버 예외");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("DB 예외");
		}

		return con;
	}

	// insert 기능 정의
	public int insertBook(Book registBook) {
		// DB접속 Connerction
		Connection con = getDBConnection();
		PreparedStatement pstmt = null;
		int insertResult = 0;

		// SQL 작성
		String sql = "INSERT INTO BOOKS(BID,BTITLE,BAUTHOR,BPUBLISHER,BEA)"
				+ " VALUES((SELECT NVL(MAX(BID),0)+1 FROM BOOKS) , ?, ?, ?, ?)";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, registBook.getBtitle());
			pstmt.setString(2, registBook.getBauthor());
			pstmt.setString(3, registBook.getBpublisher());
			pstmt.setInt(4, registBook.getBea());
			// SQL 실행 및 결과 반환
			insertResult = pstmt.executeUpdate();
			pstmt.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (con != null) {
					con.close();
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

		// SQL 접속된 DB에 전송

		// SQL 결과 확인

		return insertResult;
	}

	public int deleteBook(int deleteBid) {
		// DB접속
		Connection con = getDBConnection();
		PreparedStatement pstmt = null;
		int deleteResult = 0;

		// SQL 작성
		String sql = "DELETE FROM BOOKS WHERE BID = ? ";

		try {
			con.setAutoCommit(false);
			;
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, deleteBid);
			deleteResult = pstmt.executeUpdate();

			if (deleteResult == 1) {
				con.commit();
			} else {
				con.rollback();
				deleteResult = 0;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return deleteResult;
	}

	public int updateBook(int updateBid, String newTitle) {
		// DB 접속
		Connection con = getDBConnection();
		PreparedStatement pstmt = null;
		int updateResult = 0;

		// SQL 작성
		String sql = "UPDATE BOOKS" + " SET BTITLE = ? " + " WHERE BID = ? ";
		// SET BTITLE앞에 띄어쓰기를 안할경우
		// UPDATE FROM BOOKSSET BTITLE=?로 입력됌

		try {

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, newTitle);
			pstmt.setInt(2, updateBid);
			// SQL 실행
			updateResult = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		// SQL 결과 반환
		return updateResult;
	}

	public ArrayList<Book> selectBooks() {
		// DB 접속
		Connection con = getDBConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Book> bookList = new ArrayList<>();

		// SQL 작성
		String sql = "SELECT * FROM BOOKS";
		try {
			pstmt = con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				int bid=rs.getInt(1); // rs.getInt("BID");
				String btitle = rs.getString("BTITLE"); // rs.getString(2);
				String bauthor = rs.getString(3);
				String bpublisher = rs.getString(4);
				int bea = rs.getInt("BEA");
				
				Book book = new Book(bid, btitle, bauthor, bpublisher, bea);
				bookList.add(book);
//				bookList.add ( new Book( rs.getInt(1), rs.getString("BTITLE"), rs.getString(3), rs.getString(4), rs.getInt("BEA")));
				
				
			}
			

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null)rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		// SQL 결과 반환

		return bookList;
	}
	public ArrayList<Book> selectBook_title(String searchTitle){
		
		Connection con = getDBConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Book> bookList = new ArrayList<>();
		
		String sql = "SELECT * FROM BOOKS WHERE BTITLE LIKE ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,  "%"+searchTitle + "%");
			rs=pstmt.executeQuery();
			while(rs.next()) {
				Book book = new Book(rs.getInt("BID"),
									 rs.getString("BTITLE"),
									 rs.getString("BAUTHOR"),
									 rs.getString("BPUBLISHER"),
									 rs.getInt("BEA"));
				bookList.add(book);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	/*
	 * public ArrayList<Book> selectBook_SEARCH(String searchText, String colName) {
		
		Connection con = getDBConnection();
		PreparedStatement pstmt = null;
		
		ResultSet rs = null;
		ArrayList<Book> bookList = new ArrayList<>();
		
		String sql = "SELECT * FROM BOOKS ";
		sql +=  " WHERE " + colName + " LIKE ? ";  // '%검색어%'
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "%" + searchText + "%" );  // "%검색어%"
			rs = pstmt.executeQuery();
			while( rs.next() ) {
				Book book = new Book( rs.getInt("BID"), 
									  rs.getString("BTITLE"), 
									  rs.getString("BAUTHOR"), 
									  rs.getString("BPUBLISHER"), 
									  rs.getInt("BEA") );
				bookList.add( book );
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return bookList;
	}
	 * */

}
