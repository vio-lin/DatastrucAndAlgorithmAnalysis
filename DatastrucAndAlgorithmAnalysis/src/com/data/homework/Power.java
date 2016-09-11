package com.data.homework;

public class Power {
	//快捷的 幂运算
	public static long  power(long x,int n){
		if(n==0){
			return 0;
		}
		if(n==1){
			return x;
		}
		if(n%2==0){
			return power(x*x, n/2);
		}
		else{
			return power(x*x,n/2)*x;
		}
	}
	public static void main(String[] args) {
		System.out.println(power(2, 9));
	}
}
/**
 * 上面的改写会影响行数  注释写在下面 对于第9行 可以删除 因为 是1的话第10行会做一样的操作
 * 对于第13 有些不可取的操作 
 * return pow(pow(x,2),n/2)  
 *return pow(pow(x,n/2),2)
 *return pow()前面两行 会产生无限的循环 后面的1个影响效率
 */
