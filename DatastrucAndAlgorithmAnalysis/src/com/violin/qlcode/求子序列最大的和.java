package com.violin.qlcode;

import java.util.Scanner;
/**
 *  输入一个序列 从头开始每次不可以取相邻的数  。 求从头到尾 最大的数组 的 和
 * 2016年9月11日17:55:06
 */
import javax.swing.text.AbstractDocument.LeafElement;
public class 求子序列最大的和 {
	public static int[] size = new int[100];
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()){
			String str = scanner.nextLine();
			int[] a = new int[str.split(" ").length];
			int j=0;
			for(String st:str.split(" ")){
				a[j] = Integer.valueOf(st);
				j++;
			}
			System.out.println(maxsub(0,a));
			for(int i = 0 ;i<size.length;i++){
				System.out.print(size[i]+"   ");
			}
		}
	}
/**
 *  这边的使用的跳跃的格子 不是1 就是2 
 * @param i
 * @param a
 * @return
 */
	private static int maxsub(int i, int[] a) {
		// TODO Auto-generated method stub
		if(i==a.length-1||i==a.length-2){
			size[i] = a[i];
			return a[i];
		}
		if(i==a.length-3){
			size[i] = a[i]+maxsub(i+2, a);
			return a[i]+maxsub(i+2, a);
		}
		if(maxsub(i+2, a)>=maxsub(i+3, a)){
			size[i] = a[i]+maxsub(i+2, a);
			return a[i]+maxsub(i+2, a);
		}else{
			size[i] = a[i]+maxsub(i+3, a);
			return a[i]+maxsub(i+3, a);
		}
	}
}
