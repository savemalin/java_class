package day11_;

import java.util.Scanner;

public class CafeMain {

	public static void main(String[] args) {
		// static : 클래스를 볼 때 객체가 없어도 메모리 안에 main 메소드가 있어서 실행이 됨
		CafeService cafesvc = new CafeService();
		// 객체가 우선 생성되어 있어야 메소드를 호출
		cafesvc.startCafe();
		
	}

}
