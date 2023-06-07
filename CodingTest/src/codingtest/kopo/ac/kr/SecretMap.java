package codingtest.kopo.ac.kr;

import java.util.Arrays;

public class SecretMap {

		    public static void main(String[] args) {
		        int n = 5; // 예시로 n을 5로 설정했습니다. 실제 입력에 따라서 값을 변경해야 합니다.
		        int[] arr1 = {9, 20, 28, 18, 11}; // 예시로 arr1을 설정했습니다. 실제 입력에 따라서 값을 변경해야 합니다.
		        int[] arr2 = {30, 1, 21, 17, 28}; // 예시로 arr2를 설정했습니다. 실제 입력에 따라서 값을 변경해야 합니다.

		        String[] result = solution(n, arr1, arr2);
		        System.out.println(Arrays.toString(result));
		    }

		    public static String[] solution(int n, int[] arr1, int[] arr2) {
		        String[] answer = new String[n];

		        for (int i = 0; i < n; i++) {
		            int map1 = arr1[i];
		            int map2 = arr2[i];
		            int mergedMap = map1 | map2; // 지도 1과 지도 2를 비트 OR 연산하여 합칩니다.
		            StringBuilder sb = new StringBuilder();

		            for (int j = 0; j < n; j++) {
		                int bit = mergedMap & 1; // 비트 AND 연산을 통해 가장 오른쪽 비트 값을 가져옵니다.
		                if (bit == 1) {
		                    sb.insert(0, "#"); // 벽인 경우 "#"을 추가합니다.
		                } else {
		                    sb.insert(0, " "); // 공백인 경우 " "을 추가합니다.
		                }
		                mergedMap >>= 1; // 비트 값을 오른쪽으로 1칸씩 이동시킵니다.
		            }

		            answer[i] = sb.toString();
		        }

		        return answer;
		    }
		
//		int n = 0;
//		int arr1 [] = null;
//		int arr2 [] = null;
//		Scanner sc = new Scanner(System.in);
//		
//		System.out.println("1~16 사이의 정수를 한개 입력해 주세요");
//		n = sc.nextInt();
//		
//		System.out.println("두자리 정수를"+ n +"개 기재 후 입력해주세요");
//		for(int i=0; i< n; i++) {
//		arr1[i] = sc.nextInt();
//		
//		}
//		
//		System.out.println("두자리 정수를"+ n +"개 기재 후 입력해주세요");
//		for(int i = 0; i< n; i++) {
//		arr2 [i]= sc.nextInt();
//		
//		}
//		System.out.println(n);
//		System.out.println(arr1[n]);
//		System.out.println(arr1[n]);
		}

