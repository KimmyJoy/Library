package kr.ac.kopo;

import kr.ac.kopo.service.RentService;
//보드 서비스 객체가 하나만 만들어지길 원해서 생성하는 클래스
public class RentServiceFactory {
	
	private static RentService rservice = null;//boardService가 하나만 만들어지길 원하여 static으로 만듬 
	
	
	public static RentService getrentInstance() {//이것은 스태틱으로 해도 되고 안해도 됨
		
		if(rservice == null) {
			rservice = new RentService();
		}
		
		return rservice;
	}
	
}
