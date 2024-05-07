package day11_;

import java.util.Scanner;

public class CafeService {
	// 카페 기능 정의 클래스
	/*
	 * 1. 주문 가능한 메뉴 출력 2. 메뉴 선택 & 선택한 메뉴를 주문 3. 주문 내역 확인
	 */

	/*
	 * 주문 가능한 메뉴 출력 기능 메소드
	 */

	// 필드
	// 메뉴 목록
	private Menu[] menuList = { new Menu("커피", "아메리카노", 2000, 0), new Menu("커피", "카페라떼", 2500, 0),
			new Menu("스무디", "딸기스무디", 3500, 0), new Menu("티", "아이스티", 2500, 0) };

	private Scanner scan;

	// 기본생성자
	public CafeService() {
		System.out.println("CafeService() 호출");
		this.scan = new Scanner(System.in);
	}

	// 메소드
	public void showMenu() {
		for (int i = 0; i < menuList.length; i++) {
			System.out.print("[" + i + "]" + menuList[i].getMenuName() + " ");
		}
		System.out.println("[" + menuList.length + "]주문내역"); //4.주문내역
	}

	// 프로그램 시작 기능
	public void startCafe() {
		boolean run = true;
		while (run) {
			// 메뉴 출력 기능 호출
			showMenu(); // 내부 메소드 호출
			int selMenu = selectMenu();
			if (selMenu == menuList.length) {
				// 주문내역 확인 기능 호출
				totalOrderList();
				
			} else if (selMenu >= 0 && selMenu < menuList.length) {
				// 선택한 메뉴의 주문 기능 호출
				menuOrder(menuList[selMenu]);

			} else {
				System.out.println("번호를 다시 입력해주세요.");
			}

		}
	}
	
	// 전체 주문 내역 확인 기능
	private void totalOrderList() {
		int totalCount = 0;	// 총 주문수
		int totalPrice = 0; // 총 주문금액
		for (int i = 0; i < menuList.length; i++) {
			// 메뉴별 주문수 출력
			System.out.print(menuList[i].getMenuName() + " " +menuList[i].getMenuOrder()+ "잔" + " ");
			totalCount += menuList[i].getMenuOrder();
			totalPrice += menuList[i].getMenuOrder() * menuList[i].getMenuPrice();
			
		}
		// 총 누적 결과 출력
		System.out.println("\n총 " + totalCount + "잔, " + "총 주문금액 " + totalPrice + "원");
		/*
		 * [0] 아메리카노 ?잔 [1] 카페라떼 ?잔 [2] 딸기스무디 ?잔 ....
		 * 총 ??잔, 총 주문금액 ????원
		 */
		
	}

	// 메뉴 주문 기능
	private void menuOrder(Menu menu) {
		System.out.println("선택한 메뉴는 " + menu.getMenuName() + " " + menu.getMenuPrice() + " 원입니다.");
		
		System.out.println("현재 주문수 : " + menu.getMenuOrder());
		
		System.out.print("주문할 수량입력>> ");
		int orderCnt = scan.nextInt();
		int menuOrder = menu.getMenuOrder();	// 현재까지의 주문수
		menu.setMenuOrder(menuOrder + orderCnt);
		System.out.println("주문 되었습니다.");
	}

	private int selectMenu() {
		System.out.print("선택>> ");
		int inputNumber = scan.nextInt();
		return inputNumber;
	}
}
