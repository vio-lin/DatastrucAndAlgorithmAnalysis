package com.violin.newcoderSecondFullConuntry;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


public class 字符串分类 {
    public static void main(String[] args) {
        Scanner scan= new Scanner(System.in);
        int  num = scan.nextInt();
        scan.nextLine();
        Set<String> set = new HashSet<String>();
        for(int i =0 ;i<num;i++){
           String line  =scan.nextLine();
           char[] chs = line.toCharArray();
           Arrays.sort(chs);
           set.add(new String(chs));
        }
        System.out.println(set.size());
    }
}
