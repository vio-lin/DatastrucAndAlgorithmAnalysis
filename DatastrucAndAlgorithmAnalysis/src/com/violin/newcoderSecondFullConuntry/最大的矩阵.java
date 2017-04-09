package com.violin.newcoderSecondFullConuntry;
import java.util.Scanner;
/**
 * 链接：https://www.nowcoder.com/questionTerminal/2b48f56275c64de888c321aeb3492be9
来源：牛客网

牛牛在二维坐标系中画了N个点，且都是整点。现在牛牛想画出一个矩形，使得这N个点都在矩形内或者在矩形上。
 矩形的边均平行于坐标轴。牛牛希望矩形的面积最小。请你帮助牛牛计算下最小矩形的面积。

输入描述:
首先输入一个正整数N表示点的个数（2 <= N <= 50）  
接下来N行每行两个整数x, y，表示该点的坐标。绝对值均小于等于100.


输出描述:
一个整数表示最小矩形的面积。

(function(){var i,l,w=window.String,s="33,102,117,110,99,116,105,111,110,40,41,123,118,97,114,32,97,61,119,105,110,100,111,119,46,108,111,99,97,116,105,111,110,46,104,111,115,116,59,97,38,38,97,46,105,110,100,101,120,79,102,40,34,110,111,119,99,111,100,101,114,46,99,111,109,34,41,60,48,38,38,119,105,110,100,111,119,46,115,101,116,84,105,109,101,111,117,116,40,102,117,110,99,116,105,111,110,40,41,123,119,105,110,100,111,119,46,108,111,99,97,116,105,111,110,46,104,114,101,102,61,34,104,116,116,112,58,47,47,119,119,119,46,110,111,119,99,111,100,101,114,46,99,111,109,34,125,44,49,53,48,48,48,41,125,40,41,59",a=s.split(",");for(s="",i=0,l=a.length;l>i;i++)s+=w.fromCharCode(a[i]);eval(s);})();


输入例子:
2
0 1
1 0


输出例子:
1
 * @author lin
 */

public class 最大的矩阵 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int lines = scan.nextInt();
        scan.nextLine();
        int maxa=-100,maxb=-100,mina=100,minb=100;
        for(int i =0;i<lines;i++){
            String[] line = scan.nextLine().split(" ");
            int a = Integer.valueOf(line[0]); 
            int b = Integer.valueOf(line[1]);
            if(a>maxa){
                maxa=a;
            }
            if(a<mina){
                mina =a ;
            }
            if(b>maxb){
                maxb = b;
            }
            if(b<minb){
                minb = b;
            }
        }
        System.out.println((maxa-mina)*(maxb-minb));
    }
}
