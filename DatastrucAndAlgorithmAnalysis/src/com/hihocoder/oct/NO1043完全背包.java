package com.hihocoder.oct;
import java.util.HashMap;
import java.util.Scanner;

/**
 * 背包问题
 * @author lin
 */
public class NO1043完全背包 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int m = scan.nextInt();
		int[] costs = new int[n];
		int[] values = new int[n];
		for(int i=0;i<n;i++){
			costs[i] = scan.nextInt();
			values[i] = scan.nextInt();
		}
		System.out.println(getMaxValue(costs,values,m));
	}

	private static int getMaxValue(int[] cos, int[] val, int m) {
		// TODO Auto-generated method stub
		int n = cos.length;
		int[] f = new int[m+1];
		for(int i =0;i<n;i++){
			//这块的循环 吓尿了 
			for(int j =0;j<=m;j++){
				if(cos[i]>j){
					f[j] = f[j];
				}else{
					f[j] = Math.max(f[j], f[j-cos[i]]+val[i]);
				} 
			}
		}
		return f[m];
	}
}
