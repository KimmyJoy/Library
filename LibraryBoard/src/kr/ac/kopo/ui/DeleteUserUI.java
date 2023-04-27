package kr.ac.kopo.ui;

import kr.ac.kopo.MemberServiceFactory;
import kr.ac.kopo.RentServiceFactory;
import kr.ac.kopo.service.MemberService;
import kr.ac.kopo.service.RentService;
import kr.ac.kopo.util.GetInfoFactory;

public class DeleteUserUI extends BaseUI {

	private MemberService memService;
	private RentService renService;
	
	public DeleteUserUI() {
		memService = MemberServiceFactory.getmemInstance();
		renService = RentServiceFactory.getrentInstance();
	}

	@Override
	public void execute() throws Exception {
		
		if(GetInfoFactory.getID().equals("admin")) {
			String tempid = scanStr("삭제 처리할 회원의 ID를 입력해주세요 :");
			memService.deleteUser(tempid);
			System.out.println("회원 삭제처리가 완료되어 메인 메뉴로 복귀합니다");
			new LibraryUI().execute();
		} else {
			if(renService.selectAll().size() == 0) {
				memService.deleteUser(GetInfoFactory.getID());
				System.out.println("");
				System.out.println("탈퇴가 완료되었습니다");
				GetInfoFactory.refreshID();
				new LibraryUI().execute();
			} else {
				System.out.println("대여중인 도서가 있어 불가능합니다");
				System.out.println("");
				System.out.println("마이페이지로 이동합니다....");
				System.out.println("");
				Thread.sleep(2000);
				new MypageUI().execute();
			}
		}
		
	}

}
