package kr.ac.kopo.ui;

import kr.ac.kopo.BookServiceFactory;
import kr.ac.kopo.service.BookService;
import kr.ac.kopo.vo.BookVO;

public class AddBookUI extends BaseUI {
//게시글이라는 것을 추상화 시켜서....객체화 시킬 수 있을 것 dto 혹은 vo로 쓴다...밸류오브젝트???
	//private BookDAO boardDao;
	private BookService bookService;
	
	public AddBookUI(){
	 bookService = BookServiceFactory.getbokInstance();//얘 필요함??
	}
	
	
	 @Override
	    public void execute() throws Exception {
	        String isbn;
	        while (true) {
	            isbn = scanStr("ISBN을 입력하세요 : ");
	            if (isValidISBN(isbn)) {
	                break;
	            } else {
	                System.out.println("유효하지 않은 ISBN입니다. 다시 입력해주세요.");
	            }
	        }

	        if(bookService.selectByIssbn(isbn)) {
	            System.out.println("입력하신 ISBN 번호가 존재합니다");
	            System.exit(0);
	        } else {
	            String title = scanStr("등록할 제목을 입력하세요 : ");
	            String writer = scanStr("저자를 입력하세요 : ");
	            int daeyeo = scanInt("도서 대출 여부를 입력하세요[반출상태: 0| 대여가능: 1] : ");

	            BookVO book = new BookVO();
	            book.setIsbn(isbn);
	            book.setTitle(title);
	            book.setWriter(writer);
	            book.setDaeyeo(daeyeo);

	            bookService.insertBook(book);

	            System.out.println("도서를 등록 완료하였습니다");
	        }
	    }

	    private boolean isValidISBN(String isbn) {
	        // ISBN의 유효성을 검사하는 코드를 작성
	        // 여기서 예를 들어 ISBN은 13자리 숫자이거나 10자리 숫자일 때 유효하다고 가정
	        return isbn.matches("\\d{10}|\\d{13}");
	    }
	}
	
	
//	@Override
//	public void execute() throws Exception {
//		//제목하고 작성자만 입력받는 것 그러니 아래 두개만 있으면 됨
//		String isbn = scanStr("ISBN을 입력하세요 :");
//		
//		
//		if(bookService.selectByIssbn(isbn)) {
//			System.out.println("입력하신 ISBN 번호가 존재합니다");
//			System.exit(0);
//		} else {
//		String title = scanStr("등록할 제목을 입력하세요 : ");
//		String writer = scanStr("저자를 입력하세요 : ");
//		int daeyeo = scanInt("도서 대출 여부를 입력하세요[반출상태: 0| 대여가능: 1] : ");
//		
//		
//		BookVO book = new BookVO();
//		book.setIsbn(isbn);
//		book.setTitle(title);
//		book.setWriter(writer);
//		book.setDaeyeo(daeyeo);
//		
//		bookService.insertBook(book);
//		//boardDao에 타이틀과 작성자를 넣는걸 해줘 입력되는 항목이나 타입이 달라지면 문제가 많이 발생할것 몇개가 바뀔지 아무도 모르지만 boardvo라는 게시글 리스트를 만드는게
//		//따라서 위처럼 타이틀과 롸이터 값을 넣어 감싸고 있는 boardvo타입 객체를 넘겨버리겠다는 것...
//		System.out.println("도서를 등록 완료하였습니다");
//		//제목과 글쓴이가 입력되면 등록완료했다는 걸 알려줌 왜냐면 UI클래스가 하는 일은 입출력일 뿐이므로 입력만 받고 등록되었다는 것만 알려주면 그만임
//		}
//	}
//
//
//}
