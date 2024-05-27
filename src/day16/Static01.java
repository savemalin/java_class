package day16;

public class Static01 {

	public static void main(String[] args) {
		Student stu01 = new Student();
		stu01.stuNumber=1;
		stu01.room="class01";
		
		Student stu02 = new Student();
		stu02.stuNumber=2;
		stu02.room="강의실01";
		
		
		System.out.println(stu01.stuNumber);
		System.out.println(stu02.stuNumber);
		System.out.println(stu01.room);
		System.out.println(stu02.room);
		
		Student stu03 = new Student();
		
		System.out.println(stu03.room);
		
		
		
		
		
	}

}
