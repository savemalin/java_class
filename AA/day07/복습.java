package day07;

import java.util.Scanner;

public class 복습 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int[] a = { 5, 6, 7, 8, 9 };
		int sum = 0;
		int sum1 = 0;
		int sum2 = 0;

		// 문제1) 배열 a의 모든 값의 합
		for (int i = 0; i < a.length; i++) {

			sum += a[i];

		}
		System.out.println(sum);

		// 문제2) 배열 a의 짝수 값의 합
		for (int i = 0; i < a.length; i++) {
			if (a[i] % 2 == 0) {
				sum1 += a[i];
			}

		}
		System.out.println(sum1);

		// 문제3) 배열 a의 짝수 인덱스의 값의 합
		for (int i = 0; i < a.length; i++) {
			if (i % 2 == 0) {
				sum2 += a[i];
			}
		}
		System.out.println(sum2);

	}

}
