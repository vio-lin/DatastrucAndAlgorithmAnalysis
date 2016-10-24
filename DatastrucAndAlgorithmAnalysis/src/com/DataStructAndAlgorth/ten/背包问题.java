package com.DataStructAndAlgorth.ten;

import java.util.Scanner;
 /**
  *   返回是不是有满足的条件的 参数使得这边的 总数可以被取到 
  *   
  *   实现思路 还是一条路上只有 两种选择 可以活着不可以。 
  *   然后往面地推 假如可以 就放掉 不可以设置不可以
  *   
  *   还是原来的算啊比较正确  选择保持正确的 东西 是这样的吗 先判断这个位置有没东西 假如有的话在尽享处理 
  *   总之上面的情况少了第二次的计算 其实算是快了一点
  * @author lin
  */
public class 背包问题 {
	public static int[] weight;
	public static int[][] pack;
	public static void main(String[] args) {
		weight = new int[]{509,838,924,645,604,793,564,651,697,649,747,787,701,605,644};
		int sum = 5000;
		pack = new int[15][5001];
		for(int i=0;i<15;i++){
			for(int j=1;j<5001;j++){
				pack[i][j] = -1; 
			}
		}
		int[] indexs  = new int[]{2,3,4,9,10,11,14};
		int sum1 = 0;{
			for(int i=0;i<indexs.length;i++){
				sum1+= weight[indexs[i]];
				System.out.println(sum1);
			}
		}
		System.out.println();
		int rest = findmax(sum,weight.length-1);
		System.out.println("最接近的是" +rest);		
		
	}
	private static int findmax(int border, int index) {
		// TODO Auto-generated method stub
		
		if(index == 0){
			if(border>=weight[index]){
				return border - weight[index];
			}else{
				return border;
			}
		}else{
			int selected = Integer.MAX_VALUE;
			if(border>=weight[index]){
				selected = findmax(border-weight[index], index-1);
			}
			int unselected = findmax(border,index-1);
//			if(border<weight[index]||selected > unselected){
			if(border<weight[index]||selected > unselected){
				return unselected;
			}else{
				if(selected ==0) {
					System.out.println(index);
				}
				return selected;
			}
		} 
	}
}
