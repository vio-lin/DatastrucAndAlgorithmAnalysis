package com.violin.qlcode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Scanner;
/**
 * 经过深思熟虑之后，小贱君打算去M国闯一闯，那是一个古老的东方国度，传说有很多高阶魔法师，他想成为一名伟大的魔法师，将来征服星辰大海。
经过千辛万苦，小贱君终于来到了M国，不幸的是刚进城门小贱君就被M国的守城士兵困在了一种叫做“困兽之斗”的阵法之中。
士兵对小贱君说：“看到漂浮在你身边的宝石了吗？彩虹连接的两颗宝石可以任意交换位置，你需要通过一系列交换后使得宝石组成的字符串的字典序最小。若不能破阵，那还是请回吧！”
小贱君观察了一下周围的宝石，只见每颗宝石上标有一个小写字母，而且有一些宝石上通过彩虹与其他宝石相连。
琢磨了半天，他终于搞懂了这个阵法的意思：
若宝石系列为：dcba
其中有两道彩虹，分别是(0,1),(1,2),代表第一个位置上的宝石可以和第二个位置上的宝石互换，第二个位置上的宝石可以和第三个位置上的宝石互换，最终可以得到字典序最小的宝石系列：bcda。
作为小贱君的死党，你有什么方法帮助他破阵吗？

输入描述:

输入包含多组测试数据。

对于每组测试数据：

字符串s --- 代表宝石序列

n --- 代表有n条彩虹

接下来n行，每行两个数ai,bi --- 表示ai和bi由一条彩虹相连。


保证：

1<=s的长度<=10000

1<=n<=10000

且输入数据均合法。


  


输出描述:

对于每组数据，输出一个字符串



输入例子:
dcba
2
0 1
1 2
hellonowcoder
4
0 1
1 4
2 5
2 3

输出例子:
bcda
ehllonowcoder
 * @author lin
 *
 */
public class 困兽之斗 {
	public static ArrayList<ArrayList<Integer>> in; 
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()){
			String str = scanner.nextLine();
			int n = scanner.nextInt();
			in = new ArrayList<ArrayList<Integer>>();
			for(int i = 0;i<n;i++){
				int a = scanner.nextInt();
				int b = scanner.nextInt();
				union(a,b);
			}
			ArrayList<ArrayList<Integer>> li = in;
			char[] temp = str.toCharArray();
			for(int i=0;i<in.size();i++){
				ArrayList<Integer> te = in.get(i);
				Collections.sort(te);
				StringBuilder sb = new StringBuilder();
				for(int j=0;j<te.size();j++){
					sb.append(temp[te.get(j)]);
				}
				char[] arr = sb.toString().toCharArray();
				Arrays.sort(arr);
				int c=0;
				for(int j=0;j<te.size();j++){
					temp[te.get(j)] = arr[c++];
				}
			}
			System.out.println(temp);
		}
	}
	public static ArrayList<Integer> findfather(Integer i){
		for(ArrayList<Integer> a : in){
			if(a.contains(i))
				return a;
		}
		return null;
	}
	/**
	 * 这边定义的返回参数 在对于数组进行变化的时候为 true
	 * @param a
	 * @param b
	 * @return
	 */
	public static boolean union(int a,int b){
		ArrayList<Integer> fa = findfather(a);
		ArrayList<Integer> fb = findfather(b);
		if(fa==fb){
			if(fa==null){
				ArrayList<Integer> list = new ArrayList<>();
				list.add(a); list.add(b);
//				System.out.println("进行了一次扩展");
				in.add(list);
				return true;				
			}else{
//				System.out.println("不做操作");
				return false;
			}
		}else {
			if(fa!=null&&fb!=null){
				fa.addAll(fb);
				boolean temp = in.remove(fb);
//				System.out.println("进行了一次合并");
				return temp;
			}else{
				if(fa==null){
					fb.add(a);
				}else{
					fa.add(b);	
				}
//				System.out.println("进行了一次 添加");
				return false;
			}
		}
	}
}
