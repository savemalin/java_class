package day15;

public class Dog extends Animal {

	// extends = 상속받을 부모 클래스

	private String smell;

	public String getSmell() {
		return smell;
	}

	public Dog() {
		super();
		this.smell = null;

	}

	@Override
	public void eat() {
		// TODO Auto-generated method stub
		System.out.println("Dog에서 재정의한 eat()");
		System.out.println("개는 개껌을 먹습니다.");
	}

}
