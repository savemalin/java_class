package day07;

import java.util.Scanner;

public class exexex {
	public static void main(String[] args) {
		int answer1 = 0;
		int answer2 = 0;
		int answer3 = 0;
		Scanner sc = new Scanner(System.in);
		int strike = 0;
		int ball = 0;
		int out = 0;
		int i = 0;

		while (true) {
			while (i==0) {

				if ((answer1 == answer2 || answer2 == answer3 || answer1 == answer3)) {
					answer1 = (int) (Math.random() * 9) + 1;
					answer2 = (int) (Math.random() * 9) + 1;
					answer3 = (int) (Math.random() * 9) + 1;

				}else {i = 1;
					
				}

			}

			System.out.printf("%d%d%d\n", answer1, answer2, answer3);
			System.out.println("숫자입력> ");
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			if (!(a == b || b == c)) {
				if (a == answer1 && b == answer2 && c == answer3) {
					System.out.println("정답!");
				} else if (a == answer1) {
					strike++;
				}
				if (b == answer2) {
					strike++;
				}
				if (c == answer3) {
					strike++;
				} else if (a == answer2 || a == answer3) {
					ball++;
				} else if (a == answer2 && a == answer3) {
					ball = ball + 2;
				} else if (b == answer2 && b == answer3) {
					ball = ball + 2;
				} else if (b == answer2 || b == answer3) {
					ball++;
				} else if (c == answer2 && c == answer3) {
					ball = ball + 2;
				} else if (c == answer2 || c == answer3) {
					ball++;
				} else if (!(a == answer2) || !(a == answer3)) {
					out++;
				} else if (!(a == answer2) && !(a == answer3)) {
					out = out + 2;
				} else if (!(b == answer2) && !(b == answer3)) {
					out = out + 2;
				} else if (!(b == answer2) || !(b == answer3)) {
					out++;
				} else if (!(c == answer2) && !(c == answer3)) {
					out = out + 2;
				} else if (!(c == answer2) || !(c == answer3)) {
					out++;
				}
			}
			System.out.printf("%d스트라이크\n%d볼\n%d아웃\n", strike, ball, out);
			if (!(strike == 3)) {
				strike = 0;
				ball = 0;
				out = 0;
			}
		}
	}

}
