package com.violin.PAT2;

import java.util.Scanner;
/**
 * 字符间使用多个空格隔开的情况
 * @author lin
 */
public class NO1010 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		while(scan.hasNext()){
			int flag = 0;
			String str = scan.nextLine();
			String arr[] = str.split("\\s+");
			if(arr.length==2&&Integer.valueOf(arr[1])==0){
				System.out.println("0 0");
				continue;
			}
			for(int i=0;i<arr.length;i+=2){
				int a = Integer.valueOf(arr[i]);
				int b = Integer.valueOf(arr[i+1]);
				if(b!=0){
					if(flag==0){
						flag++;
					}else{
						System.out.print(" ");
					}
					System.out.print(a*b+" ");
					System.out.print(b-1);
				}
			}			
		}
	}
}
