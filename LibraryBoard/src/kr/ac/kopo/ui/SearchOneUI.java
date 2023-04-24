package kr.ac.kopo.ui;

import kr.ac.kopo.service.BoardService;
import kr.ac.kopo.vo.BookVO;

public class SearchOneUI extends BaseUI {

	private BoardService service;//이제 db에서 가져오는 것이므로 static일 필요가 없음...
	
	public SearchOneUI() {
		service = new BoardService();
	}

	@Override
	public void execute() throws Exception {
		//단위가 파일일수도 db일수도 있음...저장된 위치에서 저장수정삭제하기 위해 만들어진 클래스: dao클래스라고 이야기한다 crud를 하게하려고 하는 것...
		int no = scanInt("조회할 글번호를 입력하세요 : ");
		BookVO board = service.selectByNo(no);//3번 게시글에 대한 no를 알려줘라고 하는거니까 리턴값이 있어야함 리턴값은 boardvo임...(감싼거) 번호는 프라이머리키임..
		
		System.out.println("-------------------------------------------");
		if (board != null) {//없으면 null값이 날아올 것이므로.....null이 아닐때에만 기록하라고 함
		System.out.println(" 번	  호 : " + board.getNo());
		System.out.println(" 제	  목 : " + board.getTitle());
		System.out.println(" 작 성 자 : " + board.getWriter());
		System.out.println(" 등 록 일 : " + board.getBirth());
		} else {
			System.out.println("[" + no + "]번 게시글은 존재하지 않습니다");
		}
		System.out.println("-------------------------------------------");
	}

}
