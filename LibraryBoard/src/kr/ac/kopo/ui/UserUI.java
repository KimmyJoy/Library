package kr.ac.kopo.ui;
//in 메모리는 무조건 service와 dao 객체는 하나여야하므로 service factory라는 형태가 필요하게 되는 것임
import java.util.Scanner;

import kr.ac.kopo.util.GetInfoFactory;

public class UserUI extends BaseUI {//BaseUI클래스를 상속받고, ILibraryUI 인터페이스를 상속받음....근데 모든 ui가 익스큐트를 써야한다는 점을 생각하면 BaseUI가 IBoardUI인터페이스 상속받으면 BaseUI만 하면 그만 아닐까?

	private int menu() {
		System.out.println("================================== 회원 관리 프로그램 ==================================");
		System.out.println("[1] 전체 회원 조회\t[2] 회원 검색\t[3] 회원 삭제");
		System.out.println("[0] 종료\t[8] 로그아웃\t[9] 메인 메뉴");
		System.out.println("====================================================================================");
		System.out.println("원하는 항목을 선택하세요 : ");
		Scanner sc = new Scanner(System.in);
		int type = sc.nextInt();
		sc.nextLine();
		
		return type;
	}
	
	@Override	
	public void execute() throws Exception {//메뉴가 나오고 메뉴를 항목에서 선택하게 만들어줘야할 것 위를 프라이빗으로 두기 위해 메소드를 따로 뺀것
		while(true){
			int type = menu();//위의 메뉴를 실행하기 위해서 이걸 넣은 것 우리는 아래 선택이 반복되도록 해야하므로....이 코드들을 while문 안에 들어가도록 배치해야한다
			ILibraryUI ui = null;
			
			switch(type) {
			case 1:
				ui = new SearchAllusersUI();//모든 유저 조회 메소드
				break;
			case 2:
				ui = new SearchIdUI();
				break;
			case 3:
				ui = new DeleteUserUI();//실행하는 문구(명령어)는 무조건 execute일 것...일일히 쓰는게 좋을까? 안좋지....그래서 위에 IBoardUI넣고 묵시적형변환 해버림...
				break;//isof나 kindof 기능을...할필요가 없음??? 눈에 보이는 사물을 만들때 저런게 중요한거고 그래서 키보드입력을 받을 수 있는 상위입력장치를 만들려고 함...
			case 8:
				GetInfoFactory.refreshID();
				System.out.println("로그아웃 되어 관리자 페이지를 벗어납니다");
				Thread.sleep(2000);
				ui = new LibraryUI();
				break;
			case 9:
				System.out.println("메인 메뉴로 돌아갑니다");
				Thread.sleep(2000);
				ui = new LibraryUI();
				break;
			case 0:
				ui = new ExitUI();//종료하는 기능을 가진 메소드를 만드려고 함
				//스위치 코드가 너무 길어져버림.... 내용이 바뀔때마다 이걸 봐야함....그래서 종료 기능 클래스를 따로 빼주려고 함...나혼자 만들수고 있는데 보드에 다 치고 있기 힘드니깡...그래서 클래스 분리를 꾀하게 됨
				break;
			}
			
			if(ui != null) {
				ui.execute();
			} else {
				System.out.println("잘못입력하셨습니다");
			}
		}
	}
	
}
