package day09;

import java.util.Scanner;

import javax.print.attribute.standard.PrinterInfo;

public class StudentListMain {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("학생 수 입력 : ");
		int stuNumber = scan.nextInt();
		Student[] studentList = new Student[stuNumber];
		
		for(int i=0; i<studentList.length; i++) {
			Student stuInfo = new Student();
			System.out.println((i+1)+"번 학생 정보 입력");
			System.out.print("이름 : ");
			stuInfo.name = scan.next();
			System.out.print("학년 : ");
			stuInfo.grade = scan.nextInt();
			System.out.print("학과 : ");
			stuInfo.major = scan.next();
			
			studentList[i]=stuInfo;
	
		}
		for(int i=0;i<studentList.length; i++) {
			studentList[i].printInfo();
		}
		
		System.out.print("확인할 grade : ");
		int checkGrade = scan.nextInt();
		int outputGrade = 0;
		
		for(int i = 0; i<studentList.length; i++) {
			if(checkGrade==studentList[i].grade) {
				outputGrade++;
			}
		}
		
		System.out.println(checkGrade+"학년 학생은 "+outputGrade+"명입니다.");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//		int stuNumbers = 3;
//		Student[] stuList = new Student[stuNumbers];
//		System.out.println("1번 학생의 정보 입력");
//		Student stu01 = new Student();
//		System.out.print("이름입력 : ");
//		stu01.name = scan.next();
//		System.out.print("학년입력 : ");
//		stu01.grade = scan.nextInt();
//		System.out.print("학과입력 : ");
//		stu01.major = scan.next();
//		
//		stuList[0] = stu01;
//		
//		System.out.println("2번 학생의 정보 입력");
//		Student stu02 = new Student();
//		System.out.print("이름입력 : ");
//		stu02.name = scan.next();
//		System.out.print("학년입력 : ");
//		stu02.grade = scan.nextInt();
//		System.out.print("학과입력 : ");
//		stu02.major = scan.next();
//		
//		stuList[1] = stu02;
//		
//		System.out.println("3번 학생의 정보 입력");
//		Student stu03 = new Student();
//		System.out.print("이름입력 : ");
//		stu03.name = scan.next();
//		System.out.print("학년입력 : ");
//		stu03.grade = scan.nextInt();
//		System.out.print("학과입력 : ");
//		stu03.major = scan.next();
//		
//		stuList[1] = stu03;
//		
//		System.out.println("\n"+stuList[2].name+"\n");
//		stuList[0].printInfo();
		
		
		
		

	}

}
