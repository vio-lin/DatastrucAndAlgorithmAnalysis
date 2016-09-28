package com.data.homework;

import java.lang.Thread.State;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.swing.JFrame;

public class 三连棋 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		MoveInfo game = new MoveInfo();
		while(scan.hasNext()){
				int step = scan.nextInt();	
				while(!game.place(step,JUNMSTATE.HUMAN)){
					System.out.println("输入有错 重新输入");
					step = scan.nextInt();
				}
				game = game.findCompMove();
				game.place(game.move,JUNMSTATE.COM);
				game.show();
				if(game.check()){
					game.initd();
					}
		}
	}
}

class MoveInfo {
	// 防止 递归的重复性  把值存放在当前的位置  主要是key名的确定  分为计算机和人 两类 取第一位为1 或2 来进行区别
	// 后面的数字用于 保存期盼的状态 那么 用来的进行值生成的 函数应该是另外的
	public static Map<String, Integer> result = new HashMap<String, Integer>();
	private static final int DRAW = 1;
	private static final int COM_LOSS = 0;
	private static final int COM_WIN = 2;
	private static int layer=3;
	public int move;
	public int value;
	public static int[][] path = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 },
			{ 1, 4, 7 }, { 2, 5, 8 }, { 3, 6, 9 }, { 1, 5, 9 }, { 3, 5, 7 } };
	
	public static JUNMSTATE place[] = new JUNMSTATE[10];
	
	//static 的代码块 用来进行数组的初始化
	static{
		for (int i = 0; i < 10; i++) {
			place[i] = JUNMSTATE.EMPTY;
		}
	}
	// 定义每一步棋 的value 和 m步数
	/**
	 *  define a step 
	 * @param m  find the next postion
	 * @param v	 the value we can go
	 */
	public MoveInfo(int m, int v) {
		move = m;
		value = v;
	}

	public void initd() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 10; i++) {
			place[i] = JUNMSTATE.EMPTY;
		}
	}

	public boolean check() {
		// TODO Auto-generated method stub
		if(isWin()){
			System.out.println("你输了");
			return	true;
		}
		if(fullBoard()){
			System.out.println("平局");
			return true;
		}
		return false;
	}

	private boolean isWin() {
		// TODO Auto-generated method stub
		for(int i=0;i<path.length;i++){
			int temp=0;
			for(int j=0;j<3;j++){
				if(place[path[i][j]]==JUNMSTATE.COM){
					temp++;
				}
			}
			if(temp==3){
				return true;
			}
		}
		return false;
	}

	//输出期盼的状态
	/**
	 *  to show the  image of the game
	 */
	public void show() {
		// TODO Auto-generated method stub
		for(int i=1;i<10;i++){
			switch(place[i]){
			case EMPTY: System.out.print("|—|");
				break;
			case COM : System.out.print("|O|");
				break;
			case HUMAN: System.out.print("|X|");
				break;
			}
			if(i%3==0)
				System.out.println();
		}
		System.out.println();
	}
	
	/**
	 * inint the game  
	 */
	public MoveInfo() {
		value=COM_LOSS;
	}
	public boolean fullBoard() {
		boolean full = true;
		for(int i=1;i<10;i++){
			if(place[i]==JUNMSTATE.EMPTY){
				full = false;
			}
		}
		return full;
	}
	
	private String generatmapkey(){
		StringBuilder sb = new StringBuilder();
		for(int i=1;i<10;i++){
			switch (place[i]) {
			case COM: sb.append("1");				
				break;
			case EMPTY: sb.append("2");				
				break;
			case HUMAN: sb.append("3");				
				break;
			}
		}
		return sb.toString(); 
	}
	/**
	 * Recurive method to find best move for computer MoveInfo.move return a
	 * number from 1-9 indicating square possible evaluation satisfy
	 * COM_LOSS<DEAW<COM_WIN Complementary memthod findHumanMove is Figure
	 * 
	 * @return
	 */
	public MoveInfo findCompMove() {
		int i, responseValue;
		int value, bestMove = 1;
		MoveInfo quickWinInfo;

		if (fullBoard()) {
			value = DRAW;
			result.put(generatmapkey()+"1", value);
		} else if ((quickWinInfo = immediateComWin()) != null) {
			return quickWinInfo;
		} else {
			value = COM_LOSS;
			for (i = 1; i <= 9; i++) {
				if (isEmpty(i)) {
					place(i, JUNMSTATE.COM);
					String temp = generatmapkey()+"1";
					if(result.get(temp) != null){
						responseValue = result.get(temp);						
					}else{
						result.put(temp, responseValue = findHumanMove().value);						
//						System.out.println(temp);
//						System.out.println(result.size());
					}
					unplace(i);// restore board
					if (responseValue > value) {
						// Update best move
						value = responseValue;
						bestMove = i;
					}
				}
			}
		}
		return new MoveInfo(bestMove, value);
	}

	/**
	 *  redo the position 
	 * @param i
	 */
	private void unplace(int i) {
		// TODO Auto-generated method stub
		place[i] = JUNMSTATE.EMPTY;
	}
	
	/**
	 *	place next step  
	 * @param i
	 * @param sta
	 */
	public boolean place(int i, JUNMSTATE sta) {
		// TODO Auto-generated method stub
		if(place[i]==JUNMSTATE.EMPTY){
			place[i] = sta;			
			return true;
		}
		return false;
	}

	/**
	 * judge the empty
	 * @param i
	 * @return
	 */
	private boolean isEmpty(int i) {
		// TODO Auto-generated method stub
		return place[i] == JUNMSTATE.EMPTY;
	}
	/**
	 * find the best move human does
	 * @return
	 */
	public MoveInfo findHumanMove() {
		int i, responseValue;
		int value, bestMove = 1;
		MoveInfo quickWinInfo;
		if (fullBoard()) {
			value = DRAW;
			result.put(generatmapkey()+"1", value);
		} else if ((quickWinInfo = immediateHumanWin()) != null) {
			return quickWinInfo;
		} else {
			value = COM_WIN;
			for (i = 1; i < 9; i++) {
				if (isEmpty(i)) {
					place(i, JUNMSTATE.HUMAN);
					String temp = generatmapkey()+"2";
					if(result.get(temp) != null){
						responseValue = result.get(temp);
					}else{
						result.put(temp,responseValue = findCompMove().value);
//						System.out.println(result.size());
					}
					unplace(i);// restore board
					if (responseValue < value) {
						// Update best move
						value = responseValue;
						bestMove = i;
					}
				}
			}
//			System.out.println("best"+bestMove);
		}
		return new MoveInfo(bestMove, value);
	}

	// 搜索棋盘发现下一步是人类胜利的状况
	private MoveInfo immediateHumanWin() {
		// TODO Auto-generated method stub
		for (int i = 0; i < path.length; i++) {
			int vic = 0;
			int pos = 0;
			for (int j = 0; j < 3; j++) {
				if (place[path[i][j]] == JUNMSTATE.HUMAN) {
					vic++;
				} else if (place[path[i][j]] == JUNMSTATE.EMPTY) {
					pos = path[i][j];
				}
				if (vic == 2 && pos != 0) {
					result.put(generatmapkey()+"1", COM_LOSS);
					return new MoveInfo(pos, COM_LOSS);
				}
			}
		}
		return null;
	}

	// 搜索棋盘 确定下一步将是可以胜利的状况
	private MoveInfo immediateComWin() {
		// TODO Auto-generated method stub
		for (int i = 0; i < path.length; i++) {
			int vic = 0;
			int pos = 0;
			for (int j = 0; j < 3; j++) {
				if (place[path[i][j]] == JUNMSTATE.COM) {
					vic++;
				} else if (place[path[i][j]] == JUNMSTATE.EMPTY) {
					pos = path[i][j];
				}
				if (vic == 2 && pos != 0) {
					result.put(generatmapkey()+"2",COM_WIN);
					return new MoveInfo(pos, COM_WIN);
				}
			}
		}
		return null;
	}

}

enum JUNMSTATE {
	COM, HUMAN, EMPTY
}

