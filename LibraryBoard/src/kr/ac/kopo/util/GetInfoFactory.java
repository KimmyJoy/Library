package kr.ac.kopo.util;


public class GetInfoFactory {
/*로그인 정보를 그냥 static으로 member에 저장되게 하려고 했으나
이런 경우 개인 아이디를 넣은 조회가 불가능해져서 새로이 만든 factory
*/
	private static String ID;
	
	public static String getID() {
		return ID;
	}
	public static void setID(String iD) {
		ID = iD;
	}
	
	public static void refreshID() {
		ID = null;
	}
	//각각의 값을 초기화해주기 위한 메소드 필요
	
}
