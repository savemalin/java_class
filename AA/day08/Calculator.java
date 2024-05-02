package day08;

public class Calculator {
	int num1;
	int num2;
	
	// 메서드
		/* 접근제한자 public, 리턴타입 x, 메서드명 sum, 매개변수 x, 
		 * 실행문구 num1과 num2 더한값 출력 */
		public void sum() {
			System.out.println(num1+num2);
			
		}
		/* 접근제한자 public, 리턴타입 x, 메서드명 sub, 매개변수 정수형 2개 
		 * 실행문구 매개변수로 받은 두개의 정수를 뺀값 출력 */
		public void sub(int a, int b) {
			System.out.println(a-b);
			
		}
		
		/* 접근제한자 public, 리턴타입 o, 메서드명 mul, 매개변수 x
		 * 실행문구 num1과 num2 곱한값 리턴 */
		public int mul() {
			return num1*num2;
		}
		
		/* 접근제한자 public, 리턴타입 o, 메서드명 div, 매개변수 정수형 2개
		 * 실행문구 매개변수로 받은 두개의 정수를 나누값 리턴 */
		public double div(int a, int b) {
			if(b==0) {
				System.out.println("0으로 나눌 수 없음");
				return 0;
			}
			return a/ (double) b;
		}
	
	
	
	
	

}

