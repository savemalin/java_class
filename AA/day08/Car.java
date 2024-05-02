package day08;

public class Car {//객체지향의 가장 큰 장점은 재사용성
	String name;
	String tire;
	String color;
	int speed;
	
	public void run() {
		System.out.println(name+" run메서드 호출");
		speed+=2;
						
	}
	

	public void speedUp(int a) {//소괄호 안에 인트를 넣었기에 출력시 인트값을 넣어야 실행됌(매개변수)
		speed += a;
		
		
	}
	public String getColor() {// String이 void의 리턴을 대신하여 리턴이 없으면 오류
		return color;//컬러대신 스피드를 넣으면 문자열과 정수열이기에 오류
		
	}
	public String tireChange(String a) {
		tire =a;
		return tire;
		
	}

}
