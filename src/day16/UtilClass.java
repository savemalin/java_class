package day16;

public class UtilClass {
	
	int number;
	
	static UtilClass uc;
	//생성자
	private UtilClass() {
		
	}
	public static UtilClass getInstance() {
		if(uc==null) {
			uc=new UtilClass();
		}
		return uc;
	}
	
	
}
