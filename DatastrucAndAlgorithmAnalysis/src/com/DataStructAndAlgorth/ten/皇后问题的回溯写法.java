package com.DataStructAndAlgorth.ten;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/**
 * 真心没有随机快  真是坑
 * @author lin
 */
public class 皇后问题的回溯写法 {

	public static void main(String[] args) {
		ArrayList<Queen> chesr = new ArrayList<>();
		long start = System.nanoTime();
		backtracking(chesr);
		int i = 0;
		long endtime = System.nanoTime();
		// print(chesr);
		System.out.println(count);
		System.out.println(endtime - start);

	}

	public static int count = 0;
	public static Map<ArrayList<Queen>, Character> result;

	private static boolean backtracking(ArrayList<Queen> chesr) {
		// TODO Auto-generated method stub
		boolean[][] temp = chese(chesr);
		if (chesr.size() == 8 && checck(chesr)) {
			return true;
		} else {
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8; j++) {
					if (temp[i][j]) {
						chesr.add(new Queen(i, j));
						count++;
						if (result.get(chesr) != null) {
							if (result.get(chesr)=='T') {
								return true;
							} else {
								chesr.remove(new Queen(i, j));
								break;
							}
						}else{
							if (backtracking(chesr)) {
								return true;
							} else {
								result.put(chesr,'F');
								chesr.remove(new Queen(i, j));
								break;
							}
						}

					}
				}
			}
			return false;
		}
	}

	// 满足条件的话 返回 true
	private static boolean checck(ArrayList<Queen> chesr) {
		// TODO Auto-generated method stub
		boolean[][] cr = new boolean[8][8];
		boolean res = true;
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				cr[i][j] = true;
			}
		}
		for (Queen quee : chesr) {
			if (!cr[quee.x][quee.y]) {
				res = false;
				return res;
			} else {
				for (int i = 0; i < 8; i++) {
					cr[quee.x][i] = false;
					cr[i][quee.y] = false;
				}
				// 斜线右下
				int i = quee.x, j = quee.y;
				while (0 <= i & i < 8 && 0 <= j && j < 8) {
					cr[i++][j++] = false;
				}
				// 斜线左下
				i = quee.x;
				j = quee.y;
				while (0 <= i & i < 8 && 0 <= j && j < 8) {
					cr[i--][j++] = false;
				}
				// 斜线左上
				i = quee.x;
				j = quee.y;
				while (0 <= i & i < 8 && 0 <= j && j < 8) {
					cr[i--][j--] = false;
				}
				// 斜线右上
				i = quee.x;
				j = quee.y;
				while (0 <= i & i < 8 && 0 <= j && j < 8) {
					cr[i++][j--] = false;
				}
			}
		}
		return res;
	}

	private static boolean[][] chese(ArrayList<Queen> chesr) {
		// TODO Auto-generated method stub
		boolean[][] cr = new boolean[8][8];
		boolean res = true;
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				cr[i][j] = true;
			}
		}
		for (Queen quee : chesr) {
			if (!cr[quee.x][quee.y]) {
				res = false;
			} else {
				for (int i = 0; i < 8; i++) {
					cr[quee.x][i] = false;
					cr[i][quee.y] = false;
				}
				// 斜线右下
				int i = quee.x, j = quee.y;
				while (0 <= i & i < 8 && 0 <= j && j < 8) {
					cr[i++][j++] = false;
				}
				// 斜线左下
				i = quee.x;
				j = quee.y;
				while (0 <= i & i < 8 && 0 <= j && j < 8) {
					cr[i--][j++] = false;
				}
				// 斜线左上
				i = quee.x;
				j = quee.y;
				while (0 <= i & i < 8 && 0 <= j && j < 8) {
					cr[i--][j--] = false;
				}
				// 斜线右上
				i = quee.x;
				j = quee.y;
				while (0 <= i & i < 8 && 0 <= j && j < 8) {
					cr[i++][j--] = false;
				}
			}
		}
		return cr;
	}

	public static void print(List<Queen> chesr) {
		for (Queen que : chesr) {
			System.out.println("x:" + que.x + ";+y:" + que.y);
		}
	}
}
