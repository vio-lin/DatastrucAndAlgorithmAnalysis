package com.violin.qlcode;

import java.util.Scanner;
/**
 * 输出一个int序列 把其中两个相加存储到下面  直到变成回形文 为止
 * 返回需要进行处理的步骤数目
 * 百分之50
 * @author lin
 *
 */
public class 转变回形纹 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while(scan.hasNext()){
			int count = scan.nextInt();
			int[] num = new int[count];
			for(int i =0;i<count;i++){
				num[i] = scan.nextInt();
			}
			
			boolean fale =  check(num,0,num.length);
			int n = change(num,0,num.length-1);
			System.out.println(n);
		}
	}

	private static int change(int[] num, int a, int b) {
		// TODO Auto-generated method stub
		if(a==b||b-a==1){
			return 0;
		}
		if(num[a]>num[b]){
			num[b-1] += num[b];
			return change(num,a,b-1)+1;
		}else if(num[a]<num[b]){
			num[a+1] += num[a];
			return change(num, a+1, b)+1;
		}else{
			return change(num,a+1,b-1);
		}
	}

	private static boolean check(int[] num, int a,int b) {
		// TODO Auto-generated method stub
		boolean temp = true;
		for(int i=a;i<a+b/2;i++){
			if(num[i]==num[b-1-i]){
				
			}else{
				temp =false;
			}
		}
		return temp;
	}
}
