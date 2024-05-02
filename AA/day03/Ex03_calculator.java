package day03;

import java.util.Scanner;

public class Ex03_calculator {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean re = true;
		int result = 0;
		while (true) {
//			System.out.println("=====계산기=====");
//			System.out.print(" => ");
//			int num1 = sc.nextInt();
//
//			System.out.println("1.더하기 2.빼기 3.곱하기 4. 나누기 5.나머지");
//			System.out.print("선택 => ");
//			int menu = sc.nextInt();
//
//			System.out.print(" = > ");
//			int num2 = sc.nextInt();

//			switch (menu) {
//			case (1):
//				System.out.println(num1 + "+" + num2 + "=" + (num1 + num2));
//				break;
//			case (2):
//				System.out.println(num1 + "-" + num2 + "=" + (num1 - num2));
//				break;
//			case (3):
//				System.out.println(num1 + "*" + num2 + "=" + (num1 * num2));
//				break;
//			case (4):
//				System.out.println(num1 + "/" + num2 + "=" + (num1 / num2));
//				break;
//			case (5):
//				System.out.println(num1 + "%" + num2 + "=" + (num1 % num2));
//				break;
//			switch (menu) {
//			case 1:
//				System.out.printf("%d + %d = %d\n", num1, num2, (num1 + num2));
//				break;
//			case 2:
//				System.out.printf("%d - %d = %d\n", num1, num2, (num1 - num2));
//				break;
//			case 3:
//				System.out.printf("%d * %d = %d\n", num1, num2, (num1 * num2));
//				break;
//			case 4:
//				System.out.printf("%d / %d = %.3f\n", num1, num2, (num1 / (double) num2));
//				break;
//			case 5:
//				System.out.printf("%d %% %d = %d\n", num1, num2, (num1 % num2));
//				break;
//			default:

//			}
//		}
			System.out.println("=====계산기=====");
			System.out.print("연산식 띄어쓰기로 구분하여 입력하시오 => ");
			//띄어쓰기를 사용해야하는 이유는 띄어쓰기를 안할시 num1값으로 들어감
			int num1=0;
			if(re) {
				num1 = sc.nextInt();
			}else {
				num1 = result;
				System.out.print(num1+" ");
			}
			
			String cal = sc.next();
			int num2 = sc.nextInt();

			switch (cal) {
			case "+":
				System.out.printf("%d + %d = %d\n", num1, num2, (num1 + num2));
				result = num1+num2;
				break;
			case "-":
				System.out.printf("%d - %d = %d\n", num1, num2, (num1 - num2));
				result = num1-num2;
				break;
			case "*":
				System.out.printf("%d * %d = %d\n", num1, num2, (num1 * num2));
				result = num1*num2;
				break;
			case "/":
				System.out.printf("%d / %d = %.3f\n", num1, num2, (num1 / (double) num2));
				result = num1/num2;
				break;
			case "%":
				System.out.printf("%d %% %d = %d\n", num1, num2, (num1 % num2));
				result = num1%num2;
				break;
			default:
			}
			
			System.out.print("새로하기(Y/y)?");
			String y=sc.next();
			if(!y.equals("Y")&&!y.equals("y")) {
				re = false;
			}else {
				re = true;
			}

		}
	}
}
