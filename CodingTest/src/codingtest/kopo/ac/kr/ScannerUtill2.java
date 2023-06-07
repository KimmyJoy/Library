package codingtest.kopo.ac.kr;

import java.util.Scanner;

public class ScannerUtill2 {

	Scanner scan;
	
	public ScannerUtill2(){
		scan = new Scanner(System.in);	
	}
	
	public int nextInt(String msg) {
		System.out.print(msg);
		int num = scan.nextInt();
		scan.nextLine();
		return num;
	}
	
	
}
