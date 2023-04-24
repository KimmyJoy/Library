package kr.ac.kopo.service;

import java.util.List;

import kr.ac.kopo.dao.RentDAO;
import kr.ac.kopo.vo.RentVO;

public class RentService {

	private RentDAO rentdao;
	
	public RentService() {
		rentdao = new RentDAO();
	}

	public void insertRent(RentVO rent) {
		rentdao.insertRent(rent);//위 항목이 추가된 것을 boardDao에 넘겨주는 것
	}
	
	public List<RentVO> selectAll() {//매개변수가 없는 형태로 날아가야함 서비스는 searchallui에게서 받은걸 dao에 토스만 하면 됨 
		List<RentVO> rentList = rentdao.selectAll();//리턴값은 리스트여야 할것이고 날아오는 파라미터의 값도 0일것...
		return rentList;
	}
	
	public void returnBook(RentVO rent) {
		rentdao.returnBook(rent);
	}
	
	public List<RentVO> selectId(String id) {
		List<RentVO> rentList = rentdao.selectId(id);
		return rentList;
	}
	
}
