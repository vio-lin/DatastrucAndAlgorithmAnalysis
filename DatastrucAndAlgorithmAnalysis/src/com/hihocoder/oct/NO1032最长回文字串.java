package com.hihocoder.oct;
import java.util.Scanner;

public class NO1032最长回文字串 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int count = scan.nextInt();
        scan.nextLine();
        for (int i = 0; i < count; i++) {
            String line = scan.nextLine();
            System.out.println(CountMax(line));
        }
    }

    private static int CountMax(String str) {
        // TODO Auto-generated method stub
        char[] temp = new char[str.length()*2+1];
        int[] f = new int[temp.length];
        f[0] = 1;
        f[1] = 3;
        int res = 1;
        int max = 1;
        int i=0;
        for(char ch : str.toCharArray()){
            temp[i] = '*';
            temp[i+1] = ch;
            i = i+2;
        }
        temp[str.length()*2] = '*';
        for(i=2;i<temp.length-1;i++){
//            int n = 1;
            int n;
            if(f[max]*0.5+max>=i){
                n =  (int) (Math.min(f[2*max-i],f[max]-2*(i-max))*0.5);                
            }else{
                n=1;
            }
            while(i-n>=0&&i+n<temp.length&&temp[i+n]==temp[i-n]){
                n++;
            }
            f[i] = n*2-1;
            if((f[i]-1)/2>res){
                res = (f[i]-1)/2;
            }
            if((i+f[i]*0.5)>f[max]*0.5+max){
                max = i;
            }
        }
        return res;
    }
}
