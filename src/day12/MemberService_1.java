package day12;

import java.util.Scanner;

public class MemberService_1 {
	
	private Scanner scan;
	
	// 회원 목록을 저장할 배열
	private Member[] memberList;
	
	// 회원 로그인 아이디를 저장할 필드
	private String loginId;
	
	public MemberService_1() {
		this.scan = new Scanner(System.in);
		this.memberList = new Member[10];
	}
	//사용자 메뉴 출력 기능
	private void showMenu() {
		if(loginId == null) {
			System.out.print("\n[1]회원가입  [2]로그인  "); // 로그인이 되어 있지 않을 때
		} else {
			System.out.print("\n[3]정보확인  [4]로그아웃  "); // 로그인이 되어 있을 때		
		}
	}	
	public void run() {
		boolean run = true;
		while(run) {
			// 사용자 메뉴 출력기능 호출
			showMenu();
			System.out.print("\n메뉴선택>>");
			String selMenu = scan.next();
			switch(selMenu) {
			case "1":	// 회원가입 기능 호출
				memberJoin();
				break;
			case "2":	// 로그인 기능 호출
				memberLogin();
				break;
			case "3":	// 내정보확인 기능 호출
				memberInfo();
				break;
			case "4":   // 로그아웃 기능 호출
				memberLogout();
				break;
				
			case "list":	// 회원 목록
				memberList();
				break;
				
			default:
				System.out.println("다시 입력 해주세요!");
			}
			
		}
	}
	private void memberLogout() {
		System.out.println("[로그아웃]");
		this.loginId = null;
		System.out.println("로그아웃 되었습니다.");
		
	}
	/* 내 정보 조회 */
	private void memberInfo() {
		System.out.println("[정보조회]");
		//로그인된 회원의 아이디, 비밀번호, 이름, 이메일 출력
		//1. 회원정보 조회(아이디로 회원정보 조회 기능)
		Member myInfo = getMemberInfo(this.loginId);
		//2. 조회된 정보를 출력
		System.out.println(myInfo);
	}
	
	private void memberList() {
		System.out.println("[회원목록]");
		boolean noMember = true;
		for(int i = 0; i < memberList.length; i++) {
			if(memberList[i] != null) {
				System.out.print(" [ID]"+memberList[i].getId());
				System.out.print(" [PW]"+memberList[i].getPw());
				System.out.println();
				noMember = false;
			}
		}
		if(noMember) {
			System.out.println("가입된 회원이 없습니다.");
		}
	}

	//회원가입 기능
	private void memberJoin() {
		System.out.println("[회원가입]");
//		1. 회원 가입이 가능 한지 확인
//		   회원가입이 불가능 하면 회원가입 중단
		int emptyIndex = -1; // 회원정보가 등록되지 않은 인덱스 저장
		for(int i = 0; i < memberList.length; i++) {
			if(memberList[i] == null) { // 회원정보가 비어있는 인덱스 확인
				emptyIndex = i;  // 해당 인덱스를 emptyIndex에 저장
				break;  // for문 중단
			}
		}
		if(emptyIndex < 0) {	// 비어있는 인덱스가 없는 경우
			System.out.println("더 이상 회원가입 할 수 없습니다.");
		} else {				// 비어있는 인덱스가 있는 경우
	//		2. 아이디 중복 확인
			System.out.print("가입할 아이디>>");
			String inputId = scan.next();
			Member memberInfo = getMemberInfo(inputId);	// 회원 정보 조회 기능
			if(memberInfo != null) {  // 조회되는 회원 정보가 있는 경우(가입 할 수 없는 경우)
				System.out.println("이미 사용 중인 아이디 입니다.\n다시 가입해 주세요.");
			} else {  // 조회되는 회원 정보가 없는 경우(가입 할 수 있는 경우)
				System.out.print("가입할 비밀번호>>");
				String inputPw = scan.next();
				System.out.print("가입할 이름>>");
				String inputName = scan.next();
				System.out.print("가입할 이메일>>");
				String inputEmail = scan.next();
//				memberList[emptyIndex] = new Member(inputId, inputPw, inputName, inputEmail);
				Member newMember = new Member(inputId, inputPw, inputName, inputEmail);
				memberList[emptyIndex] = newMember;
				System.out.println("회원 가입 되었습니다.");
			}
		}
	}
	
	/* 회원 정보 조회 기능 */
	private Member getMemberInfo(String userId) {
		Member memberInfo = null; // 조회된 회원 정보를 저장할 객체
		for(int i = 0; i < memberList.length; i++) {	// 회원 목록 에서
			if( memberList[i] != null ) {	
				
				if( userId.equals(  memberList[i].getId()  ) ) {  // 조회할 아이디(userId)와 같은 아이디 인 회원정보
					memberInfo = memberList[i];	 // 
					break;
				}
				
			}
		}
		return memberInfo;		  // 조회된 회원 정보 객체를 반환 (Member 객체 또는 null)
	}
	
	//로그인 기능
	private void memberLogin() {
		System.out.println("[로그인]");
		System.out.print("로그인할 아이디>>");
		String inputId = scan.next();
		System.out.print("로그인할 비밀번호>>");
		String inputPw = scan.next();
//		회원정보 조회 확인
		Member memberLogin = null;
		for(int i = 0; i < memberList.length; i++) {
			if( memberList[i] != null ) {
				if(inputId.equals( memberList[i].getId() ) && inputPw.equals( memberList[i].getPw() )  ) {
					memberLogin = memberList[i];
					break;
				} 
			}
		}
		if(memberLogin != null) {	// 회원 정보를 찾은 경우
			// 회원정보가 조회되면 loginId 필드에 해당 회원의 아이디 저장
			this.loginId = memberLogin.getId();
			System.out.println("로그인 되었습니다.");
		} else {  // 회원정보를 찾지 못한 경우
			System.out.println("아이디/비밀번호가 일치하지 않습니다");
		}
	}
	//로그아웃 기능
	
	//내정보 확인 기능
}



























