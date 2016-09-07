package com.DataStructAndAlgorth.chatacter1;

import java.util.Arrays;

import org.junit.Test;

public class Ex1 {
/**
 * 编写一个程序解决选择问题，令k=N/2画出表格显示程序中对于N不同值的运算时间 求解出里面钱k个大小的数字
 */
	@Test
	public void serchk(){
		long start = System.currentTimeMillis();
		System.out.println(start);
		int[] a = new int[]{1,2,3,4,8,5,6,2,5,1,85,8,4,5,5,5,87,4,45,7,78,9,80,156,4,5,3,2,43,4,1,2,3,4,8,5,6,2,5,1,85,8,4,5,5,5,87,4,45,7,78,9,80,156,4,5,3,2,43,4,1,2,3,4,8,5,6,2,5,1,85,8,4,5,5,5,87,4,45,7,78,9,80,156,4,5,3,2,43,4,1,2,3,4,8,5,6,2,5,1,85,8,4,5,5,5,87,4,45,7,78,9,80,156,4,5,3,2,43,4,1,2,3,4,8,5,6,2,5,1,85,8,4,5,5,5,87,4,45,7,78,9,80,156,4,5,3,2,43,4,1,2,3,4,8,5,6,2,5,1,85,8,4,5,5,5,87,4,45,7,78,9,80,156,4,5,3,2,43,4};
		int k = a.length/2;
		int[] b = new int[k];
		for(int i=0;i<a.length;i++){
			for(int j=b.length-1;j>=0;j--){
				if(b[b.length-1]>=a[i]){
					break;
				}else if(a[i]>b[j]&&a[i]>b[j-1]){
					b[j]=b[j-1];
					if(j==1){
						b[0]=a[i];
					}
				}else if(a[i]>b[j]&&a[i]<b[j-1]){
					b[j] = a[i];
					break;
				}
			}
		}
		System.out.println(Arrays.toString(b));
		long end = System.currentTimeMillis();
		System.out.println(end);
		System.out.println("time："+(end-start));
	}
}
