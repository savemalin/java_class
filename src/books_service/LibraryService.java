package books_service;

import java.util.ArrayList;
import java.util.Scanner;

import books_dao.BookDao;
import books_dao.BrentDao;
import books_dao.MemberDao;
import books_dto.Book;
import books_dto.Brent;
import books_dto.Member;


public class LibraryService {
	private Scanner sc;
	private String loginId;// 로그인 중인 회원 아이디
	private Book book;
	
	private MemberDao mdao;
	private BookDao bdao;
	private BrentDao rdao;
	
	public LibraryService() {
		this.sc = new Scanner(System.in); 
		this.mdao = new MemberDao();
		this.bdao = new BookDao();
		this.rdao = new BrentDao();
		this.book = new Book();
	}

	public void start() {

		/* 메뉴 출력 */
		while (true) {
			libMenu(); // 메뉴 출력
			System.out.print("메뉴선택>>");
			String selMenu = sc.next(); // 사용자가 메뉴 선택

			switch (selMenu) { // 선택한 메뉴의 기능 호출
			case "1":
				memberJoin(); // 회원가입 기능 호출
				break;
			case "2":
				memberLogin();// 로그인 기능 호출
				break;
			case "3":
				rentalBook(); // 도서 대여 기능 호출
				break;
			case "4":
//				returnBook(); // 도서 반납 기능 호출
//				break;
//			case "5":
//				rentalList(); // 대여 목록 조회 기능 호출
				break;
			case "add":
				addBook(); // 도서 등록 기능 호출
				break;
//			case "list":
//				bookList(); // 도서 목록 조회 기능 호출
//				break;
//			case "exit":
//				memberLogout();// 로그아웃 기능 호출
//				break;
			default:
				System.out.println("다시 입력 해주세요!");
			}
		}

	}
	private void memberLogin() {
		System.out.println("[로그인]");
		System.out.print("로그인 할 아이디 : ");
		String mid = sc.next();
		System.out.print("로그인 할 비밀번호 : ");
		String mpw = sc.next();
		
		if(mid.equals("admin")&&mpw.equals("admin")) {
			System.out.println("관리자로 로그인 되었습니다.");
			this.loginId="admin";
			return;
		}
		Member loginMember = mdao.selectMember(mid, mpw);
		if(loginMember != null) {
			this.loginId = loginMember.getMid();
			System.out.println("로그인 되었습니다.");
		}else {
			System.out.println("아이디 또는 비밀번호가 일치하지 않습니다.");
		}
	}
	
	private void addBook() {
		System.out.println("[도서등록]");
		/* 1. 등록할 도서 정보 입력 */
		System.out.print("등록할 책 제목 : ");
		String btitle = sc.next();
		System.out.println("등록할 책 저자 : ");
		String bauthor = sc.next();
		System.out.print("등록할 책 출판사 : ");
		String bpublisher = sc.next();
		System.out.print("등록할 책 권수 : ");
		int bea = sc.nextInt();
		
		Book registBook = new Book(btitle, bauthor, bpublisher, bea);
		
		
		/* 2. Books 테이블에 도서정보 등록처리 */
		int addResult = bdao.insertBook(registBook);
		
		
		/* 3. 처리결과 확인 출력 */
		if(addResult > 0) {
			System.out.println("도서가 등록되었습니다.");
		}else {
			System.out.println("도서등록을 실패하였습니다.");
		}
		
		
	}
	
	private void returnBook() {
		System.out.println("[도서반납]");
		/* 미 반납된 대여 내역 조회 */
		ArrayList<Brent> brentList = rdao.rentListByMid(loginId, false);
		/* 대여내역 출력 */
		if(brentList.size()<=0) {
			System.out.println("반납할 도서가 없습니다.");
			return;
			
		}
		int index = 0;
		for(Brent brent : brentList) {
			System.out.print("["+index+"]"+brent.getBook().getBtitle());
			System.out.println(" [대여날짜 : "+brent.getReturndate()+"]");
			index++;
			
		}
		System.out.print("반납할 도서선택 : ");
		int selRent = sc.nextInt();
		Brent returnBrent = brentList.get(selRent);
		int rid = returnBrent.getRid();
		int bid = returnBrent.getBook().getBid();
		
			
		Brent reBook = new Brent();
		reBook.setBid(bid);
		reBook.setRid(rid);
		
		int returnResult = rdao.bookReturn(reBook);
		
		if(returnResult > 0) {
			System.out.println(returnBrent.getBook().getBtitle()+"도서가 반납 처리 되었습니다.");
		}else {
			System.out.println("도서 반납 처리에 실패 하였습니다.");
		}
		
	}
	
	
	
