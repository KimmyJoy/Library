package kr.ac.kopo.ui;

public class ExitUI extends BaseUI {//키보드쓸일은 없을 수 있지만 모든 UI는 일단 BaseUI를 상속받게 해두는게 좋다

	@Override
	public void execute() throws Exception {
		System.out.println("------------------------------------------------------------------------------------");
		System.out.println("\t\t\t프로그램을 종료합니다");
		System.out.println("------------------------------------------------------------------------------------");
		System.exit(0);
	}

}
