package com.offer.day01;

public class 打印从1到n位的数字 {
    public static void main(String[] args) {
        // 想想看 有位数限制的还是使用str吧
        int n = 5;
        Print("", n);
    }

    private static void Print(String str, int n) {
        // TODO Auto-generated method stub
        if (n == 0) {
            if (str.charAt(0)!= '0') {
                System.out.println(str);
            }else{
                int index= 0;
                while(str.charAt(index)=='0'){
                    index++;
                    if(index>=str.length()){
                        return;
                    }
                }
                System.out.println(str.substring(index));
            }
            return;
        }
        for (int i = 0; i <= 9; i++) {
            Print(str + "" + i, n - 1);
        }
    }
}
