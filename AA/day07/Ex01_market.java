package day07;

import java.util.Scanner;

public class Ex01_market {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String[] name = new String[10];
		String[] id = new String[10];
		String[] pw = new String[10];
		String loginId = "";
		String loginPw = "";
		String regId = "";
		String regPw = "";
		String regPw1 = "";
		String regName = "";
		String pack = "";
		int logina = -1;
		int pack1 = 0;
		int[] balance = new int[10];
		int cnt = 0;
		int loginIndex = -1;
		int selec = 0;
		while (true) {
			System.out.println("=====라면장터=====");
			if (loginIndex == -1) {
				System.out.println("1.회원가입 2.로그인 3.회원목록 0.종료");
			} else {
				System.out.println("1.상품구매 2.로그아웃 3.마이페이지 4.충전 0.종료");
			}
			System.out.print("선택 : ");
			int menu = sc.nextInt();
			if (menu == 1) {
				if (loginIndex == -1) {
					System.out.print("회원가입할 이름 : ");
					regName = sc.next();
					System.out.print("회원가입할 아이디 : ");
					regId = sc.next();
					System.out.print("회원가입할 비밀번호 : ");
					regPw = sc.next();
					System.out.print("비밀번호를 다시입력 : ");
					regPw1 = sc.next();
					while (true) {
						int a = 0;
						for (int i = 0; i < cnt; i++) {
							if (name[i].equals(regName)) {
								System.out.println("이미 가입된 이름이 있습니다.");
								a = 1;
								break;
							} else if (id[i].equals(regId)) {
								System.out.println("중복된 아이디가 있습니다.");
								a = 1;
								break;
							} else if (!regPw.equals(regPw1)) {
								System.out.println("등록하실 비밀번호가 틀립니다.");
								a = 1;
								break;
							}
						}
						if (a == 0) {
							id[cnt] = regId;
							pw[cnt] = regPw;
							name[cnt] = regName;
							System.out.println(name[cnt] + "님의 회원가입이 성공했습니다.");
							cnt++;
							break;
						} else
							break;
					}
				} else {
					System.out.print("구매하실 상품을 선택하십시오.\n1.신라면(1100원) 2.참깨라면(1300원) 3.The미식 장인라면(2500)\n선택 : ");
					selec = sc.nextInt();
					if (selec <= 3 && selec >= 1) {
						if (selec == 1) {
							pack = "신라면";
							pack1 = 1100;
						}
						if (selec == 2) {
							pack = "참깨라면";
							pack1 = 1300;
						}
						if (selec == 3) {
							pack = "The미식 장인라면";
							pack1 = 2500;
						}
						System.out.print("개수 : ");
						int num = sc.nextInt();
						for (int i = 0; i < cnt; i++) {
							if (balance[logina] >= (num * pack1)) {
								balance[logina] -= (num * pack1);
								System.out.println(pack + " " + num + "개를 구매하였습니다[잔액 : " + balance[logina] + "원]");
								break;
							} else {
								System.out.println("잔액이 부족합니다.");
								break;
							}
						}
					} else {
						System.out.println("없는 품목입니다.");
					}
				}
			} else if (menu == 2) {
				if (loginIndex == -1) {
					System.out.print("로그인 할 아이디 : ");
					loginId = sc.next();
					System.out.print("로그인 할 비밀번호 : ");
					loginPw = sc.next();
					for (int i = 0; i < cnt; i++) {
						if (loginId.equals(id[i]) && loginPw.equals(pw[i])) {
							System.out.println(name[i] + "님 환영합니다.[" + balance[i] + "원]");
							logina = i--;
							loginIndex = 0;
							break;
						}
					}
					if (loginIndex == -1) {
						System.out.println("아이디와 비밀번호가 없거나 틀립니다.");
					}
				} else {
					System.out.println("로그아웃되었습니다.");
					loginIndex = -1;
				}
			} else if (menu == 3) {
				if (loginIndex == -1) {
					System.out.println("=====================================");
					System.out.println("이름\t아이디\t비밀번호\t잔액\n");
					for (int i = 0; i < cnt; i++) {
						System.out.printf("%s\t%s\t%s\t%,d원\n", name[i], id[i], pw[i], balance[i]);
					}
					System.out.println("=====================================");
				} else {
					for (int i = 0; i < cnt; i++) {
						if (id[i].equals(loginId)) {
							System.out.println("=====================================");
							System.out.println("이름\t아이디\t비밀번호\t잔액\n");
							System.out.printf("%s\t%s\t%s\t%,d원\n", name[i], id[i], pw[i], balance[i]);
							System.out.println("=====================================");
							break;
						}
					}
				}
			} else if (menu == 4 && loginIndex != -1) {
				System.out.print("충전하실 금액 : ");
				for (int i = 0; i < cnt; i++)
					if (id[i].equals(loginId)) {
						balance[i] += sc.nextInt();
						System.out.printf("잔액 %,d원", balance[i]);
						break;
					}
			} else if (menu == 0) {
				break;
			}
			System.out.println();
		}
	}
}
