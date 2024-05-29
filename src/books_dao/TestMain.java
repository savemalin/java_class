package books_dao;

import java.util.ArrayList;

import books_dto.Brent;

public class TestMain {

	public static void main(String[] args) {
		
		BrentDao rdao = new BrentDao();
		
		ArrayList<Brent> rentList = rdao.rentListByMid("TEST01", false);
		for(Brent brent : rentList) {
			System.out.println("mid : " + brent.getMember().getMid());
			System.out.println("mname : " + brent.getMember().getMid());
			System.out.println("bid : " + brent.getBook().getBid());
			System.out.println("btitle : " + brent.getBook().getBtitle());
			System.out.println("rentdate : " + brent.getRentdate());
			System.out.println("returndate : " + brent.getReturndate());
			
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
