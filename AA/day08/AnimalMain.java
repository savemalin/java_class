package day08;

public class AnimalMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 입력값을 바로 출력하지 않고 메서드를 통해 출력
		Animal dog = new Animal();
		dog.setName("강아지");
		dog.setSound("멍멍");
		dog.setLeg(4);
		dog.print();
//		System.out.println(dog.getName()+"\t"+dog.getSound()+"\t"+dog.getLeg());
		
		// cat, 고양이, 냥냥, 4
		Animal cat = new Animal();
		cat.setName("고양이");
		cat.setSound("냥냥");
		cat.setLeg(4);
		cat.print();
//		System.out.println(cat.getName()+"\t"+cat.getSound()+"\t"+cat.getLeg());
		
		// chicken, 닭, 꼬끼오, 2
		Animal chicken = new Animal();
		chicken.setName("닭");
		chicken.setSound("꼬끼오");
		chicken.setLeg(2);
		chicken.print();
//		System.out.println(chicken.getName()+"\t"+chicken.getSound()+"\t"+chicken.getLeg());
		
		
		// snake, 뱀, 쓰읍, 0
		Animal snake = new Animal();
		snake.setName("뱀");
		snake.setSound("쓰읍");
		snake.setLeg(0);
		snake.print();
//		System.out.println(snake.getName()+"\t"+snake.getSound()+"\t"+snake.getLeg());
		
	
		
		
	}

}
