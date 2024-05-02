package day10;

public class Book {
	//필드
	String name;
	int price;
	String author;
	String publisher;
	
	public Book() { // 기본생성자는 보이드도 없다
		//생성자가 호출되면 실행
	}
	
	public Book(String name) { // 매개변수가 있는 생성자
		this.name = name;//생성자가 호출되면 실행
		// 매개변수 name의 값을  필드name의 값으로 사용
	}
	
	public Book(int price) {
		this.price = price;
	}
	
	
	 public void printInfo() {
		 
	 }
	 public Book(String String, int i) {
		 this.name = name;
		 this.price=price;
	 }
	 public Book(String string, int i, String string1) {
		 this.name = name;
		 this.price=price;
		 this.author=author;
		
	}
// 모든 필드를 초기화 하는 생성자
	public Book(String name, int price, String author, String publisher) {
		super();
		this.name = name;
		this.price = price;
		this.author = author;
		this.publisher = publisher;
	}
	 
	 
	 
	 

}
