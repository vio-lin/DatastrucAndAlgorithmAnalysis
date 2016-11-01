package com.violin.PAT2;
import java.util.Scanner;


public class A除以B {
    public static void main(String[] args) {
        Scanner scan  = new Scanner(System.in);
        while(scan.hasNext()){
            String line = scan.nextLine();
            String num = line.split("\\s")[0];
            int inte = Integer.valueOf(line.split("\\s")[1]);
            process(num,0,0,inte);
        }
    }

    private static void process(String num,int index,int resut,int inte) {
        // TODO Auto-generated method stub
        if(index == num.length()-1){
            int temp = resut*10+num.charAt(index)-'0';
            int res = temp%inte;
            System.out.println(temp/inte+" "+res);
        }else{
            int temp = resut*10+num.charAt(index)-'0';
            int res = temp%inte;
            if(index == 0&&temp/inte==0){
            }else{
                System.out.print(temp/inte);
            }
            process(num,index+1,res,inte);
        }
    }
}
