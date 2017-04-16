package com.violin.dp;

import java.util.Scanner;

public class 上台阶 {
    public static int[]dp = new int[101];
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int sum = scan.nextInt();
        for(int j=0;j<sum;j++){
            int n = scan.nextInt();
            dp[1] = 1;
            dp[2] = 1;
            for(int i=3;i<=n;i++){
                    dp[i] = dp[i-1] +dp[i-2]; 
            }
            System.out.println(dp[n]+"");
        }
    }
}
