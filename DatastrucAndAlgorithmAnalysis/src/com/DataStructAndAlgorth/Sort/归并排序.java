package com.DataStructAndAlgorth.Sort;

import com.violin.qlcode.上古卷轴相关;

public class 归并排序 {
	public static void main(String[] args) {
		int[] a = new int[] {15,25,3,45,21,5,54,8,21,5,2};
		int[] b = new int[a.length];
		mergeSort(a);
		for(int i=0;i<a.length;i++){
			System.out.print(a[i]+" ");
		}
	}

	private static void mergeSort(int[] a, int[] b, int left,int right) {
		// TODO Auto-generated method stub
		if(left<right){
			int center = (left+right)/2;
			mergeSort(a,b,left,center);
			mergeSort(a,b,center+1,right);
			merge(a,b,left,center+1,right);
		}
	}
	/**
	 * Internal method that merge two sorted halves of a subway
	 * @param a an array of comparable items.
	 * @param b temArray a array to place the merger result 
	 * @param leftPos leftPos the left-most index of the subarray
	 * @param  rightPos the index of the start of the second half
	 * @param rightEnd the right_most index of the subarray
	 */
	private static void merge(int[] a, int[] tmpArray, int leftPos, int rightPos, int rightEnd) {
		// TODO Auto-generated method stub
		int leftEnd = rightPos-1;
		int tmpPos = leftPos;
		int numElements = rightEnd - leftPos +1;
		
		//Main loop 
		while(leftPos<=leftEnd&&rightPos<=rightEnd){
			if(a[leftPos]>a[rightPos])
				tmpArray[tmpPos++] = a[leftPos++];
			else 
				tmpArray[tmpPos++] = a[rightPos++];
		}
		while(leftPos<=leftEnd){
			tmpArray[tmpPos++] = a[leftPos++];
		}
		while(rightPos<=rightEnd){
			tmpArray[tmpPos++] = a[rightPos++];
		}
		//Copy tmpArray back
		for(int i=0;i<numElements;i++,rightEnd--){
			a[rightEnd] = tmpArray[rightEnd];
		}
	}

	public static void mergeSort(int[] a){
		int[] tmpArray = new int[a.length];
		mergeSort(a,tmpArray,0,a.length-1);
	}
}
