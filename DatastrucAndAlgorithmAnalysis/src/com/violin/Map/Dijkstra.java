package com.violin.Map;

import java.util.LinkedList;
import com.DataStructAndAlgorth.Sort.test;

/**
 * 估计真的是一个英文记得比中文来厉害的东西 基本的思想什么都ok 就是直接是实现好了
 * 
 * @author lin
 * 
 */
public class Dijkstra {
	public static int[][] vertexs;

	public static void main(String[] args) {
		vertexs = new int[7][7];
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 7; j++) {
				vertexs[i][j] = Integer.MAX_VALUE;
			}
		}
		vertexs[2][0] = 3;
		vertexs[0][1] = 2;
		vertexs[1][4] = 10;
		vertexs[4][6] = 6;
		vertexs[6][5] = 1;
		vertexs[2][5] = 5;
		vertexs[3][2] = 2;
		vertexs[0][3] = 1;
		vertexs[1][3] = 3;
		vertexs[3][4] = 2;
		vertexs[3][6] = 4;
		vertexs[3][5] = 8;
//		for (int i = 0; i < vertexs.length; i++) {
//			for (int j = 0; j < vertexs.length; j++) {
//				if (vertexs[i][j] < 1000) {
//					System.out.format("%2d ", vertexs[i][j]);
//				} else
//					System.out.print(" - ");
//			}
//			System.out.println();
//		}
		int[] dis = new int[vertexs.length];
		for (int i = 0; i < dis.length; i++) {
			dis[i] = Integer.MAX_VALUE;
		}
		LinkedList<Integer> list = new LinkedList<>();
		list.add(0);
		dis[0] = 0;
		dijkstra(vertexs, list, dis);
		for (int i = 0; i < dis.length; i++) {
			System.out.print((i + 1) + ":" + dis[i]+"   ");
		}
	}

	private static void dijkstra(int[][] vertexs, LinkedList<Integer> list,
			int[] dis) {
		// TODO Auto-generated method stub
		// 现在初始化什么都不用管了
		// 利用一个表来保存已经知道的参数
		// 从下面一个为止的参数中 选择一条最小的道路 返回的东西有两个。 一个是
		while (list.size() < vertexs.length) {
			int min = Integer.MAX_VALUE;
			int start = -1;
			int end = -1;
			for (int s : list) {
				for (int i = 0; i < vertexs.length; i++) {
					if (vertexs[s][i] != Integer.MAX_VALUE && !list.contains(i)) {
						if (vertexs[s][i] < min) {
							start = s;
							end = i;
						}
					}
				}
			}

			list.add(end);
			dis[end] = dis[start]+vertexs[start][end];
			for (int i = 0; i < vertexs.length; i++) {
				if (vertexs[end][i] != Integer.MAX_VALUE) {
					if (list.contains(i)) {
						int cvw = vertexs[end][i];
						if (dis[end] + cvw < dis[i]) {
							// update w
							dis[i] = dis[end] + cvw;
						}
					}
				}
			}
		}
	}
}
