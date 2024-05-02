package day04;

import java.util.Scanner;

public class Ex03_sort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("=====sort=====");
			System.out.println("숫자입력 : ");
			int num1 = sc.nextInt();
			System.out.println("숫자입력 : ");
			int num2 = sc.nextInt();
			
			
			System.out.println("1.오름차순 2.내림차순");
			System.out.println("선택 : ");
			int menu = sc.nextInt();
			
			if(num1 > num2) {
				int temp = num1;
				num1 = num2;
				num2 = temp;
			}
			
//			if(menu == 1) {
//				for(int i = 1; i<=num; i++) {
//					System.out.print(i);
//					if(i!=num) {
//						System.out.print(",");
//					}
//				}
//				
//			}else if(menu == 2) {
//				for(int j = num; j>=1; j--) {
//					System.out.print(j);
//					if(j!=1) {
//						System.out.print(",");
//					}
//				}
//				
//			}
			
			
			System.out.println();
			
			
		}

	}

}
