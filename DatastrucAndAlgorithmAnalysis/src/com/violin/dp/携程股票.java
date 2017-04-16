package com.violin.dp;

import java.util.Scanner;

/**
 * 样例输入 int[] sotckPrice = {1,2,3,5,2,6,3,7}; int k = 2; 输入为 8（表示数组长度）
 * 1（开始依次输入数组元素） 2 3 5 2 6 3 7 2（输入k）
 * 
 * @author lin
 */
public class 携程股票 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int sum = scan.nextInt();
        int[] price = new int[sum];
        for(int i= 0;i<sum;i++){
            price[i] = scan.nextInt();
        }
        int k = scan.nextInt();
        int[]dp = new int[sum];
        int cur = 100000;
        int ans =0;
        for(int i =1;i<sum;i++){
            //cur表示支出的价格 前面的支出的价格 前面支出比较低的部分
            dp[i] = Math.max(dp[i-1],price[i]-cur);
            System.out.println(i+" "+ dp[i]);
            if(i>=k){
                //有时间在上次的基础上进行交易  dp表示交易完成的状态 在i-k时刻把东西卖出的需求
                cur = Math.min(price[i]-dp[i-k],cur);
            }else{
                cur = Math.min(cur, price[i]);
            }
            ans = Math.max(ans,dp[i]);
        }
        System.out.println(ans);
    }
}
