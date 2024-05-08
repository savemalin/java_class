package day13;

import java.util.ArrayList;
import java.util.Scanner;

public class BookService {
	/*
	 * 도서 관리 프로그램 1.도서정보등록 : add() - ArrayList<Book> bookList - 제목 가격 저자 출판사에 해당하는
	 * 값을 입력 받고 도서목록(bookList)에 도서 정부를 추가 2.도서목록조회 : get() - 도서목록(bookList)에 저장된 모든
	 * 도서의 정보를 출력 제목, 가격, 저자, 출판사 도서 정보를 출력 3.도서정보수정 : get() - 정보를 수정할 도서정보를 조회
	 * (도서이름으로 도서목록(bookdList)에서 조회) - 수정할 도서 정보가 조회되면 새 제목을 입력 받아서 수정 - 도서 정보가 조회되지
	 * 않으면 "도서목록에 해당 도서가 업습니다. 4.도서정보삭제 : get(), remove() - 정보를 삭제할 도서정보를 조회 (도서이름으로
	 * 도서목록(bookList)에서 조회) - 삭제할 도서 정보가 조회되면 해당 도서 정보를 목록에서 갖게 - 도서 정보가 조회되지 않으면
	 * "도서목록에 해당 도서가 업습니다." 출력
	 */
	// 도서 목록
	private ArrayList<Book> bookList;
	private Scanner sc;
	int a = -1;

	public BookService() {
		this.bookList = new ArrayList<>();
		this.sc = new Scanner(System.in);
	}

	// 실행 메소드
	public void run() {
		while (true) {
			a = -1;
			bookMenu(); // 도서 관련 메뉴 출력

			String selMenu = sc.next();// 출력된 메뉴 선택

			switch (selMenu) {
			case "1":// 도서 등록 기능 호출
				bookInsert();
				break;

			case "2":// 도서 목록 조회 기능 호출
				bookInfo();
				break;

			case "3":// 도서 정보 수정 기능
				bookModify();
				break;

			case "4":// 도서 정보 삭제 기능
				bookDelete();
				break;

			}
		}

	}

	private void bookMenu() {
		System.out.println("\n1.도서등룍 2.도서목록 3.도서수정 4.도서삭제");
		System.out.print("메뉴선택 : ");
	}

	private void bookInsert() {
		System.out.print("등록할 도서의 제목을 입력 : ");
		String insTitle = sc.next();
		System.out.print("등록할 도서의 가격을 입력 : ");
		int insPrice = sc.nextInt();
		System.out.print("등록할 도서의 저자를 입력 : ");
		String insAthor = sc.next();
		System.out.print("등록할 도서의 출판사를 입력 : ");
		String insPublisher = sc.next();

		bookList.add(new Book(insTitle, insPrice, insAthor, insPublisher));

	}

	private void bookInfo() {
		for (int i = 0; i < bookList.size(); i++) {
			System.out.println(bookList.get(i));
		}
	}

	private void bookModify() {
		System.out.print("수정할 책의 제목 : ");
		String modifyTitle = sc.next();
		for (int i = 0; i < bookList.size(); i++) {
			if (modifyTitle.equals(bookList.get(i).getTitle())) {
				System.out.println("수정될 책의 제목 : ");
				bookList.get(i).setTitle(sc.next());
				a = 0;
				break;

			}
		}
		if (a == -1) {
			System.out.println("도서목록에 없는 도서");
		}
	}

	private void bookDelete() {
		System.out.print("목록에서 삭제할 책의 제목 : ");
		String deleteBook = sc.next();
		for (int i = 0; i < bookList.size(); i++) {
			if (deleteBook.equals(bookList.get(i).getTitle())) {
				bookList.remove(i);
				a = 0;
				break;
			} else if (i == bookList.size()) {
				System.out.println("도서목록에 없는 도서");
			}
		}
		if (a == -1) {
			System.out.println("도서목록에 없는 도서");
		}
	}

}
