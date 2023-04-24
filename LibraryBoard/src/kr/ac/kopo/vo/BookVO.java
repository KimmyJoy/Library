package kr.ac.kopo.vo;
//밸류오브젝트만 모아놓은 클래스
//일반적으로는 vo하나가 테이블을 의미함
public class BookVO {
//알슆s+c, o, r
	//게시판을 위해 필요한 것: 제목/이름/날짜가 필요한것 각각의 게시글은 고유한 게시물번호가 있음 이를 기억하고자 멤버변수를 만듬
//	private int barcode;
	private String isbn;
	private String title;
	private String writer;
	private int daeyeo;
	
	public BookVO() {
		super();
	}
	
	
	
	public BookVO(String isbn, String title, String writer, int daeyeo) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.writer = writer;
		this.daeyeo = daeyeo;
	}

//	public int getBarcode() {
//		return barcode;
//	}
//
//	public void setBarcode(int barcode) {
//		this.barcode = barcode;
//	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public int getDaeyeo() {
		return daeyeo;
	}

	public void setDaeyeo(int daeyeo) {
		this.daeyeo = daeyeo;
	}
	

	@Override
	public String toString() {
		return "BookVO [isbn=" + isbn + ", title=" + title + ", writer=" + writer + ", daeyeo=" + daeyeo + "]";
	}

	
	
}
