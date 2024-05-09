package day14;

public class Book {
	private String title; // 제목
	private int price; // 가격
	private String author; // 저자
	private String publisher;// 출판자
	
	private Member member; //도서를 대여해간 회원

	public Book(String title, int price, String author, String publisher, Member member) {
		super();
		this.title = title;
		this.price = price;
		this.author = author;
		this.publisher = publisher;
		this.member = null;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	@Override
	public String toString() {
		return "도서정보 [제목:" + title + ", 가격:" + price + ", 저자:" + author + ", 출판사:" + publisher + "]";
	}
	
	
	
	
	
	
}
