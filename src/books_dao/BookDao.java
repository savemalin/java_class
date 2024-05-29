package books_dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import books_dto.Book;

public class BookDao {
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

	/* 도서 등록 */
	public int insertBook(Book registBook) {
		Connection con = getDBConnection();
		PreparedStatement pstmt = null;
		int insertResult = 0;

		String sql = "INSERT INTO BOOKS(BID, BTITLE, BAUTHOR, BPUBLISHER, BEA"
				+ " VALUES((SELECT NVL(MAX(BID),0)+1 FROM BOOKS), ?, ?, ?, ?)";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, registBook.getBtitle());
			pstmt.setString(2, registBook.getBauthor());
			pstmt.setString(3, registBook.getBpublisher());
			pstmt.setInt(4, registBook.getBea());
			insertResult = pstmt.executeUpdate();
			pstmt.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();

		}
		return insertResult;

	}

	/* 전체 도서 목록 */
	public ArrayList<Book> selectBookList() {
		// DB 접속
		Connection con = getDBConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Book> bookList = new ArrayList<>();

		// SQL 작성
		String sql = "SELECT * FROM BOOKS ";
		
		sql +=" ORDER BY BID";
		
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Book book = new Book(rs.getInt("BID"), rs.getString("BTITLE"), rs.getString(3), rs.getString(4),
						rs.getInt("BEA"));

				bookList.add(book);			

			}

		} catch (SQLException e) {
			e.printStackTrace();

		}

		// SQL 결과 반환

		return bookList;
	}

	/* 도서 검색 - 제목으로 검색 */
	public ArrayList<Book> selectBookListByTitle(String btitle) {
		Connection con = getDBConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Book> bookList = new ArrayList<>();

		String sql = "SELECT * FROM BOOKS WHERE BTITLE LIKE ? ";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, btitle);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Book book = new Book(rs.getInt("BID"), 
									rs.getString("BTITLE"), 
									rs.getString(3), 
									rs.getString(4),
									rs.getInt("BEA"));

				bookList.add(book);		

			}

		} catch (SQLException e) {
			e.printStackTrace();

		}

		// SQL 결과 반환

		return bookList;
	}

}
