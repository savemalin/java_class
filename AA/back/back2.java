package back;

import java.util.Scanner;

public class back2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int num1 = 1;
		int num2 = 2;
		int sum = 0;
		System.out.println("a를 입력하시오");
		int a = input.nextInt();
		if(0<a) {
			System.out.println("b를 입력하시오");
			int b = input.nextInt();
			if(b<10) {
				sum = a+b;
				System.out.println("정답 : "+ sum);
				System.out.println(num1 + "+"+ num2+"="+(num1+num2));
			}
		}
		
			

	}

}
