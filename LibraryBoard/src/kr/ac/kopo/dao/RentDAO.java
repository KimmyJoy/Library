package kr.ac.kopo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kr.ac.kopo.util.ConnectionFactory;
import kr.ac.kopo.vo.RentVO;

/**
 * 오라클 DB t_board 에 게시글 CRUD하는 DAO클래스
 * 
 * @author User
 *
 */
//data와 관련된 애는 dao 하나뿐이므로 얘만 수정하면 모든게 끝남....
public class RentDAO {

	/*
	 * private List<BookVO> boardList;//맵으로 하는건 의미가 없음. 게시글 번호는 key로 쓰려는 것이 아님
	 * 
	 * public BookDAO() { boardList = new ArrayList<>(); }
	 */
	
	// 반납
	public void returnBook(RentVO rent) {
		StringBuilder sql = new StringBuilder();
		sql.append("delete from Rental where id = ? and isbn = ? ");

		int cnt = 0;
		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {
			
			pstmt.setString(1, rent.getId());
			pstmt.setString(2, rent.getIsbn());

			cnt = pstmt.executeUpdate();// 종료하는건 쓸필요 없음...자동종료 메소드를 호출하니까

		} catch (Exception e) {
			e.printStackTrace();
		}
		if(cnt != 0) {
			updateDeayeo(rent.getIsbn(), 1);
		}
	}

	
	// 대여시 북테이블 daeyeo 업데이트 메소드
	public void updateDeayeo(String isbn, int a) {
		StringBuilder sql = new StringBuilder();
		sql.append("update book_board set Daeyeo = ? where isbn = ?");

		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {
			
			pstmt.setInt(1, a);
			pstmt.setString(2, isbn);

			int cnt = pstmt.executeUpdate();// 종료하는건 쓸필요 없음...자동종료 메소드를 호출하니까
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void insertRent(RentVO rent) {// t_board로...하면 되는 것...

		// boardList.add(board); DB용으로 필요 없어짐 쿼리가 필요해짐 1.7버전의 try 캐치문을 쓸예정임
		StringBuilder sql = new StringBuilder();
		sql.append("insert into Rental(no, id, isbn, title) ");
		sql.append(" values(seq_Rental_no.nextval, ?, ?, ?) ");// 내용이 어떻게 적힐지 모르는 변수는 ?임 이야아아앙... 이변수값은 board 변수가 알고 있음

		int cnt = 0;
		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {
			
			pstmt.setString(1, rent.getId());
			pstmt.setString(2, rent.getIsbn());
			pstmt.setString(3, rent.getTitle());

			cnt = pstmt.executeUpdate();// 종료하는건 쓸필요 없음...자동종료 메소드를 호출하니까
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(cnt != 0) {
			updateDeayeo(rent.getIsbn(), 0);
		}
	}

	public List<RentVO> selectAll() {

		List<RentVO> rentList = new ArrayList<>();// 보드 vo를 감싸안아줄 list가 필요함

		// String sql = "select * from t_board";//연월일시분초가 다 나오므로 이게 아니고 다른 형태로 해야 함
		StringBuilder sql = new StringBuilder();
		sql.append("select no, isbn, id, to_char(rentdate, 'yyyy-mm-dd') as rentdate, to_char(returndate, 'yyyy-mm-dd') as returndate, title ");
		sql.append(" from rental ");
		sql.append(" order by rentdate desc ");// 가장최근순으로 하기 위해

		try (
				// 1. 접속개체를 얻어와야 함
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {

			// 익스큐트 쿼리
			ResultSet rs = pstmt.executeQuery();// 리턴타입이 rsultset임

			while (rs.next()) {
				int no = rs.getInt("no");
				String isbn = rs.getString("isbn");// 넘버 컬럼에 있는 int를 가져오면 됨 각각의 컬럼형태로 만들어야함
				String id = rs.getString("id");
				String rentdate = rs.getString("rentdate");
				String returndate = rs.getString("returndate");
				String title = rs.getString("title");

				RentVO rent = new RentVO(no, id, isbn, rentdate, returndate, title);// 매개변수가진걸 boardvo에 만들어뒀었으므로....가져오면 됨
				/*
				 * 위가 싫으면 이렇게 하면 됨 BookVO board = new BookVO board.setNO(no);
				 * board.setTitle(title); board.setwriter(writer); board.setregDate(regDate);
				 */
//				System.out.println(board);
				rentList.add(rent);// 애드해야함...

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return rentList; // 보드 vo를 감싸안을 애를 만들고 리턴해줘야함...
	}
	
	public List<RentVO> selectId(String idd) {

		List<RentVO> rentList = new ArrayList<>();// 보드 vo를 감싸안아줄 list가 필요함

		// String sql = "select * from t_board";//연월일시분초가 다 나오므로 이게 아니고 다른 형태로 해야 함
		StringBuilder sql = new StringBuilder();
		sql.append("select no, isbn, id, to_char(rentdate, 'yyyy-mm-dd') as rentdate, to_char(returndate, 'yyyy-mm-dd') as returndate, title ");
		sql.append(" from rental ");
		sql.append(" where id = ? ");// 가장최근순으로 하기 위해

		try (
				// 1. 접속개체를 얻어와야 함
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {

			pstmt.setString(1, idd);
			
			// 익스큐트 쿼리
			ResultSet rs = pstmt.executeQuery();// 리턴타입이 rsultset임

			while (rs.next()) {
				int no = rs.getInt("no");
				String isbn = rs.getString("isbn");// 넘버 컬럼에 있는 int를 가져오면 됨 각각의 컬럼형태로 만들어야함
				String id = rs.getString("id");
				String rentdate = rs.getString("rentdate");
				String returndate = rs.getString("returndate");
				String title = rs.getString("title");

				RentVO rent = new RentVO(no, id, isbn, rentdate, returndate, title);// 매개변수가진걸 boardvo에 만들어뒀었으므로....가져오면 됨
				/*
				 * 위가 싫으면 이렇게 하면 됨 BookVO board = new BookVO board.setNO(no);
				 * board.setTitle(title); board.setwriter(writer); board.setregDate(regDate);
				 */
//				System.out.println(board);
				rentList.add(rent);// 애드해야함...

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return rentList; // 보드 vo를 감싸안을 애를 만들고 리턴해줘야함...
	}
	
//	public RentVO selectById(String iD) {// isbn으로 조회
//
//		RentVO rent = null;
//
//		StringBuilder sql = new StringBuilder();
//		sql.append("select id, isbn, to_char(rentdate, 'yyyy-mm-dd') as rentdate, to_char(returndate, 'yyyy-mm-dd') as returndate, title ");
//		sql.append(" from rental ");
//		sql.append(" where id = ? ");
//
//		try (Connection conn = new ConnectionFactory().getConnection();
//				PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {
//
//			pstmt.setString(1, iD);
//
//			ResultSet rs = pstmt.executeQuery();// 최대 한줄이라 next가 필요 없을 것
//
//			if (rs.next()) {// true면...
//
//				String id = rs.getString("id");
//				String isbn = rs.getString("isbn");
//				String rentdate = rs.getString("rentdate");
//				String returndate = rs.getString("returndate");
//				String title = rs.getString("title");
//
//				rent = new RentVO(id, isbn, rentdate, returndate, title);
//
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return rent;// if를 만족하지 않으면 null값일 것
//	}
//
//	public List<RentVO> getUserInfo(String iD) {
//		List<RentVO> rentList = new ArrayList<>();
//		
//		StringBuilder sql = new StringBuilder();
//		sql.append("select id, isbn, to_char(rentdate, 'yyyy-mm-dd') as rentdate, to_char(returndate, 'yyyy-mm-dd') as returndate, title ");
//		sql.append(" from rental ");
//		sql.append(" where id = ? ");
//		
//		try (Connection conn = new ConnectionFactory().getConnection();
//				PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {
//
//			pstmt.setString(1, iD);
//
//			ResultSet rs = pstmt.executeQuery();// 최대 한줄이라 next가 필요 없을 것
//
//			while (rs.next()) {// true면...
//
//				String id = rs.getString("id");
//				String isbn = rs.getString("isbn");
//				String rentdate = rs.getString("rentdate");
//				String returndate = rs.getString("returndate");
//				String title = rs.getString("title");
//
//				RentVO rent = new RentVO(id, isbn, rentdate, returndate, title);
//				rentList.add(rent);
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return rentList;// if를 만족하지 않으면 null값일 것
//	 }
	}

