package com.offer.day01;

public class 斐波那契数列的产生 {
    public static void main(String[] args) {
        int  n = 17;
        System.out.println(phy(5));
    }

    private static int phy(int n) {
        // TODO Auto-generated method stub
        int n1=1,n2=1;
        if(n==1||n==2){
            return 1;
        }
        int res = 0;
        for(int i=0;i<n-2;i++){
            res = n1+n2;
            n1 =n2;
            n2 = res;
            
        }
        return res;
    }
}
