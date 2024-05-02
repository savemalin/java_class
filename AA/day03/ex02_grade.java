package day03;

import java.util.Scanner;

public class ex02_grade {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("=====성적표=====");
			System.out.println("이름 : ");
			String name = sc.next();
			System.out.println("국어 : ");
			int kor = sc.nextInt();
			System.out.println("영어 : ");
			int eng = sc.nextInt();
			System.out.println("수학 : ");
			int mat = sc.nextInt();
			int total = kor+eng+mat;
			double avg = total/3.0;
			//double avg = total/(double)3; , double avg = total/3.0;
			char grade = ' ';
			//char =>캐릭터는 ''넣어야한다. 유니코드로 변환하여 글자를 넣기때문에. 띄어쓰기 또한 유니코드에 존재하니 띄어쓰기해야함
			if(avg >= 90) {
				grade = 'A';
				
			}else if(avg >= 80) {
				grade='B';
			}else if(avg >= 70) {
				grade='C';
			}else if(avg >= 60) {
				grade='D';
			}else {
				grade = 'F';
			}
			System.out.println("이름\t국어\t영어\t수학\t총점\t평균\t학점");
			System.out.println("====================================================");
			System.out.println(name+"\t"+kor+"\t"+eng+"\t"+mat+"\t"+total+"\t"+avg+"\t"+grade);
			System.out.printf("%s\t%d\t%d\t%d\t%d\t%.2f\t%c\n",name,kor,eng,mat,total,avg,grade);
			//System.out.printf => 포맷, s=string, d=double, f=fault?실수, c=char캐릭터, %,d원 => 100,000,000원
			
			System.out.println("다시등록(Y/y)?");
			String re = sc.next();
			if(!(re.equals("Y")||re.equals("y"))) {
				break;
			}
			
			System.out.println();
		}
		System.out.println("성적 프로그램 종료");
	}

}
