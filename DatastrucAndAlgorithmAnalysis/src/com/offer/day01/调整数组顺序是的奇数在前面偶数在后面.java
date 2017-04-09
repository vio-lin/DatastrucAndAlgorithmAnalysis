package com.offer.day01;

public class 调整数组顺序是的奇数在前面偶数在后面 {
    public static void main(String[] args) {
        int[] array = new int[] { 2, 4, 5, 8, 3, 6, 24, 652, 258, 87, 231 };
        select(array, 0, array.length - 1);
        System.out.println(array[0]);
    }
    
    private static void select(int[] array, int i, int j) {
        // TODO Auto-generated method stub
        // 前面找一个 奇数 后面找一个偶数 交换 然后 i++ j-- 直到 i > = j
        while(judge(array[i])==true&&i<j){
            i++;
        }
        while(judge(array[j])==false&&i<j){
            j--;
        }
        while (i < j) {
            while(judge(array[i])==true&&i<j){
                i++;
            }
            while(judge(array[i])==true&&i<j){
                j--;
            }
            int x = array[i];
            array[i] = array[j];
            array[j] = x;
            i++;
            j--;
        }
    }
     public static  boolean judge(int a){
         if((a & 0x1)==1){
             return false;
         }
         return true;
     }

}
