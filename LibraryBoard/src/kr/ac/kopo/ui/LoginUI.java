package kr.ac.kopo.ui;

import java.util.Scanner;

import kr.ac.kopo.LibraryServiceFactory;
import kr.ac.kopo.service.MemberService;
import kr.ac.kopo.util.GetInfoFactory;
import kr.ac.kopo.vo.MemberVO;

//id 로그인 성공시 t 아니면 f로 static 정보값이 계속 따라다니게 해야함 admin도 가능하려낭
public class LoginUI extends BaseUI {

	private MemberService memService;
	
	public LoginUI() {
		memService = LibraryServiceFactory.getmemInstance();
	}
	
	private int menu() {
		System.out.println("==================================== 로그인 페이지 ====================================");
		System.out.println("[1] 로그인\t[2] 회원 가입");//관리자는 미리 넣어놔야 할 것(admin/0000)?? 아니면 회원으로...?
		System.out.println("[0] 종료\t\t[9] 메인 메뉴");
		System.out.println("====================================================================================");
		System.out.println("원하는 항목을 선택하세요 : ");
		Scanner sc = new Scanner(System.in);
		int type = sc.nextInt();
		sc.nextLine();
		
		return type;
	}
	
	
	@Override
	public void execute() throws Exception {
		while(true){
			int type = menu();
			MemberVO mem = null;
			ILibraryUI ui = null;
			
		switch(type) {
		case 1: //입력된 아이디를 검색하여 가져온 값이 있는지 없는지 여부만 확인하면 되므로 if의 null인지, 아닌지 부분만 확인하면 됨
			boolean bool = true;
			while(bool) {
			String id = scanStr("아이디를 입력하세요 : ");
			mem = memService.searchMemByid(id);
			if(mem != null) {
				GetInfoFactory.setID(id);
				id = GetInfoFactory.getID();//스태틱은 클래스명으로 데려올 수 있어.......
				String password = scanStr("비밀번호를 입력하세요 : ");
				password = mem.getPassword();
				if(password != null) {
					System.out.println("로그인이 완료되었습니다");
					if(id.equals("admin")) {
					new AdminpageUI().execute();//여기선 어드민을 불러오고 나서 아이디 판별하는게 맞는듯?
					} else {
						ui = new MypageUI();
					}
					bool = false;
				}
			} else {
				System.out.println("일치하는 아이디가 없습니다");
			}
			}
			break;
		case 2:
			ui = new JoinmemberUI();
			break;
		case 9:
			ui = new LibraryUI();
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
//		else {
//			System.out.println("잘못 입력하셨습니다");
//		}
		
	}
	}
}
