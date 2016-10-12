package com.violin.qlcode;

import java.awt.Image;

//动态规整  兼职碉堡了  无论是前面还是后面  给出总户数和  多个小块的重量 
//求最接近 总数的小块的组合  应该是给出一个商品的价值表 求这边最大不超过 v的值
public class  求最大不超过2{
	private static int[] produ;
	private static int[][] produ1;
	public static void main(String[] args) {
		long start = System.nanoTime();
		produ = new int[] { 509, 838, 924, 650, 604, 793, 564, 651, 697, 649,
				747, 787, 701, 605, 644 };
		produ1 = new int[15][5001] ;
		for(int i=0;i<15;i++){
			for(int j=0;j<5001;j++){
				produ1[i][j]=-1;
			}			
		}
		int result = maxbag(5000, produ.length - 1);
		System.out.println(result);
		long end = System.nanoTime();
		System.out.println(end - start);
		int count=0;
//		for(int i=0;i<15;i++){
//			for(int j=0;j<5001;j++){
//				if(produ1[i][j]==9){
//					System.out.println("index:"+i+";margin:"+j+";margin(2):"+produ1[i][j]);
//					count++;
//				}
//			}			
//			count=0;
//		}
	}

	public static int maxbag(int margin, int index) {
		if (index == 0) {
			if (margin >= produ[index]) {
				produ1[index][margin]= margin - produ[index];
				return margin - produ[index];
			} else {
				produ1[index][margin]= margin;
				return margin;
			}
		} else {
			//if (maxbag(margin, index - 1) < maxbag(margin - produ[index],index - 1)) {
			//这边制定 规则 假如下一个选项直接超过 5000 不选择 不选比选了少。
			
			if (margin<produ[index]|| maxbag(margin, index - 1)<maxbag(margin - produ[index], index - 1)) {
				//使用数组保存结果 加快速度 显示出的东西还是不错的
				produ1[index-1][margin]= maxbag(margin, index - 1);
				return produ1[index-1][margin] ;
			} else {
				produ1[index-1][margin - produ[index]]= maxbag(margin - produ[index], index - 1);
				return produ1[index-1][margin - produ[index]];
			}
		}
	}
}
