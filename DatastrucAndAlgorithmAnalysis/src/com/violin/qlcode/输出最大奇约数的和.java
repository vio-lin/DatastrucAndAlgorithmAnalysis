package com.violin.qlcode;

import java.util.Scanner;
/**
 * f(n)  为最大的奇约数    
 * 输入一个 n  输出 f(1)+f(2)+f(3)......f(n)
 * @author lin
 *
 */
public class 输出最大奇约数的和 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while(scan.hasNext()){
			int s = scan.nextInt();
			int sum = 0;
			for(int i=1;i<=s;i++){
				sum+=find(i);
			}
			System.out.println(sum);
		}
	}
	public static int find(int a){
		int res=1;
		if(a%2==1){
			return a;
		}
		for(int i=a/2;i>2;i--){
			if(i%2==1&&a%i==0){
				res=i;
				break;
			}
		}
		return res;
	}
}
