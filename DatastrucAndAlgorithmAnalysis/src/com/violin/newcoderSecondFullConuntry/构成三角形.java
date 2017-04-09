package com.violin.newcoderSecondFullConuntry;
import java.util.Arrays;
import java.util.Scanner;


public class 构成三角形 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        int[] arrs = new int[num];
        for(int i=0;i<num;i++){
            arrs[i] = scan.nextInt();
        }
        Arrays.sort(arrs);
        int sum=0;
        for(int i =0;i<arrs.length;i++){
            for(int j=i+1;j<arrs.length;j++){
                int k =0;
                while(j+k+1<arrs.length&&arrs[i]+arrs[j]>arrs[j+k+1]&&arrs[j+k+1]-arrs[i]<arrs[j]){
                    k++;
                }
                sum += k;
            }
        }
        System.out.println(sum);
    }
}
