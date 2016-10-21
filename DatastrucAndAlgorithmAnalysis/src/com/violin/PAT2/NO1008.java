package com.violin.PAT2;

import java.util.Scanner;

public class NO1008 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while(scan.hasNext()){
			int sum = scan.nextInt();
			int step = scan.nextInt();
			int[] arr = new int[sum];
			for(int i=0;i<sum;i++){
				arr[i] = scan.nextInt();
			}
			int flag = 0;
			step = step%sum;
			for(int i=0;i<sum;i++){
				if(flag == 0){
					flag++;
				}else{
					System.out.print(" ");
				}
				if(i-step<0){
					System.out.print(arr[i-step+sum]);					
				}else{
					System.out.print(arr[i-step]);
				}
			}
		}
	}
}
