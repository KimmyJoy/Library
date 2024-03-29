package kr.ac.kopo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kr.ac.kopo.util.ConnectionFactory;
import kr.ac.kopo.vo.MemberVO;

/**
 * sql에 Member 에 게시글 CRUD하는 DAO클래스
 * 
 * @author User
 *
 */
//data와 관련된 애는 dao 하나뿐이므로 얘만 수정하면 모든게 끝남....
public class MemberDAO {

	/*
	 * private List<BookVO> boardList;//맵으로 하는건 의미가 없음. 게시글 번호는 key로 쓰려는 것이 아님
	 * 
	 * public BookDAO() { boardList = new ArrayList<>(); }
	 */
	public void insertMember(MemberVO member) {// t_board로...하면 되는 것...

		// boardList.add(board); DB용으로 필요 없어짐 쿼리가 필요해짐 1.7버전의 try 캐치문을 쓸예정임
		StringBuilder sql = new StringBuilder();
		sql.append("insert into Member(no, id, password, name, birth, phonenum, e_mail) "); // no는 nextval로 이루어졌음...reg
																							// date는 이미 디폴을 sydate로
																							// 잡았으므로...없어도 됨
		sql.append(" values(seq_Member_no.nextval, ?, ?, ?, ?, ?, ?) ");// 내용이 어떻게 적힐지 모르는 변수는 ?임 이야아아앙... 이변수값은 board
																		// 변수가 알고 있음

		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPassword());
			pstmt.setString(3, member.getName());
			pstmt.setString(4, member.getBirth());
			pstmt.setString(5, member.getPhonenum());
			pstmt.setString(6, member.getEmail());

			pstmt.executeUpdate();// 종료하는건 쓸필요 없음...자동종료 메소드를 호출하니까

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<MemberVO> selectAllusers() {// 관리자에게 회원관리번호를 포함하여 출력하는 메소드

		List<MemberVO> memberList = new ArrayList<>();// 보드 vo를 감싸안아줄 list가 필요함

		// String sql = "select * from t_board";//연월일시분초가 다 ㄴ나오므로 이게 아니고 다른 형태로 해야 함
		StringBuilder sql = new StringBuilder();
		sql.append("select no, id, password, name, birth, phonenum, e_mail ");
		sql.append(" from member ");
		sql.append(" order by no desc ");// 가장최근순으로 하기 위해

		try (
				// 1. 접속개체를 얻어와야 함
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {

			// 익스큐트 쿼리
			ResultSet rs = pstmt.executeQuery();// 리턴타입이 rsultset임

			while (rs.next()) {
				int no = rs.getInt("no");// 넘버 컬럼에 있는 int를 가져오면 됨 각각의 컬럼형태로 만들어야함
				String id = rs.getString("id");
				String password = rs.getString("password");
				String name = rs.getString("name");
				String birth = rs.getString("birth"); // 여기서 숫자를 쓸 수 있음...4번째 컬럼을 가져오라고 하려면 rs.getString(4)라고 해도 됨
				String phonenum = rs.getString("phonenum");
				String email = rs.getString("e_mail");

				MemberVO member = new MemberVO(no, id, password, name, birth, phonenum, email);// 매개변수가진걸 boardvo에
																								// 만들어뒀었으므로....가져오면 됨
				/*
				 * 위가 싫으면 이렇게 하면 됨 BookVO board = new BookVO board.setNO(no);
				 * board.setTitle(title); board.setwriter(writer); board.setregDate(regDate);
				 */
//				System.out.println(board);
				memberList.add(member);// 애드해야함...

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return memberList; // 보드 vo를 감싸안을 애를 만들고 리턴해줘야함...
	}

	public MemberVO searchMemByid(String iD) {// 특정 아이디 검색이 가능한 쿼리실행

		MemberVO member = null;

		StringBuilder sql = new StringBuilder();
		sql.append("select no, id, password, name, birth, phonenum, e_mail ");
		sql.append(" from member ");
		sql.append(" where id = ? ");

		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {

			pstmt.setString(1, iD);

			ResultSet rs = pstmt.executeQuery();// 최대 한줄이라 while(rs.next())가 필요 없을 것

			if (rs.next()) {// true면...
				int no = rs.getInt("no");
				String id = rs.getString("id");
				String password = rs.getString("password");
				String name = rs.getString("name");
				String birth = rs.getString("birth"); // 여기서 숫자를 쓸 수 있음...4번째 컬럼을 가져오라고 하려면 rs.getString(4)라고 해도 됨
				String phonenum = rs.getString("phonenum");
				String email = rs.getString("e_mail");

				member = new MemberVO(no, id, password, name, birth, phonenum, email);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return member;// if를 만족하지 않으면 null값일 것
	}

	public void deleteUser(String id) {

		StringBuilder sql = new StringBuilder();
		sql.append("delete ");// instr 때문에 전부 입력받아야함....그리고 애초에 등록이라 다 입력해야함!!
		sql.append(" from Member ");
		sql.append(" where id = ? ");

		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {

			pstmt.setString(1, id);
			pstmt.executeUpdate();

//		if(cnt == 0) {
//			return true;
//		}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
