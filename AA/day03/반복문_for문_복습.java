package day03;

import java.util.Scanner;

public class 반복문_for문_복습 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		// 문제1) 1~100까지의 합
		int sum = 0;
		for (int i = 0; i <= 100; i++) {
			sum = sum + i;
		}
		System.out.println("1번 답 : " + sum);

		// 문제2) 1~입력받은 수까지의 합
		System.out.println("숫자를 입력하시오");
		int num = scan.nextInt();
		int ex = 0;
		for (int j = 0; j <= num; j++) {
			ex = ex + j;
		}
		System.out.println("2번 답 : " + ex);
		// 문제3) 1~345까지 5의배수 개수
		int count = 0;
		for (int k = 1; k <= 345; k++) {
			if (k % 5 == 0) {
				count++;
			}
		}
		System.out.println("3번 답 : " + count);

	}

}
