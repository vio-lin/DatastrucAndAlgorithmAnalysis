package com.hihocoder.oct;
import java.util.Scanner;

public class NO1015KMP算法 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int sum = scan.nextInt();
        scan.nextLine();
        for (int i = 0; i < sum; i++) {
            String part = scan.nextLine();
            String str = scan.nextLine();
            int count = KVP(part.toCharArray(), str.toCharArray());
            System.out.println(count);
        }
    }

    private static int KVP(char[] part, char[] str) {
        // TODO Auto-generated method stub
        // 从匹配穿 得出next数组
        int[] next = new int[part.length];
        // 进行整体匹配
        getNext(2, part, next);
        // 从原来的数组生成next数组
        int q = 0;
        int count = 0;
        int i = 0;
        while (i < str.length) {
//            System.out.println(i+":"+q);
            if (str[i] == part[q]) {
                i++;
                q++;
                if (q == part.length) {
                    count++;
                    q = next[q-1];
                }
            } else {
                if(q==0){
                    i++;
                    continue;
                }
                q = next[q-1];
                
            }
        }
        return count;
    }

    private static int getNext(int i, char[] part, int[] next) {
        // TODO Auto-generated method stub
        next[0] = 0;
        for(int index=1;index<next.length;index++){
            int k = index;
            if(part[index] == part[next[k-1]]){
                next[index] = next[k-1]+1;
            }else{
               //反向逻辑
               k = next[k-1];
               while(k>=1&&part[index] != part[next[k-1]]){
                   k = next[k-1];
               }
               if(k==0){
                   next[index] = 0;
               }else{
                   next[index] = next[k-1]+1;
               }
            }
        }
        return 0;
    }
}
