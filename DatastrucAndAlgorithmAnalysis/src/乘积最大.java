/**
 * 题目描述
                                    
有一个整数n，将n分解成若干个不同自然数之和，问如何分解能使这些数的乘积最大，输出这个乘积m

15 
144
 * @author lin
 */
public class 乘积最大 {
    static long[][] dp = new long[20][20];
   static long solve(int n){
        long ans = 0;
        for(int i = 0; i <= n; i++)
            ans = Math.max(ans, dp[n][i]);
        return ans;
    }
   public static void  main(String args[]){
        int n;
        n=5;
        for(int i = 0; i <= n; i++)
            dp[0][i] = 1;
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= i; j++){
                for(int k = 0 ; k < j; k++)
                    dp[i][j] = Math.max(dp[i][j], dp[i - j][k] * j);
            }
        }
        for(int i=0;i<dp.length;i++){
            for(int j =0;j<dp.length;j++){
                System.out.print(dp[i][j]+",");
            }
            System.out.println();
        }
       System.out.println(solve(n));
    }
}
