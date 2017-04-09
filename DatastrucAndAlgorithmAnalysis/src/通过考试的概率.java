import java.util.Scanner;

/**
 * 动态规划求 通过考试的概率
 * 
 * @author lin
 */
public class 通过考试的概率 {
    public static void main(String[] args) {
        int c ="sda".length();
        Scanner scan = new Scanner (System.in);
        int sum = scan.nextInt();
        double[][] dp = new double[sum+1][sum+1];
        double[] per = new double[sum+1];
        for(int i=1;i<=sum;i++){
            int  num = scan.nextInt();
            per[i] = ((double)num)/100;
        }
        dp[0][0] = 1;
        for(int i =1;i<=sum;i++){
            dp[i][0] =dp[i-1][0]*(1-per[i]); 
            for(int j=1;j<=i;j++){
                dp[i][j] = dp[i-1][j]*(1-per[j])+dp[i-1][j-1]*per[j];
            }
        }
        int j = (int) ((3*sum+4)/5);
        double res =0;
        for(int i=j;i<=sum;i++){
            res+=dp[sum][i];
        }
        System.out.println(res);
    }
}
