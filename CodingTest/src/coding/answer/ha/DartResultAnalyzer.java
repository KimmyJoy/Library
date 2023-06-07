package coding.answer.ha;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class DartResultAnalyzer {
	//지지고 볶아서 최종 점수와 산출했던 방정식을 보내고 끝남
	private int DartScore;
	private String DartScoreEquation;
	//dartResult가 스트링으로 날아올 것
	public DartResultAnalyzer(String dartResult) {
		List<Integer> Score = new ArrayList<Integer>();
		List<String> ScoreEquation = new ArrayList<String>();
		//하단처럼 하면 10이 쪼개지므로....비교 유틸을 넣어야한다
		StringTokenizer st = new StringTokenizer(dartResult, "0123456789", true);//"" 안에 있는 숫자를 잘라주는 것임 true를 넣으면 해당 잘랐던 숫자도 살려줌
		
		int numOfDart = 0;
		while(st.hasMoreElements()) {//true일때 토큰들을 출력해줌
			//비교를 위해....10만 찾으면 되기 때문에 하단처럼 하는거지 실전에서는 이러면 안된다
			String token1 = st.nextToken();
			String token2 = st.nextToken();
			if(token1.equals("1") && token2.equals("0")) {
				token1 = "10";
				token2 = st.nextToken();
			} else {
				//noop
			}
			
			if(numOfDart == 0) {
			System.out.printf("score : %s  Option %s\n", token1, token2);
			//점수와 옵션을 분리한 것
			//가져온 토큰을 아래에 넣는다
			DartScoreParser sp = new DartScoreParser(token1, token2);
			Score.add(sp.getCurScore());
			ScoreEquation.add(sp.getCurEquation());
			System.out.printf("score : %s   Equation %s\n", Score.get(numOfDart), ScoreEquation.get(numOfDart));
			//옵션으로 *이 들어간다 하면은 앞에 들어갔던 방정식과 score를 알아야 뒤에서 처리할 수 있게 된다
//			이러한 사례가 상당히 많다(g마켓, 쿠팡 -> 이전의 기록을 통해 뽑기? 가 가능하도록 만드는 식으로)
//			1회 token1, token2 -> score, scoreEq
//			2회	이전 score, scoreEq을 더해 줘야 결과 처리가 가능해진다
//			3회 (이하동문)
//			-->  1회 때엔 괜찮지만 2회/ 3회 
			
			
			
			//이전 스코어 값을 더해줘야한다
			}else {
				System.out.printf("score : %s   Option %s\n", token1, token2);
				DartScoreParser sp = new DartScoreParser(token1, token2, Score.get(numOfDart-1), ScoreEquation.get(numOfDart-1));
				
				Score.set(numOfDart-1, sp.getPrvScore());
				ScoreEquation.set(numOfDart-1, sp.getPrvEquation());
				Score.add(sp.getCurScore());
				ScoreEquation.add(sp.getCurEquation());
				System.out.printf("score : %s   Equation %s\n", Score.get(numOfDart), ScoreEquation.get(numOfDart));
			}

			numOfDart++;
		}
		for(int idx = 0; idx<numOfDart; idx++) {
			DartScore += Score.get(idx);
			DartScoreEquation += ScoreEquation.get(idx)+ "+" ;
		}
			
	//입출력받는 부분을 분리하는 것이 좋다
	}
	public int getDartScore() {
		return DartScore;
	}
	
	public String getDartScoreEquation() {
		return DartScoreEquation;
	}
	
}
