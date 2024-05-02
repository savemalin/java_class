package back;

import java.util.Scanner;

public class back3 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int de = 0;
		System.out.println("a를 입력하시오");
		int a = input.nextInt();
		System.out.println("b를 입력하시오");
		int b = input.nextInt();
		if(0<a && b<10) {
			de = a - b;
			
		}System.out.println(de);
		

	}

}
