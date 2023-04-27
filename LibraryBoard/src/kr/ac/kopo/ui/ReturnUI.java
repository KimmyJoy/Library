package kr.ac.kopo.ui;

import kr.ac.kopo.BookServiceFactory;
import kr.ac.kopo.RentServiceFactory;
import kr.ac.kopo.service.BookService;
import kr.ac.kopo.service.RentService;
import kr.ac.kopo.util.GetInfoFactory;
import kr.ac.kopo.vo.RentVO;

public class ReturnUI extends BaseUI {
	private BookService bookService;
	private RentService rentService;


	public ReturnUI() {
		bookService = BookServiceFactory.getbokInstance();
		rentService = RentServiceFactory.getrentInstance();
	}

	@Override
	public void execute() throws Exception {

		RentVO rent = null;
		//현재 이미 로그인 된 상태(팩토리에 아이디 값이 저장되어있음)
		String isbn = scanStr("반납할 도서의 ISBN을 입력해주세요: ");
		if(bookService.selectByIssbn(isbn)) {
		
			rent = new RentVO();
			rent.setId(GetInfoFactory.getID());
			rent.setIsbn(isbn);
			rentService.returnBook(rent);
			System.out.println("반납이 완료되었습니다");
			new MypageUI().execute();
		} else {
			System.out.println("잘못입력하였습니다. 다시 입력해주세요");
			this.execute();
		}
	}

}
