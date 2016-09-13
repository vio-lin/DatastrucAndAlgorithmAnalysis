package com.violin.qlcode;

import java.util.Scanner;

import org.junit.Test;

public class 大数相加 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()){
			String a = scanner.nextLine();
			String b = scanner.nextLine();
			if(check(a)&&check(b)){
				System.out.println(a.length()>b.length()?add(a,b):add(b,a));
			}else{
				System.out.println("error");
			}
		}
	}

	private static String add(String a, String b) {
		int len1 = a.length(),len2 =b.length();
		char[] a1 = a.toCharArray();
		char[] b1 = b.toCharArray();
		int len = len1<len2?len1:len2;
		char[] res = new char[len1>len2?len1:len2]; 
		int temp = 0;
		for(int i=0;i<len;i++){
			if((a1[len1-i-1]-'0')+(b1[len2-i-1]-'0')+temp>=10){
				a1[len1-i-1] = (char) ((a1[len1-i-1]-'0')+(b1[len2-i-1]-'0')+temp-10+'0');
				temp=1;
			}else{
				a1[len1-i-1]=(char)((a1[len1-i-1]-'0')+(b1[len2-i-1]-'0')+temp+'0');
				temp=0;
			}
		}
		if(temp==1){
			return "1"+new String(a1);	
		}else{
			return new String(a1);
		}
		
		
	}

	private static boolean check(String b) {
		// TODO Auto-generated method stub
		for(char a : b.toCharArray()){
			if(!(a>='0'&&a<='9')){
				return false;
			}else 
				return true;
		}
		return false;
	}
	@Test
	public void checkNUm(){
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()){
			String temp = scanner.nextLine();
			System.out.println(check1(temp));
		}
	}
	
	private static boolean check1(String b){
		return b.matches("\\d*");
	}
}

