package com.violin.qlcode;

import java.util.Scanner;
/**
 * 输入一个一个面额   输出可以使用6中货币
 * 多少种组合 可以输出这边的值 
 * @author lin
 *
 */
public class 纸币搭配种数 {
	public static int[] a = new int[]{1,5,10,20,50,100};
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()){
			int total = scanner.nextInt();
			System.out.println(Count(5,total));
		}
		
	}

	private static int Count(int ind, int total) {
		// TODO Auto-generated method stub
		int sum = 0;
		if(ind == 0){
			return 1;
		}else{
			for(int i=0;i*a[ind]<=total;i++){
				sum += Count(ind-1, total-i*a[ind]);
			}
			return sum;
		}
	}
}
