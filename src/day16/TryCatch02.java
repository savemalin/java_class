package day16;

import java.util.Scanner;

public class TryCatch02 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		try {
		System.out.print("입력 : ");
		String input = sc.next();
		
		int number = Integer.parseInt(input); 
		System.out.println("number : " + number);
		int [] scores = new int[3];
		scores[number]=100;
		}catch(NumberFormatException e) {
			System.out.println("실행불가");
		}
			
		
	}

}
