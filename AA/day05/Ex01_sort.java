package day05;

import java.util.Scanner;

public class Ex01_sort {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("=====sort=====");
			System.out.print("숫자입력 : ");
			int n = sc.nextInt();
			
			System.out.println("1.오름차순 2.내림차순");
			int menu = sc.nextInt();
			
			if(menu==1) {
				for(int i =1;i<=n;i++) {
				System.out.print(i+" ");
				}
			}else if(menu==2) {
				for(int i=n;i>=1;i--) {
					System.out.print(i+" ");
				}
				
			}
			System.out.println();
			

		}
		
		
		
		
		
		
		
		

	}

}
