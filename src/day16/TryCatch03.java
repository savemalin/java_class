package day16;

import java.util.Scanner;

public class TryCatch03 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		TryCatchService trysvc = new TryCatchService();

		// 새로 가입할 회원 정보
//		Member memberInfo = new Member("ID01", "PW01");
//
//		// 회원 가입 기능 호출
//		int index = trysvc.registMember(memberInfo);
//		System.out.println("새 회원정보가 memberList[" + index + "] 등록되었습니다.");
//
//		System.out.print("회원아이디 : ");
//		String inputId = sc.next();
//		// 회원 정보 조회 기능 호출
//		Member serchMember = trysvc.getMemberInfo(inputId);
//
//		if (serchMember == null) {
//			System.out.println("회원정보를 찾을 수 없습니다");
//		} else {
//			System.out.println("아이디 : " + serchMember.getId());
//			System.out.println("비밀본호 : " + serchMember.getPw());
//		}
		System.out.print("입력 : ");
		String inputIndex = sc.next();
		// 새로 가입할 회원 정보2
		Member memberInfo2 = new Member("ID02", "PW02");

//		int registResult = trysvc.registMember(inputIndex, memberInfo2);

		try {
			trysvc.registMember2(inputIndex, memberInfo2);
		} catch (NumberFormatException e) {
			System.out.println("NumberFormatException");
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("ArrayIndexOutOfBoundsException");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("다른 예외");
		} finally {
			System.out.println("무조건 실행");
		}
		System.out.println("try 이후 코드");
	}

}