	private void rentalBook() {
		System.out.println("[도서대여]");
		
		/* 대여 가능한 도서 목록 출력 (1.전체목록 2.제목조회) */
		System.out.println("[1]전체목록 [2]제목검색");
		System.out.print("선택 : ");
		String selmenu = sc.next();
		ArrayList<Book> bookList;
		if(selmenu.equals("1")) {
			bookList = bdao.selectBookList();
		}else if (selmenu.equals("2")) {
			System.out.print("검색할 제목 : ");
			String title = sc.next();
			bookList=bdao.selectBookListByTitle(title);
		}else {
			System.out.println("다시 선택해주세요.");
			return;
		}
		int index=0;
		for(Book book : bookList) {
			System.out.print("["+index+"]"+book.getBtitle());
			int bea = book.getBea();
			if(bea>0) {
				System.out.println("["+book.getBea()+"]");
				
			}else {
				System.out.println("[재고없음]");
			}
			index++;
		}
		System.out.print("대여할 도서 선택 : ");
		int selBookIndex = sc.nextInt();
		
		/*
		 * [0]제목, [재고:3권]
		 * [1]제목, [재고없음]
		 * [2]제목, [재고:5권]
		 * 대여할 도서 선택*/
		Book selectBook = bookList.get(selBookIndex);
		
		if( selectBook.getBea() <= 0 ) {
			System.out.println("재고가 없는 도서입니다.");
			System.out.println("다시 이용해주세요.");
			return;
		}
		
		
		/* 대여할 도서를 선택 - BID */
		int selBid = selectBook.getBid();
		
		
		/* 선택한 도서의 대여처리 - MID, BID */
		Brent rent = new Brent();
		rent.setMid(loginId);;
		rent.setBid(selBid);
		int rentResult = rdao.bookRent(rent);
		
		
		/* 대여처리 결과 출력 */
		if(rentResult > 0) {
			System.out.println("도서 대여 처리에 성공했습니다.");
		}else {
			System.out.println("도서 대여 처리에 실패했습니다.");
		}
		
		
		
		
	}
	
	private void bookList() {
		System.out.println("[도서목록]");
		/* 1. 등록된 도서 목록 조회 */
		ArrayList<Book> bookList = bdao.selectBookList();
		/* 2. 조회된 도서 목록 출력 */
		int size = bookList.size();
		if(size == 0) {
			System.out.println("등록된 도서가 없습니다.");
			return;
		}
		for(Book book : bookList) {
			System.out.print("[제목]"+book.getBtitle());
			System.out.print("[저자]"+book.getBauthor());
			System.out.println("[재고]"+book.getBea());
		}
		System.out.println("등록된 도서는"+size+"권 입니다.");
	}
	
	
	private void memberJoin() {
		System.out.println("[회원가입]");
		/* 1. 아이디 중복확인 */
		System.out.print("가입할 아이디 : ");
		String mid = sc.next();
		Member idCheck = mdao.selectMember(mid, null);
		if(idCheck != null) {
			System.out.println("이미 사용중인 아이디 입니다.");
			return;//아이디 중복으로 회원가입 종료
		}
		System.out.print("가입할 비밀번호 : ");
		String mpw = sc.next();
		System.out.print("가입할 이름 : ");
		String mname = sc.next();
		System.out.print("가입할 이메일 : ");
		String memail = sc.next();
		System.out.print("가입할 전화번호 : ");
		String mphone = sc.next();
		
		Member joinMember = new Member(mid, mpw, mname, memail, mphone);
		
		/* 2. 회원가입 처리 */
		int joinResult = mdao.insertMember(joinMember);//회원정보 테이블에 회원정보 입력
		
		/* 3. 회원가입 처리 결과 출력 */
		if(joinResult>0) {
			System.out.println("회원 가입 되었습니다.");
		}else {
			System.out.println("회원 가입에 실패 하였습니다.");
		}
		
	}
	
	
	
	
	

	private void libMenu() {
		System.out.println();
		if (loginId == null) { // 로그인이 되어 있지 않은 경우
			System.out.println("[1]회원가입 [2]로그인");

		} else if (loginId.equals("admin")) { // admin 으로 로그인 되어 있는 경우
			System.out.println("[add]도서등록 [list]도서목록 [exit]로그아웃");

		} else { // 일반 회원으로 로그인 되어 있는 경우
			System.out.println("[3]도서대여 [4]도서반납 [5]대여목록 [exit]로그아웃");

		}

	}

}
