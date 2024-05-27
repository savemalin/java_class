package day16;

public class Student {

	static int count; // 생성된 student 객체 수
	
	int stuNumber;
	static String room;
	
	public Student() {
		count++;
//		this.stuNumber=count;
	}
		
	public static void printInfo() {
		System.out.println("PrintInfo() 호출");
	
	}
	
	
	

}
