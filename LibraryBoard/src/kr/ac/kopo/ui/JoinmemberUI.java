package kr.ac.kopo.ui;

import kr.ac.kopo.LibraryServiceFactory;
import kr.ac.kopo.service.MemberService;
import kr.ac.kopo.vo.MemberVO;

public class JoinmemberUI extends BaseUI {

	private MemberService memService;
	
	public JoinmemberUI() {
		memService = LibraryServiceFactory.getmemInstance();
	}

	@Override
	public void execute() throws Exception {
		MemberVO mem = null;
		
		System.out.println("==================================== 회원가입 페이지 ===================================");
		String id = scanStr("아이디를 입력해주세요 : ");//중복아이디 체크 및 admin 체크. 정확히 admin만 안됨(소문자)
		mem = memService.searchMemByid(id);
		if(mem == null) {
			String password = scanStr("비밀번호를 입력해주세요 : ");
			String name = scanStr("이름을 입력해주세요 : ");
			String birth = scanStr("생년월일 8자리[예)19991111]를 입력해주세요 : ");
			String phonenum = scanStr("'-'를 제외한 휴대전화번호 11자리를 입력해주세요 : ");
			String email = scanStr("이메일 주소를 입력해주세요 : ");
			
			MemberVO member = new MemberVO();
			member.setId(id);
			member.setPassword(password);
			member.setName(name);
			member.setBirth(birth);
			member.setPhonenum(phonenum);
			member.setEmail(email);
			
			memService.insertMember(member);
			System.out.println("");
			System.out.println("회원 등록이 완료되었습니다");
			System.out.println("");
		 } else {
			 System.out.println("중복된 아이디가 존재합니다 다시 입력해주세요");
			 this.execute();
		 }
		
				
	}

}
