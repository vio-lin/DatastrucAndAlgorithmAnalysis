package com.violin.qlcode;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 　威威猫不是一只普通的猫，普通的猫喜欢吃鱼，但威威猫最喜欢吃鸡腿。他每天都在不停的吃啊吃，吃了一只又一只鸡腿。现在他遇到了一个难题，如果他的体重太胖那么他的主人就不给他吃鸡腿了，所以他需要你的帮助。
　　威威猫的身体由n个器官构成，由于他的身体很特殊所以他的增长也很特殊（不要问为什么，喜欢吃鸡腿的猫已经够奇怪了）。他的增长有个k1和k2系数，而且每天的增长量和前一天有关，我们假设这n个器官在第i天的数值分别是a(i,1), a(i,2), a(i,3) …… a(i,n)，那么，第i+1天他每个器官的数值就会变成:
　　a(i+1,1) = k1 * a(i,1) + k2 * a(i,2)
　　a(i+1,2) = k1 * a(i,2) + k2 * a(i,3)
　　......
　　a(i+1,n) = k1 * a(i,n) + k2 * a(i,1)
　　威威猫的体重等于他的所有器官的数值之和，并且他还拥有一个特殊的机能，就是会自动检测自己的体重，如果他的体重比K大，那么就会自动停止生长（为了每天都能吃到鸡腿），由于威威猫的特殊身体构造他的体重是可能会变成负数的。
　　现在我给你n个器官的初始数值和他的增长系数k1,k2，请问他几天之后会停止生长，如果他永远无法停止生长那么就输出"inf"。(引号不用输出)

 

 

Input

输入数据第一行是一个正整数T，表示有T组测试数据；
每组数据的第一行包含4个数字n,k1,k2,k，代表威威猫有n个器官，他的生长系数是k1,k2，当体重超过k的时候他就停止生长。
接下来的一行是n个数ai，代表威威猫每个器官第一天的数值是多少。

[Technical Specification]
T <= 100
1 <= n <= 10000
-100 <= k1, k2 <= 100
1 <= k <= 10 ^ 18
1 <= ai <= 1000（1 <= i <= n）

 

 

Output

对于每组测试数据，请首先输出"Case #X: "，X代表测试用例的编号，然后输出一个数ans，代表ans天之后他会停止生长，如果不会停止就输出inf.
具体可参见sample output。

Sample Input

2

5 1 1 10

1 1 1 1 1

5 1 1 500

1 1 1 1 1

Sample Output

Case #1: 2

Case #2: 7
 * @author lin
 *
 */

public class 威威猫什么的 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while(scan.hasNext()){
			int count = scan.nextInt();
			for(int i=0;i<count;i++){
				int n = scan.nextInt();
				int k1 = scan.nextInt();
				int k2 = scan.nextInt();
				int k =scan.nextInt();
				int[] wei = new int[n];
				int sum = 0;
				for(int j=0;j<n;j++){
					wei[j] = scan.nextInt();
					sum+=wei[i];
				}
				int day = 0;
				
				while(sum<=k){
					sum=grow(wei,k1,k2);
					day++;
				}
				System.out.println("Case #"+(i+1)+":"+day);
			}
		}
	}

	private static int grow(int[] wei, int k1, int k2) {
		// TODO Auto-generated method stub
		int sum = 0;
		int[] wei2 = Arrays.copyOf(wei,wei.length );
		for(int i=0;i<wei.length;i++){
			if(i==wei.length-1){
				wei[i]=wei2[wei.length-1]*k1+wei2[1]*k2;
				sum+=wei[i];
			}else{
				wei[i]=wei2[i]*k1+wei2[i+1]*k2;				
				sum+=wei[i];
			}
		}
		return sum;
	}
}
