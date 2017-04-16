package com.violin.dp;

import java.util.Scanner;

public class 下100层未完成 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int  n =  scan.nextInt();
        int x = scan.nextInt();
        int y = scan.nextInt();
        int max = scan.nextInt();
        int[] xs = new int[n];
        int[] x1s = new int[n];
        int[] hs = new int[n];
        for(int i=0;i<n;i++){
            xs[i] = scan.nextInt();
            x1s[i] = scan.nextInt();
            hs[i] = scan.nextInt();
        }
        //假设尚敏进过了一次排序 然后输入
        //开始进行dp
        int dp[][] = new int[20001][40001];
        for(int i=0;i<40001;i++){
            dp[0][i] = 0;
        }
        for(int i=0;i<20001;i++){
            
        }
    }
}
