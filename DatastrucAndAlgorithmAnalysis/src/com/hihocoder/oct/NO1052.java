package com.hihocoder.oct;

import java.util.Scanner;

import javax.print.attribute.standard.Chromaticity;

public class NO1052 {
	public static void main(String[] args) {
		Scanner scan  = new Scanner(System.in);
		while(scan.hasNext()){
			int num = scan.nextInt();
			for(int i=0;i<num;i++){
				scan.nextLine();
				String str = scan.nextLine();
				int len = scan.nextInt();
				int res = Count(str,len);
				System.out.println(res);
			}
		}
	}

	private static int Count(String str, int len) {
		// TODO Auto-generated method stub
		char[] ch = str.toCharArray();
		int[] flag = new int[str.length()];
		int lef = 0;
		int rig = str.length()-len;
		int sum1=0;
		for(int i=lef;i<rig&&i<len;i++){
			int[] alp = new int[26];
			int temp =i;
			int sum = 1 ;
			alp[ch[temp]-'A']++;
			do{
				temp+=rig;
				alp[ch[temp]-'A']++;
				sum++;
			}while(temp<len);
			 int max = findmax(alp);
			 sum1 = sum1 + sum-max;
		}
		return sum1;
	}

	private static int findmax(int[] alp) {
		// TODO Auto-generated method stub
		int max = 0;
		char c= 'A';
		for(int i=0;i<alp.length;i++){
			if(alp[i]>max){
				max = alp[i];
			}
		}
		return max;
	} 
}
