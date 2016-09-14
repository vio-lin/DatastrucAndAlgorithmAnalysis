package com.DataStructAndAlgorth.Sort;

import org.junit.Test;

/**
 * 希尔 排序 基本思想  0 0+n o+2n的元素取出来之后 进行一步排序之后重新放回原来的数组 中去
 * 再逐渐减少后面的的间隔 知道 这边的间隔 n变成1  
 * 成为简单的冒泡排序  不做证明 但是真的有效
 * @author lin
 *
 */
public class 希尔排序 {
	public static void main(String[] args) {
		int[] a = { 1, 24, 6, 6, 4, 5, 6, 5, 7, 45, 5, 6, 67, 67, 56,1, 24, 6, 6, 4, 5, 6, 5, 7, 45, 5, 6, 67, 67, 56 };
		int j =0;
		for(int gap=a.length/2;gap>0;gap/=2){
			for(int i=gap;i<a.length;i++){
				int temp = a[i];
				for(j=i;j>=gap&&temp<a[j-gap];j-=gap){
					a[j] = a[j-gap];
				}
				a[j] = temp;
			}
		}
//		for(int i=0;i<a.length;i++){
//			System.out.print(a[i]+" ");
//		}
	}
	
	@Test
	public void shell(){
		int a[] = new int[] {81,94,11,96,12,35,17,95,28,58,41,75,15};
		for(int step=a.length/2;step>0;step/=2){
			for(int i=0;i<step;i++){
				int temp=a[i];
				int j=0;
				for( j=i;j+step<a.length&&a[j+step]<a[j];j+=step){
					a[j]=a[j+step];
					System.out.println(j+":"+(j+step));
				}
				a[j]=temp;				
				prit(a);
			}
		}
		prit(a);
	}
	public static void prit(int[] a){
		for(int i=0;i<a.length;i++){
			System.out.print(a[i]+" ");
		}
		System.out.println();
	}
	@Test
	 public void chager(){
		 int[] a = new int[]{81,94,11,96,12,35,17,95,28,58,41,75,15};
		 for(int i=0;i<a.length;i++){
			 System.out.print((i+1)+":"+a[i]+"  ");
		 }
	 }
	
}
