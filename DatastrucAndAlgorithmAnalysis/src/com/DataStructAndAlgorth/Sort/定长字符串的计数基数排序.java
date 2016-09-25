package com.DataStructAndAlgorth.Sort;

public class 定长字符串的计数基数排序 {
	/**
	 * Counting radix sort an array of Strings
	 * Assume all are all ASCII
	 * Auusume all have same length 
	 */
	public void countingRadixSort(String[] arr,int stringlen){
		final int BUCKETS = 256;
		
		int N = arr.length;
		String [] buffer = new String[N];
		
		String[] in = arr;
		String[] out = buffer;
		//从字符串的最后开始慢慢往前面 算  因为最大位上的数组 一定优先决定最后的排序
		for(int pos = stringlen-1;pos>=0;pos--){
			//设置使用count 来保存每个组 index 这样可以在数组中减少考虑位置
			int[] count = new int[BUCKETS+1];
		
			
			for(int i=0;i<N;i++)
				count[in[i].charAt(pos)+1]++;
			
			//count 保存当亲的ascll码建立 的bucket的index 当赋值结束后 这边的容量要++ 
			for(int b=1;b<=BUCKETS;b++)
				count[b]+=count[b-1];
		
			for(int i=0;i<N;i++)
				out[count[in[i].charAt(pos)]++] = in[i];
			//swap in out roles 
			String [] temp = in;
			in = out;
			out = temp;
		}
		
			//if odd number of passes,in is buffer,out is arr;so copy back
		if(stringlen %2 ==1){
			for(int i=0;i<arr.length;i++){
				out[i] = in[i];
			}
		}
	}
}
