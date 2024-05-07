package day11_;

public class Menu {
	// 메뉴 정보
	private String menuType;//종류
	private String menuName;//이름
	private int menuPrice;	// 가격
	private int menuOrder;	// 주문수
	
	public String getMenuType() {
		return menuType;
	}
	public void setMenuType(String menuType) {
		this.menuType = menuType;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public int getMenuPrice() {
		return menuPrice;
	}
	public void setMenuPrice(int menuPrice) {
		this.menuPrice = menuPrice;
	}
	public int getMenuOrder() {
		return menuOrder;
	}
	public void setMenuOrder(int menuOrder) {
		this.menuOrder = menuOrder;
	}
	
	// 생성자
	public Menu(String menuType, String menuName, int menuPrice, int menuOrder) {
		super();
		this.menuType = menuType;
		this.menuName = menuName;
		this.menuPrice = menuPrice;
		this.menuOrder = menuOrder;
	}
	
	
	
}
