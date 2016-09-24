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
		
		for(int pos = stringlen-1;pos>=0;pos--){
			int[] count = new int[BUCKETS+1];
			for(int i=0;i<N;i++)
				count[in[i].charAt(pos)+1]++;
			
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
