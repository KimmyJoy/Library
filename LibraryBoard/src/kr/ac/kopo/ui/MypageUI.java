package kr.ac.kopo.ui;

import java.util.List;

import kr.ac.kopo.RentServiceFactory;
import kr.ac.kopo.service.RentService;
import kr.ac.kopo.util.GetInfoFactory;
import kr.ac.kopo.vo.RentVO;

//반납은 추후 개발 예정~ 정보수정도 추후 개발 예정~
public class MypageUI extends BaseUI {

	private RentService rentService;
	
	public MypageUI() {
		rentService = RentServiceFactory.getrentInstance();
	}

	@Override
	public void execute() throws Exception {
		List<RentVO> rentList = rentService.selectId(GetInfoFactory.getID());
		
		System.out.println("===================================== 마이 페이지 =====================================");
//		System.out.println("현재 대여 중인 책 n권"/*본인 아이디에 따른 정보 출력되게 함(아이디 비번 책제목 isbn 대여일*/);
		if(rentList == null || rentList.size() == 0) {
			System.out.println("현재 대여중인 도서가 없습니다");
		} else {
			System.out.println("ID\tISBN\t\t제 목\t\t  대여일\t\t반납기한");
			for(RentVO rent : rentList) {
				System.out.println(rent.getId()+"\t"+rent.getIsbn()+"\t"+rent.getTitle()+"\t"+rent.getRentdate()+"\t"+rent.getReturndate());
			}
		}
		System.out.println("------------------------------------------------------------------------------------");
		System.out.println("[1] 도서 대여\t[2] 도서 반납\t");
		System.out.println("[0] 종료\t[8]회원 탈퇴\t");
		System.out.println("====================================================================================");
		int type = scanInt("원하는 메뉴를 입력해주세요 : ");
		ILibraryUI ui = null;
		
		switch(type) {
		case 1: 
			ui = new SearchOneBookUI();
			//본인 자료 전부 나오게 함
			break;
		case 2:
			ui = new ReturnUI();
			break;
//		case 3:
//			ui = new Changeuserinfo();
//			break;
		case 8:
			ui = new DeleteUserUI();
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
		}
	}

}
