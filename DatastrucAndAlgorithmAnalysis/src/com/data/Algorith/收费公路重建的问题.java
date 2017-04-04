package com.data.Algorith;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 从 所包含的路径中重新 划分出告诉公路的 原始站点。
 * 路上的节点 为 0 3 5 7 8 
 * 对应的距离 1 3 5 8 2 4 7 2 5 3                     
 * @author guolin
 *
 */
public class 收费公路重建的问题 {
	public static boolean trunpik(int[] x, LinkedList<Integer> dis, int n) {
		x[1] = 0;
		x[n] = dis.pollLast();
		x[n - 1] = dis.pollLast();
		if (dis.contains(Math.abs(x[n] - x[n - 1]))) {
			dis.remove(new Integer(Math.abs(x[n] - x[n - 1])));
			return place(x, dis, n, 2, n - 2);
		}
		return false;
	}

	/**
	 * Backtracking algorithm to place the pouns if the result true then x[left]
	 * - x[right] have values
	 * 
	 * @param x
	 * @param dis
	 * @param n
	 * @param i
	 * @param j
	 * @return
	 */
	private static boolean place(int[] x, LinkedList<Integer> dis, int n,
			int left, int right) {
		// TODO Auto-generated method stub
		int dmax;
		boolean found = false;
		if (dis.isEmpty()) {
			for (int i = 1; i < x.length; i++) {
				System.out.print(i + ":" + x[i] + "   ");
			}
			System.out.println();
			return true;
		}
		dmax = dis.getLast();
		boolean temp = true;
		List<Integer> list = new ArrayList<>();
 		for (int j = 1; j < left; j++) {
			if (dis.remove(new Integer(Math.abs(x[j] - dmax))))
				list.add(Math.abs(x[j] - dmax));
			else
				temp = false;
		}
		for (int j = n; j > right; j--) {
			if (dis.remove(new Integer(Math.abs(x[j] - dmax))))
				list.add(Math.abs(x[j] - dmax));
			else
				temp = false;
		}
		dis.addAll(list);
		Collections.sort(dis);
		list.clear();		
		if (temp) {
			for (int j = 1; j < left; j++) {
				if (dis.remove(new Integer(Math.abs(x[j] - dmax))))
					list.add(Math.abs(x[j] - dmax));		
			}
			for (int j = n; j > right; j--) {
				if (dis.remove(new Integer(Math.abs(x[j] - dmax))))
					list.add(Math.abs(x[j] - dmax));
			}
			x[right] = dmax;
			found = place(x, dis, n, left, right-1);
			if (!found) {
				dis.addAll(list);
				Collections.sort(dis);
				list.clear();
			}
		}
		// 上面的分支失败 转入下次的分支
		temp = true;
		for (int j = 1; j < left; j++) {
			if (dis.remove(new Integer(Math.abs(x[n]-dmax-x[j]))))
				list.add(Math.abs(x[n]-dmax-x[j]));
			else
				temp = false;
		}
		for (int j = n; j > right; j--) {
			if (dis.remove(new Integer(Math.abs(x[n]-dmax-x[j]))))
				list.add(Math.abs(x[n]-dmax-x[j]));
			else
				temp = false;
		}
		dis.addAll(list);
		Collections.sort(dis);
		list.clear();
		if (temp) {
			x[left] = x[n] - dmax;
			for (int j = 1; j < left; j++) {
				if (dis.remove(new Integer(Math.abs(x[n]-dmax-x[j]))))
					list.add(Math.abs(x[n]-dmax-x[j]));
			}
			for (int j = n; j > right; j--) {
				if (dis.remove(new Integer(Math.abs(x[n]-dmax-x[j]))))
					list.add(Math.abs(x[n]-dmax-x[j]));
			}
			found = place(x, dis, n, left + 1, right);
			if (!found) {
				dis.addAll(list);
				Collections.sort(dis);
			}
		}
		return found;
	}

	public static void main(String[] args) {
		LinkedList<Integer> dis = new LinkedList<Integer>();
//		int[] x = new int[7];
//		Integer[] a = new Integer[] { 1, 2, 2, 2, 3, 3, 3, 4, 5, 5, 5, 6, 7, 8,
//				10 };
		int[] x = new int[6];
		Integer[] a = new Integer[] { 1, 3, 5,8,2,4,7,2,5,3};
		dis.addAll(Arrays.asList(a));
		Collections.sort(dis);
		System.out.println(trunpik(x, dis, 5));
	}
}
