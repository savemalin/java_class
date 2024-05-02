package day10;

import java.util.Scanner;

public class BookMain {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Book book = new Book();// Book이라는 필드를 가지고 있는 개체
		book.name="오라클";
		System.out.println("Book.name : "+book.name);
		
		
		Book book2 = new Book("HELLO IT");
		System.out.println("Book2.name : "+book2.name);
		
		Book book3 = new Book("JAVA");
		System.out.println("Book3.name : "+book3.name);
		
		//book4 : price가 20000인 상태로 생성
		
		Book book4 = new Book(20000);
		System.out.println("Book4.price : " + book4.price);
		
		// 책 이름, 가격이 초기화 된 객체 생성
		Book javaBook = new Book();
		System.out.println("Book4.name"+book4.name);
		System.out.println("Book4.price"+book4.price);
		
		Book book5 = new Book();
		book5.price = 20000;
		System.out.println();
		
		// 책 이름, 가격이 초기화 된 객체 생성 이름(매개변수1, 매개변수2)
		Book javaBook1 = new Book("자바",30000);
		
		// 책 이름, 가겨, 저자가 초기화 된 객체 생성
		Book htmlBook = new Book("HTML"+25000+"알수없음");
		
		Book javaScriptBook = new Book("JS", -10000,"알수없음");
		System.out.println("javaScriptBook.price: "+javaScriptBook.price);
		
		Book book6 = new Book("저자",10000,"출판사","책이름");
		
		
		
		
		
		
		

	}

}
