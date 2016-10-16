package com.violin.qlcode;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//动态规划
public class 输入n个字符黑暗字符串的个数 {
	public static char[] temp;
	public static Map<String,Long> res;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		res = new HashMap<String, Long>();
		while(scan.hasNext()){
			int num = scan.nextInt();
			temp = new char[]{'A','B','C'};
			Long result = count("",num);
			System.out.println(result);
		}
	}

	private static Long count(String string, int num) {
		// TODO Auto-generated method stub
		Long count =0l;
		if(num==0){
			return 1l;
		}
		for(int i=0;i<temp.length;i++){
			String str = string;
			str+=temp[i];
			if(check(str)){
				if(str.length()>3){
					if(res.get(str.substring(str.length()-2)+num)!=null){
						count = count + res.get(str.substring(str.length()-2)+num);
					}else{
						Long result = count(str,num-1);
						count = count+result;
						res.put(str.substring(str.length()-2)+num, new Long(result));
					}					
				}
				else{
					Long result = count(str,num-1);
					count = count+result;
				}
			}else{
				continue;
			}
		}
		return count;
	}
	
	private static boolean check(String temp) {
		// TODO Auto-generated method stub
		return ((temp.indexOf("BCA")==-1)&&(temp.indexOf("BAC")==-1)&&(temp.indexOf("ABC")==-1)&&(temp.indexOf("ACB")==-1)&&(temp.indexOf("CAB")==-1)&&(temp.indexOf("CBA")==-1));
	}
}
