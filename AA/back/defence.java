package back;

import java.util.Scanner;

public class defence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int choice = 10;
		int unit = 0;
		int round = 1;
		int power = 0;
		int roundUp = 0;
		int roundsum = 1;
		int boss = 0;
		int normal = 0;
		int rare = 0;
		int uniqe = 0;
		int legendary = 0;
		int god = 0;

		while (true) {
			if(round==101) {
				System.out.println("ALL Clear!!!!!!!!!!!!!!!!!!!!!!");
				break;
			}
			roundUp = ((int) Math.ceil(round / 10) + 1);
			power = (normal * 1) + (rare * 10) + (uniqe * 25) + (legendary * 50) + (god * 100);

			System.out.println("현재 라운드 : " + round + "\n뽑기권 : " + choice);
			System.out.println("노말" + normal + ", 레어" + rare + ", 유니크" + uniqe + ", 레전더리" + legendary + ", 갓" + god);
			System.out.println("1.유닛뽑기 2.라운드진행");
			
			int selec = sc.nextInt();

			if (selec == 1) {
				if (choice > 0) {
					for (int i = choice; i >= 1; i--) {
						unit = (int) (Math.random() * 100) + 1;
						if (unit <= 50) {
							normal++;
							choice--;
							System.out.println("노말\n");
						} else if (unit <= 80) {
							rare++;
							choice--;
							System.out.println("레어\n");
						} else if (unit <= 95) {
							uniqe++;
							choice--;
							System.out.println("유니크!\n");
						} else if (unit <= 99) {
							legendary++;
							choice--;
							System.out.println("레전더리!!\n");
						} else {
							god++;
							choice--;
							System.out.println("갓!!!\n");
						}

					}

				} else {
					System.out.println("뽑기권 부족\n");

				}
			}

			if (selec == 2) {
				roundsum = (round * round / 2) + roundUp;
				if (power > roundsum) {
					if (round == 10 || round == 20 || round == 30 || round == 40 || round == 50 || round == 60
							|| round == 70 || round == 80 || round == 90 || round == 100) {
						boss = roundsum + (round / 2);
						if (power > boss) {
							System.out.println((round / 10) + "보스 Clear!!!!!\n");
							round++;
							choice += 10;
						} else {
							System.out.println("Failed");
							break;

						}

					} else {

						System.out.println(round + "라운드 Clear!!!\n");
						round++;
						choice += 4;
					}

				} else {
					System.out.println("Failed");
					break;

				}

			}

		}
	}

}
