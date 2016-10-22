package com.violin.PAT2;

import java.util.ArrayList;
import java.util.Scanner;

public class NO1012 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while(scan.hasNext()){
			int num = scan.nextInt();
			int[] arr = new int[num];
			int count0=0,count1=0,count2=0,count3=0,count4=0;
			int sum0=0,sum1=0,sum3=0,max=-1;
			int flag = 1;
			for(int i=0;i<num;i++){
				int temp = scan.nextInt();
				int exit = temp%5;
				if(exit==0&&temp%2==0){
					if(count0==0){
						count0++;						
					}
					sum0 = sum0+temp;
				}
				if(exit==1){
					if(count1==0){
						count1++;						
					}
					sum1 = sum1+temp*flag;
					flag*=-1;

				}
				if(exit==2){
					count2++;
				}
				if(exit==3){
					sum3 = sum3 +temp;
					count3++;
				}
				if(exit==4){
					if(count4==0){
						count4++;						
					}
					if(temp>max){
						max = temp;
					}
				}
			}
			if(count0==0){
				System.out.print("N ");
			}else{
				System.out.print(sum0+" ");
			}
			
			if(count1==0){
				System.out.print("N ");
			}else{
				System.out.print(sum1+" ");
			}
			
			if(count2==0){
				System.out.print("N ");
			}else{
				System.out.print(count2+" ");
			}
			
			if(count3==0){
				System.out.println("N ");
			}else{
				int sum = 0;
				System.out.format("%.1f ", (double)sum3/count3);
			}
			if(count4==0){
				System.out.print("N");
			}else{
				System.out.print(max);
			}
		}
	}
}
