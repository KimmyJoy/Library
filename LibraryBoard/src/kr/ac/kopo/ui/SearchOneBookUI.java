package kr.ac.kopo.ui;

import java.util.Scanner;

import kr.ac.kopo.LibraryServiceFactory;
import kr.ac.kopo.service.BookService;
import kr.ac.kopo.util.GetInfoFactory;
import kr.ac.kopo.vo.BookVO;

public class SearchOneBookUI extends BaseUI {

	private BookService bookService;// 이제 db에서 가져오는 것이므로 static일 필요가 없음...

	public SearchOneBookUI() {
		bookService = LibraryServiceFactory.getbokInstance();
	}

	private int menu() {
		System.out.println("다음 중 검색할 내용을 선택하세요");
		System.out.println("------------------------------------------------------------------------------------");
		System.out.println("[1] ISBN\t[2] 도서 제목\t[3] 저자");
		System.out.println("[0] 종료\t\t\t[9] 메인 메뉴");
		System.out.println("------------------------------------------------------------------------------------");
		System.out.println("원하는 항목을 선택하세요 : ");
		Scanner sc = new Scanner(System.in);
		int type = sc.nextInt();
		sc.nextLine();

		return type;
	}

	@Override
	public void execute() throws Exception {

		ILibraryUI ui = null;
		while (true) {
			int type = menu();
			BookVO book = null;
			switch (type) {
			case 1:
				String isbn = scanStr("ISBN을 입력하세요 : ");
				book = bookService.selectByIsbn(isbn);
				break;
			case 2:
				String title = scanStr("도서 제목을 입력하세요 : ");
				book = bookService.selectByTitle(title);
				break;
			case 3:
				String writer = scanStr("저자를 입력하세요 : ");
				book = bookService.selectByWriter(writer);
				break;
			case 0:
				new ExitUI().execute();
				break;
			case 9:
				new LibraryUI().execute();
				break;
			default:
				System.out.println("");
				System.out.println("잘못입력하셨습니다");
				break;
			}

			System.out.println("------------------------------------------------------------------------------------");
			System.out.println("ISBN\t\t대여여부\t저 자\t제 목");
			System.out.println("------------------------------------------------------------------------------------");
			if (book != null) {// 없으면 null값이 날아올 것이므로.....null이 아닐때에만 기록하라고 함
				if (book.getDaeyeo() == 0) {
					System.out.println(book.getIsbn() + "\t대여불가\t" + book.getWriter() + "\t" + book.getTitle());
				} else {
					System.out.println(book.getIsbn() + "\t대여가능\t" + book.getWriter() + "\t" + book.getTitle());
				}
				if (GetInfoFactory.getID() != null) {
					ui = new RentalUI();
				} else {
					System.out.println("도서를 대여하시겠습니까?");
					int num = scanInt("진행을 원하신다면 [0]을 입력해주세요 : ");
					System.out.println("");
					if(num == 0) {
					System.out.println("비회원은 대여 불가합니다");
					System.out.println("");
					System.out.println("대여를 위해 로그인 페이지로 이동합니다......");
					System.out.println("");
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					ui = new LoginUI();
					} else {
						System.out.println("메인 메뉴로 돌아갑니다");
						System.out.println("");
					break;
					}
				}
			} else {
				System.out.println("해당 도서는 존재하지 않습니다");
				System.out.println("");
			}
			if (ui != null) {
				ui.execute();
			} else {
				System.out.println("잘못입력하셨습니다");
				System.out.println("");
			}
		}
	}

}
