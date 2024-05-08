package day13;

public class Book {
	private String title; // 제목
	private int price; // 가격
	private String author; // 저자
	private String publisher;// 출판자

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

	@Override
	public String toString() {
		return "도서정보 [제목:" + title + ", 가격:" + price + ", 저자:" + author + ", 출판사:" + publisher + "]";
	}

	public Book(String title, int price, String author, String publisher) {
		super();
		this.title = title;
		this.price = price;
		this.author = author;
		this.publisher = publisher;
	}

}
