package kr.ac.kopo;

import kr.ac.kopo.ui.LibraryUI;

public class LibraryMain {

	//뭔가를 출력해 보여주는 클래스들은 View 또는 Vw 또는 UI 이렇게 만들어도 됨 입출력하는 클래스는 UI로 만드실 예정
	
	public static void main(String[] args) {

		try {
		new LibraryUI().execute();//보드유아이의 익스큐트메소드를 호출하기만 하면 될 것
		} catch (Exception e) {
			e.printStackTrace();
			//메인에서 모든 예외처리 관리를 위해 다른 곳에서는 전부 throws로 간접처리를 보내고 메인에서 일괄처리하도록 여기에만 추가함
		}
	}

}
