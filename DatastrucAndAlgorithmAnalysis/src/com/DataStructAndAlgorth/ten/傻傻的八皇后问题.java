package com.DataStructAndAlgorth.ten;
/**
 * 
 */
import java.util.ArrayList;
import java.util.List;

public class 傻傻的八皇后问题 {
	
	public static void main(String[] args) {
		ArrayList<Queen> chesr =  new ArrayList<>();
		long	start = System.nanoTime();
		chesr.add(new Queen(5, 5));
		chesr.add(new Queen(5, 4));
		chesr.add(new Queen(4, 2));
		int i=0;
		while(checck(chesr)!=true||chesr.size()<8){
//			System.out.println(i++);
			chesr.clear();
			boolean[][] cheese = chese(chesr);
			while(chesr.size()<8){
				int x = (int) (Math.random()*8);
				int y = (int) (Math.random()*8);
				Queen te =new Queen(x, y);
				if(chesr.contains(te)||!cheese[x][y]){
					boolean temp = false;
					for(int t1=0;t1<8;t1++){
						for(int t2=0;t2<8;t2++){
							temp =temp||cheese[t1][t2];
						}
					}
					if(temp){
						continue;						
					}else{
						break;
					}
				}else{
					chesr.add(te);
					cheese = chese(chesr);
				}
			}
		}
		long endtime = System.nanoTime();
//		print(chesr);
		System.out.println(endtime-start);
		
	}
// 满足条件的话 返回 true 
	private static boolean checck(ArrayList<Queen> chesr) {
		// TODO Auto-generated method stub
		boolean[][] cr = new boolean[8][8];
		boolean res= true;
		for(int i=0;i<8;i++){
			for(int j=0;j<8;j++){
				cr[i][j] = true;
			}
		}
		for(Queen quee : 	chesr){
			if(!cr[quee.x][quee.y]){
				res = false; 
				return res;
			}else{
				for(int i=0;i<8;i++){
					cr[quee.x][i] = false;
					cr[i][quee.y] = false;
				}
				//斜线右下 
				int i=quee.x,j=quee.y;
				while(0<=i&i<8&&0<=j&&j<8){
					cr[i++][j++] =false;
				}
				//斜线左下 
				i=quee.x;
				j=quee.y;
				while(0<=i&i<8&&0<=j&&j<8){
					cr[i--][j++] =false;
				}
				//斜线左上
				i=quee.x;
				j=quee.y;
				while(0<=i&i<8&&0<=j&&j<8){
					cr[i--][j--] =false;
				}
				//斜线右上
				i=quee.x;
				j=quee.y;
				while(0<=i&i<8&&0<=j&&j<8){
					cr[i++][j--] =false;
				}
			}
		}
		return res;
	}
	public static void print(List<Queen> chesr){
		for(Queen que :chesr){
			System.out.println("x:"+que.x+";+y:"+que.y);
		}
	}
	private static boolean[][] chese(ArrayList<Queen> chesr) {
		// TODO Auto-generated method stub
		boolean[][] cr = new boolean[8][8];
		boolean res= true;
		for(int i=0;i<8;i++){
			for(int j=0;j<8;j++){
				cr[i][j] = true;
			}
		}
		for(Queen quee : 	chesr){
			if(!cr[quee.x][quee.y]){
				res = false; 
			}else{
				for(int i=0;i<8;i++){
					cr[quee.x][i] = false;
					cr[i][quee.y] = false;
				}
				//斜线右下 
				int i=quee.x,j=quee.y;
				while(0<=i&i<8&&0<=j&&j<8){
					cr[i++][j++] =false;
				}
				//斜线左下 
				i=quee.x;
				j=quee.y;
				while(0<=i&i<8&&0<=j&&j<8){
					cr[i--][j++] =false;
				}
				//斜线左上
				i=quee.x;
				j=quee.y;
				while(0<=i&i<8&&0<=j&&j<8){
					cr[i--][j--] =false;
				}
				//斜线右上
				i=quee.x;
				j=quee.y;
				while(0<=i&i<8&&0<=j&&j<8){
					cr[i++][j--] =false;
				}
			}
		}
		return cr;
	}
}

class Queen {
	int x;
	int y;
	public Queen(int x, int y) {
		this.x = x;
		this.y = y;
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub		
		Queen te = (Queen) obj;
		return (this.x==te.x)&&(this.y==te.y);
	}
}
