package day08;

public class PeopleMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		People p1 = new People("김개똥", 100);
//		p1.name = "김개똥";
		p1.aging();
		p1.print();
		
		People p2 = new People("이순신", 80);
		System.out.println(p2.aging(15));
		
	}

}
