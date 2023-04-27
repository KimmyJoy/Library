package kr.ac.kopo.ui;

import kr.ac.kopo.MemberServiceFactory;
import kr.ac.kopo.service.MemberService;

public class ChangeInfo extends BaseUI {

	private MemberService memService;
	protected int cnt;
	
	public ChangeInfo() {
		// TODO Auto-generated constructor stub
	}

	@Override//내용을 바꿔주는 기능을 만들고 싶음
	public void execute() throws Exception {
		
		memService = MemberServiceFactory.getmemInstance();
		// 부분수정- 선택시 부분수정으로 넘어감, 전체수정을 넣음
		//그리고 protected로 변수값을 가지고 있으면?? 상속받은 애들끼리만 할수있도록 키워드를 넣고 빼고만 조정해서 리턴 어케 안되나??
		System.out.println("회원 정보 수정 페이지");
		//일단 기존 정보 보여주고
		System.out.println("[1] 일괄 수정\t\t[2] 부분 수정");
		int type = scanInt("원하는 메뉴를 선택해주세요 : ");
		
		if(type == 1) {
			System.out.println("일괄 수정을 선택하셨습니다");
			
			
			//
			//memService.insertMember(MemberVO member);
			
		}

	}

}
