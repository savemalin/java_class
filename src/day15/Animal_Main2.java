package day15;

public class Animal_Main2 {

	public static void main(String[] args) {
//		Animal animal = new Animal("동물이름","울음소리");
		Dog dog = new Dog();//Dog클래스의 기본 생성자 호출
		System.out.println("dog.getName() : "+dog.getName());
		System.out.println("dog.getSound() : "+dog.getSound());
		System.out.println("dog.getSmell() : "+dog.getSmell());
		
		
		Cat cat = new Cat("나비","야옹","도약");
		System.out.println("cat.getName() : "+cat.getName());
		System.out.println("cat.getSound() : "+cat.getSound());
		System.out.println("cat.getJump() : "+cat.getJump());
		
		
	}

}
