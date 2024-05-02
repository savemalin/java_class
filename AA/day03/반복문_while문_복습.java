package day03;

import java.util.Scanner;

public class 반복문_while문_복습 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		// 문제1) while로 1~100까지 합
		int i = 0;
		int sum = 0;
		while(true) {
			if(i<=100) {
				sum = sum + i;
				i++;
			}else break;
		} 
		System.out.println("1번 정답 : "+sum);
	
		// 문제2) 반복적으로 숫자를 입력받아 출력하는데 0이 입력되면 반복문 종료
		while(true) {
			System.out.println("숫자입력");
			int num = scan.nextInt();
			if(num==0) {
				break;
			}else System.out.println("2번 : "+num);
		}
		
		// 문제3) 반복적으로 숫자를 입력받아 3의배수, 5의배수, 3과5의배수, 둘다아님 출력
		while(true) {
			System.out.println("3번 숫자입력");
			int num1 = scan.nextInt();
			if(num1 == 0) {
				break;
			}
			if(num1%15==0) {
				System.out.println("3과5의배수");
				
			}else if(num1%3==0) {
				System.out.println("3의배수");
				
			}else if(num1%5==0) {
				System.out.println("5의배수");
				
			}else System.out.println("둘다아님");

		}
	}

}
