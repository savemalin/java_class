package day04;

import java.util.Scanner;

public class Ex01_drink {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int money = 0;
		int balance = 10000;
		int cola = 0;
		int saida = 0;
		int milk = 0;

		while (true) {
			System.out.printf("=====미니자판기=====\n[보유금액 : %,d원]\n", balance);
			System.out.println("1.콜라(1200) 2.사이다(1300) 3.우유(1500) 4.충전 5.환급 6.구매목록 7.종료");
			System.out.print("선택 : ");
			int menu = sc.nextInt();

			if (menu == 1) {
				if (balance >= 1200) {
					System.out.println("콜라선택\n");
					balance -= 1200;
					cola++;
					
				} else {
					System.out.println("잔액부족\n");
				}

			} else if (menu == 2) {
				if (balance >= 1300) {
					System.out.println("사이다선택\n");
					balance -= 1300;
					saida++;

				} else {
					System.out.println("잔액부족\n");
				}

			} else if (menu == 3) {
				if (balance >= 1500) {
					System.out.println("우유선택\n");
					balance -= 1500;
					milk++;

				} else {
					System.out.println("잔액부족\n");
				}

			} else if (menu == 4) {
				System.out.println();
				while (true) {
					System.out.printf("충전금액[%,d원]\n1.천원  2.오천원  3.만원  4.오만원  5.자유금액  6.처음으로", money);
					int paper = sc.nextInt();
					if (paper >= 1 && paper <= 6) {
						if (paper == 1) {
							System.out.println("\n몇장 추가");
							int m1 = sc.nextInt();
							money += money + (1000 * m1);
							System.out.println();
						}
						if (paper == 2) {
							System.out.println("\n몇장 추가");
							int m2 = sc.nextInt();
							money += money + (5000 * m2);
							System.out.println();
						}
						if (paper == 3) {
							System.out.println("\n몇장 추가");
							int m3 = sc.nextInt();
							money += money + (10000 * m3);
							System.out.println();
						}
						if (paper == 4) {
							System.out.println("\n몇장 추가");
							int m4 = sc.nextInt();
							money += money + (50000 * m4);
							System.out.println();
						}
						if (paper == 5) {
							System.out.println("금액입력");
							money += sc.nextInt();
							System.out.println();
						}
						if (paper == 6) {
							System.out.printf("[잔액%,d + 추가금액%,d]\n처음으로\n ", balance, money);
							balance += money;
							break;
						}
					} else {
						System.out.println("다시입력\n");
					}
				}

			} else if (menu == 5) {
				System.out.println("\n환급금액");
				int back = sc.nextInt();
				if (balance >= back) {
					balance -= back;
					System.out.println(back + "원을 환급\n");
				} else {
					System.out.println("금액초과\n");
				}
			} else if (menu == 6) {
				System.out.println("===구매목록===");
				if (cola >= 1) {
					System.out.println("콜라\t1200원\t" + cola + "개");
				}
				if (saida >= 1) {
					System.out.println("사이다\t1300원\t" + saida + "개");
				}
				if (milk >= 1) {
					System.out.println("우유\t1500원\t" + milk + "개");
				}
				System.out.println();

			} else if (menu == 7) {
				System.out.println("전액환급");
				break;
			}
		}
	}

}
