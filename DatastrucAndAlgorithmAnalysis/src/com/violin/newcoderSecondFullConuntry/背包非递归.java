package com.violin.newcoderSecondFullConuntry;

import java.util.*; 
public class 背包非递归 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            int x = sc.nextInt();
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[] zero = new int[x];
            int[] one = new int[x];
            String item;
            for(int i=0;i<x;i++) {
                item = sc.next();
                int cnt = 0;
                for(int j=0;j<item.length();j++) {
                    if(item.charAt(j) == '0') {
                        cnt++;
                    }
                }
                zero[i] = cnt;
                one[i] = item.length()-cnt;
            }
            int[][] dp = new int[n+1][m+1];
            for(int i=0;i<x;i++) {
                for(int j=n;j>=zero[i];j--) {
                    for(int k=m;k>=one[i];k--) {
                        if(dp[j][k] < dp[j-zero[i]][k-one[i]]+1) {
                            dp[j][k] = dp[j-zero[i]][k-one[i]]+1;
                        }
                    }
                }
            }
            System.out.println(dp[n][m]);
        }
    }
}