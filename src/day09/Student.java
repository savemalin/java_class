package day09;

public class Student {//public 접근제한자
	String name;
	int grade;
	String major;
	
	
	/* void : 리턴타입
	 * rpintInfo : 메소드 이름
	 * () : 매개변수
	 * 
	 * 
	 */
	void printInfo() {
		System.out.println("학생정보 출력");
		System.out.println("이름 : "+name);
		System.out.println("학년 : "+grade);
		System.out.println("전공 : "+major);
		
		
		
	}
	
	
	
	

}
