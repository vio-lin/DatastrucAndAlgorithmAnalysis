package com.violin.qlcode;

import java.util.Stack;

public class CleanMachine {
	public static Stack<Integer> root;
	public static void main(String[] args) {
		int x;
		int y;
		
		// 100000000000吧
		String problem = "level=6&x=5&y=5&map=1000000110000000000000000";
		String[] slice = problem.split("&");
		String level = slice[0].substring(slice[0].indexOf("=") + 1);
		 x = Integer.valueOf(slice[1].substring(slice[1].indexOf("=") + 1));
		 y = Integer.valueOf(slice[2].substring(slice[2].indexOf("=") + 1));
		int[][] map = new int[x+2][y+2];
		for (int i = 0; i < x+2; i++) {
			for (int j = 0; j < y+2; j++) {
				if(i!=0&&j!=0&&i!=x+1&&j!=y+1){
					map[i][j] = Integer.valueOf(slice[3].substring(4 + (i -1)* y + (j-1), 4+ (i-1) * y + j ));		
//					System.out.println((4 + (i -1)* y + (j-1)));
				}else{
					map[i][j]=1;
				}
			}
		}
		// 上面是数据的读入的所有操作了
		//路径
		root  = new Stack<Integer>();
		//起始点 x，y
		int posx=0,posy=0;
		//这边先设一个可以从原始图形和路径计算后面得到的图
		//回溯的时候需要原来的图 还有就是这边怎么确定这个方向没有去过
		for(int i=1;i<x-1;i++){
			for(int j=1;j<y-1;j++){
				System.out.println();
				if(find(map,i,j)){
					System.out.println((i)+";"+(j));
					break;
				}	
			}
		}
		for(int i =0;i<root.size();i++){
			int d=root.get(i);
			if(d==0){
				System.out.print("r");
			}
			if(d==1){
				System.out.print("l");
			}
			if(d==2){
				System.out.print("d");
			}
			if(d==3){
				System.out.print("u");
			}
		}
		
	
	}

	private static boolean find(int[][] m, int posx, int posy) {
		// TODO Auto-generated method stub
		int[][] map =m;
		for(int d=0;d<4;d++){
			int p=0,s=0;
			if(d==0){
				p=0;s=1;
			}
			if(d==1){
				p=0;s=-1;
			}
			if(d==2){
				p=1;s=0;
			}
			if(d==3){
				p=-1;s=0;
			}
			if(map[posx+p][posy+s]!=1){
				root.push(d);
				while(map[posx+p][posy+s]!=1){
					posx+=p;
					posy+=s;
					map[posx][posy] =1;
				}
				find(map,posx,posy);
			}
		}
		for(int i=0;i<map.length;i++){
			for(int j=0;j<map[0].length;j++){
				if(map[i][j]==0){
					return false ;
				}
			}
		}
		return true;
	}
	
}
