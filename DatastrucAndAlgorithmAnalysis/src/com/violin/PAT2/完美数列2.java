package com.violin.PAT2;
import java.util.Arrays;
import java.util.Scanner;
 
 
public class 完美数列2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int sum = scan.nextInt();
        int p = scan.nextInt();
        int[] temp = new int[100000];
        for(int i =0;i<100000;i++){
        	temp[i] = Integer.MAX_VALUE;
        }
        for(int i=0;i<sum;i++){
             int num = scan.nextInt();
             temp[i] =num;
         }
        Arrays.sort(temp);
        int boundary = temp[0]*p;
        int res = 0;
        while(temp[res]<boundary&&temp[res+1]!=0){
            res++;
         }
        System.out.println(res+1);
    }
 
}