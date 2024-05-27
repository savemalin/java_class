package day16;

public class TryCatchService {

	private Member[] memberList; // 회원목록배열

	public TryCatchService() {
		this.memberList = new Member[5];
	}

	// 회원가입 기능
	public int registMember(Member joinMember) {
		int joinIndex = -1;// 비어있는 인덱스
		for (int i = 0; i < memberList.length; i++) {
			if (memberList[i] == null) {
				joinIndex = i;
				break;
			}
		}
		memberList[joinIndex] = joinMember;
		return joinIndex;

	}

	public Member getMemberInfo(String inputId) {
		Member member = null;
		for (int i = 0; i < memberList.length; i++) {
			try {
				if (inputId.equals(memberList[i].getId())) {
					member = memberList[i];

				}
			} catch (NullPointerException e) {
				continue;
			}
			System.out.println("회원정보를 찾았습니다");
		}

		return null;
	}

	public int registMember(String inputIndex, Member memberInfo) {
		int index = -1;
		try {
		// inputIndex를 int 타입으로 변환
		index = Integer.parseInt(inputIndex);// NumberFormatException 오류
		// memberInfo를 memberList[inputIndex]에 저장
		memberList[index] = memberInfo;// ArrayIndexoutofBoundsException 오류
		}catch(NumberFormatException e) {
			System.out.println("숫자를 입력해주세요");
			
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("인덱스 범위에 맞는 숫자를 입력해주세요");
		}
		
		return index;
	}
	public void registMember2(String inputIndex, Member memberInfo)throws Exception {
		memberList[Integer.parseInt(inputIndex)]=memberInfo;
		int a =Integer.parseInt(inputIndex);
//		return 0;
			
	}
	
	
	

}
