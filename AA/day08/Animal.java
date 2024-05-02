package day08;

public class Animal {
	String name;
	String sound;
	int leg;
	String pri;
	
	public void setName(String name) {
		this.name=name;//매개변수와 필드의 이름이 무엇인지 프로그램이 헷갈리기에 this를 입력하여 필드를 나타냄
		
	}
	public String getName() {
		return name;
	}
	public void setSound(String sound) {
		this.sound=sound;
	}
	public String getSound() {
		return sound;		
	}
	public void setLeg(int leg) {
		this.leg=leg;
	}
	public int getLeg() {
		return leg;		
		
	}
	public void print() {
		System.out.println(name+"\t"+sound+"\t"+leg);
		
	}
		
		
	
}
