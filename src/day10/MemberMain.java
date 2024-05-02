package day10;

import java.util.Scanner;

public class MemberMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 회원 목록이 저장될 배열
		Member[] memberList = new Member[10];
		int listNum = 0;
		boolean run = true;
		while (run) {
			// 1. 회원메뉴 출력 & 선택
			System.out.println("1.회원가입 2.로그인 3.회원목록 0.종료");
			System.out.print("메뉴선택 : ");
			String selectMenu = sc.next();
			// 2. 선택한 메뉴에 대한 실행 코드
			switch (selectMenu) {
			case "1":
				System.out.println("1. 회원가입 메뉴 선택");
				// 회원정보를 입력 받기
				System.out.print("가입할 아이디 : ");
				String inputId = sc.next();
				System.out.print("가입할 비밀번호 : ");
				String inputPw = sc.next();
				System.out.print("가입할 이름 : ");
				String inputName = sc.next();
				System.out.print("가입할 이메일 : ");
				String inputEmail = sc.next();
				// 입력 받은 회원정보로 member객체 생성

				Member member = new Member(inputId, inputPw, inputName, inputEmail);
				// member객체를 memberList에 저장
				// - memberList 배열에 비어있는 인덱스에 member객체를 저장
				// - memberList 배열에 비어있는 인덱스가 없으면 가입 중단.
				if (listNum == memberList.length) {
					System.out.println("더 이상 회원가입이 불가능합니다.");
					break;

				} else {
					for (int i = 0; i < memberList.length; i++) {
						if (memberList[i] != null && (memberList[i].id).equals(inputId)) {
							System.out.println("중복된 아이디가 존재합니다.");
							// memberList[i].id 만 있을경우 다른클래스의 필드가 값이 없을경우 불러오지 못하여 오류
							break;
						} else if (memberList[i] == null) {
							memberList[listNum] = member;
							listNum++;
							break;
						}
					}
					break;
				}

			case "2":
				System.out.println("2.로그인 메뉴 선택");
				/*
				 * 1.로그인 할 아이디, 비밀번호 입력 2.입력받은 아이디, 비밀번호와 일치하는 회원정보가 회원목록에 있는지 확인 3.일치하는 회원 정보가
				 * 있다면 "로그인 되었습니다" + 해당 회원의 정보 출력 일치하는 회원 정보가 없다면 "아이디/비밀번호가 일치하지 않습니다" 출력
				 */
				System.out.print("로그인 할 아이디 : ");
				String loginId = sc.next();
				System.out.print("로그인 할 비밀번호 : ");
				String loginPw = sc.next();

				for (int i = 0; i < memberList.length; i++) {
					if (memberList[i].id.equals(loginId) && memberList[i].pw.equals(loginPw)) {
						System.out.println("로그인 되었습니다.");
						memberList[i].printMemberInfo();
						break;
					} else {
						System.out.println("아이디 / 비밀번호가 일치하지 않습니다.");
					}
				}
				
				break;
			case "3":
				System.out.println("3.회원목록 메뉴 선택");
				for (Member memberInfo : memberList) {
					if (memberInfo != null) {
						memberInfo.printMemberInfo();
					} else {
						System.out.println("회원정보가 없습니다.");
					}
				}
				break;
			case "0":
				System.out.println("프로그램 종료");
				break;

			}

		}

	}

}
