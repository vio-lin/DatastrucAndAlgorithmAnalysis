package com.violin.dp;

import java.util.Scanner;

/*
 样例输入
 5 1000
 144 990
 487 436
 210 673
 567 58
 1056 897
 样例输出
 2099

 01的包  2099
 完全的包 5940

 * @author lin
 */
public class 背包问题01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int[] costs = new int[n];
        int[] values = new int[n];
        for (int i = 0; i < n; i++) {
            costs[i] = scan.nextInt();
            values[i] = scan.nextInt();
        }
        System.out.println(getMaxValue(costs, values, m));
        System.out.println(getMaxm(costs, values, m));
    }
    //01的包
    private static int getMaxValue(int[] costs, int[] values, int m) {
        // TODO Auto-generated method stub
        int[] f = new int[m + 1];
        // 01 背包每次使用的都是一样的东西 主要的地推公式是 dp[i][j] =
        // dp[j] = Math.max(dp[j],dp[j-weight[j]]+value[j]) 因为是01 的只有一次机会
        // 01的包和完全的包 应该只是 从前面开始的意思 相当于 dp[i][j] = dp[i-1][j] dp[i-2][j]
        int res = 0;
        for (int j = 0; j < costs.length; j++) {
            for (int i = m; i >= costs[j]; i--) {
                    f[i] = Math.max(f[i], f[i - costs[j]] + values[j]);
                    res = Math.max(res, f[i]);                    
                // 01 和 完全没之间的变化
            }
        }
        return f[m];
    }
    //完全的包
    public static int getMaxm(int[] costs,int[] values,int m){
        int[] f = new int[m+1];
        //还是状态转移方程 dp[i] = dp[i-weight[j]] 中间有一段是小于的情况 是怎么处理的 
        for(int i =1;i<=m;i++ ){
            for(int j=0;j<costs.length;j++){
                if(i-costs[j]>=0){
                    f[i] = Math.max(f[i], f[i-costs[j]]+values[j]);
                }else{
                    f[i] = f[i];
                }
            }
        }
        return f[m];    
    }
}
