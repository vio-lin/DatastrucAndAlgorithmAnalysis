package com.offer.day01;

/**
 * 题目描述：把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如数组{3,4,5
 * ,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1.
 * 
 * @author lin
 */
public class 旋转数组的最小数字 {
    public static void main(String[] args) {
//        int[] arr = new int[] {};
//      int[] array={1,1,1,2,0};
//      int[] array={3,4,5,6,1,2};
        int[] array={1,0,1,1,1};
        if (array == null) {
            System.out.println("输入无效");
        }
        System.out.println(findmin(array, 0, array.length - 1));
    }

    private static int findmin(int[] arr, int start, int end) {
        // TODO Auto-generated method stub
        int res = 0;
        while (arr[start] >= arr[end]) {
            int mind = (start + end) / 2;
            if (arr[mind] > arr[start]) {
                start = mind+1;
            } else if (arr[mind] < arr[start]) {
                end = mind;
            } else {
               return findOrder(arr, start, end);
            }
        }
        return arr[start];
    }

    private static int findOrder(int[] arr, int start, int end) {
        // TODO Auto-generated method stub
        int min = Integer.MAX_VALUE;
        for(int i= start;i<=end;i++){
            if(arr[i]<min){
                min = arr[i];
            }
        }
        return min;
    }
}
