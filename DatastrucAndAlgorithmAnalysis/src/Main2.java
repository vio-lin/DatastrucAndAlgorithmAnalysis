import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.Scanner;


public class Main2{

    /*请完成下面这个函数，实现题目要求的功能*/
    /*当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^ */
    /******************************开始写代码******************************/
    static int run(String numbers){
        int Count=0;  
        for(int i=1;i<numbers.length();i++)  
        {  
            for(int j=0;j<i;j++)  
            {  
              int a=(numbers.charAt(i)-'0');  
              int b=(numbers.charAt(j)-'0');  
              if(a<b)  
              {  
                  Count++;  
              }  
            }  
        } 
        int temp = numbers.indexOf("0");
        Count = Count +temp/3+temp%3;
        if(Count==0){
            return 0;
        }else if(Count%2==0){
            return Count;            
        }else{
            return -1;
        }
    }
   /******************************结束写代码******************************/
   
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
      
        String numbers = new String();
        for(int rows=3; rows>0; rows--){
            for(String n: scan.nextLine().split(" ")){
                numbers += n;
            }
        }
 
        int res = run(numbers);
      
        System.out.println(String.valueOf(res));
    }
}

