package kr.ac.kopo.ui;
/**
 * 유저정보 변경
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

import kr.ac.kopo.util.ConnectionFactory;

public class Reshape extends BaseUI {

	public static void main(String[] args) {

			StringBuilder sql = new StringBuilder();
			sql.append("update t_test ");
			sql.append(" set pw = ? ");
			sql.append(" where id = ? ");
				
		try( 
				Scanner sc = new Scanner(System.in);
				Connection conn = new ConnectionFactory().getConnection();//쿼리를 여기에 집어넣으려면 3단계에서 만들었던 쿼리가 만들어져있어야함...그래서 1.7버전 try-catch문을 쓰려면 그전에 쿼리가 만들어져 있어야함
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());//모든 오브젝트 클래스는 toString 메소드를 가지고 있으므로 toString 메소드를 이용해서 다시 문자열로 변경이 된다
				){
			System.out.print("아이디를 입력하세요 : ");
			String id = sc.nextLine();
			System.out.print("변경할 이름을 입력 : ");
			String name = sc.nextLine();
			
			pstmt.setString(1, name);
			pstmt.setString(2, id);//id를 검색하여...name 바꾸는 것..
			
			int cnt = pstmt.executeUpdate();//반환타입은 int임
			if(cnt == 0) {
				System.out.println("해당 아이디가 존재하지 않습니다");
			} else {
				System.out.println("이름변경이 완료되었습니다.");
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void execute() throws Exception {
		// TODO Auto-generated method stub
		
	}

}
