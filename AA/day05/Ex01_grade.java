package day05;

import java.util.Scanner;

public class Ex01_grade {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String[] name = new String[10];
		int[] kor = new int[10];
		int[] eng = new int[10];
		int[] mat = new int[10];
		int[] total = new int[10];
		double[] avg = new double[10];
		char[] grade = new char[10];
		int cnt = 0;

		while (true) {
			System.out.println("=====성적표=====");
			System.out.println("1.성적등록 2.성적리스트 3.성적수정 0.종료");
			System.out.print("선택 : ");
			int menu = sc.nextInt();

			if (menu == 1) {

				System.out.print("이름 : ");
				name[cnt] = sc.next();
				System.out.print("국어 : ");
				kor[cnt] = sc.nextInt();
				System.out.print("영어 : ");
				eng[cnt] = sc.nextInt();
				System.out.print("수학 : ");
				mat[cnt] = sc.nextInt();
				total[cnt] = kor[cnt] + eng[cnt] + mat[cnt];
				avg[cnt] = total[cnt] / (double) 3;
				if (avg[cnt] >= 90) {
					grade[cnt] = 'A';
				} else if (avg[cnt] >= 80) {
					grade[cnt] = 'B';
				} else if (avg[cnt] >= 70) {
					grade[cnt] = 'C';
				} else if (avg[cnt] >= 60) {
					grade[cnt] = 'D';
				} else {
					grade[cnt] = 'F';
				}
				System.out.println(name[cnt] + "학생 성적등록 완료!");
				cnt++;

			} else if (menu == 2) {
				System.out.println("이름\t국어\t영어\t수학\t총점\t평균\t학점");
				System.out.println("===================================");
				for (int j = 0; j < cnt; j++) {
					System.out.printf("%s\t%d\t%d\t%d\t%d\t%.2f\t%c\n", name[j], kor[j], eng[j], mat[j], total[j],
							avg[j], grade[j]);

				}

			} else if (menu == 3) {
				int ex=0;
				System.out.print("수정할 학생 : ");
				String insName = sc.next();
				for (int i = 0; i < cnt; i++) {
					if (insName.equals(name[i])) {
						System.out.print("국어 : ");
						kor[i] = sc.nextInt();
						System.out.print("영어 : ");
						eng[i] = sc.nextInt();
						System.out.print("수학 : ");
						mat[i] = sc.nextInt();
						total[i] = kor[i] + eng[i] + mat[i];
						avg[i] = total[i] / (double) 3;
						if (avg[i] >= 90) {
							grade[i] = 'A';
						} else if (avg[i] >= 80) {
							grade[i] = 'B';
						} else if (avg[i] >= 70) {
							grade[cnt] = 'C';
						} else if (avg[i] >= 60) {
							grade[i] = 'D';
						} else {
							grade[i] = 'F';
						}
						System.out.println(name[i] + "학생 수정 완료");
						ex=1;
						

					}
					if (i == (cnt - 1)&&!(ex==1)) {
						System.out.println("없는 학생");

					}
				}

			} else if (menu == 0) {
				break;
			}

		}

		System.out.println();

	}

}
