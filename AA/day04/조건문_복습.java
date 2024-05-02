package day04;

import java.util.Scanner;

public class 조건문_복습 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 문제1) 하나의 숫자를 입력받아 짝수, 홀수 출력
		System.out.println("숫자를 입력하시오");
		int num = sc.nextInt();
		System.out.println("1번 답");
		if (num % 2 == 0) {
			System.out.println("짝수");
		} else {
			System.out.println("홀수");
		}
		// 문제2) 하나의 점수를 입력받아 90이상A 80이상B 70이상C 60이상D 60미만F를 출력
		System.out.println();
		System.out.println("숫자를 입력하시오");
		int num1 = sc.nextInt();
		System.out.println("2번 답");
		if (num1 <= 100 && num1 >= 0) {
			if (num1 >= 90) {
				System.out.println("A");
			} else if (num1 >= 80) {
				System.out.println("B");
			} else if (num1 >= 70) {
				System.out.println("C");
			} else if (num1 >= 60) {
				System.out.println("D");
			} else {
				System.out.println("F");
			}
		} else {
			System.out.println("입력오류");
		}

	}

}
