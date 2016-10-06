package com.DataStructAndAlgorth.Sort;

public class test {
	public static void main(String[] args) {
		int[] array = new int[]{15,25,3,45,21,5,54,8,21,5,2};
		int[] temp = new int[array.length];
		mergesort(array,temp,0,array.length-1);
		for(int i=0;i<array.length;i++){
			System.out.print(array[i]+";");
		}
	}

	private static void mergesort(int[] array, int[] temparray, int left, int right) {
		// TODO Auto-generated method stub
		if(left<right){
			int center = (left+right)/2;
			mergesort(array, temparray, left, center);
			mergesort(array, temparray, center+1, right);
			merge(array,temparray,left,center,right);
		}
	}

	private static void merge(int[] array, int[] temparray, int left,
			int center, int right) {
		// TODO Auto-generated method stub
		int leftstart = left;
		int rightstart = center+1;
		int index = left;
		while(leftstart<=center&&rightstart<=right){
			if(array[leftstart]<=array[rightstart]){
				temparray[index++] = array[leftstart++];
			}else{
				temparray[index++] = array[rightstart++];
			}
		}
		if(leftstart>center){
			while(rightstart<=right){
				temparray[index++] = array[rightstart++];
			}
		}else{
			while(leftstart<=center){
				temparray[index++] = array[leftstart++];
			}
		}
		index = left;
		while(index<=right){
			array[index] = temparray[index];
			index++;
		}
	}
}
