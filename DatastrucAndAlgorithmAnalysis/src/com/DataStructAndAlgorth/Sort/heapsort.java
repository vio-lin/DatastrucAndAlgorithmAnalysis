package com.DataStructAndAlgorth.Sort;

public class heapsort {
	public static void main(String[] args) {
		Integer[] array = new Integer[]{5,1,3,6,8,7,9,2,4,0};
		heapsort(array);
		for(Integer i : array){
			System.out.print(i+";");
		}
	}
	//几个重要的函数
	//搜寻父树函数 
	private static int leftchild(int i){
		return 2*i+1;
	}
	private static <AnyType extends Comparable<? super AnyType>>void perDown(AnyType[] a,int i,int n) {
		// TODO Auto-generated method stub
		int child;
		AnyType tmp;
		for(tmp = a[i];leftchild(i)<n;i=child){
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
	void heapsort(AnyType[] a){
		for(int i=a.length/2-1;i>=0;i--){ //构建堆
			perDown(a,i,a.length);
		}
		for(int i=a.length-1;i>0;i--){
			swapReferebce(a,0,i);
			perDown(a,0,i);
		}
	} 
	
	private static <AnyType extends Comparable<? super AnyType>> 
	void swapReferebce(AnyType[] a, int i,int n){
		AnyType temp = a[i];
		a[i] = a[n];
		a[n] = temp;
	}
}
