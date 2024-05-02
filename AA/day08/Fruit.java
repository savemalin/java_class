package day08;

public class Fruit {
	String name;
	String color;
	boolean isSeed;
	
	// 생성자 특징
	// 1. 리턴타입이 없다.
	// 2. 클래스이름과 동일하다.
	
	public Fruit() { // 기본생성자-객체를 만들려면 생성자가 필수(기본생성자는 다른생성자가 없을때 자동으로 생성된다)
			
	}
	
	public Fruit(String name) {
		this.name=name;
	}
	
	public Fruit(String name, String color) {
		this.name=name;
		this.color=color;
		
		
	}
	public Fruit(String name, String color, boolean isSeed) {
		this.name = name;
		this.color = color;
		this.isSeed = isSeed;
		//this(name,color,isSeed); 는 본인이 생성자기에 매개변수에 해당되는 생성자를 호출한다.
		//this()생성자는 무조건 맨 위로 올라와야 한다.
	}
	
	
	public void Print() {
		System.out.printf("%s\t%s\t%b\n",name,color,true);
		
	}
	
	
	// 오버로딩은 매개변수가 다른 메소드
	// ex) public void print(int a)
	// ex) public void print(int a, int b)
	// ex) public void print(int b, int a)
	// ex) public void print(String a, int b)
}
