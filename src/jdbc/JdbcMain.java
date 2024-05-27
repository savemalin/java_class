package jdbc;

import java.util.ArrayList;
import java.util.Scanner;

public class JdbcMain {

	public static void main(String[] args) {
		/* INSERT, SELECT, UPDATE, DELETE */
		Scanner sc = new Scanner(System.in);
		Sql sql = new Sql();
		
		while(true) {
			System.out.println("[1]입력 [2]조회 [3]수정 [4]삭제");
			System.out.print("선택 :");
			String selMenu = sc.next();
			switch(selMenu) {
			case "1":
				System.out.println("[INSERT]");
				System.out.print("제목 : ");
				String registBookTitle = sc.next();
				System.out.print("저자 : ");
				String registBookAuthor = sc.next();
				System.out.print("출판사 : ");
				String registBookPublisher = sc.next();
				System.out.print("재고 : ");
				int registBookEa = sc.nextInt();
				Book registBook = new Book(0, registBookTitle,registBookAuthor,registBookPublisher,registBookEa);
				System.out.println(registBook);
				
				// Books 테이블에 insert 수행
				int insertResult = sql.insertBook(registBook);
				
				if(insertResult>0) {
					System.out.println("새 책이 등록되었습니다.");
				}else {
					System.out.println("새 책 등록에 실패하였습니다.");
				}
				
				break;
			
			case "2":
				System.out.println("[SELECT]");
				// SELECT * FROM BOOKS
				ArrayList<Book> bookList = sql.selectBooks();
				if(bookList.size()>0) {
					//조회되는 책 목록 있음
					for(Book bookInfo : bookList) {
						System.out.println("[제목]"+bookInfo.getBtitle()+", [재고]"+bookInfo.getBea());
					}
					
				}else {
					//조회되는 책목록 없음
					
				}
				
				
				
				
				
				break;
				
			case "3":
				System.out.println("[UPDATE]");
				/* UPDATE BOOKS
				 * SET BTITLE = ?
				 * WHERE BID = ? */
				System.out.print("수정할 BID : ");
				int updateBid = sc.nextInt();
				System.out.print("새 제목 : ");
				String newTitle = sc.next();
				int updateResult = sql.updateBook(updateBid, newTitle);
				
				if(updateResult >0) {
					System.out.println("책 정보가 수정되었습니다.");
				}else {
					System.out.println("책 정보 수정을 실패하였습니다.");
				}
				
				break;
				
				
			case "4":
				
				System.out.println("[DELETE]");
				System.out.print("삭제할 BID : ");
				int deleteBid = sc.nextInt();
				
				//Books 테이블에 delete 수행
				// DELETE FROM BOOKS WHERE BID = ?
				int deleteResult = sql.deleteBook(deleteBid);
				
				if(deleteResult >0) {
					System.out.println("책정보가 삭제 되었습니다");
				}else {
					System.out.println("책정보 삭제에 실패하였습니다.");
				}
				
				
				
				break;
				
			case "5":
				System.out.println("[SELECT - WHERE]");
				// SELECT * FROM BOOKS WHERE BTITLE LIKE '%?%'
				// pstmt.setString(1, "검색어"); =>> SELECT * FROM BOOKS WHERE BTITLE LIKE ? - ?는 문자열
				//고로 SELECT * FROM BOOKS WHERE BTITLE LIKE ? =>> ? '%검색어%' 이 검색어를 만드는법은?
				// ? :: pstmt.setSting(1, "A") :: 'A'
				
				System.out.print("검색할 제목 :");
				String searchTitle = sc.next();
				
				ArrayList<Book> searchList = sql.selectBook_title(searchTitle);
				if(searchList.size() > 0) {
					for(Book bookInfo : searchList) {
						System.out.println("[제목]"+bookInfo.getBtitle()+",[재고]"+bookInfo.getBea());
					}
				}else {
					System.out.println("검색 결과가 없습니다.");
				}
				
				break;
				
			
				default:
					sc.close();
					return;
							
			
			
			
			
			}
			
			
			
			
			
			
			
		}
		
		
		
		
		
		
		
		
		
	}

}
