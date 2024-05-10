package day14;

import java.util.ArrayList;
import java.util.Scanner;


public class LibraryService {
	
	/**
	 * 도서 기능
	 *     도서등록, 도서목록조회
	 * 
	 * 회원 기능
	 *     회원가입, 로그인, 도서대여, 도서반납, 대여목록조회
	 */
	private ArrayList<Book> bookList; // 도서 목록
	private ArrayList<Member> memberList; // 회원 목록
	private Scanner scan; // 사용자 입력 스캐너
	private String loginId; // 로그인 중인 회원 아이디
	
	public LibraryService() {
		this.bookList = new ArrayList<>();
		this.memberList = new ArrayList<>();
		this.scan = new Scanner(System.in);
		this.loginId = null;
		
		bookList.add( new Book("이것이자바다", 20000, "신용권", "한빛미디어") );
		bookList.add( new Book("HELLO_IT", 30000, "박영웅", "패스트캠퍼스") );
		
	}
	
	public void libraryStart() {
		while(true) {
			showMenu(); // 메뉴 출력
			System.out.print("메뉴선택>>");
			String selMenu = scan.next(); // 사용자가 메뉴 선택
			
			switch(selMenu) { // 선택한 메뉴의 기능 호출
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
				returnBook(); // 도서 반납 기능 호출
				break;
			case "5":
				rentalList(); // 대여 목록 조회 기능 호출
				break;
			case "add":
				addBook(); // 도서 등록 기능 호출
				break;
			case "list":
				bookList(); // 도서 목록 조회 기능 호출
				break;
			case "exit":
				memberLogout();// 로그아웃 기능 호출
				break;
			default:
				System.out.println("다시 입력 해주세요!");
			}
		}
	}
	
	/* 회원가입 기능 */
	private void memberJoin() {
		System.out.println("[회원가입]");
		// 1. 가입할 회원 정보를 입력받고
		System.out.print("아이디>>");
		String inputId = scan.next();
		System.out.print("비밀번호>>");
		String inputPw = scan.next();
		System.out.print("이름>>");
		String inputName = scan.next();
		System.out.print("이메일>>");
		String inputEmail = scan.next();
		Member joinMember = new Member( inputId, inputPw, inputName, inputEmail );
		
		// 2. 중복 회원 인지 확인
		// 입력한 아이디로 회원목록 회원정보를 조회
		Member memberInfo = null;  // 조회된 회원 정보를 저장하기 위한 변수
		for(int i = 0; i < memberList.size(); i++) {	// 회원 목록에서
			if( inputId.equals( memberList.get(i).getId() ) ) { // 입력한 아이디와 기존 회원의 아이디 비교
				memberInfo = memberList.get(i);	// 조회된 회원 정보를 저장
				break;
			}
		}
		
		// 3. 중복 회원이 아니면 회원 가입 처리(memberList에 회원정보 추가)
		if(memberInfo != null) {
			System.out.println("중복된 아이디 입니다.\n다시 가입해주세요!");
		} else {
			memberList.add(joinMember);
			System.out.println("회원 가입 되었습니다.");
		}
	}	
	
	/* 로그인 기능 */
	private void memberLogin() {
		// 1. 로그인할 아이디, 비밀번호 입력받고
		System.out.print("로그인아이디>>");
		String inputId = scan.next();
		System.out.print("로그인비밀번호>>");
		String inputPw = scan.next();
		if( inputId.equals("admin") && inputPw.equals("admin") ) {
			// 2. 입력한 아이디가 "admin", 비밀번호가 "admin" 이면 로그인 처리( loginId 필드에 "admin" 저장 )
			this.loginId = "admin";
			System.out.println("관리자로 로그인 되었습니다.");
		} else {
			// 3. 입력한 아이디와 비밀번호가 "admin" 이 아니면 회원 목록에서 일치하는 회원정보 조회
			Member memberInfo = null;
			for(int i = 0; i < memberList.size(); i++) {
				if(inputId.equals( memberList.get(i).getId() ) && inputPw.equals( memberList.get(i).getPw() ) ) {
					memberInfo = memberList.get(i);
					break;
				}
			}
			if(memberInfo != null) {
				// 4. 회원정보가 조회되면 해당 아이디로 로그인 처리( loginId 필드에 회원 아이디 저장 )
				this.loginId = memberInfo.getId();
				System.out.println("로그인 되었습니다.");
			} else {
				// 5. 회원정보가 조회 되지 않으면 "아이디/비밀번호가 일치하지 않습니다" 출력
				System.out.println("아이디/비밀번호가 일치하지 않습니다");
			}
		}
		
	}
	
