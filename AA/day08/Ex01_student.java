package day08;

public class Ex01_student {
	private String no;
	private String name;
	private String dept;
	private int year;
	
	//생성자
	public Ex01_student() {
		
	}
	public Ex01_student(String no, String name, String dept, int year) {
		this.no=no;
		this.name=name;
		this.dept=dept;
		this.year=year;
		
	}
	//메서드
	public void setNo(String no) {
		this.no=no;
	}
	public String getNo() {
		return no;
	}
	public void setName(String name) {
		this.name=name;
	}
	public String getName() {
		return name;
	}
	public void setDept(String dept) {
		this.dept=dept;
	}
	public String getDept() {
		return dept;
	}
	public void setYear(int year) {
		this.year=year;
	}
	public int getYear() {
		return year;
	}
	public void print() {
		System.out.printf("%s\t%s\t%s\t%d\n", no,name,dept,year);
	}
		
	}


