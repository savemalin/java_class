package day04;

import java.util.Scanner;

public class 반복문_복습 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 문제1) 1~100까지의 합
		int sum = 0;
		for (int i = 0; i <= 100; i++) {
			sum = sum + i;
		}
		System.out.println("1번 답 : " + sum);

		// 문제2) 1~100까지 3의배수, 5의배수, 3과5의개수가 각각 몇개
		int a3 = 0;
		int a5 = 0;
		int a35 = 0;
		for (int j = 1; j <= 100; j++) {
			if (j % 3 == 0 && j % 5 == 0) {
				a35++;
			}if (j % 3 == 0) {
				a3++;
			}if (j % 5 == 0) {
				a5++;
			}
		}
		System.out.println("2번 답 - 3의배수 : " + a3 + ", 5의배수 : " + a5 + ", 3과5의배수 : " + a35);
		// 문제3) 숫자를 무한으로 입력받는데 0이 입력되면 반복문 종료
		System.out.println("숫자를 입력하시오");
		while (true) {
			int num = sc.nextInt();
			if (num != 0) {
				System.out.println("숫자를 입력하시오");
			} else {
				System.out.println("끝");
				break;

			}
		}

	}

}
