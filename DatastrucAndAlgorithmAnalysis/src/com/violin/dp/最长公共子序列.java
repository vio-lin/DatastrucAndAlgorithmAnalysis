package com.violin.dp;

import java.util.Scanner;

public class 最长公共子序列 {
    public static void main(String[] args) {
        // 两个子序列输出在 相当的环境下面的输出的值
        // 动态规划 每个状态 使用 dp[i][j] 表示匹配到 i和 j在之间的关系
        // 状态转移方程为 ans 为max
        // dp[i][j] = dp[i-1][j-1]+1 if(i==j) else dp[i][j] = 0 连续的状态
        // dp[i][j] = dp[i-1][j-1]+1 if(i==j) else 上面一个状态的 dp[i][j] = dp[i-1][j]
        // dp[j-1][i] 取出最大值
        // 还因为这还和上面的关系有关
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            String line = scan.nextLine();
            String[] lines = line.split(" ");
            LCS(lines[0], lines[1]);
            getLongestCommonSequence(lines[0], lines[1]);
        }
    }

    public static void LCS(String a, String b) {
        int[][] dp = new int[a.length() + 1][b.length() + 1];
        // 初始状况的 dp[0][0]的情况
        int res = 0;
        for (int i = 1; i <= a.length(); i++) {
            for (int j = 1; j <= b.length(); j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    res = Math.max(res, dp[i][j]);
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        System.out.println(res);
    }

    public static int getLongestCommonSequence(String A, String B) {
        int a_len = A.length();
        int b_len = B.length();
        int size = 0;
        int[][] dp = new int[a_len + 1][b_len + 1];
        for (int i = 1; i <= a_len; i++) {
            for (int j = 1; j <= b_len; j++) {
                if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    if (dp[i][j] > size) {
                        size = dp[i][j];
                    }
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        System.out.println(size);
        return size;
    }
}
