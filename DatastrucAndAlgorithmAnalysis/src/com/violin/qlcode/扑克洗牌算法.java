package com.violin.qlcode;

import java.util.Scanner;
/**
 * 扑克洗牌算法 给出 
 * 6 1 
 * 1 2 3 4 5 6
 * 
 * 6张牌 洗一次 
 * 分前后凉两半  
 * 右边在下左边在上 依次排列
 * 输出 1 4 2 5 3 6
 * 
 * 洗两次 1 5 4 3 2 6
 * @author lin
 *
 */
public class 扑克洗牌算法 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while(scan.hasNext()){
			int count = scan.nextInt();
			int times = scan.nextInt();
			int a[] = new int[count+1];
			int b[] = new int[count+1];
			for(int i=1;i<=count;i++){
				a[i] = scan.nextInt();
			}
			for(int i=1;i<a.length;i++){
				b[change(i,a.length-1,times)] =a[i];
//				System.out.println(i+"---"+change(i,a.length-1,times));
				
			}
			for(int i=1;i<a.length;i++){
				System.out.print(" "+b[i]);
			}
 		}
	}

	private static int change(int i, int length, int times) {
		// TODO Auto-generated method stub
		if(times==0){
			return i;
		}
		if(i>length/2){
			return change((i-length/2)*2,length,times-1);
		}else if(i<=length/2){
			return change((i-1)*2+1,length,times-1);
		}
		return 0;
	}
}
