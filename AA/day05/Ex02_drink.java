package day05;

import java.util.Scanner;

public class Ex02_drink {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		int mo = 10000000;// 돈
//		int a1 = 110000;// 망고빙수가격
//		int b2 = 200000;// 초코빙수가격
//		int c3 = 89000;// 딸기빙수가격
//		int a = 0;// 총망고빙수갯수
//		int b = 0;// 총초코빙수갯수
//		int c = 0;// 총딸기빙수갯수
//		int ea = 0;// 구매갯수
//		int ch = 0;// 충전금액
//		int menu = 0;// 메뉴선택
//
//		while (true) {
//			System.out.printf("=====신라호텔=====잔액[%,d원]\n", mo);
//			System.out.println("1.망고빙수(110,000원) 2.초코빙수(200,000원) 3.딸기빙수(89,000원) 4.충전 5.구매목록");
//			System.out.print("선택 : ");
//			menu = sc.nextInt();
//
//			if (menu > 0 && menu < 6) {
//				if (menu == 1) {
//					System.out.println("수량 : ");
//					ea = sc.nextInt();
//					if (ea > 0) {
//						a = +ea;
//						mo -= ea * a1;
//						System.out.println("망고빙수" + ea + "개 구매!!\n ");
//					} else {
//						System.out.println("망고빙수 구매 취소\n ");
//					}
//				} else if (menu == 2) {
//					System.out.println("수량 : ");
//					ea = sc.nextInt();
//					if (ea > 0) {
//						b = +ea;
//						mo -= ea * b2;
//						System.out.println("초코빙수" + ea + "개 구매!!\n ");
//					} else {
//						System.out.println("초코빙수 구매 취소\n ");
//					}
//				} else if (menu == 3) {
//					System.out.println("수량 : ");
//					ea = sc.nextInt();
//					if (ea > 0) {
//						c = +ea;
//						mo -= ea * c3;
//						System.out.println("딸기빙수" + ea + "개 구매!!\n ");
//					} else {
//						System.out.println("딸기빙수 구매 취소\n ");
//					}
//				} else if (menu == 4) {
//					System.out.print("충전금액 : ");
//					ch = sc.nextInt();
//					if (ch > 0) {
//						System.out.printf("%,d원 충전완료", ch);
//						System.out.println();
//						mo += ch;
//					} else {
//						System.out.println("충전불가능");
//					}
//				} else {
//					System.out.println("=====목록=====\n망고빙수\t" + a + "개\n초코빙수\t" + b + "개\n딸기빙수\t" + c + "개\n");
//				}
//			} else {
//				System.out.println("입력오류");
//			}
//		}
		int mo = 10000000;
		int ch = 0;
		int menu;
		int a=0;
		int b=0;
		int c=0;

		String name = "";

		while (true) {
			int price = 0;
			int ea = 0;
			System.out.printf("=====신라호텔=====잔액[%,d원]\n", mo);
			System.out.println("1.망고빙수(110,000원) 2.초코빙수(200,000원) 3.딸기빙수(89,000원) 4.충전 5.구매목록");
			System.out.print("선택 : ");
			menu = sc.nextInt();

			if (menu > 0 && menu < 6) {
				switch (menu) {
				case 1:
					price = 110000;
					name = "망고빙수";
					break;
				case 2:
					price = 200000;
					name = "초코빙수";
					break;
				case 3:
					price = 89000;
					name = "딸기빙수";
					break;
				}
				System.out.print("수량 : ");
				ea = sc.nextInt();
				if (ea > 0) {
					if (mo >= (price * ea)) {
						mo -= price;
						System.out.println(name + "\t" + ea + "개 구매완료\n");
						
						
					} else {
						System.out.println("잔액부족\n");
					}
				} else {
					System.out.println(name + "구매취소\n");

				}if(menu == 4) {
					System.out.print("충전할 금액 : ");
					ch=sc.nextInt();
					mo+=ch;
					System.out.printf("충전된 금액 : %,d",mo);
					System.out.println();
					
					}else if(menu == 5) {
						System.out.println("=====구매목록=====\n망고빙수\t "+a+"개\n초코빙수\t "+b+"개\n딸기빙수\t "+c+"개\n ");
					}
			}
		}
	}
}
