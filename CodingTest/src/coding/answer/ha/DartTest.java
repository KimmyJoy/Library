package coding.answer.ha;

import java.util.Scanner;

public class DartTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("다트 결과 : ");
		//메인에서는 dartResult만 넘겨주고 끝
		String dartResult = sc.nextLine();
		
		DartResultAnalyzer ra = new DartResultAnalyzer(dartResult);
		int dartScore = ra.getDartScore();
		String dartScoreEquation = ra.getDartScoreEquation();
		
		System.out.printf("score : %s     equation : %s", dartScore, dartScoreEquation);
		//문자열을 잘라줌
		
	}
	
}
