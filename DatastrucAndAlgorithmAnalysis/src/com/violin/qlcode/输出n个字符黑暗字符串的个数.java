package com.violin.qlcode;
/**
 *  输入一个数字 使用ABC 三种字符进行填充 输出排列组合 
 *  并输出其中不包含  (temp.indexOf("BCA")==-1)&&(temp.indexOf("BAC")==-1)&&(temp.indexOf("ABC")==-1)&&(temp.indexOf("ACB")==-1)&&(temp.indexOf("CAB")==-1)&&(temp.indexOf("CBA")==-1)
 *  的所有字符串的个数
 */
import java.util.ArrayList;
import java.util.Scanner;


public class 输出n个字符黑暗字符串的个数 {
	public static ArrayList<String> list = new ArrayList<>();
	public static int  num;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String a[] = new String[]{"A","B","C"};
		while(scan.hasNext()){
			num = scan.nextInt();
			int  count = 0;
			genera(a,"");
			for(int j=0;j<list.size();j++){
				if(check(list.get(j))){
					count++;
				}
				
			}
			System.out.println(count);
		}
	}

	private static void genera(String[] a,String temp) {
		// TODO Auto-generated method stub
		if(temp.length()==num){
			list.add(temp);
		}else{
			for(int i=0;i<a.length;i++){
				String str = temp;
				str += a[i];
				genera(a,str);
			}
		}
	}

	private static int num(int ind, int count,String[] a) {
		// TODO Auto-generated method stub
		String temp;
		return 0;
	}

	private static boolean check(String temp) {
		// TODO Auto-generated method stub
		return ((temp.indexOf("BCA")==-1)&&(temp.indexOf("BAC")==-1)&&(temp.indexOf("ABC")==-1)&&(temp.indexOf("ACB")==-1)&&(temp.indexOf("CAB")==-1)&&(temp.indexOf("CBA")==-1));
	}
}
