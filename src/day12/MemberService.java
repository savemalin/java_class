package day12;

import java.util.Scanner;

public class MemberService {
	// 회원 목록 배열
	private Member[] memberList;
	private Scanner scan;
	private int index;

	public MemberService() {
		this.memberList = new Member[10];
		this.scan = new Scanner(System.in);

	}

	// 회원 로그인 아이디
	private String loginId;

	private String id;
	private String pw;
	private String name;
	private String email;

	// 사용자 메뉴 출력 기능
	private void showMenu() {
		if (loginId == null) {
			System.out.print("\n[1]회원가입 [2]로그인");// 로그인이 되어 있지 않을 때
		} else {
			System.out.print("\n[3]내정보확인 [4]로그아웃");// 로그인이 되어 있을 때
		}

	}

	// 회원 정보 조회 기능

	public void run() {
		boolean run = true;
		while (run) {
			// 사용자 메뉴 출력기능 호출
			showMenu();
			
			index = 0;
			
			System.out.print("\n메뉴선택 : ");
			String selMenu = scan.next();
			switch (selMenu) {
			case "1":// 회원가입 기능
				memberJoin();
				break;
			case "2":// 로그인 기능
				memberLogin();
				break;
			case "3":// 로그아웃 기능
				if (loginId != null) {
					memberLogout();
				}
				break;
			case "4":// 내정보 확인 기능
				for (int i = 0; i < memberList.length; i++) {
					if (memberList[i].getId() == loginId) {
						System.out.println(memberList[i]);
					}
				}
				break;
			default:
				System.out.print("\n다시입력");
				break;

			}

		}

	}

	private Member getMemberInfo(String userId) {
		Member memberInfo = null; // 조회된 회원정보를 저장할 객체
		for (int i = 0; i < memberList.length; i++) {
			if (memberList[i] != null) {
				if (userId.equals(memberList[i].getId())) {
					memberInfo = memberList[i];
					break;
				}
			}
		}

		return memberInfo;// 조회된 회원 정보 객체를 반환
	}

	private void memberJoin() {
		int empty=-1;
		for(int i = 0; i < memberList.length; i++) {
			if(memberList[i] == null) { // 회원정보가 비어있는 인덱스 확인
				empty = i; 	    // 해당 인덱스를 emptyIndex에 저장
				break;	                // for문 중단
			}
		}
		if(empty < 0) {	// 비어있는 인덱스가 없는 경우
			System.out.println("더 이상 회원가입 할 수 없습니다.");
		} else {				// 비어있는 인덱스가 있는 경우
	//		2. 아이디 중복 확인
			System.out.print("가입할 아이디>>");
			String inputId = scan.next();
			Member memberInfo = getMemberInfo(inputId);	// 회원 정보 조회 기능
			if(memberInfo != null) {	// 조회되는 회원 정보가 있는 경우(가입 할 수 없는 경우)
				System.out.println("이미 사용 중인 아이디 입니다.\n다시 가입해 주세요.");
			} else {					// 조회되는 회원 정보가 없는 경우(가입 할 수 있는 경우)
				System.out.print("가입할 비밀번호>>");
				String inputPw = scan.next();
				System.out.print("가입할 이름>>");
				String inputName = scan.next();
				System.out.print("가입할 이메일>>");
				String inputEmail = scan.next();
//				memberList[emptyIndex] = new Member(inputId, inputPw, inputName, inputEmail);
				
				Member newMember = new Member(inputId, inputPw, inputName, inputEmail);
				memberList[empty] = newMember;
				System.out.println("회원 가입 되었습니다.");
			}
		}
	
	}

	private void memberLogin() {
		System.out.print("로그인할 아이디 : ");
		String loginId = scan.next();
		System.out.print("로그인할 비밀번호 : ");
		String loginPw = scan.next();
		Member memberLogin = null;
		for(int i =0;i<memberList.length;i++) {
		if(memberList[i]!=null) {
			if(loginId.equals(memberList[i].getId())&&loginPw.equals(memberList[i].getPw())) {
				memberLogin = memberList[i];
				break;
			}
		}
		}
		if(memberLogin !=null) {
			this.loginId=memberLogin.getId();
			System.out.println("로그인되었습니다.");
		}else {
			System.out.println("아이디 또는 비밀번호가 일치하지 않습니다.");
		}
		
	}
	//내 정보 조회
	private void memberInfo() {
		System.out.println("정보조회");
		Member myInfo = getMemberInfo(this.loginId);
		System.out.print("[ID]"+myInfo.getId());
		System.out.print("[PW]"+myInfo.getPw());
		System.out.print("[NM]"+myInfo.getName());
		System.out.print("[EM]"+myInfo.getEmail());
		
		
	}
	private void memberList() {
		System.out.println("회원목록");
		boolean noMember=true;
		for(int i =0; i<memberList.length;i++) {
			if(memberList[i]!=null) {
				System.out.print("[ID]");
				System.out.print("[ID]");
			}
		}
		
		
		
	}
	private void memberLogout() {
		System.out.println("로그아웃되었습니다.");
		this.loginId=null;
		
	}
	
}
