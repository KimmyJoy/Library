package codingtest.kopo.ac.kr;

import java.util.StringTokenizer;

public class Calculater {
//static으로 해서 클래스 명으로 메소드를 사용할 수 있게 구성
	 public static int calculateTotalScore(String input) {
	        int[] scores = new int[3]; //이전 값을 기억해둬야 하기 때문에 배열로 해서 score를 기록해 두는 것
	        int currentRound = -1;
	        //tokenizer를 통해 지정한 문자열을 기준으로 입력된 문자열을 분리
	        StringTokenizer tokenizer = new StringTokenizer(input, "SDT*#", true);
	        //숫자가 아닌 SDT*#로 분류하는 이유 : 점수/보너스/옵션을 구분하기 위함
	        //분리된 토큰을 순회하면서 점수와 보너스 옵션을 처리
	        while (tokenizer.hasMoreTokens()) {
	            String token = tokenizer.nextToken();

	            if (Character.isDigit(token.charAt(0))) {
	                scores[++currentRound] = Integer.parseInt(token);
	            } else if (isBonus(token)) {
	                applyBonus(token, scores, currentRound);
	            } else if (isOption(token)) {
	                applyOption(token, scores, currentRound);
	            }
	        }

	        int totalScore = 0;
	        for (int score : scores) {
	            totalScore += score;
	        }

	        return totalScore;
	    }
	 
	 //토큰이 보너스인지 확인
	 public static boolean isBonus(String token) {
	        return token.equals("S") || token.equals("D") || token.equals("T");
	    }
	 //보너스 적용
	    public static void applyBonus(String bonus, int[] scores, int currentRound) {
	        int index = bonus.equals("S") ? 1 : (bonus.equals("D") ? 2 : 3);
	        scores[currentRound] = (int) Math.pow(scores[currentRound], index);
	    }
	    //토큰이 옵션인지 확인
	    public static boolean isOption(String token) {
	        return token.equals("*") || token.equals("#");
	    }
	    //옵션을 적용
	    public static void applyOption(String option, int[] scores, int currentRound) {
	        if (option.equals("*")) {
	            scores[currentRound] *= 2;
	            if (currentRound > 0) {
	                scores[currentRound - 1] *= 2;
	            }
	        } else if (option.equals("#")) {
	            scores[currentRound] *= -1;
	        }
	    }
	
}
