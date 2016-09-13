package com.violin.qlcode;

import java.util.Scanner;

public class 求多少组两个素数组成 {
	static int[] so = new int[1001];
	
	public static void main(String[] args) {
		for(int i=0;i<1001;i++){
			so[i]=0;
		}
		for(int i=1;i<1000;i++){
			if(so[i+1]!=-1){
				int j =2;
				while((i+1)*j<1000){
					so[(i+1)*j-1] =1;
					j++;	
			}
		}
	}
		so[0]=1;
		so[1]=0;
		for(int i=0;i<1001;i++){
			System.out.print(i+1+":"+""+(so[i]==0?"素数":"合数")+" ");
		}
	
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()){
			int a = scanner.nextInt();
			int count = 0;
			for(int i=1;i<=a/2;i++){
				if(so[i-1]==0&&so[a-i-1]==0){
					count++;
				}
			}
			System.out.println(count);
		}
	}
}
