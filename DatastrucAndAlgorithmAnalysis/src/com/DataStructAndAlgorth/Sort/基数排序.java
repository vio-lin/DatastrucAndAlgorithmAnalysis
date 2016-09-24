package com.DataStructAndAlgorth.Sort;

import java.util.ArrayList;

/**
 *  Raix sort an array of String 
 *  assume all are all ASCALL
 *  Assum all have  same length
 * @author lin
 *
 */
public class 基数排序 {
	public static void radixSorta(String[] arr, int length){
		final int BUCKETS = 256;
		//在实际当中这样定义 会产生问题 在书上的 相关代码 ： ArrayList<String> [] buckets = new ArrayList<>[BUCKETS];
		ArrayList<String>[] buckets = new ArrayList[BUCKETS];
		
		//每个metadata的 范围 ascall 总共是256 
		for(int i = 0;i<BUCKETS;i++)
			buckets[i] = new ArrayList<String>(); 
		
		for(int pos = length-1;pos >= 0;pos--){
			for(String s : arr)
				buckets[s.charAt(pos)].add(s);
			int indx=0;
			for(ArrayList<String> thisBucket : buckets){
				for(String s : thisBucket)
					arr[indx++] = s;
				thisBucket.clear();
			}
		}
	}
	
	//中间使用了 关于数字和字符串的自动装换。 在char中直接转变成数字。 数组的下边的正确使用方式
	public static void main(String[] args){
		String[] arr = "asd,rtf,fds,ghg,ftr,fds,sad,sds".split(",");
		radixSorta(arr,3);
		for(int i=0;i<arr.length;i++){
			System.out.println(arr[i]);
		}
	} 
}
