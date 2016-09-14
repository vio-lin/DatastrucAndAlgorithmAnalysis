package com.DataStructAndAlgorth.Sort;

import java.util.Comparator;
/**
 *  基于二叉树的优先队列
 * 
 * @author guolin
 *
 * @param <AnyType>
 */
public class 优先队列堆 <AnyType extends Comparable<? super AnyType>>  {
	//3发不同的构造函数
	public 优先队列堆(){}
	public 优先队列堆(int capacity){}
	/**
	 * Construct the binary heap queue any an array of items
	 */

	public 优先队列堆(AnyType[] items){
		currentSize = items.length;
		array  = (AnyType[]) new Comparable[(currentSize+2)*11/10];
		int i = 1;
		for(AnyType item:items)
			array[i++] = item;
		buildHeap();
	}
	//设定一些基本的操作
	public AnyType findMin(){
		return null;
	}
	/**
	 * Remove the smallrest item from the priority queue 
	 * 
	 * @return the smallerst item ,or throw UndeflowException,id empty
	 * @throws Exception 
	 */
	public AnyType deleteMin() throws Exception{
		if(isEmpty()){
			throw new Exception();
		}
		AnyType minItem = findMin();
		array[1] = array[currentSize--];
		percolateDown(1);
		return minItem;
	}
	public boolean isEmpty(){
		return false;
	}
	public void makeEmpty(){
	}
	/**
	 * Insert into the priority queue,maintaining heap order
	 * Duplicate are allowed
	 * @param x the data insert into queue
	 */
	public void insert (AnyType x){
		if(currentSize == array.length-1)
			enlarageArray(array.length*2+1);
		int hole = ++currentSize;
		for(array[0] = x;x.compareTo(array[hole/2])<0;hole/=2){
			array[hole] = array[hole/2];
		array[hole] =x;
		}
	}

	//下面新建的方法 都是 private 的原因是安全吗
	private static final int DEFAULT_CAPACITY = 10;
	private int currentSize; //number of the elements in the heap
	private AnyType[] array; //the  data structure to save the  data 
	/**
	 * Intrernal method to percolate down in the heap 
	 * @param hole the index  at which the percolate begin;
	 */
	private void percolateDown(int hole){
		int child ;
		AnyType tmp = array[hole];
		for(;hole*2<=currentSize;hole=child){
			child = hole*2;
			//child 下面是他的孩子 假如下面的孩子比他本身还要小那么选择下面比较小的孩子做继续下沉处理
			// 一般的compare 的理解 把他放在后面表示前面减去后面 返回值为 -1 0 1 三个的一个
			if(child!=currentSize&&array[child+1].compareTo(array[child])<0)
				child++;
	//chil比father小的时候继续往下面移动 直到出现 child比father大
			if(array[child].compareTo(tmp)<0)
				array[hole] = array[child];
			else 
				break;
		}
		array[hole] = tmp;
	}
	/**
	 * Establish heap order property from an arbitrary 
	 * arrangement of items.runs in linear time	
	 */
	private void buildHeap() {
		// TODO Auto-generated method stub
		for(int i = currentSize/2;i>0;i--){
			percolateDown(i);
 		}
	}	
	private void enlarageArray(int newSize){
	}
}
