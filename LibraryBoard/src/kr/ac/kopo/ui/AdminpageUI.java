package kr.ac.kopo.ui;

public class AdminpageUI extends BaseUI {

	public AdminpageUI() {
		
	}

	@Override
	public void execute() throws Exception {
		
		System.out.println("==================================== 관리자 페이지 ====================================");
		System.out.println("[1] 도서 관리 페이지\t[2] 회원 관리 페이지");
		System.out.println("[0] 종료");
		System.out.println("====================================================================================");
		int type = scanInt("원하는 메뉴를 입력해주세요 : ");
		ILibraryUI ui = null;
		
		switch(type) {
		case 1: 
			ui = new BookUI();
			break;
		case 2:
			ui = new UserUI();
			break;
		case 0:
			ui = new ExitUI();
			break;
		default :
			System.out.println("잘못입력하셨습니다");
			break;
		}
		if(ui != null) {
			ui.execute();
		} else {
			System.out.println("잘못입력하셨습니다");
		}
	}

}
