package kr.ac.kopo.ui;
//추상메소드를 가진 아이
public interface ILibraryUI {

	void execute() throws Exception;
	//중간중간 문제가 생길 수 있으므로 예외처리를....꼭 만들 수 있도록 그리고 통합관리가 가능하도록 간접처리로 보내는 강제성을 부여함
}
