package 华东计算机复试;
import java.util.Scanner;

public class 八进制 {
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		while(scan.hasNext()){
			int input = scan.nextInt();
			syso(input);
			System.out.println();;
		}
	}	
	public static void syso(int a){
		if(a/8==0){
			System.out.print(a%8);
			return;
		}
		syso(a/8);
		System.out.print(a%8);
	}
}
