package day16;

public class Static02 {

	public static void main(String[] args) {
		
		Student stu01 = new Student();
		System.out.println("stu01.stuNumber : "+stu01.stuNumber);
		System.out.println("stu01.room : "+stu01.room);
		
		Student stu02 = new Student();
		System.out.println("stu02.stuNumber : "+stu02.stuNumber);
		System.out.println("stu02.room : "+stu02.room);
		
		
		Student stu03 = new Student();
		
		System.out.println("\n생성된 Student 객체의 수 : "+Student.count);
		
		System.out.println(stu01.count);
		System.out.println(stu02.count);
		System.out.println(stu03.count);
		
		
		UtilClass uc01=UtilClass.getInstance();
		uc01.number = 1;
		UtilClass uc02 = UtilClass.getInstance();
		
		System.out.println(uc02.number==1);
		
		
	}

}
