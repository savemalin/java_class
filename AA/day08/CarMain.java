package day08;

public class CarMain {
	public static void main(String[] args) {
		Car car1 = new Car();// car1은 객체 - Car()는 생성자
		car1.name = "그랜져";
		car1.tire = "한국";
		car1.color = "검정";
//		System.out.println(car1.name);
		car1.run();//생성자 아님 메서드(메서드)
		car1.speedUp(89);
		car1.getColor();
		System.out.println(car1.getColor());
//		System.out.println(car1.run());//리턴값이 없기에 오류
		car1.tireChange("금호");
		System.out.println();
		
		
		Car car2 = new Car();
		car2.name = "제네시스";
		car2.tire = "넥센";
		car2.color = "빨강";
		
		
		
		
		
		
		
		
	}

}
