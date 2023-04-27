package kr.ac.kopo;

import kr.ac.kopo.service.BookService;
//보드 서비스 객체가 하나만 만들어지길 원해서 생성하는 클래스
public class BookServiceFactory {
	
	private static BookService bservice = null;//boardService가 하나만 만들어지길 원하여 static으로 만듬 
	
	
	public static BookService getbokInstance() {//이것은 스태틱으로 해도 되고 안해도 됨
		
		if(bservice == null) {
			bservice = new BookService();
		}
		
		return bservice;
	}
	
}
