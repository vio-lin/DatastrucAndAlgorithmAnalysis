package com.DataStructAndAlgorth.Sort;
/**
 * 用于实现堆排序的类 
 * @author lin
 *
 */
public class 堆排序 {
	/**
	 * Internal method for heapsort
	 * @param i the index of an item in the heap
	 * @return the index of the left child 
	 */
	private static int leftchild(int i){
		return 2*i+1;
	}
	/**
	 * Internal method for heapsort that is used in deleteMax and buildHeap  
	 * @param a anarray of comparable items
	 * @param i the position from which to perco;ate down 
	 * @param n the logical size of the binary heap
	 */
	private static <AnyType extends Comparable<? super AnyType>>
	void perDown(AnyType [] a,int i,int n){
		int child;
		AnyType tmp;
		for(tmp=a[i];leftchild(i)<n;i=child){
			child = leftchild(i);
			if(child!=n-1&&a[child].compareTo(a[child+1])<0)
				child++;
			if(tmp.compareTo(a[child])<0)
				a[i] = a[child];
			else 
				break;
		}
		a[i] = tmp;
	}
	public static <AnyType extends Comparable<? super AnyType>>
	void heapsort(AnyType [] a){
		for(int i = a.length/2-1;i>=0;i--){ //build dheap
			perDown(a, i, a.length);
		}
		for(int i=a.length-1;i>0;i--){
//			swapReference(a,0,i);
			perDown(a, 0, i);
		}
	}
	public static void main(String[] args) {
		Integer[] arra = new Integer[]{8,4,5,6,2,1,3,9,7,0};
		heapsort(arra);
		for(Integer i:arra){
			System.out.println(i+";");
		}
		
	}
}
