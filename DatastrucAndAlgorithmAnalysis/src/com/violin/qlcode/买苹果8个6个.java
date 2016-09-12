package com.violin.qlcode;

import java.util.Scanner;
/**
 * 输入要买苹果的个数  使用一袋8个 或者 1袋6个 的购买方式
 * 假如无法满足 输出 -1 否则输出 袋数
 * @author lin
 *
 */
public class 买苹果8个6个 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while(scan.hasNext()){
			int sum = scan.nextInt();
			int c = 0;
			
			for(int i=sum/8;i>=0;i--){
				if((sum-8*i)%6==0){
					c++;
					System.out.println((i+((sum-8*i)/6)));
					break;
				}
			}
			if(c==0){
				System.out.println(-1);
			}
		}
	}
}
