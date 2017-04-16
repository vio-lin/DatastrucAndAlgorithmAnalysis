package com.violin.dp;

public class MonoSum {
    public static void main(String[] args) {
        int[] a =new int[]{1,3,5,2,4,6};
        System.out.println(new MonoSum().calcMonoSum(a, 6));
    }
    public int calcMonoSum(int[] A, int n) {
        // write code here
        int[] dp= new int[n];
        int res =0;
        //递归条件 在现在的位置 返回前面小于它的 一个值 然后取出这边到前面一个值之间的所有
        //在dp[2] dp[3] 假如 3>2 的话 那么直接使用 dp[2]+1
        //假如不是  dp[n-1]+1; 直到找到一个这样的数据  前面有比j大但是比i小的数据
        //找到 比他大的 数据
        dp[0] = 0;
        for(int i =1;i<n;i++){
            for(int j=i-1;j>=0;j--){
                
            }
            res += dp[i];
        }
        return res;
    }
}