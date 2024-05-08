package day13;

import java.util.ArrayList;

public class ArrayList01 {
	public static void main(String[] args) {
		String[] nameList = new String[5];
		int length = nameList.length;
		nameList[0] = "김이름";
		System.out.println("nameList.length : "+nameList.length);
		
		
//		ArrayList<데이터타입> 리스트이름
		ArrayList<String> nameList1 = new ArrayList<>();
		int listSize = nameList1.size();
		System.out.println("listSize : "+listSize);
		//1.add() : ArrayList에 데이터 입력
		nameList1.add("자바");//nameList1의 0번 인덱스에 "자바" 저장
		nameList1.add("오라클");//nameList1의 1번 인덱스에 "오라클" 저장
		nameList1.add("HTML");//nameList1의 2번 인덱스에 "HTML" 저장
		//2.get() : ArrayList에 저장된 데이터 확인
		System.out.println("nameList1.get(0) : "+nameList1.get(0));
		System.out.println("nameList1.get(1) : "+nameList1.get(1));
		System.out.println("nameList1.get(2) : "+nameList1.get(2));
//		System.out.println("nameList1.get(3) : "+nameList1.get(3));
		//3번 인덱스가 존재하지 않기에 오류
		
		System.out.println("nameList1.size() : "+nameList1.size());
		// add(인덱스 번호, 저장할 값) : 지정된 인덱스에 데이터를 추가(끼어넣기)
		nameList1.add(1, "자바스크립트");
		System.out.println("\n nameList1.add() 실행 후");
		System.out.println("nameList1.get(0) : "+nameList1.get(0));
		System.out.println("nameList1.get(1) : "+nameList1.get(1));
		System.out.println("nameList1.get(2) : "+nameList1.get(2));
		System.out.println("nameList1.get(3) : "+nameList1.get(3));
		System.out.println("nameList1.size() : "+nameList1.size());

		//3.remove() : ArrayList에 저장된 데이터 삭제
		nameList1.remove(0);
		System.out.println("\n nameList1.remove(0) 실행 후");
		System.out.println("nameList1.size() : "+nameList1.size());
		System.out.println("nameList.get(0) : "+ nameList1.get(0));
		System.out.println("nameList.get(1) : "+ nameList1.get(1));
		System.out.println("nameList.get(2) : "+ nameList1.get(2));

		nameList1.remove("오라클");
		System.out.println("\n nameList1.remove(오라클) 실행 후");
		System.out.println("nameList1.size() : "+nameList1.size());
		System.out.println("nameList1.get(0)"+nameList1.get(0));
		System.out.println("nameList1.get(1)"+nameList1.get(1));
		
		nameList1.remove("스프링");
		System.out.println("\n nameList1.remove(스프링) 실행 후");
		System.out.println("nameList1.size() : "+nameList1.size());
		System.out.println("nameList1.get(0) : "+nameList1.get(0));
		System.out.println("nameList1.get(1) : "+nameList1.get(1));
		//String removeData = nameList1.remove(0); = 제거하는 값을 알려줌
		//boolean re = nameList1.remove("오라클");일 경우 True
		//boolean re1 = nameList1.remove("스프링");일 경우 False
		
		
		
		
		
	}

}
