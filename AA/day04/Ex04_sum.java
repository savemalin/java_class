package day04;

import java.util.Scanner;

public class Ex04_sum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("=====sum=====");
			System.out.print("숫자입력 : ");
			int num = sc.nextInt();

			System.out.println("1.총합 2.짝수합 3.홀수합 4.3의배수합 0.나가기");
			System.out.println("선택 : ");
			int menu = sc.nextInt();

//			int = 0;
//			if (menu == 1) {
//				for (int i = 1; i <= num; i++) {
//					sum += i;
//				}
//				System.out.println("총합 : " + sum);
//
//			} else if (menu == 2) {
//				for (int j = 1; j <= num; j++) {
//					if (j % 2 == 0) {
//						sum += j;
//					}
//				}
//				System.out.println("짝수합 : " + sum);
//
//			} else if (menu == 3) {
//				for (int k = 1; k <= num; k++) {
//					if (k % 2 == 1) {
//						sum += k;
//					}
//				}
//				System.out.println("홀수합 : " + sum);
//
//			} else if (menu == 4) {
//				for (int a = 1; a <= num; a++) {
//					if (a % 3 == 0) {
//						sum += a;
//					}
//				}
//				System.out.println("3의배수합 : " + sum);
//
//			} else if (menu == 0) {
//				break;
//			}
//
//			System.out.println();

			int a = 0;
			int b = 0;

			if (menu == 1) {
				a = 1;
				b = 0;

			} else if (menu == 2) {
				a = 2;
				b = 0;

			} else if (menu == 3) {
				a = 2;
				b = 1;

			} else if (menu == 4) {
				a = 3;
				b = 0;

			} else if (menu == 0) {
				break;
			}
			int sum = 0;

			for (int i = 1; i <= num; i++) {
				if (i % a == b) {
					sum += i;
				}
			}
			System.out.println(sum);

		}
		System.out.println("종료");

	}

}
