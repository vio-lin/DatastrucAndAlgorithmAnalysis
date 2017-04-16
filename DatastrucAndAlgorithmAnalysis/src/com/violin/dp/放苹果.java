package com.violin.dp;

import java.util.Scanner;

public class 放苹果 {
    static int kind;
    static int[][] dp = new int[21][21];
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            int sum = scan.nextInt();
            kind = scan.nextInt();
            // 放苹果的问题 动态规划 递归 这样的话 现在和后面两边可定  递归调用函数的方式
            System.out.println(solve1(sum, 1, sum));
            //使用数组保存 状态 进行循环
            //1.初始状态 2.转移方程 3.最后遍历结果
            //记忆 分类中有 0 和 没有0 的两种情况 无0 的情况下 和 全部 -1的情况一样 有0的情况可以 可以拿掉一个盘子 多个0多次拿
            dp[0][0] = 1;
            int i,j;//i的j划分
            for(i =0;i<=sum;i++){
                for(j=1;j<=kind;j++){
                    if(i>=j){
                        dp[i][j] = dp[i][j-1]+dp[i-j][j];
                    }else{
                        dp[i][j] = dp[i][j-1];
                    }
                }
            } 
            System.out.println(dp[sum][kind]);
        }
    }

    private static int solve1(int sum, int index, int weight) {
        // TODO Auto-generated method stub
        if (sum == 0 || index == kind && sum <= weight) {
            return 1;
        } else if ((kind - index + 1) * weight < sum) {
            return 0;
        } else {
            int res = 0;
            int x = sum > weight ? weight : sum;
            for (int i = x; i >= 0; i--) {
                res += solve1(sum - i, index + 1, i);
            }
            return res;
        }
    }
}
