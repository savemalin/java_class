package day08;

public class CalculaoterMain {

	public static void main(String[] args) {
		// Calcultor 객체하나 생성
		Calculator c = new Calculator();
		// 객체 num1, num2필드에 값 대입
		c.num1 = 100;
		c.num2 = 10;
		// 4개의 메서드 호출해서 각각의 값 출력
		c.sum();
		c.sub(100, 10);
		System.out.println(c.mul());
		System.out.println(c.div(50, 20));
		
		
		

	}

}
