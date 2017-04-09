package com.violin.PAT2;
import java.util.Scanner;
 
public class 插入与归并1 {
    public static void Merge1(int[] Array, int[] TemA, int L, int R, int RightEnd) {
        int LeftEnd = R - 1;
        int Tem = L;
        int NumElements = RightEnd - L + 1;
        while (L <= LeftEnd && R <= RightEnd) {
            if (Array[L] < Array[R]) {
                TemA[Tem++] = Array[L++];
            } else {
                TemA[Tem++] = Array[R++];
            }
        }
        while (L <= LeftEnd) {
            TemA[Tem++] = Array[L++];
        }
 
        while (R <= RightEnd) {
            TemA[Tem++] = Array[R++];
        }
    }
 
    public static void MergeSort_pass(int[] Array, int[] TemA, int N, int length) {
        int i;
        for (i = 0; i <= N - 2 * length; i += 2 * length) {
            Merge1(Array, TemA, i, i + length, i + length * 2 - 1);
        }
        if (i + length < N) {
            Merge1(Array, TemA, i, i + length, N - 1);
        } else {
            for (int j = i; j <= N - 1; j++) {
                TemA[j] = Array[j];
            }
        }
    }
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] store = new int[num];
        int[] array = new int[num];
 
        for (int i = 0; i < num; i++) {
            store[i] = sc.nextInt();
        }
        for (int i = 0; i < num; i++) {
            array[i] = sc.nextInt();
        }
        int index = 0;
        for (int i = 0; i < num - 1; i++) {
            if (array[i] > array[i + 1]) {
                index = i + 1;//从i+1这里开始无序
                break;
            }
        }
        boolean Flag = true;
        for (int i = index; i < num - 1; i++) {
            if (array[i] != store[i]) {
                Flag = false;//如果是插入排序，从index开始两个数组的顺序是一样的 那么如果不等False就是归并排序了
                break;
            }
        }
        if (!Flag) {
            System.out.println("Merge Sort");
            if(index==0)
                index = num-1;
            MergeSort_pass(array, store, num, index);
        }
        if (Flag) {
            System.out.println("Insertion Sort");
            int num1 = array[index];
            for (int j = index; j > 0; j--) {
                if (array[j] < array[j - 1]) {
                    array[j] = array[j - 1];
                    array[j - 1] = num1;
                }
            }
 
 
            for (int i = 0; i < num; i++) {
                store[i] = array[i];
            }
        }
 
        for (int i = 0; i < num; i++) {
            System.out.print(store[i]);
            if (i < num - 1) {
                System.out.print(" ");
            }
        }
    }
}