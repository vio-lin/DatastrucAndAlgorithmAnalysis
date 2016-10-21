package com.violin.Map;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/**
 * 用队列做的 写法。应该是图的广度优先遍历
 * 
 * @author lin
 *
 */
public class 无权最短路径的算法 {
	public static int MAX_VALUE = Integer.MAX_VALUE;
	private static int[][] vertexs;
 	public static void main(String[] args) {		
		vertexs = new int[7][7];
		for(int i=0;i<7;i++){
			for(int j=0;j<7;j++){
				vertexs[i][j] = MAX_VALUE;
			}
		}
		vertexs[2][0]=1;vertexs[2][5]=1;
		vertexs[0][3]=1;vertexs[0][1]=1;
		vertexs[3][6]=1;vertexs[1][4]=1;
		vertexs[4][6]=1;vertexs[6][5]=1;
		vertexs[3][2]=1;vertexs[1][3]=1;
		vertexs[3][5]=1;vertexs[3][4]=1;
		List<Integer> list = new ArrayList<>();
		list.add(2);
		unweightted(2,list);
		System.out.println(list);
 	}
	private static void unweightted(int s,List<Integer> list) {
		// TODO Auto-generated method stub
		LinkedList<Integer> queue=new LinkedList<>();
		queue.add(s);
		while(!queue.isEmpty()){
			int temp = queue.pop();
			for(int i=0;i<vertexs.length;i++){
				if(vertexs[temp][i]==1&&!(list.contains(i))){
					queue.offer(i);
					list.add(i);
				}
			}
		}
		
	}
 	
}
