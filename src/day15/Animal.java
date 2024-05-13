package day15;

public class Animal {

	private String name; // 동물 이름
	private String sound;

	public Animal() {
		this.name = null;
		this.sound = null;
	}

	public Animal(String name, String sound) {
		this.name = name;
		this.sound = sound;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void sound() {
		System.out.print("동물은 ");
		System.out.print(sound);
		System.out.println(" 소리를 낸다.");
	}

	public void setSound(String sound) {
		this.sound = sound;
	}

	public String getSound() {
		return sound;
	}

	public void eat() {
		System.out.println("동물은 먹이를 먹습니다.");

	}

}
