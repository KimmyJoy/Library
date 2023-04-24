package kr.ac.kopo.ui;

import java.util.Scanner;

//키보드입력을 받을
public abstract class BaseUI implements ILibraryUI {//abstract인 인터페이스를 가져오고 싶은데 대신 얘는 굳이 오버라이드를 할필요 없음...그러니 클래스를 abstract로 하면 됨....
//얘한테 상속 받을 애들만 사용할수 있도록 하기 위해서 protected를 하고 싶음
	private Scanner sc;
	//protected BookDAO boardDao; 만약 베이스ui에 합치고 싶다면 실제호출은 add나 다른 애들이 할거니까 protected로 해줘야함
	
	public BaseUI() {
		sc = new Scanner(System.in);//인스턴스 생성객체를 만들어주면 됨
	//	boardDao = new BookDAO(); 위에 만든다고 했을때 객체도 여기 만들어줘야함
	}
	
	protected int scanInt(String msg) {//정수입력 받는 메소드
		System.out.print(msg);
//		int num = sc.nextInt();
//		sc.nextInt();//매번버퍼쓰기 귀찮아서 쓰는 방법이 있음 아래와 같음
		int num = Integer.parseInt(sc.nextLine());
		return num;
	}
	
	protected String scanStr(String msg) {//문자열 입력받는 메소드
		System.out.print(msg);
		return sc.nextLine();
	}
	
}
