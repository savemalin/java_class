package day14;

import java.util.ArrayList;
import java.util.Scanner;

public class LibraryService {

	/*
	 * 도서 기능 도서등록, 도서목록
	 * 
	 * 회원 기능 회원가입, 로그인, 도서대여, 도서반납, 대여목록조회
	 */
	private ArrayList<Book> bookList; // 도서목록
	private ArrayList<Member> memberList; // 회원목록
	private Scanner sc; // 사용자입력 스캐너
	private String loginId1; // 로그인 중인 회원 아이디
	private int fire=0;
	private int bo = 0;

	public LibraryService() {
		this.bookList = new ArrayList<>();
		this.memberList = new ArrayList<>();
		this.sc = new Scanner(System.in);
		this.loginId1 = null;
	}

	public void libraryStart() {
		while (true) {
			// 메뉴 출력
			
			showMenu();
			// 사용자가 메뉴 선택
			String selMenu = sc.next();
			// 선택한 메뉴의 기능 호출
			switch (selMenu) {
			case "1":
				memberJoin();// 회원가입 기능 호출
				break;
			case "2":
				memberLogin();// 로그인 기능 호출
				break;
			case "3":
				rentalBook();// 도서 대여 기능 호출
				break;
			case "4":
				returnBook();// 도서 반납 기능 호출
				break;
			case "5":
				rentalList();// 대여 목록 조회 기능 호출
				break;
			case "add":
				if(fire==1) {
					break;
				}
				addBook();// 도서 등록 기능 호출
				break;
			case "list":
				if(fire==1) {
					break;
				}
				bookList();// 도서 목록 조회 기능 호출
				break;
			case "exit":
				memberLogout();// 로그아웃 기능 호출
				break;
			default:
				System.out.println("다시입력");

			}

		}

	}

	public void showMenu() {
		if (loginId1 == null) {// 로그인이 되어 있지 않은 경우
			System.out.println("[1]회원가입 [2]로그인");

		} else if (loginId1.equals("admin")) {// admin으로 로그인이 되어 있는 경우
			System.out.println("[add]도서등록 [list]도서목록 [exit]로그아웃");

		} else {// 일반회원으로 로그인 되어 있는 경우
			System.out.println("[3]도서대여 [4]도서반납 [5]대여목록 [exit]로그아웃");

		}

	}

	// 회원가입기능
	private void memberJoin() {
		// 1. 가입할 회원 정보를 입력받고
		System.out.print("아이디 : ");
		String inputId = sc.next();
		System.out.print("비밀번호 : ");
		String inputPw = sc.next();
		System.out.print("이름 : ");
		String inputName = sc.next();
		System.out.print("이메일 : ");
		String inputEmail = sc.next();
		Member joinMember = new Member(inputId, inputPw, inputName, inputEmail);
		// 2. 중복 회원 인지 확인
		Member memberInfo = null;
		for (int i = 0; i < memberList.size(); i++) {
			if (inputId.equals(memberList.get(i).getId())) {
				memberInfo = memberList.get(i);
				break;
			}
		}
		// 3. 중복 회원이 아니면 회원 가입 처리(memberList에 회원정보 추가)
		if (memberInfo != null) {
			System.out.println("중복된 아이디 입니다.");
		} else {
			System.out.println("회원 가입 되었습니다.");
			memberList.add(joinMember);
		}

	}

