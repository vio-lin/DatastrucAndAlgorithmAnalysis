package com.data.homework;

import javax.swing.text.MaskFormatter;

/**
 * 寻找 最大子串的 几种算法 和相关 的优化行为
 * @author  violin qq:846271633
* @date 创建时间：2016年7月4日 下午3:43:00
 */
public class FindMaxSubSenquence {
	/**
	 * 分治 出现在左边 右边或者 两边不为0的子串相加  所以这边采用递归
	 * @param a
	 * @param left
	 * @param right
	 * @return
	* maxSumRed
	 */
	private static  int maxSumRed(int[] a ,int left,int right){
		if(left==right){
			if(a[left]>0)
				return a[left];
			else 
				return 0;
		}
		
		int center = (left+right)/2;
 		int maxLeftSum = maxSumRed(a, left, center);
		int maxRightSum = maxSumRed(a, center+1, right);
		
		int maxLeftBorderSum =0,leftBorderSum =0;
		for(int i = center;i>=left;i--){
			leftBorderSum +=a [i];
			if(leftBorderSum>maxLeftBorderSum)
				maxLeftBorderSum = leftBorderSum;
		}
		
		int maxRightBorderSum =0,rightBorderSum =0;
		for(int i =center+1;i<=right;i++){
			rightBorderSum+= a[i];
			if(rightBorderSum>maxRightBorderSum)
				maxRightBorderSum = rightBorderSum;
		}
		int resu =		 (maxLeftSum>=maxRightSum?maxLeftSum:maxRightSum)>=(maxLeftBorderSum+maxRightBorderSum)?(maxLeftSum>=maxRightSum?maxLeftSum:maxRightSum):(maxLeftBorderSum+maxRightBorderSum);
		return resu;
		
	}
	//不使用递归的写法 假如到负数了 就重置为0 查询最大的子串的值
	private  static int maxseq(int[] a){
		int len = a.length;
		int sum=0,summax = 0;
		for(int i=0;i<len;i++){
			sum += a[i];
			if(sum>summax)
				summax = sum;
			else if(sum<0)
				sum=0;
		}
		return summax;
	}
	public static void main(String[] args) {
		int[] a = new int[]{4,-3,5,-2,-1,2,6,-2};
//		System.out.println(maxSumRed(a, 0, a.length-1));
		System.out.println(maxseq(a));
	}
}
