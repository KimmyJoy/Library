package codingtest.kopo.ac.kr;

import java.util.Scanner;

public class Cache {
	
	 public static void main(String[] args) {
		 Scanner scanner = new Scanner(System.in);

	        System.out.print("캐시 크기를 입력하세요: ");
	        int cacheSize = scanner.nextInt();
	        scanner.nextLine(); // 개행 문자 제거

	        System.out.print("도시 이름을 입력하세요 (여러 개의 도시는 공백으로 구분): ");
	        String[] cities = scanner.nextLine().split(" ");

	        int executionTime = CalculLRU.calculateExecutionTime(cacheSize, cities);
	        System.out.println("총 실행시간: " + executionTime);

	        scanner.close();
	    }
	}

