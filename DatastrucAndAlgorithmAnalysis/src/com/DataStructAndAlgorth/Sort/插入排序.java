package com.DataStructAndAlgorth.Sort;
/**
 * 插入排序 分别使用两种 后面一种做的加快还会比较少
 * 分别从数组的第二位开始查询   假设从小到大排列  
 * 发现后面的一个数比前面小的话 开始把前面的数字后移 
 * 直到找到对应的位置进行插入
 * @author lin
 *
 */
public class 插入排序 {
	public static void main(String[] args) {
		int[] a = { 1, 24, 6, 6, 4, 5, 6, 5, 7, 45, 5, 6, 67, 67, 56,1, 24, 6, 6, 4, 5, 6, 5, 7, 45, 5, 6, 67, 67, 56 };
		long time = System.currentTimeMillis();
		for (int i = 1; i < a.length; i++) {
			sort1(a, i);
		}
		System.out.println((time-System.currentTimeMillis()));
		for (int i = 1; i < a.length; i++) {
			System.out.print(a[i]+";");
		}
	}

	private static void sort(int[] a, int i) {
		// TODO Auto-generated method stub
		while (i >= 1) {
			if (a[i] < a[i - 1]) {
				change(a, i);
				i--;
			}else{
				return;
			}
		}
	}

	private static void change(int[] a, int i) {
		// TODO Auto-generated method stub
		int temp = a[i];
		a[i] =a[i-1];
		a[i-1] = temp;
	}
	private static void sort1(int[] a, int i) {
		// TODO Auto-generated method stub
		int temp = a[i];
		int j;
		for( j=i;a[j]<temp&&j>1;j--)
			a[j--] = a[j];
		a[j]=temp;
	}
}
