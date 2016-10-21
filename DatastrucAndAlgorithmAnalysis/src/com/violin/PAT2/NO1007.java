package com.violin.PAT2;

import java.util.Scanner;

public class NO1007 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while(scan.hasNext()){
			int sum = scan.nextInt();
			int[] arr = new int[sum+1];
			for(int i=2;i<=sum/2;i++){
				if(arr[i]==0){
					for(int j=2;j*i<sum;j++){
						arr[i*j] = 1;
					}
				}
			}
			int count = 0;
			for(int i=2;i<=sum-2;i++){
				if(arr[i]==0&&arr[i+2]==0){
					count ++;
				}
			}
			System.out.println(count);
		}
	}
}
