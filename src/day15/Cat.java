package day15;

public class Cat extends Animal {

	private String jump;

	public String getJump() {
		return jump;
	}

	public Cat(String name, String sound, String jump) {
//		super();
//		setName(name);
//		setSound(sound);
		super(name, sound);// Animal클래스의 생성자 호출

		this.jump = jump;
	}

	@Override
	public void sound() {
//		System.out.println("Cat 클래스의 sound()를 호출");
//		super.sound();//super란 상속을 한 부모클래스의 이름
		System.out.print("고양이는 ");
		System.out.print(getSound());
		System.out.println(" 소리를 낸다");
	}

	public void eat() {
		super.eat();// 부모클래스의 eat() 메소드 호출
		System.out.println("고양이는 츄르를 먹습니다.");
	}

}
