package com.violin.dp;

import java.util.Scanner;
//1分、5分、10分、25分和50分 的硬币 输入 x 输出 有几种分法

public class 换零钱 {
    public static long[][] dp = new long[10001][5];
    public static void main(String[] args) {
       //首先是最初的情况 dp [0] = 0;
        int value[] =new int[]{1,5,10,25,50};
        dp[0][0] = 1;
        for(int i=1;i<=10000;i++){
            for(int j=0;j<5;j++){
                for(int k = 0;k<=j;k++){
                    if(i-value[j]>=0){
                        dp[i][j] += dp[i-value[j]][k];
                    }
                }
            }
        }
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){
            int count =scan.nextInt();
            long res   = 0;
            for(int i=0;i<5;i++){
                res+=dp[count][i];
            }
            System.out.println(res);
        }
       
    }
}
