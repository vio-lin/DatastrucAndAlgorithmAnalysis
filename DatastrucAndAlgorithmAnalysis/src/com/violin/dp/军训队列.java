package com.violin.dp;

import java.util.Scanner;

public class 军训队列 {
    static int[] dp = new int[5001];
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int cut = scan.nextInt();
        for(int i=1;i<=5000;i++){
            dp[i] = i;
        }
        for(int i=0;i<cut;i++){
            int temp = scan.nextInt();
            for(int j = 0;j<temp;j++){
            }
        }
    }
}
