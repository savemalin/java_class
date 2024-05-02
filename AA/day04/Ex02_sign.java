package day04;

import java.util.Scanner;

public class Ex02_sign {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		String name = "";
		String pw = "";
		String id = "";
		int menu = 0;

		while (true&&menu<=2&&menu>=0) {
			System.out.println("=====쇼핑몰=====");
			System.out.println("1.회원가입 2.로그인 0.종료");
			System.out.println("선택 : ");
			menu = sc.nextInt();

			switch (menu) {
			case 1:
				System.out.println("이름 : ");
				name = sc.next();
				System.out.println("아이디 : ");
				id = sc.next();
				System.out.println("비밀번호 : ");
				pw = sc.next();
				System.out.println(name + "님 회원가입을 축하합니다.");
				break;
			case 2:
				System.out.println("로그인할 아이디 : ");
				String loginId = sc.next();
				System.out.println("로그인할 비밀번호 : ");
				String loginPw = sc.next();
				if (loginId.equals(id) && loginPw.equals(pw)) {
					System.out.println(name + "님 환영합니다.");
					menu = 9;

				} else {
					System.out.println("아이디와 비밀번호를 확인하여주세요.");
				}
				break;
			case 0:	
				System.out.println("종료");
				menu=9;
				break;
				default:
					

			}
		}		

	}

}
