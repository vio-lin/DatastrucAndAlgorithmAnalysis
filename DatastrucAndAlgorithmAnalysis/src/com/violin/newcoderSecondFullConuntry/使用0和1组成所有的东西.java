package com.violin.newcoderSecondFullConuntry;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class 使用0和1组成所有的东西 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int lines =scan.nextInt();
        int zenu = scan.nextInt();
        int onenu = scan.nextInt();
        int[] ones=new int[lines],zeros=new int[lines];
        scan.nextLine();
        for(int i=0;i<lines;i++){
            String line = scan.nextLine();
            ones[i] = findone(line);
            zeros[i] = findzeor(line);
        }
        System.out.println(findmax(0,0,zenu,onenu,ones,zeros));
    }

    private static int findmax(int sum,int i, int zenu, int onenu, int[] ones,
            int[] zeros) {
        // TODO Auto-generated method stub
        if(i==ones.length-1){
            if(zenu>=zeros[i]&&onenu>=ones[i]){
                return sum+1;
            }
            return sum;
        }else{
            int nosel=findmax(sum,i+1,zenu,onenu,ones,zeros);
            if(zenu-zeros[i]>=0&&onenu-ones[i]>=0){
                int sel = findmax(sum+1, i+1, zenu-zeros[i], onenu-ones[i], ones, zeros);                
                if(sel>nosel){
                    return sel;
                }
            }
            return nosel;
        }
    }

    private static int findzeor(String line) {
        // TODO Auto-generated method stub
        Pattern pa = Pattern.compile("[0]");
        Matcher ma = pa.matcher(line);
        int temp = 0;
        while(ma.find()){
            temp++;
        }
        return temp;
    }

    private static int findone(String line) {
        // TODO Auto-generated method stub
        Pattern pa = Pattern.compile("[1]");
        Matcher ma = pa.matcher(line);
        int temp = 0;
        while(ma.find()){
            temp++;
        }
        return temp;
    }
}
