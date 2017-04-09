package com.offer.day01;

public class 大数的乘法 {
    //考虑问题的全面性 除数为0 的情况 在部位0 的情况下 负数的情况 还有很多
    public static void main(String[] args) {
        double x = 6;
        System.out.println(power(x,0));
    }

    private static double power(double x, int i) {
        // TODO Auto-generated method stub
        if(equal(x,0.0)&&i<0){
            System.out.println("无意义");
        }
        if(i<0){
            return 1.0/power(x,-i);
        }
        if(i==1){
            return x;
        }
        if(i==0){
            return 1;
        }
        double res = power(x,i>>1);
        if((i & 0x1)==1){
            res = res*res*x;
        }else{
            res = res*res;
        }
        return res;
    }

    private static boolean equal(double x, double d) {
        // TODO Auto-generated method stub
        if(Math.abs(x-d)<0.000000001){
            return true;
        }
        return false;
    }
}
