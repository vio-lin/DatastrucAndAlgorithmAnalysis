package com.violin.dp;

public class EditDistance {
    static String str1 = "eeba";
    static String str2 = "abca";
    public static void main(String[] args) {
        int[][] dp = new int[str1.length()][str2.length()];
        //三種不同操作 
        //1.刪除 dp[i][j]=dp[i][j] = dp[i][j+1] 2.添加 dp[i+1][j] 3.替換 dp[i+1][j+1]
        //看到這樣 好像是從後面開始的
        for(int i = str1.length()-2;i>=0;i--){
            for(int j =str2.length()-2;j>=0;j--){
                if(str1.charAt(i)==str2.charAt(j)){
                    dp[i][j] = dp[i+1][j+1];
                }
                dp[i][j] = Math.min(Math.min(dp[i][j+1]+1, dp[i+1][j]+1), dp[i+1][j+1]+1);
            }
        }
        System.out.println(dp[0][0]);
    }
     
}
