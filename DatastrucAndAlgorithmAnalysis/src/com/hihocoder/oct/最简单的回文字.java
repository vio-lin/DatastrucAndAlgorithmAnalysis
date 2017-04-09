package com.hihocoder.oct;
import java.util.Scanner;


public class 最简单的回文字 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int count = scan.nextInt();
        scan.nextLine();
        for (int i = 0; i < count; i++) {
            String line = scan.nextLine();
            System.out.println(CountMax(line));
        }
    }

    private static int CountMax(String line) {
        // TODO Auto-generated method stub
        char[] temp = line.toCharArray();
        int max = 1;
        for(int i=0;i<line.length();i++){
            int n = 0;
            while(i+n<temp.length&&i-n>=0&&temp[i+n]==temp[i-n]){
                n++;
                }
            if(2*n-1>max){
                max = 2*n-1;
            }
        }
        for(int i=0;i<line.length();i++){
            int n = 0;
            while(i+n+1<temp.length&&i-n>=0&&temp[i+1+n]==temp[i-n]){
                n++;
                }
            if(2*n>max){
                max = 2*n;
            }
        }
        return max;
    }
}
