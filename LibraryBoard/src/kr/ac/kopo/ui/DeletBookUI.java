package kr.ac.kopo.ui;

import kr.ac.kopo.LibraryServiceFactory;
import kr.ac.kopo.service.BookService;
import kr.ac.kopo.vo.BookVO;

public class DeletBookUI extends BaseUI {

	private BookService bookService;
	
	public DeletBookUI() {
		bookService = LibraryServiceFactory.getbokInstance();
	}

	@Override
	public void execute() throws Exception {
		
		BookVO book = null;
		
		String isbn = scanStr("삭제할 도서의 ISBN 코드를 정확하게 입력해주세요 : ");
		book = bookService.selectByIsbn(isbn);
		
		System.out.println("------------------------------------------------------------------------------------");
		System.out.println("ISBN\t\t저 자\t제 목");
		System.out.println("------------------------------------------------------------------------------------");
		
		if (book != null) {// 없으면 null값이 날아올 것이므로.....null이 아닐때에만 기록하라고 함
			System.out.println(book.getIsbn()+"\t" + book.getWriter()+"\t"+ book.getTitle());
			System.out.println("------------------------------------------------------------------------------------");
			System.out.println("위 도서를 삭제하시겠습니까?");
			int choice = scanInt("삭제를 원하시면 [1] 아니면 [2]을 입력해주세요 : ");//string으로 받으면 if문 적기가 귀찮으니까 int로 형변환 해버릴 생각..
			System.out.println("");
			if(choice == 1) {
				System.out.println(book.getTitle()+"(이)가 삭제되었습니다");
				bookService.deleteBook(isbn);
			} else {
				System.out.println("이전 메뉴를 재호출합니다");
				try {//몇초간 지연하고 싶음..
		            Thread.sleep(2000);
		        } catch (InterruptedException e) {
		            e.printStackTrace();
		        }
				new BookUI().execute();
			}
		} else {
			System.out.println("해당하는 도서가 없습니다");
			new DeletBookUI().execute();
		}
		System.out.println("------------------------------------------------------------------------------------");
		}
	
	
	}

