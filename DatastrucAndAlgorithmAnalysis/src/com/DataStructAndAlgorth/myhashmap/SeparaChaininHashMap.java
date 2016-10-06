package com.DataStructAndAlgorth.myhashmap;

import java.util.List;

public class SeparaChaininHashMap<AnyType> {
	public SeparaChaininHashMap(){
	}
	
	public SeparaChaininHashMap(int size){}
	
	public void insert(AnyType x){}
	
	public void remove(AnyType x){}
	
	public boolean cotain(AnyType x){
		return false;
	}
	
	public void makeEmpty(){}
	
	public static final int DEFALT_TABLE_SIZE = 101;
	
	private List<AnyType> [] theLists;
	
	private int currentsize;
	
	private void rehash(){}
	
	private static int nextPrime(int n){
		return 1;
	}
	
	private static boolean isPrime(int n){
		return false;
	}
	
	/**
	 * 自己设定hash的算法
	 */
	private int myhash(AnyType e){
		int hashVal = e.hashCode();
		hashVal %= theLists.length;
		if(hashVal<0){
			hashVal += theLists.length;
		}
		return hashVal;
	}
}
