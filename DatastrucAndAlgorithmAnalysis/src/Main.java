import java.util.Scanner;


public class Main {
//最长的公共子串
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        char[] ch1 = scan.nextLine().toCharArray();
        char[] ch2 = scan.nextLine().toCharArray();
        int[][] dp = new int[ch1.length][ch2.length];
        for(int i=1;i<ch1.length;i++){
            for(int j=1;j<ch2.length;j++){
                if(ch1[i]==ch2[j]){
                    dp[i][j] = dp[i-1][j-1]++;
                }
            }
        }
    }
}
