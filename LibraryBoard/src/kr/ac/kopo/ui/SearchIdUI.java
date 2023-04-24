package kr.ac.kopo.ui;

import kr.ac.kopo.service.MemberService;
import kr.ac.kopo.vo.MemberVO;

public class SearchIdUI extends BaseUI {

	private MemberService service;//이제 db에서 가져오는 것이므로 static일 필요가 없음...
	
	public SearchIdUI() {
		service = new MemberService();
	}

	@Override
	public void execute() throws Exception {
		//단위가 파일일수도 db일수도 있음...저장된 위치에서 저장수정삭제하기 위해 만들어진 클래스: dao클래스라고 이야기한다 crud를 하게하려고 하는 것...
		String id = scanStr("조회할 아이디를 입력하세요 : ");
		MemberVO mem = service.searchMemByid(id);//3번 게시글에 대한 no를 알려줘라고 하는거니까 리턴값이 있어야함 리턴값은 boardvo임...(감싼거) 번호는 프라이머리키임..
		
		System.out.println("------------------------------------------------------------------------------------");
		if (mem != null) {//없으면 null값이 날아올 것이므로.....null이 아닐때에만 기록하라고 함
		System.out.println("NO\t아이디\t이름\t생년월일\t\t휴대번호\t\t이메일주소");
		System.out.println(mem.getNo()+"\t"+mem.getId()+"\t"+mem.getName()+"\t"+mem.getBirth()+"\t"+mem.getPhonenum()+"\t"+mem.getEmail());
		} else {
			System.out.println("[" + id + "] 회원은 존재하지 않습니다");
		}
		System.out.println("------------------------------------------------------------------------------------");
	}

}
