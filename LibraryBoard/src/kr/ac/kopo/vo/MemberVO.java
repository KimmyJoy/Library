package kr.ac.kopo.vo;
//밸류오브젝트만 모아놓은 클래스
//일반적으로는 vo하나가 테이블을 의미함
public class MemberVO {
//알슆s+c, o, r
	//유저정보를 위해 필요한 것 고유번호/id/pw/생년월일/전화번호/이메일주소
	private  int no;
	private  String id;
	private  String password;
	private  String name;
	private  String birth;
	private  String phonenum;
	private  String email;
	
	public MemberVO() {
		super();
	}
	
	public MemberVO(String id) {
		super();
		this.id = id;
	}	
	
	public MemberVO(int no, String id, String password, String name, String birth, String phonenum, String email) {
		super();
		this.no = no;
		this.id = id;
		this.password = password;
		this.name = name;
		this.birth = birth;
		this.phonenum = phonenum;
		this.email = email;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	
	public String getPhonenum() {
		return phonenum;
	}

	public void setPhonenum(String phonenum) {
		this.phonenum = phonenum;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	@Override
	public String toString() {
		return "MemberVO [no=" + no + ", id" + id + ", password=" + password + ", name=" + name + ", birth=" + birth + ", phonenum=" + phonenum + ", email=" + email + "]";
	}//스태틱으로 선언된 멤버변수를 소환하고 싶으면 '스태틱이들은클래스이름.변수'로 소환

	
}
