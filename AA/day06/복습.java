package day06;

import java.util.Scanner;

public class 복습 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 문제1) 하나의 숫자를 입력받고 짝수, 홀수 출력
		System.out.print("숫자입력 : ");
		int num = sc.nextInt();
		if (num % 2 == 0) {
			System.out.println("1번 답 : 짝수");
		} else {
			System.out.println("1번 답 : 홀수");
		}
		// 문제2) 하나의 숫자를 입력받아 1~입력받은 수까지의 합 출력
		int sum = 0;
		System.out.print("숫자입력 : ");
		int max = sc.nextInt();
		for (int i = 0; i <= max; i++) {
			sum += i;
		}
		System.out.println("2번 답 : " + sum);

		// 문제3) 반복해서 숫자를 입력받다가 0이 입력되면 반복문 종료
		int num2 = 0;
		while (true) {
			System.out.print("숫자입력 : ");
			num2 = sc.nextInt();
			if (num2 == 0) {
				break;
			}
		}

		// 문제4) 배열a의 전체값의 합 출력
		int[] a = { 5, 6, 7, 8, 9 };
		int sum2 = 0;
		for (int j = 0; j < a.length; j++) {
			sum2 += a[j];
		}
		System.out.println("4번 답 :" + sum2);

	}

}
