package day08;

import java.util.Scanner;

public class Ex01_studentMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Ex01_student[] list = new Ex01_student[10];
		int cnt = 0;
		int number = 100;

		while (true) {
			System.out.println("=====학사관리시스템=====");
			System.out.println("1.학생등록 2.학생목록 3.학생검색 0.종료");
			System.out.print("선택 : ");
			int menu = sc.nextInt();

			if (menu == 1) {
				Ex01_student s = new Ex01_student();
				s.setNo("S" + number++);
				System.out.print("이름 : ");
				s.setName(sc.next());
				System.out.print("학과 : ");
				s.setDept(sc.next());
				System.out.print("학년 : ");
				s.setYear(sc.nextInt());
				list[cnt] = s;
				System.out.println(s.getName() + "학생 등록 완료!");
				cnt++;

			} else if (menu == 2) {
				System.out.println("학번\t이름\t학과\t학년");
				System.out.println("========================");
				for (int i = 0; i < cnt; i++) {
					list[i].print();
				}

			} else if (menu == 3) {
				System.out.print("검색할 학번 : ");
				String serchNo = sc.next();
				boolean find = false;
				for (int i = 0; i < cnt; i++) {
					if (serchNo.equals(list[i].getNo())) {
						list[i].print();
						find = true;
						break;
					}
				}
				if (!find) {
					System.out.println("조회할 수 없는 학생입니다.");
				}

			} else if (menu == 0) {
				break;
			}

			System.out.println();
		}

	}

}
