package com.violin.PAT2;
import java.util.Scanner;


public class 个数统计 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while(scan.hasNext()){
			String str = scan.nextLine();
			int[]  num = new int[10];
			for(int i=0;i<str.length();i++){
				num[str.charAt(i)-'0']++;
			}
			for(int i=0;i<10;i++){
				if(num[i]!=0){
					System.out.println((i)+":"+num[i]);
				}
			}
		}
	}
}
