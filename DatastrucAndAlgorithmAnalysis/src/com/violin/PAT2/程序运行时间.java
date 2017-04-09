package com.violin.PAT2;
import java.util.Scanner;


public class 程序运行时间 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while(scan.hasNext()){
			long a =scan.nextLong();
			long b = scan.nextLong();
			long c = (b-a+50)/100;
			print(c/3600);
			System.out.print(":");
			print(c/60%60);
			System.out.print(":");
			print(c%60);
		}
	}

	private static void print(long c) {
		// TODO Auto-generated method stub
		if(c>=10){
			System.out.print(c);
		}else{
			System.out.print("0"+c);
		}
	}
}
