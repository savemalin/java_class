package jdbcTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConnetTest {

	public static void main(String[] args) {
		Connection con = null; // 접속 정보 저장
		String url = "jdbc:oracle:thin:@//localhost:1521/xe"; // 접속할 DB 아이피 및 포트
		String userid = "SYS AS SYSDBA"; // 접속할 DB의 아이디
		String userpw = "807malin"; // 접속할 DB의 비밀번호
		int insertResult=0;
		
		try {
			Class.forName("oracle.jdbc.OracleDriver"); // 드라이버선언
			con = DriverManager.getConnection(url, userid, userpw);//getConnection - 스태틱으로 설정되어 있음
			System.out.println("DB접속");
			con.setAutoCommit(false);
			
			/* 1. 쿼리문 작성 전송 */
			String sql = "INSERT INTO BOOKS(BID, BTITLE, BAUTHOR, BPUBLISHER,BEA)"
						+ "VALUES(4,'html','css','js',5)";
			PreparedStatement pstmt=con.prepareStatement(sql);
			insertResult=pstmt.executeUpdate();			
			
			/* 2. 결과값 확인 처리 */
			System.out.println("insertResult : "+ insertResult);
			if(insertResult>0) {
				con.commit();
			}else {
				con.rollback();
			}
			
		} catch (ClassNotFoundException e) { // 드라이버 예외
			e.printStackTrace();
			System.out.println("드라이버 예외");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("DB 예외");
		}	
		
		
		
		
		
		
	}

}
