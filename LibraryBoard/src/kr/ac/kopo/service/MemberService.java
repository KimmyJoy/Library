package kr.ac.kopo.service;

import java.util.List;

import kr.ac.kopo.dao.MemberDAO;
import kr.ac.kopo.vo.MemberVO;
//이런 서비스는 DB를 사용하게 되면 필요가 없어짐
//boardService 객체는 늘 하나만 만들어져야하는데 ....
public class MemberService {

	private MemberDAO memberdao;
	
	public MemberService() {
		memberdao = new MemberDAO();
	}

	public void insertMember(MemberVO member) {//이걸로 대여하는 테이블을 추가해버린다면?
		memberdao.insertMember(member);//위 항목이 추가된 것을 boardDao에 넘겨주는 것
	}
//	
	public List<MemberVO> selectAllusersUI() {//매개변수가 없는 형태로 날아가야함 서비스는 searchallui에게서 받은걸 dao에 토스만 하면 됨 
		List<MemberVO> memberList = memberdao.selectAllusers();//리턴값은 리스트여야 할것이고 날아오는 파라미터의 값도 0일것...
		return memberList;
	}
	
	public MemberVO searchMemByid(String id) {
		MemberVO member = memberdao.searchMemByid(id);//해당번호에 대한 게시글을 얻어오려는 것
		return member;
	}
	
	public void deleteUser(String id) {
		memberdao.deleteUser(id);
	}
	
}
