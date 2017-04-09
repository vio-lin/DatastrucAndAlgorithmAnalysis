package com.offer.day01;

import java.util.Scanner;

/**
 * 题目：请实现一个函数，把字符串中的每个空格替换成“%20”。
 * @author lin
 */
public class 替换空格 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String line =scan.nextLine();
        if(line!=null){
            System.out.println(line.replace(" ", "%20"));            
        }
        String str = "asdkj askdjas sakjdeiu iuoib";
        System.out.println(replace(str));
    }

    private static String replace(String str) {
        // TODO Auto-generated method stub
        if(str ==null){
            return null;
        }
        StringBuffer sb = new StringBuffer();
        char[] ch1 = str.toCharArray();
        for(char ch :ch1){
            if(ch==' '){
                sb.append('%');
                sb.append('2');
                sb.append('0');
            }else{
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}
