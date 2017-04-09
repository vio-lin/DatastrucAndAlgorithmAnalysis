package com.violin.newcoderSecondFullConuntry;
import java.util.Scanner;

/**
 * 
 * 牛牛有两个字符串（可能包含空格）,牛牛想找出其中最长的公共连续子串,希望你能帮助他,并输出其长度。 
输入描述:
输入为两行字符串（可能包含空格），长度均小于等于50.


输出描述:
输出为一个整数，表示最长公共连续子串的长度。

输入例子:
abcde
abgde

输出例子:
2
 * @author lin
 */
public class 最长公共连续子串 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String line1 = scan.nextLine();
        String line2 = scan.nextLine();
        System.out.println(solve(line1, line2));
    }

    private static int solve(String line1, String line2) {
        // TODO Auto-generated method stub
        int res = 0;
        char[] ch1 = line1.toCharArray();
        char[] ch2 = line2.toCharArray();
        for (int i = 0; i < ch1.length; i++) {
            for (int j = 0; j < ch2.length; j++) {
                int temp = 0;
                int k = i, l = j;
                while (k < ch1.length && l < ch2.length && ch1[k++] == ch2[l++]) {
                    temp++;
                }
                if (temp > res) {
                    res = temp;
                }
            }
        }
        return res;
    }
}