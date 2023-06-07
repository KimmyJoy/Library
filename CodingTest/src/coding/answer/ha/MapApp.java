package coding.answer.ha;

import java.util.Scanner;

public class MapApp {

	public static void main(String[] args) {

		int count;
		int[] arr1;
		int[] arr2;
		int[] outArr;// OR 연산 결과
		String[] outString; //출력 문자열
		
		Scanner sc = new Scanner(System.in);
		System.out.println("지도 한변 크기를 입력해주세요");
		//if 문으로 n이 1<= n <= 16이 되게 해줘야 함
		count = sc.nextInt();
		arr1 = new int[count];
		arr2 = new int[count];
		outArr = new int[count];
		outString = new String[count];
	
		System.out.println("Arr1의"+ count +"개의 숫자를 입력하세요(구분자 ,)");
		Scanner sc1 = new Scanner(sc.next()).useDelimiter("\\s*,\\s*");//이렇게 되면 ,로 구분이 되어서 들어온다?
		for(int i=0; i<count; i++) {
			arr1[i] = sc1.nextInt();
		}
	
		System.out.println("Arr2의"+ count +"개의 숫자를 입력하세요(구분자 ,)");
		Scanner sc2 = new Scanner(sc.next()).useDelimiter("\\s*,\\s*");//이렇게 되면 ,로 구분이 되어서 들어온다?
		for(int i=0; i<count; i++) {
			arr2[i] = sc2.nextInt();
		}
		for(int i=0; i<count; i++) {
			outArr[i] = arr1[i] | arr2[i];
			outString[i] = Integer.toBinaryString(outArr[i]);
			outString[i] = outString[i].replace('1', '#');
			outString[i] = outString[i].replace('0', ' ');
			System.out.println(outString[i]);
		}
	}

}
