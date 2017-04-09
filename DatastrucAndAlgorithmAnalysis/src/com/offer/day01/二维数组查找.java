package com.offer.day01;

/**
 * 题目描述：一个二维数组，每一行从左到右递增，每一列从上到下递增．输入一个二维数组和一个整数，判断数组中是否含有整数。
 * 
 * @author lin
 */
public class 二维数组查找 {
    public static void main(String[] args) {
        // 输入一个数组和一个数字输出 包含的数字
        int[][] testarray = new int[4][4];
        testarray[0][0] = 1;
        testarray[0][1] = 2;
        testarray[0][2] = 8;
        testarray[0][3] = 9;
        testarray[1][0] = 2;
        testarray[1][1] = 4;
        testarray[1][2] = 9;
        testarray[1][3] = 12;
        testarray[2][0] = 4;
        testarray[2][1] = 7;
        testarray[2][2] = 10;
        testarray[2][3] = 13;
        testarray[3][0] = 6;
        testarray[3][1] = 8;
        testarray[3][2] = 11;
        testarray[3][3] = 15;
        System.out.println(find(testarray, 5));
    }

    static boolean find(int[][] a, int b) {
        if (a == null) {
            return false;
        }
        // 顺序从右上开始
        int row = 0;
        int colum = a[0].length-1;
        while (row <= a.length && colum >= 0) {
            System.out.println(row + "" + colum);
            if (a[row][colum] == b) {
                return true;
            } else if (a[row][colum] < b) {
                row++;
            } else {
                colum--;
            }
        }
        return false;
    }
}