	private void memberLogout() {
		System.out.println("[로그아웃]");
		this.loginId = null;
		System.out.println("로그아웃 되었습니다.");
	}

	/* 도서 등록 기능 */
	private void addBook() {
		if(this.loginId == null  ||  !this.loginId.equals("admin") ) {
			System.out.println("잘못된 접근입니다.");
			return;
		}

		
		System.out.println("[도서 등록]");
		// 1. 등록할 도서 정보 입력 받고
		System.out.print("제목입력>>");
		String title = scan.next();
		System.out.print("가격입력>>");
		int price = scan.nextInt();
		System.out.print("저자입력>>");
		String author = scan.next();
		System.out.print("출판사입력>>");
		String publisher = scan.next();
		Book book = new Book(title, price, author, publisher);
		// 2. 도서목록에 새 도서 정보를 추가
		bookList.add(book); //
		System.out.println("새 도서가 등록 되었습니다.");
	}
	/* 도서 목록 조회 */
	private void bookList() {
		System.out.println("[도서목록]");
		// 도서 목록에 있는 도서 정보 출력
		for(int i = 0; i < bookList.size(); i++) { 
			System.out.print("[제목]"+bookList.get(i).getTitle());
			System.out.print(" [저자]"+bookList.get(i).getAuthor());
			
			Member rentalMember = bookList.get(i).getMember();
			
			if(rentalMember == null) {
				System.out.println(" [대여가능]");
			} else {
				System.out.println(" ["+rentalMember.getId()+"]");
			}
			
		}
	}

	private void rentalList() {
		// 1.로그인 된 회원의 대여중인 도서 목록 출력
		
	}

	private void returnBook() {
		// 1. 로그인 된 회원의 대여중인 도서 목록 출력
		// 1-1 로그인 회원의 정보를 조회
		Member memberInfo = null; // 로그인된 회원의 정보를 저장할 객체
		for(int i = 0; i < memberList.size(); i++) {
			if(  this.loginId.equals( memberList.get(i).getId() ) ) {
				memberInfo = memberList.get(i);
				break;
			}
		}	
		// 1-2 해당 회원의 도서대여목록 배열 조회
		Book[] loginRentalList = memberInfo.getRentalList();
		

		// 1-3 대여 중인 도서 목록 출력
		int rentalCount = memberInfo.rentalInfo();
		// 대여중인 도서 목록이 없는 경우 기능 중단.
		if(rentalCount == 0) {
			System.out.println("대여 중인 도서가 없습니다.");
			return;
		}
		// 2. 반납할 도서를 선택
		System.out.print("반납할 도서제목>>");
		String title = scan.next();
		Book returnBook = null;
		int index = -1;
		for(int i = 0; i <  loginRentalList.length; i++) {
			if(loginRentalList[i] == null) {
				continue;
			}
			if( title.equals(  loginRentalList[i].getTitle() ) ) {
				returnBook = loginRentalList[i];
				index = i;
				break;
			}
		}
		if(returnBook == null ) {
			System.out.println("반납할 도서를 찾을 수 없습니다.");
			return;
		}
		// 회원정보 : memberInfo, 대여목록 : loginRentalList, 반납할도서 : returnBook
		
		// 3. 선택한 도서 정보(returnBook) 를 해당 회원의 도서대여목록(loginRentalList)에서 삭제
		loginRentalList[index] = null;
		
		// 4. 선택한 도서 정보(returnBook) 에서 대여해 간 회원정보(member)를 삭제 
		returnBook.setMember(null);
		
	}

