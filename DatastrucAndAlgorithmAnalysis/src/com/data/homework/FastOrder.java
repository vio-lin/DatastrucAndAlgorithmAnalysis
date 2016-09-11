package com.data.homework;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class FastOrder {	
	@Test
	public void test(){
		int[] a = new int[]{98,75,66,58,51,35,15,31,48,52};
		int temp;
		temp = a[0];
		while(true){
			for(int i = a.length-1;i>=1;i--){
				if(temp>=a[i]){
					int c= 0;
					c=a[i];
					a[i]=temp;
					temp=c;
					if(i==0){
						a[0]=temp;
						break;
					}
				}
			}
			for(int i=1;i<a.length;i++){
				if(temp<=a[i]){
					int c= 0;
					c=a[i];
					a[i]=temp;
					temp=c;
					if(i==a.length){
						a[a.length] = temp;
						break;
					}
				}
			}
			for(int i=0;i<a.length;i++){				
				System.out.print(a[i]+";");
			}
			System.out.println();
		}
	}
	
	public void  sort (int[] arr, int low,int high){
		int l =low;
		int h= high;
		//设定当前的初始值 为这边的最低位
		int povit = arr[low];
		while(l<h){
			while(l<h&&arr[h]>=povit)
				h--;
				if(l<h){
					int temp = arr[h];
					arr[h] = arr[l];
					arr[l] = temp;
					l++;
				}
		while(l<h&&arr[l]<=povit)
				l++;
		if(l<h){
			int temp = arr[h];
			arr[h] = arr[l];
			arr[l] = temp;
			h--;
		}
		}
		println(arr);
		System.out.println("l="+(l+1)+"h="+(h+1)+"povit="+povit+"\n");
		if(l>low) sort(arr, low, l-1);
		if(h<high) sort(arr, l+1, high);
	}

	private void println(int[] arr) {
		// TODO Auto-generated method stub
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+";");
		}
	}
	@Test
	 public void test1(){
		int[] a = new int[]{98,75,66,58,51,35,15,31,48,52};
		sort(a, 0, a.length-1);
		
	}
}
