package com.violin.qlcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;
/**
 * 队列算法 
 * 1.从头取出一个元素 加到尾部
 * 2.取出一个元素并进行输出
 * 3.重复上面的行为
 * 假如取出的东西正好是 1.2.3.4.n 
 * 求原始序列
 * @author lin
 *
 */
public class 环形队列的输出问题 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while(scan.hasNext()){
			int num = scan.nextInt();
			Integer[] data = new Integer[num];
			for(int i=0;i<num;i++){
				int result =  turn(i+1,num);
				System.out.println((i+1)+"-->"+result);
				data[i] = result;
			}
			for(int i=0;i<data.length;i++){
				System.out.println(data[i]);
			}
			LinkedList<Integer> list = new LinkedList<Integer>();
			list.addAll(Arrays.asList(data));
			while(!list.isEmpty()){
				int  i = list.pop();
				list.offer(i);
				System.out.print(list.pop()+"  ");
			}
		}
	}

	private static int turn(int i, int num) {
		// TODO Auto-generated method stub
		if(i%2==0){
			return i/2;
		}else if(i==1){
			return 1+turn(num-1,num-1);
		}else{
			return (i-1)/2+turn(1,num-(i-1)/2);
		}
	}
}
 