package com.violin.PAT2;

import java.util.Scanner;

public class NO1006 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while(scan.hasNext()){
			int num = scan.nextInt();
			for(int i=0;i<num/100;i++){
				System.out.print("B");
			}
			for(int i=0;i<num/10%10;i++){
				System.out.print("S");
			}
			for(int i=1;i<=num%10;i++){
				System.out.print(i);
			}
		}
	}
}
