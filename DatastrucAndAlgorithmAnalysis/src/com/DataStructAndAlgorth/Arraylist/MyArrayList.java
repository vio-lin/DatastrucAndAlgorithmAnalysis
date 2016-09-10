package com.DataStructAndAlgorth.Arraylist;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyArrayList<AnyType> implements Iterable<AnyType> {
	private static final int DEFAULT_CAPACITY = 10;
	
	private int theSize; 
	private AnyType[]  theItems;
	
	/**
	 * 构造函数 先进行数据的清理
	 */
	public MyArrayList(){
		{doclear();}
	}
	/**
	 * 数据的清理 主要有数据数量为0 并且对于capability进行确认
	 * 防止外部直接调用 modift 使用private
	 */
	private void doclear() {
		// TODO Auto-generated method stub			}
		{
			this.theSize = 0;
			ensureCapacity(DEFAULT_CAPACITY);
			
		}
	}
	public	AnyType get(int index){
		if(index<0||index>=size()){
			throw new ArrayIndexOutOfBoundsException();
		}
		return theItems[index];
	}
	/**
	 * 确认这边新的大小 截断大小之类的把
	 * @param newCapability
	 */
	public void ensureCapacity(int newCapability) {
		// TODO Auto-generated method stub
		if(newCapability<theSize)
			return;
		AnyType[] old = theItems;
		theItems = (AnyType[]) new Object[newCapability];
		for(int i=0;i<size();i++){
			theItems[i] = old[i];
		}
	}
	public int size(){
		return theSize;
	}
	
	public boolean isEmpty(){
		return (size()==0);
	}
	public void trimToSize(){
		ensureCapacity(size());
	}
	
	/**
	 * 提供给外部 访问clear 的方法
	 */
	public void clear() {
		// TODO Auto-generated method stub
		doclear();
	}
	
	public AnyType set(int index,AnyType newVal){
		if(index<0||index>=size()){
			throw new ArrayIndexOutOfBoundsException();
		}
		AnyType old = theItems[index];
		theItems[index] = newVal;
		return old;
	}
	
	public boolean add(AnyType x){
		add(size(),x);
		return true;
	}
	
	public void add(int index,AnyType x){
		if(theItems.length==size())
			ensureCapacity(size()*2+1);
		for(int i = theSize;i>index;i--)
			theItems[i] = theItems[i-1];
		theItems[index] = x;
		theSize++;
	}
	
	public AnyType remove(int idx){
		AnyType removeType = theItems[idx];
		for(int i=idx;i<size();i++)
			theItems[i] =theItems[i+1];
		theSize--;
		return removeType;
	}
	
	public Iterator<AnyType> iterator(){
		return new ArrayListIterator();
	}
	
	private class  ArrayListIterator implements Iterator<AnyType>{
		private int current = 0;
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return current<size();
		}

		@Override
		public AnyType next() {
			// TODO Auto-generated method stub
			if(!hasNext()){
				throw new NoSuchElementException();
			}
			return theItems[current++];
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			{
				MyArrayList.this.remove(--current);
			}
		}
	}
}

