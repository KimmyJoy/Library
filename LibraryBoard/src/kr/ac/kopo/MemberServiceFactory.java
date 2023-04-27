package kr.ac.kopo;

import kr.ac.kopo.service.MemberService;
//보드 서비스 객체가 하나만 만들어지길 원해서 생성하는 클래스
public class MemberServiceFactory {
	
	private static MemberService mservice = null;
	
	
	public static MemberService getmemInstance() {//이것은 스태틱으로 해도 되고 안해도 됨
		
		if(mservice == null) {
			mservice = new MemberService();
		}
		
		return mservice;
	}
	
}
