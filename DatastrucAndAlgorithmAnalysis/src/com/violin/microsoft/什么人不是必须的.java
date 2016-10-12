package com.violin.microsoft;

import java.util.ArrayList;
import java.util.Scanner;

/*   从原来的输入推算出上面哪个用户不可以删除
 * 5个人  最初要达到  0 
  样本输入
5         5个
1 0  	   1号 可以直接到 0
1 0			2号可以直接到0
2 1 2		3号可以连接1号和2号
1 3			4号可以连接3号
2 4 3		5号可以连接 4号和3号
样例输出
3
 */
public class 什么人不是必须的 {
	public static void main(String[] args) {
		Scanner san = new Scanner(System.in);
		ArrayList<ArrayList<Integer>> pool = new ArrayList<ArrayList<Integer>>();
		while(san.hasNext()){
			int sum = san.nextInt();
			for(int i=0;i<sum;i++){
				ArrayList<Integer> temp = new ArrayList<Integer>();
				int lin = san.nextInt();
				for(int j=0;j<lin;j++){
					int ten =san.nextInt();
					temp.add(ten);
				}
				pool.add(temp);
			}
			for(int i =0;i<pool.size();i++){
				ArrayList<Integer> ser = new ArrayList<Integer>();
				ser.add(-1);
				for(int j=0;j<pool.size();j++){
					if(i==j){
						continue;
					}
					for(Integer temp:pool.get(j)){
						if(ser.contains(temp-1)&&temp-1!=i||temp==0){
							ser.add(j);
						}
					}
				}
				if(ser.size()<(pool.size()-1)){
					System.out.println(i+1);
				}
			}
		}
	}
		
}
