package coding.answer.ha;

public class DartScoreParser {
	// 계산을 기본적으로 계산한 점수와 방정식을 전달해주면 되므로
	private int curScore;
	private String curEquation;
	private int prvScore;
	private String prvEquation;

	// parser는 많이 쓴다....꼭 기억하고 있다가 다양한 활용을 하여라
	public DartScoreParser(String token1, String token2) {
		// 생성자는 기본적으로
		// * 이 나왔을때 같이 수정되게 해줘야한다
		if(token2.charAt(0) == 'S' || token2.charAt(0) == 's') {
			if(token2.length() > 1) {
				if(token2.charAt(1) == '*') {
					curScore = Integer.parseInt(token1) * 2;
					curEquation = token1 + "^1*2";
				}else if(token2.charAt(1) == '#') {
					curScore = Integer.parseInt(token1)*(-1);
					curEquation = token1 + "^1*(-1)";
				}else {
					System.out.println("Use Only *, #");
				}	
			}else {
				curScore = Integer.parseInt(token1);
				curEquation = token1 + "^1";
			}			
		}else if(token2.charAt(0) == 'D' || token2.charAt(0) == 'd') {
			if(token2.length() > 1) {
				if(token2.charAt(1) == '*') {
					curScore = (int)(Math.pow(Integer.parseInt(token1), 2) * 2);
					curEquation = token1 + "^2*2";
				}else if(token2.charAt(1) == '#') {
					curScore = (int)(Math.pow(Integer.parseInt(token1), 2) * (-1));
					curEquation = token1 + "^2*(-1)";
				}else {
					System.out.println("Use Only *, #");
				}	
			}else {
				curScore = (int) Math.pow(Integer.parseInt(token1), 2);
				curEquation = token1 + "^2";
			}			
		}else if(token2.charAt(0) == 'T' || token2.charAt(0) == 't') {
			if(token2.length() > 1) {
				if(token2.charAt(1) == '*') {
					curScore = (int) Math.pow(Integer.parseInt(token1), 3) * 2;
					curEquation = token1 + "^1*2";
				}else if(token2.charAt(1) == '#') {
					curScore = (int) Math.pow(Integer.parseInt(token1), 3)*(-1);
					curEquation = token1 + "^1*(-1)";
				}else {
					System.out.println("Use Only *, #");
				}	
			}else {
				curScore = (int) Math.pow(Integer.parseInt(token1), 3);
				curEquation = token1 + "^3";
			}			
		}else {
			System.out.println("Error : Use only S, D , T!!!");
		}
	}
	
	public DartScoreParser(String token1, String token2, int prevScore, String prevScoreEquation) {
		if(token2.charAt(0) == 'S' || token2.charAt(0) == 's') {
			if(token2.length() > 1) {
				//s가 걸린 후에 길이를 통해 있는지 없는지 확인하고 1보다 크면 뒤에 옵션이 있는거니까 아래의 if문으로 보내는 것
				if(token2.charAt(1) == '*') {
					curScore = Integer.parseInt(token1) * 2;
					curEquation = token1 + "^1*2";
					prvScore = prevScore*2;
					prvEquation = prevScoreEquation+"*2";
				}else if(token2.charAt(1) == '#') {
					curScore = Integer.parseInt(token1)*(-1);
					curEquation = token1 + "^1*(-1)";
					prvScore = prevScore;
					prvEquation = prevScoreEquation;
				}else {
					System.out.println("Use Only *, #");
				}	
				// else 조건이 없더라도 꼭 넣어줄것 그리고 코드 중간에 return을 넣어서 안됨 메소드 맨 끝에 넣고 return value를 중간에
				// 바꿔주는 형식으로 해줘야함
//				안그러면 스파게티 코드(안좋은 양상의 코드)가 된담
				// 두번째 문자가 없다는 소리는
			}else {
				curScore = Integer.parseInt(token1);
				curEquation = token1 + "^1";
				prvScore = prevScore;
				prvEquation = prevScoreEquation;
			}			
		}else if(token2.charAt(0) == 'D' || token2.charAt(0) == 'd') {
			if(token2.length() > 1) {
				if(token2.charAt(1) == '*') {
					curScore = (int)(Math.pow(Integer.parseInt(token1), 2) * 2);
					curEquation = token1 + "^2*2";
					prvScore = prevScore*2;
					prvEquation = prevScoreEquation+"*2";
				}else if(token2.charAt(1) == '#') {
					curScore = (int)(Math.pow(Integer.parseInt(token1), 2) * (-1));
					curEquation = token1 + "^2*(-1)";
					prvScore = prevScore;
					prvEquation = prevScoreEquation;
				}else {
					System.out.println("Use Only *, #");
				}	
			}else {
				curScore = (int) Math.pow(Integer.parseInt(token1), 2);
				curEquation = token1 + "^2";
				prvScore = prevScore;
				prvEquation = prevScoreEquation;
			}			
		}else if(token2.charAt(0) == 'T' || token2.charAt(0) == 't') {
			if(token2.length() > 1) {
				if(token2.charAt(1) == '*') {
					curScore = (int) Math.pow(Integer.parseInt(token1), 3) * 2;
					curEquation = token1 + "^1*2";
					prvScore = prevScore*2;
					prvEquation = prevScoreEquation+"*2";
				}else if(token2.charAt(1) == '#') {
					curScore = (int) Math.pow(Integer.parseInt(token1), 3)*(-1);
					curEquation = token1 + "^1*(-1)";
					prvScore = prevScore;
					prvEquation = prevScoreEquation;
				}else {
					System.out.println("Use Only *, #");
				}	
			}else {
				curScore = (int) Math.pow(Integer.parseInt(token1), 3);
				curEquation = token1 + "^3";
				prvScore = prevScore;
				prvEquation = prevScoreEquation;
			}			
		}else {
			System.out.println("Error : Use only S, D , T!!!");
		}
	}

	public int getCurScore() {
		return curScore;
	}

	public String getCurEquation() {
		return curEquation;
	}

	public int getPrvScore() {
		return prvScore;
	}

	public String getPrvEquation() {
		return prvEquation;
	}


	
}
