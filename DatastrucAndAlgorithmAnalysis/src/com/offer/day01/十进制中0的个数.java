package com.offer.day01;

//题目：请实现一个函数，输入一个整数，输出该数二进制表示中1的个数。例如把9表示成二进制是1001；有2位是1，因此如果输入9，函数输出2.

public class 十进制中0的个数 {
    public static void main(String[] args) {
        int n = -1;
        System.out.println(countone1(n));
        System.out.println(Double.SIZE);
        System.out.println(Double.MAX_VALUE);
    }

    private static int countone(int n) {
        // TODO Auto-generated method stub
        int res = 0;
        while (n != 0) {
            res += n & 1;
            n = n >> 1;
        }
        return res;
    }
//这块使用原来的  二进制 最大 和最小的参数分别是 符号位和 表示10进制变化的各种
    private static int countone1(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = (n - 1) & n;
        }
        return count;
    }
}
