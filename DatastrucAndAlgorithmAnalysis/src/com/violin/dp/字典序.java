package com.violin.dp;

import java.util.Scanner;

/**
 * 题目描述
求字典序在s1和s2之间的，长度在len1到len2的字符串的个数，结果mod 1000007。

输入描述:
每组数据包涵s1（长度小于100），s2（长度小于100），len1（小于100000），len2（大于len1，小于100000）


输出描述:
输出答案。

输入例子:
ab ce 1 2

输出例子:
56
 * @author lin
 */
public class 字典序 {
    public static void main(String[] args) {
        //查找字典序 和 数量 也算是动态规划的 话 状态应该分为 2端 a,b 和 3个状态 没法保存了这样
        Scanner scan= new Scanner(System.in);
        String line = scan.nextLine();
        String[] lines = line.split(" ");
        System.out.println(Count(lines[0],lines[1],Integer.valueOf(lines[2]),Integer.valueOf(lines[3])));
    }

    private static int Count(String str1, String str2, int i1,int i2) {
        // TODO Auto-generated method stub
        
        return 0;
    }
}
