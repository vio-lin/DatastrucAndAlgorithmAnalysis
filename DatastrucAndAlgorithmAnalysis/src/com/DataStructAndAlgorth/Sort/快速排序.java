package com.DataStructAndAlgorth.Sort;

public class 快速排序 {
	public static void main(String[] args) {
		int[] arr = new int[]{15,65,4,89,1,5,6,2,18,7,68,9,27};
		_quicksort(arr,0,arr.length-1);
		print(arr);
	}

	private static void print(int[] arr) {
		// TODO Auto-generated method stub
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+" ");
		}
	}

	private static void _quicksort(int[] arr, int left, int right) {
		// TODO Auto-generated method stub
		if(left<right){
			int i = quicksort(arr, left, right);
			_quicksort(arr, left,i-1);
			_quicksort(arr, i+1, right);		
		}
	}

	private static int quicksort(int[] arr, int left, int right) {
		// TODO Auto-generated method stub
		int temp = arr[left];
		while(left<right){
			while(temp<arr[right]&&left<right){
				right--;
			}
			arr[left] = arr[right];
			while(temp>arr[left]&&left<right){
				left++;
			}
			 arr[right]=arr[left];
		}
		arr[left] = temp;
		return left;
	}
}
