package kr.ac.kopo.vo;

//밸류오브젝트만 모아놓은 클래스
//일반적으로는 vo하나가 테이블을 의미함
public class RentVO {
//알슆s+c, o, r
	// 게시판을 위해 필요한 것: 대여일/반납일/연장일/연체일
	private int no;
	private String id;
	private String isbn;
	private String title;
	private String rentdate;
	private String returndate;
	private String renewdate;
//	private String overdewdate;
//	private String latefee;
	private int daeyeo;
	

	public RentVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RentVO(int no, String id, String isbn, String rentdate, String returndate, String title) {
		super();

		this.no = no;
		this.id = id;
		this.isbn = isbn;
		this.rentdate = rentdate;
		this.returndate = returndate;
		this.title = title;
//		this.renewdate = renewdate;
//		this.daeyeo = daeyeo;
	}

	public RentVO(int no, String isbn, int daeyeo, String id, String rentdate, String returndate, String title) {
		super();

		this.no = no;
		this.isbn = isbn;
		this.id = id;
		this.rentdate = rentdate;
		this.returndate = returndate;
//		this.renewdate = renewdate;
		this.daeyeo = daeyeo;
//		this.overdewdate = overdewdate;
//		this.latefee = latefee;
		

	}

	public RentVO(String id2, String isbn2, String rentdate2, String returndate2, String title2) {
		// TODO Auto-generated constructor stub
	}

	public int getNo() {
		return no;
	}
	
	public void setNo(int no) {
		this.no = no;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
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

	public String getRentdate() {
		return rentdate;
	}

	public void setRentdate(String rentdate) {
		this.rentdate = rentdate;
	}

	public String getReturndate() {
		return returndate;
	}

	public void setReturndate(String returndate) {
		this.returndate = returndate;
	}

//	public String getRenewdate() {
//		return renewdate;
//	}
//
//	public void setRenewdate(String renewdate) {
//		this.renewdate = renewdate;
//	}

//	public String getOverdewdate() {
//		return overdewdate;
//	}
//
//	public void setOverdewdate(String overdewdate) {
//		this.overdewdate = overdewdate;
//	}

//	public String getLatefee() {
//		return latefee;
//	}
//
//	public void setLatefee(String latefee) {
//		this.latefee = latefee;
//	}

	

}
