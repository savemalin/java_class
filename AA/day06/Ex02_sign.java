package day06;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Ex02_sign {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] name = new String[10];
		String[] id = new String[10];
		String[] pw = new String[10];
		String[] date = new String[10];
		String[] account = new String[10];
		int[] balance = new int[10];
		int cnt = 0;
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyy/MM/dd (a)hh:mm:ss");
		int loginIndex = -1;
		int num = 1000;

		while (true) {
			System.out.println("=====자바사이트=====");
			if (loginIndex == -1) {
				System.out.println("1.회원가입 2.로그인 3.리스트 0.종료");

			} else {
				System.out.println("1.비밀번호수정 2.로그아웃 3.마이페이지(" + name[loginIndex] + "님) 4.입금 5.출금 6.계좌이체 0.종료");

			}
			System.out.print("선택 : ");
			int menu = sc.nextInt();

			if (menu == 1) {
				if (loginIndex == -1) {
					System.out.print("이름 : ");
					name[cnt] = sc.next();
					System.out.print("아이디 : ");
					id[cnt] = sc.next();
					System.out.print("비밀번호 : ");
					pw[cnt] = sc.next();
					account[cnt] = num++ + "";
					LocalDateTime now = LocalDateTime.now();
					date[cnt] = dtf.format(now);
					System.out.println(name[cnt] + "님의 회원가입을 축하드립니다.");
					cnt++;

				} else {
					// 비밀번호수정
					System.out.print("현재비밀번호 : ");
					String loginPw = sc.next();
					if (pw[loginIndex].equals(loginPw)) {
						System.out.print("수정할 비밀번호 : ");
						String insPw = sc.next();
						pw[loginIndex] = insPw;
						System.out.println("비밀번호 수정완료.\n다시 로그인하여주세요.");
						loginIndex = -1;

					} else {
						System.out.println("비밀번호를 틀렸습니다.");
					}

				}

			} else if (menu == 2) {
				if (loginIndex == -1) {
					System.out.print("로그인할 아이디: ");
					String loginId = sc.next();
					System.out.print("로그인할 비밀번호 : ");
					String loginPw = sc.next();
					for (int i = 0; i < cnt; i++) {
						if (id[i].equals(loginId) && pw[i].equals(loginPw)) {
							System.out.println("어서오세요. " + name[i] + "님. 환영합니다. ");
							loginIndex = i;
							break;
						} else {
							System.out.println("로그인실패");
							break;
						}
					}

				} else {
					loginIndex = -1;
					System.out.println("로그아웃하였습니다.");

					// 로그아웃
				}

			} else if (menu == 3) {
				if (loginIndex == -1) {
					System.out.println("이름\t아이디\t비밀번호\t계좌번호\t잔액\t가입날짜");
					System.out.println("==============================");
					for (int i = 0; i < cnt; i++) {
						System.out.printf("%s\t%s\t%s\t%s\t%,d원\t%s\n", name[i], id[i], pw[i], account[i], balance[i],
								date[i]);

					}
				} else {
					// 마이페이지
					System.out.println("이름\t아이디\t비밀번호\t계좌번호\t잔액\t가입날짜");
					System.out.println("==============================");
					System.out.printf("%s\t%s\t%s\t%s\t%,d원\t%s\n", name[loginIndex], id[loginIndex], pw[loginIndex],
							account[loginIndex], balance[loginIndex], date[loginIndex]);
				}
			} else if (menu == 4 && loginIndex != -1) {
				System.out.print("입금금액 : ");
				balance[loginIndex] += sc.nextInt();
				System.out.printf("입금완료! 입금 후 잔액 : %,d원\n", balance[loginIndex]);

			} else if (menu == 5 && loginIndex != -1) {
				System.out.print("출금금액 : ");
				int outMoney = sc.nextInt();
				if (balance[loginIndex] >= outMoney) {
					balance[loginIndex] -= outMoney;
					System.out.printf("출금완료! 출금 후 잔액 : %,d원\n", balance[loginIndex]);
				} else {
					System.out.println("잔액부족");

				}

			} else if (menu == 6 && loginIndex != -1) {
				System.out.println("이체할 계좌번호 : ");
				String sendAccount = sc.next();
				for (int i = 0; i < cnt; i++) {
					if (sendAccount.equals(account[i])) {
						if(!(sendAccount.equals(account))) {
							System.out.print("이체할 금액 : ");
							int sendMoney = sc.nextInt();
							if (balance[loginIndex] >= sendMoney) {
								balance[loginIndex] -= sendMoney;
								balance[i]+=sendMoney;
								System.out.println(name[i]+"님에게 "+sendMoney+"원 이체하였습니다.\n잔액 : "+balance[loginIndex]+"원\n");
								break;
							}
					}else System.out.println("내 계좌에는 보낼수 없습니다.");
					}else System.out.println("계좌번호가 존재하지 않거나 틀립니다.");
				}

			} else if (menu == 0) {
				break;

			}

		}

	}
}
