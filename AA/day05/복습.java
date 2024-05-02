package day05;

import java.util.Scanner;

public class 복습 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 문제1) 하나의 숫자를 입력받아 3의배수, 5의배수, 3과5의배수, 둘다아님 출력
		System.out.println("숫자입력 : ");
		int q1 = sc.nextInt();
		if (q1 % 3 == 0 && q1 % 5 == 0) {
			System.out.println("3과5의배수");
		} else if (q1 % 3 == 0) {
			System.out.println("3의배수");
		} else if (q1 % 5 == 0) {
			System.out.println("5의배수");
		} else {
			System.out.println("둘다아님");
		}
		// 문제2) 하나의 숫자를 입력받아 1~입력받은 수까지의 합 출력
		int sum = 0;
		System.out.println("숫자입력 : ");
		int q2 = sc.nextInt();
		for (int i = 1; i <= q2; i++) {
			sum += i;
		}
		System.out.println("2번 답 : " + sum);
		// 문제3) 2번문제 while문으로
		int sum1 = 0;
		int j = 0;
		while (true) {
			if (j <= q2) {
				sum1 += j;
				j++;
			} else {
				break;
			}
		}
		System.out.println("3번 답 : " + sum1);
		// 문제4) 반복하면서 숫자를 입력받고, 0이 입력되면 반복문 종료
		while (true) {
			System.out.println("숫자입력 : ");
			int q3 = sc.nextInt();
			if (q3 == 0) {
				System.out.println("끝");
				break;
			}
			System.out.println("다시입력\n");
		}
	}
}
