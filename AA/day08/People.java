package day08;
//필드
public class People {
	private String name;
	private int age;
//생성자
	public People(String name, int age) {
		this.name = name;
		this.age = age;

	}
	//메서드
	public void setName(String name) {
		this.name=name;
				
	}
	public String getName() {
		return name;
	}
	public void aging() {
		age++;
	}
	public int aging(int age) {
		this.age+=age;
		return this.age;
	}
	public void print() {
		System.out.println(name+"\t"+age);
	}

}
