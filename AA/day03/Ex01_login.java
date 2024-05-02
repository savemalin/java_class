package day03;

import java.util.Scanner;

public class Ex01_login {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String name = "";
		String id = "";
		String pw = "";
		
		while(true) {
			System.out.println("=====날아라쇼핑몰=====");
			System.out.println("1.회원가입 2.로그인");
			System.out.print("선택 : ");
			int menu = scan.nextInt();
			
			if(menu == 1) {
				System.out.print("회원가입 이름 : ");
				name = scan.next();
				System.out.print("회원가입 아이디 : ");
				id = scan.next();
				System.out.print("회원가입 비밀번호 : ");
				pw = scan.next();
				System.out.println(name+"님 회원가입 축하드립니다!");
			}else if(menu == 2) {
				System.out.print("아이디 : ");
				String loginId = scan.next();
				System.out.print("비밀번호 : ");
				String loginPw = scan.next();
				
				if(loginId.equals(id) && loginPw.equals(pw)) {
					System.out.println("로그인 성공");
					break;
				}else {
					System.out.print("로그인 실패\n다시시도(Y/y)? ");
					String re = scan.next();
					if(!(re.equals("Y") ||!re.equals("y"))) {
						break;
					}
				}
			}
			
			System.out.println();
		}
		System.out.println("끝");
		
	}

}