	private void rentalBook() {
		System.out.println("[도서대여]");
		// 1. 해당 회원이 대여가 가능한지 확인(대여 가능 수가 남아있는지)
		//   1-1 로그인된 회원의 정보를 조회 ( loginId를 이용해서 memberList에서 조회 )
		Member memberInfo = null; // 로그인된 회원의 정보를 저장할 객체
		for(int i = 0; i < memberList.size(); i++) {
			if(  this.loginId.equals( memberList.get(i).getId() ) ) {
				memberInfo = memberList.get(i);
				break;
			}
		}
		//   1-2 rentalList 배열에 비어있는 인덱스가 있는지 확인
		Book[] loginRentalList = memberInfo.getRentalList();
		int emptyIndex = -1;
		for(int i = 0; i < loginRentalList.length; i++) {
			if( loginRentalList[i] == null ) {
				emptyIndex = i;
				break;
			}
		}
		if(emptyIndex < 0) {
			System.out.println("더 이상 대여 할 수 없습니다.");
			return;
		}
		// 2. 대여 가능한 도서 목록 출력
		//    bookList에 있는 도서 정보를 출력
		if( bookList.size() <= 0 ) {
			System.out.println("등록된 도서가 없습니다.");
			return;
		}

		boolean isRental = false;
		for(int i = 0; i < bookList.size(); i++) {
			String title = bookList.get(i).getTitle();
			Member rentalMember = bookList.get(i).getMember();
			System.out.print("[제목]"+title);
			if( rentalMember == null ) {
				System.out.println(" [대여가능]");
				isRental = true;
			} else {
				System.out.println( " [대여불가]" );
			}
		}
		if( !isRental ) {
			System.out.println("대여 가능한 도서가 없습니다.");
			return;
		}
		// 3. 사용자가 대여할 도서를 선택
		System.out.print("대여할 도서제목>>");
		String inputTitle = scan.next();
		Book rentalBook = null;
		for(int i = 0; i < bookList.size(); i++) {
			if(inputTitle.equals( bookList.get(i).getTitle() )) {
				rentalBook = bookList.get(i);
				break;
			}
		}
		if( rentalBook == null ) {
			System.out.println("해당 도서를 찾을 수 없습니다.\n다시 이용해주세요.");
			
		} else if( rentalBook.getMember() != null ) {
			System.out.println("현재 대여중인 도서 입니다.\n다시 이용해주세요.");
			
		} else { // 단, 선택이 가능한 객체는 Book 객체에 있는 member 필드가 null인 객체
			
			// 1-1 memberInfo,  1-2 emptyIndex, loginRentalList배열  3. rentalBook
			
			// 4. 선택한 도서 정보를 해당 회원의 도서대여목록에 저장 
			//    loginRentalList 배열에 비어있는 인덱스(emptyIndex)에 선택한 도서( rentalBook )를 저장
			loginRentalList[emptyIndex] = rentalBook;
			
			// 5. 선택한 도서 정보에 대여해 간 회원정보를 저장 
			//    rentalBook 객체의 member 필드에 로그인된 회원정보(memberInfo) 를 저장
			rentalBook.setMember(memberInfo);
			
			System.out.println("["+rentalBook.getTitle()+"] 대여 처리 되었습니다.");
		}
		
	}

	public void showMenu() {
		System.out.println();
		if(loginId == null) {	// 로그인이 되어 있지 않은 경우
			System.out.println("[1]회원가입 [2]로그인");
			
		} else if( loginId.equals("admin") ) { // admin 으로 로그인 되어 있는 경우
			System.out.println("[add]도서등록 [list]도서목록 [exit]로그아웃");
			
		} else {	// 일반 회원으로 로그인 되어 있는 경우
			System.out.println("[3]도서대여 [4]도서반납 [5]대여목록 [exit]로그아웃");
			
		}
	}
	
	
	
	

	
}
















