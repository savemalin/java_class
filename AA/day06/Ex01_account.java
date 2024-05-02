package day06;

import java.util.Scanner;

public class Ex01_account {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String YorN = "";
		String[] name = new String[10];
		String[] account = new String[10];
		String account1 = "!a";
		String[] YesLeon = new String[10];
		int[] balance = new int[10];
		int cnt = 0;
		int num = 10;

		while (true) {
			System.out.println("=====자바은행=====");
			System.out.println("1.계좌생성 2.입금 3.출금 4.계좌목록 5.대출 0.종료");
			System.out.print("선택 : ");
			int menu = sc.nextInt();

			if (menu == 1) {
				System.out.print("예금주 : ");
				name[cnt] = sc.next();
				System.out.print("계좌번호 : ");
				account1 = num++ + "-" + sc.next();
				 
					for (int a = 0; cnt == 0||a < cnt; a++) {
						if (!(account[a].equals(account1))) {
							account[cnt] = account1;
							System.out.println(name[cnt] + "님의 계좌가 생성되었습니다.");
							YesLeon[cnt]="대출가능";

						}
					}cnt++;
								
			} else if (menu == 2) {
				// 계좌번호를 하나 받는다.
				// 계좌번호를 account에서 찾는다.
				// 계좌번호를 찾으면 입금금액을 입력받고, 입금!
				// 계좌번호가 없으면 "없는 계좌번호입니다." 한번만 출력

				int acc = 0;
				int inMoney = 0;
				System.out.print("입금계좌 : ");
				String inAccount = sc.next();

				for (int i = 0; i < cnt; i++) {
					if (inAccount.equals(account[i])) {
						System.out.print("입금할 금액 : ");
						inMoney = sc.nextInt();
						System.out.printf("입금하실 금액이 %,d원이 맞습니까?[Y/N]", inMoney);
						YorN = sc.next();
						if (YorN.equals("Y")) {
							balance[i] += inMoney;
							System.out.printf("입금성공! 입금 후 잔액 : %.d원\n", balance[i]);
							break;
						} else if (YorN.equals("N")) {
							System.out.println("입금을 취소합니다.");
							break;
						}

					} else {
						System.out.println("없는 계좌입니다.\n입금이 취소되었습니다.");
						break;
					}
				}

			} else if (menu == 3) {
				System.out.print("출금계좌 : ");
				String outAccount = sc.next();
				for (int k = 0; k < cnt; k++) {
					if (outAccount.equals(account[k])) {
						System.out.print("출금할 금액 : ");
						int outMoney = sc.nextInt();
						System.out.printf("출금하실 금액이 %,d원이 맞습니까?[Y/N]", outMoney);
						YorN = sc.next();
						if (YorN.equals("Y")) {
							if (balance[k] >= outMoney) {
								balance[k] -= outMoney;
								System.out.printf("출금성공! 출금 후 잔액 : %,d원\n", balance[k]);
								break;
							} else {
								System.out.println("잔액이 부족합니다.\n출금이 취소됩니다.");
								break;
							}

						} else if (YorN.equals("N")) {
							System.out.println("출금이 취소되었습니다.");
							break;
						}

					} else {
						System.out.println("없는 계좌입니다.\n출금이 취소되었습니다.");
						break;
					}
				}

			} else if (menu == 4) {
				System.out.println("예금주\t계좌번호\t잔고\t대출여부");
				System.out.println("=========================");
				for (int i = 0; i < cnt; i++) {
					System.out.printf("%s\t%s\t%,d원\t%s\n", name[i], account[i], balance[i],YesLeon[i]);

				}

			} else if (menu == 5) {
				System.out.print("대출계좌 : ");
				String loanAccount = sc.next();
				for (int i = 0; i < cnt; i++) {
					if (loanAccount.equals(account[i])) {
						int maxLoan = balance[i] * 10;
						System.out.printf("대출금액(한도:%,d원) : ", maxLoan);
						int loanMoney = sc.nextInt();
						if (loanMoney > maxLoan) {
							System.out.println("대출이 불가한 금액입니다.\n대출이 취소됩니다.");
							break;
						} else {
							balance[i] += maxLoan;
							System.out.printf("대출성공! 대출 후 잔액 : %,d원\n", balance[i]);
							break;
						}

					} else {
						System.out.println("없는 계좌번호입니다.\n 대출이 취소됩니다.");
						break;
					}
				}
			} else if (menu == 0) {
				break;

			}
			System.out.println();

		}

}
}
