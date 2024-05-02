package day04;

import java.util.Scanner;

public class Ex05_updown {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int answer = (int) (Math.random() * 31) + 1;
		// 결론으로 1~31까지 랜덤
		System.out.println(answer);

		int life = 5;

		// 미션1) 제한횟수 5번

		while (true) {
			if (life != 0) {
				System.out.print("=====up&down=====");
				System.out.println("남은횟수 : " + life);
				System.out.println("1~31까지 숫자 : ");
				int num = sc.nextInt();

				if (answer > num) {
					System.out.println("UP");
				} else if (answer < num) {
					System.out.println("DOWN");
				} else {
					if (life == 5) {
						System.out.println("Perfect!");
					} else if (life >= 3) {
						System.out.println("Good~");
					} else if (life > 0) {
						System.out.println("Not Bad...");
					}
					break;

				}
				life--;
				System.out.println();

			} else {
				System.out.println("Restart?(Y/N)");
				String re = "";
				re = sc.next();
				if (re.equals("Y")) {
					answer = (int) (Math.random() * 31) + 1;
					life = +5;
				} else if (re.equals("N")) {
					System.out.println("Good bye...");
					break;
				} else {
					System.out.println("You're out!");
					break;
				}

			}

		}

	}

}
