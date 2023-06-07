package codingtest.kopo.ac.kr;

import java.util.Scanner;

public class Dartgame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("다트 게임 입력: ");
        String input = scanner.nextLine();

        int result = Calculater.calculateTotalScore(input);
        System.out.println("총 점수: " + result);
    }

}
		

