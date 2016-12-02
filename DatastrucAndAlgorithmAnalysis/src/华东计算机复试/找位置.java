package 华东计算机复试;
import java.util.Scanner;
public class 找位置{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){
            String str = scan.nextLine();
            for(int i=0;i<str.length();i++){
            	if(str.charAt(i)!='#'){
            		char a = str.charAt(i);
            		if(str.indexOf(a)!=str.lastIndexOf(a)){
            			System.out.print(a+":"+str.indexOf(a));
            			while((str=str.replaceFirst(a+"", "#")) != null){
            				if(str.indexOf(a)==-1){
            					System.out.println();
            					break;
            				}
            				System.out.print(","+a+":"+str.indexOf(a));            				
            			}
            		}
            	}
            }
        }
    }
}