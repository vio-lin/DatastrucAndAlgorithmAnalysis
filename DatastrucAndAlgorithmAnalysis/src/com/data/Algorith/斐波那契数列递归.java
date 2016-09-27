package com.data.Algorith;

import javax.naming.spi.DirStateFactory.Result;

import org.junit.Test;

/**
 * 简单事物的递归 会造成很多 结果的重复于是乎 
 * 会产生很多不必要的计算 于是
 * @author lin
 *
 */
public class 斐波那契数列递归 {
	/**
	 * Computer Fibonaci number as described in Chapter 1
	 * 斐波那契函数因为做了很多无效的运算导致在长时间的递归中出现了很多无用的计算
	 * 
	 */
	public static int  fib(int N){
		if(N<=1){
			return 1;
		}else {
			return fib(N-1) +fib(N-2);
		}
	}
	/**
	 * Cpmputer Fibonaci number in an other way
	 */
	public static int fib1(int n){
		int last=1;
		int last2 =1;
		if(n<=1){
			return 1;
		}
		int res =2;
		for(int i=2;i<n;i++){
			last2 = last;
			last = res; 
			res = last+last2;
		}
		return res;
	}
	@Test
	public void timetesr(){
		long start = System.currentTimeMillis();
		System.out.println(fib1(40));
		long end = System.currentTimeMillis();
		System.out.println(end-start);
	}
}
