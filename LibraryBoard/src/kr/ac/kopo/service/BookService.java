package kr.ac.kopo.service;

import java.util.List;

import kr.ac.kopo.dao.BookDAO;
import kr.ac.kopo.vo.BookVO;
//이런 서비스는 DB를 사용하게 되면 필요가 없어짐
//boardService 객체는 늘 하나만 만들어져야하는데 ....
public class BookService {

	private BookDAO bookdao;
	
	public BookService() {
		bookdao = new BookDAO();
	}

	public void insertBook(BookVO book) {
	
		bookdao.insertBook(book);//위 항목이 추가된 것을 boardDao에 넘겨주는 것
	}
	
	public List<BookVO> selectAll() {//매개변수가 없는 형태로 날아가야함 서비스는 searchallui에게서 받은걸 dao에 토스만 하면 됨 
		List<BookVO> bookList = bookdao.selectAllbook();//리턴값은 리스트여야 할것이고 날아오는 파라미터의 값도 0일것...
		return bookList;
	}
	
	
	public BookVO selectByIsbn(String isbn) {
		BookVO book = bookdao.selectByIsbn(isbn);//해당번호에 대한 게시글을 얻어오려는 것
		return book;
	}
	
	public BookVO selectByTitle(String title) {
		BookVO book = bookdao.selectByTitle(title);//해당번호에 대한 게시글을 얻어오려는 것
		return book;
	}

	public BookVO selectByWriter(String writer) {
		BookVO book = bookdao.selectByWriter(writer);//해당번호에 대한 게시글을 얻어오려는 
		return book;
	}
	
	public boolean selectByIssbn(String isb) {
		return bookdao.selectByIssbn(isb);
	}
	

	public void deleteBook(String isbn) {
		bookdao.deleteBook(isbn);
	}
	
}
