package com.violin.newcoderSecondFullConuntry;
import java.util.Scanner;

public class 平衡数 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str= scan.nextLine();
        if(str.length()<2){
            System.out.println("NO");
            return;
        }
        int start=0,end =str.length()-1;
        boolean flag=false;
        while(start<end){
            int temp = (start+end)/2;
            long ptr = change(str.substring(0,temp+1));
            long aft = change(str.substring(temp+1));
            if(ptr>aft){
                end = temp-1;
            }else if(ptr<aft){
                start = temp+1;
            }else{
                flag = true;
                break;
            }
        }
        System.out.println(flag?"YES":"NO");
        
        
    }

    private static long change(String str) {
        // TODO Auto-generated method stub
        long res =1;
        for(char ch : str.toCharArray()){
            if(ch=='0'){
                return 0;
            }else{
                res*=ch-'0';
            }
        }
        return res;
    }
}
