package com.violin.hihocode;
import java.util.Scanner;


public class 延迟优化 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		long Q = scan.nextLong();
		int[] array = new int[N];
		int k;
		for(int i=0;i<N;i++){
			array[i] = scan.nextInt();
		}
		int min =1,max = N;
		if(CountSP(array, max, Q)==-1){
			System.out.println(-1);
			return;
		}
		while(min!=max){
			int mean = (int)((min+max)/2);
			if(CountSP(array, mean, Q)==-1){
				min = mean +1;
			}else{
				max = mean;
			}
		}
		System.out.println(min);
	}
	public static int CountSP(int[] array, int k,long q){
		int[] heap = new int[k];
		int step = 1;
		int sum=0;
		for(int i=0;i<k;i++){
			heap[i] = array[i];
		}
		//重新初始化这个堆 
		for(int i=k/2-1;i>=0;i--){
			perDown(heap, i, k);
		}
		//对于下面的参数 进一个 推出去一个 计算总量 传入阀值break会快一点
		int i;
		for(i=k;i<array.length;i++){
			sum += step * heap[0];
			if(sum>q){
//				System.out.println(k+":"+sum);
				return -1;
			}
			heap[0] = array[i];			
			perDown(heap,0,k);
			step++;
		}
		for(int j=k-1;j>=0;j--){
			sum += step*heap[0];
			int val = heap[0];
			if(sum>q){
//				System.out.println(k+":"+sum);
				return -1;
			}
			heap[0] = heap[j];
			heap[j] = val;
			perDown(heap,0,j);
			step++;
		}
//		System.out.println(k+":"+sum);
		if(i!=array.length){
			return -1;
		}else{
			return 1;
		}
	}
	private static int leftchild(int i){
		return (i*2+1);
	}
	public static void perDown(int[] a,int i,int n){
		int tmp;
		int child;
		for(tmp =a[i];leftchild(i)<n;i=child){
			child= leftchild(i);
			if(child<n-1&&a[child]<a[child+1]){
				child++;
			}
			if(a[i]<a[child]){
				a[i] = a[child];
			}else{
				break;
			}
		}
		a[i] = tmp;
	}
}
