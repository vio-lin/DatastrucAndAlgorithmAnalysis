package com.violin.PAT2;
import java.util.Scanner;


public class D进制的APluseB {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while(scan.hasNext()){
			int a = scan.nextInt();
			int b = scan.nextInt();
			int d = scan.nextInt();
			int sum = a+b;
			print(sum,d);
		}
	}

	private static void print(int sum, int d) {
		// TODO Auto-generated method stub
		if(sum/d==0){
			System.out.print(sum);;
		}else{
			print(sum/d,d);
			System.out.print(sum%d);
		}
	}
}
