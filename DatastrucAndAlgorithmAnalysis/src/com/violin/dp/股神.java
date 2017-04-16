package com.violin.dp;

import java.util.Scanner;

public class 股神 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int sum = scan.nextInt();
        int n =(int) (Math.sqrt(2*sum+0.25)-1.5);
        int price = sum-2*n;
        System.out.println(price);
    }

}
