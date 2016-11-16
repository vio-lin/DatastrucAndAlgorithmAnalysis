package com.violin.PAT2;
import java.util.Scanner;
import java.util.Arrays;
public class 完美数列 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int p = in.nextInt();
        int[] arr = new int[n];
        for(int i = 0;i<n;i++)
            arr[i] = in.nextInt();
        Arrays.sort(arr);
        int maxlen = 0;
        for(int i = 0;i<n;i++){
            for(int j = i+maxlen;j<n;j++){
                if(arr[j]>arr[i]*p)
                    break;
                maxlen++;
            }
 
        }
        System.out.println(maxlen);
    }
}