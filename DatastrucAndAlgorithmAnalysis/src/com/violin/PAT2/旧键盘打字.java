package com.violin.PAT2;
import java.util.Scanner;


public class 旧键盘打字 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while(scan.hasNext()){
			char[] a = scan.nextLine().toCharArray();
			String str = scan.nextLine();
			for(int i=0;i<a.length;i++){
				if(a[i]=='+'){
					str = str.replaceAll("[A-Z]", "");					
				}else{
					str = str.replace(Character.toLowerCase(a[i])+"", "");
					str = str.replace(a[i]+"", "");
				}
			}
			System.out.println(str);
		}
	}
}
