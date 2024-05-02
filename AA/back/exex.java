package back;

public class exex {

	public static void main(String[] args) {

		int sum=0;
		for(int i=0; i<10; i++) {
			switch(i%2) {
			case 1:
			case 2:
			case 3:
			case 4:
			case 5:
			case 6:
			case 7:
			case 8:
			case 9:
				sum+=100;
			default:
				sum+=i;
			}
		}
		System.out.println(sum);
		}
		
		
		

	}


