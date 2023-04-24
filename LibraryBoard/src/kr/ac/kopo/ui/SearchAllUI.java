package kr.ac.kopo.ui;

import java.util.List;

import kr.ac.kopo.LibraryServiceFactory;
import kr.ac.kopo.service.BookService;
import kr.ac.kopo.vo.BookVO;
//회원, 도서 서치가 가능하도록 만들어야함....
//얘는 service한테 요청해야함 게시글 조회 정보 내놓으라고
public class SearchAllUI extends BaseUI {//서비스도 여러가지가 있을 수 있으므로 베이스유아이를 가져오는 것

	private BookService bookService;
	
	public SearchAllUI() {
		//bookService = new BookService(); 이러면 매번 조회때마다 새로운 boardservice, 새로운 dao를 생성하게 되므로 의미가 없어지게 됨
		bookService = LibraryServiceFactory.getInstance();
	}
	
	@Override
	public void execute() throws Exception {
     List<BookVO> bookList = bookService.selectAll();//전체 게시글을 알려달라는 애를 호출(요청) 전체니까 보내는 파라미터는 없음 보드의 형태는 vo인데 날아서 받는 형태는 리스트여야할 것
     	
     System.out.println("----------------------------------------------");
     System.out.println("바코드\tISBN\t제목\t글쓴이\t대출여부");
     System.out.println("----------------------------------------------");
     
     if(bookList == null || bookList.size() == 0) { //예외처리...리스트이므로 사이즈가 알고 있을 것
    	 System.out.println("목록이 존재하지 않습니다");
     } else {
    	 for(BookVO book : bookList) {//1.5버전의 포문사용 가능
    		 System.out.println(book.getNo() + "\t" + book.getWriter() + "\t" + book.getBirth() + "\t" + book.getTitle());
    	 }
     }
     System.out.println("----------------------------------------------");
     
	}
//	
//	public void execute() throws Exception {
//		List<MemberVO> memberList = bookService.selectAll();
//				
//		 System.out.println("----------------------------------------------");
//	     System.out.println("NO\t아이디\t비밀번호\t이름\t생년월일\t휴대번호\t이메일주소");
//	     System.out.println("----------------------------------------------");
//		
//	}
//	
//	
}
