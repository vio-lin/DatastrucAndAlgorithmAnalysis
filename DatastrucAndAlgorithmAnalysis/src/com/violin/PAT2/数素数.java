package com.violin.PAT2;
import java.util.Scanner;

public class 数素数 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while (scan.hasNext()) {
			int a = scan.nextInt();
			int b = scan.nextInt();
			int[] arr = new int[110000];
			for (int i = 2; i < 60000; i++) {
				if (arr[i] == 0) {
					for (int j = 2; i * j < 110000; j++) {
						arr[i * j] = 1;
					}
				}
			}
			int j =1;
			 for(int i=0;i<a;){
				 if(arr[j]==0){
					 i++;
				 }
				 j++;
			 }
			 for(int i=1;i<=b-a+1;){
				 if(arr[j]==0){
					 if(i%10==1){
						 System.out.print(j);					 						 
					 }else if(i%10==0){
						 System.out.println(" "+j);
					 }else{
						 System.out.print(" "+j);
					 }
					 i++;
				 }
				 j++;
			 }
		}
	}
}