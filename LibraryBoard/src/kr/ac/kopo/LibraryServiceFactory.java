package kr.ac.kopo;

import kr.ac.kopo.service.BookService;
import kr.ac.kopo.service.MemberService;
import kr.ac.kopo.service.RentService;
//보드 서비스 객체가 하나만 만들어지길 원해서 생성하는 클래스
public class LibraryServiceFactory {
	
	private static BookService bservice = null;//boardService가 하나만 만들어지길 원하여 static으로 만듬 
	private static MemberService mservice = null;
	private static RentService rservice = null;
	
	
	public static BookService getbokInstance() {//이것은 스태틱으로 해도 되고 안해도 됨
		
		if(bservice == null) {
			bservice = new BookService();
		}
		
		return bservice;
	}
	
	public static MemberService getmemInstance() {//이것은 스태틱으로 해도 되고 안해도 됨
		
		if(mservice == null) {
			mservice = new MemberService();
		}
		
		return mservice;
	}
	
public static RentService getrentInstance() {//이것은 스태틱으로 해도 되고 안해도 됨
		
		if(rservice == null) {
			rservice = new RentService();
		}
		
		return rservice;
	}
	
}
