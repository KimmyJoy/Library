package kr.ac.kopo;

import kr.ac.kopo.service.BoardService;
//보드 서비스 객체가 하나만 만들어지길 원해서 생성하는 클래스
public class BoardServiceFactory {
	
	private static BoardService service = null;//boardService가 하나만 만들어지길 원하여 static으로 만듬 

	public static BoardService getInstance() {//이것은 스태틱으로 해도 되고 안해도 됨
		
		if(service == null) {
			service = new BoardService();
		}
		
		return service;
	}
	
}
