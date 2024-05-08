package day13;

import java.util.ArrayList;

import day12.Member;

public class ArrayList02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Member> memberList = new ArrayList<>();
		
		//1. 회원 정보 추가
//		Member mem01=new Member("아이디01", "비밀번호01", "이름01", "이메일01");
		memberList.add(new Member("아이디01", "비밀번호01", "이름01", "이메일01"));
		memberList.add(new Member("아이디02", "비밀번호02", "이름02", "이메일02"));
		memberList.add(new Member("아이디03", "비밀번호03", "이름03", "이메일03"));
		
		//0번 인덱스 저장된 회원의 이름을 출력
		System.out.println(memberList.get(0).getName());//
		
		//아이디가 "아이디02"인 회원의 이름을 출력
		int num=-1;
		for(int i = 0; i<memberList.size();i++) {
			if(memberList.get(i).getId() == "아이디02") {
				num = i;
				break;
			}
		}
		System.out.println(memberList.get(num).getName());
		//1. 아이디가 "아이디02"인 회원 정보가 memberList에서 조회
//		String serchId="아이디02";
//		int index=-1;
//		for(int i =0;i<memberList.size();i++) {
//			if(serchId.equals(memberList.get(i).getId())) {
//				index=i;
//				break;
//			}
//		}
		//아이디가 "아이디20"인 회원 정보를 memberList에서 삭제
		memberList.add(new Member("아이디20", "비밀번호20","이름20","이메일20"));
		
		int rem = -1;
		String remId = "아이디20";
		for(int i= 0;i<memberList.size();i++) {
			if(remId.equals(memberList.get(i).getId())) {
				rem=i;
				break;
			}			
		}
		System.out.println("아이디20인 회원 삭제 전 목록");
		for(int i=0;i<memberList.size();i++) {
			System.out.println(memberList.get(i));
		}
		System.out.println("아이디20인 회원 삭제 후 목록");
		memberList.remove(rem);
		for(int i=0;i<memberList.size();i++) {
			System.out.println(memberList.get(i));
		
		
		
		
		
		
		
	}

}
}
