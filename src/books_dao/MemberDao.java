package books_dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import books_dto.Member;

public class MemberDao {
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
	/* Member 테이블 관련 기능 */
	
	/* 회원가입 - INSERT */
	public int insertMember(Member member) {
		//DB 접속
		Connection con = getDBConnection();
		PreparedStatement pstmt = null;
		int insertResult = 0;
		
		String sql = "INSERT INTO MEMBERS(MID, MPW, MNAME, MEMAIL, MPHONE )"
					+" VALUES(?, ?, ?, ?, ?)";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, member.getMid());
			pstmt.setString(2, member.getMpw());
			pstmt.setString(3, member.getMname());
			pstmt.setString(4, member.getMemail());
			pstmt.setString(5, member.getMphone());
			insertResult = pstmt.executeUpdate();
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return insertResult;
		
		
		
		
	}
	/* 회원정보조회 - SELECT */ //회원정보조회 바탕의 로그인
	public Member selectMember(String mid, String mpw) {
		Connection con = getDBConnection();
		PreparedStatement pstmt = null;
		
		ResultSet rs = null;
		Member member = null;
		
		String sql = "SELECT * FROM MEMBERS WHERE MID = ? ";
		if(mpw != null) {
			sql += " AND MPW = ? ";
		}
		
		try {
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mid);
			if(mpw != null) {
				pstmt.setString(2, mpw);
			}
			rs=pstmt.executeQuery();
			while(rs.next()) {
				member = new Member();
				member.setMid(rs.getString("MID"));
				member.setMpw(rs.getString(2));
				member.setMname(rs.getString(3));
				member.setMemail(rs.getString("MEMAIL"));
				member.setMphone(rs.getString(5));
				member.setMdate(rs.getString(6));
				//getInt(),getString() 괄호안엔 숫자나 컬럼의 이름을 넣어도된다(순서정하기)
				
				
			}
			if(rs != null) {
				con.commit();
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try{
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null)con.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return member;
		
		
	} 
	
	
	
	
	
	
	
	
}