	// 로그인 기능
	private void memberLogin() {
		// 1. 로그인할 아이디, 비밀번호 입력받고
		System.out.print("로그인할 아이디 : ");
		String loginId = sc.next();
		System.out.print("로그인할 비밀번호 : ");
		String loginPw = sc.next();
		// 2. 입력한 아이디가 "admin", 비밀번호가 "admin" 이면 로그인 처리(loginId 필드에 "admin"저장)
		if (loginId.equals("admin") && loginPw.equals("admin")) {
			System.out.println("관리자로 로그인되었습니다.");
			loginId1 = "admin";
		}
		// 3. 입력한 아이디가 "admin"이 아니면 회원 목록에서 일치하는 회원정보 조회
		else if (!loginId.equals("admin")) {
			for (int i = 0; i < memberList.size(); i++) {
				if (loginId.equals(memberList.get(i).getId())) {
					// 4. 회원정보가 조회되면 해당 아이디로 로그인 처리
					loginId1 = loginId;
					System.out.println(memberList.get(i).getName() + "님 환영합니다.");
					break;
				}
			}
			System.out.println("아이디/비밀번호가 일치하지 않습니다.");
		} else {
			// 5. 회원정보가 조회 되지 않으면 "아이디/비밀번호가 일치하지 않습니다" 출력
			System.out.println("아이디/비밀번호가 일치하지 않습니다.");
		}

	}

	private void memberLogout() {
		System.out.println("[로그아웃]");
		this.loginId1 = null;
		System.out.println("로그아웃 되었습니다.");
		fire=0;
	}

	private void bookList() {
		fireWall();
		
		System.out.println(bookList + "\n");

		System.out.print("대여 여부 확일할 도서명 : ");
		String checkBook = sc.next();

		for (int i = 0; i < bookList.size(); i++) {
			if (bookList.get(i).getTitle().equals(checkBook)) {
				System.out.print(bookList.get(i));
				if (bookList.get(i).getMember() != null) {
					System.out.print("[" + bookList.get(i).getMember() + "]");
				} else {
					System.out.println("[대여가능]");
				}

			}
		}

	}

	// 도서 등록 기능
	private void addBook() {
		

			// 1. 등록할 도서 정보 입력 받고
			System.out.print("등록할 도서명 : ");
			String newBookTitle = sc.next();
			System.out.print("등록할 가격 : ");
			int newBookPrice = sc.nextInt();
			System.out.print("등록할 저자 : ");
			String newBookAuthor = sc.next();
			System.out.print("등록할 출판사 : ");
			String newBookPublisher = sc.next();
			// 2. 도서목록에 새 도서 정보를 추가
			bookList.add(new Book(newBookTitle, newBookPrice, newBookAuthor, newBookPublisher, null));
			System.out.println("새 도서가 등록 되었습니다.");
		
	}

	private void rentalList() {
		for (int i = 0; i < memberList.size(); i++) {
			memberList.get(i).rentalInfo();
		}
	}

	private void returnBook() {
		for(int i =0; i<memberList.size();i++) {
		// 1. 로그인 된 회원의 대여중인 도서 목록 출력
		memberList.get(i).rentalInfo();
		bo=i;
		break;
	}
		// 2. 반납할 도서를 선택
		System.out.print("반납할 도서명 : ");
		String returnBookTitle = sc.next();
		
		// 3. 선택한 도서 정보를 해당 회원의 도서대여목록에서 삭제
		memberList.get(bo).getRentalList();
		// 4. 선택한 도서 정보에서 대여해 간 회원정보를 삭제

		
		
				
			}
		

	

	private void rentalBook() {
		// 1. 해당 회원이 대여가 가능한지 확인(대여 가능 수가 남아있는지 확인)
		// 2. 대여 가능한 도서 목록 출력
		// 3. 사용자가 대여할 도서를 선택
		// 4. 선택한 도서 정보를 해당 회원의 도서대여목록에 저장
		// 5. 선택한 도서 정보에 대여해 간 회원정보를 저장
		int a = 3;
		for (int i = 0; i < bookList.size(); i++) {

		}
		for (int i = 0; i < bookList.size(); i++) {
			if (bookList.get(i).getMember() != null) {
				System.out.println(bookList.get(i).getTitle());
			}
		}
		System.out.print("대여할 도서명");
		String rentalBookTitle = sc.next();
		int rentalListCount = 0;
		for (int i = 0; i < memberList.size(); i++) {
			if (rentalBookTitle.equals(bookList.get(i).getTitle())) {

			}
		}

	}
	private void fireWall() {
		if (!loginId1.equals("admin")) {
			System.out.println("잘못입력하였습니다.");
			fire=1;
			
		}
	}
}
