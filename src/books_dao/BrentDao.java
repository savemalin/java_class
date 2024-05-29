package books_dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import books_dto.Brent;

public class BrentDao {

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

	/* 도서 대여 - BRENT(INSERT), BOOKS(UPDATE) */
	public int bookRent(Brent brent) {
		Connection con = getDBConnection();
		PreparedStatement pstmt = null;
		int insertResult = 0;
		int updateResult = 0;

		String insertSql = "INSERT INTO BRENT(RID, MID, BID) " + " VALUES(SELECT NVL(MAX(RID),0)+1 FROM BRENT, ?, ?)";

		String updateSql = "UPDATE BOOKS" + " SET BEA = BEA -1" + " WHERE BID = ?";

		try {
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(insertSql);
			// 맵핑
			pstmt.setString(1, brent.getMid());
			pstmt.setInt(2, brent.getBid());
			insertResult = pstmt.executeUpdate();

			pstmt = con.prepareStatement(updateSql);
			// 맵핑
			pstmt.setInt(1, brent.getBid());

			updateResult = pstmt.executeUpdate();

			if (insertResult > 0 && updateResult > 0) {
				con.commit();
			} else {
				con.rollback();
			}

		} catch (SQLException e) {
			try {
				con.rollback();

			} catch (SQLException rollbackE) {
				rollbackE.printStackTrace();
			}
			e.printStackTrace();
		} finally {

		}

		return updateResult;
	}

	/* 도서 반납 BRENT(UPDATE), BOOKS(UPDATE) */
	public int bookReturn(Brent brent) {
		Connection con = getDBConnection();
		PreparedStatement pstmt = null;
		int updateBrentResult = 0;
		int updateBookResult = 0;
		
		String updateBrentSql = "UPDATE BRENT "
			 	             + " SET RETURNDATE = SYSDATE "
			 	             + " WHERE RID = ? ";
		
		String updateBookSql = "UPDATE BOOKS "
				        + " SET BEA = BEA + 1 "
				        + " WHERE BID = ? ";
		
		try {
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(updateBrentSql);
			pstmt.setInt(1, brent.getRid());
			updateBrentResult = pstmt.executeUpdate();
			
			pstmt = con.prepareStatement(updateBookSql);
			pstmt.setInt(1, brent.getBid());
			updateBookResult = pstmt.executeUpdate();
			
			if(updateBrentResult > 0 && updateBookResult > 0) {
				con.commit();
			} else {
				con.rollback();
			}
			
		} catch (SQLException e) {
			try {
				con.rollback();
			} catch (SQLException rollbackE) {
				rollbackE.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			
			
		}
		return updateBookResult;		
		
		
	}

	/* 대여 목록 */
	public ArrayList<Brent> rentListByMid(String mid, Boolean allList){
		Connection con = getDBConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Brent> rentList = new ArrayList<>();
		
		String sql = " SELECT"
					+"FROM BRENT R"
					+"INNER JOIN MEMBERS"
					+"ON R.MID = M.MID"
					+"INNER JOIN BOOKS B"
					+"ON R.BID = B.BID"
					+"WHERE M.MID = ?";
		if(!allList) {
			sql += " AND R.RETURNDATE IS NULL ";
			
		}
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mid);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Brent brent = new Brent();
				brent.setRid(rs.getInt("RID"));
				brent.setRentdate(rs.getString("RENTDATE"));
				brent.setReturndate(rs.getString("RETURNDATE"));
				
				brent.getMember().setMid(rs.getString("MID"));
				brent.getMember().setMpw(rs.getString("MPW"));
				brent.getMember().setMname(rs.getString("MNAME"));
				brent.getMember().setMemail(rs.getString("MEMAIL"));
				brent.getMember().setMphone(rs.getString("MPHONE"));
				brent.getMember().setMdate(rs.getString("MDATE"));
				
				brent.getBook().setBid(rs.getInt("BID"));
				brent.getBook().setBtitle(rs.getString("BTITLE"));
				brent.getBook().setBauthor(rs.getString("BAUTHOR"));
				brent.getBook().setBpublisher(rs.getString("BPUBLISHER"));
				brent.getBook().setBea(rs.getInt("BEA"));
				
				rentList.add(brent);
				
				
				
				
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
		
		
		return rentList;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
