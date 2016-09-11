package com.data.homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import org.junit.Test;
/**
 * 输出前k个最大值  ；字谜游戏 算出包含的的东西； 递归写出1的个数 ；递归写出字符串所有的排列组合
 * @author lin
 *
 */

public class Ex1 {

/**
 * 编写一个程序解决选择问题，令k=N/2画出表格显示程序对于N中不同值的运算时间 求解出里面的前 k个大小的数字
 * 
 */
	@Test
	public void serchk(){
		long start = System.currentTimeMillis();
		System.out.println(start);
		int[] a = new int[]{1,2,3,4,8,5,6,2,5,1,85,8,4,5,5,5,87,4,45,7,78,9,80,156,4,5,3,2,43,4,1,2,3,4,8,5,6,2,5,1,85,8,4,5,5,5,87,4,45,7,78,9,80,156,4,5,3,2,43,4,1,2,3,4,8,5,6,2,5,1,85,8,4,5,5,5,87,4,45,7,78,9,80,156,4,5,3,2,43,4,1,2,3,4,8,5,6,2,5,1,85,8,4,5,5,5,87,4,45,7,78,9,80,156,4,5,3,2,43,4,1,2,3,4,8,5,6,2,5,1,85,8,4,5,5,5,87,4,45,7,78,9,80,156,4,5,3,2,43,4,1,2,3,4,8,5,6,2,5,1,85,8,4,5,5,5,87,4,45,7,78,9,80,156,4,5,3,2,43,4};
		int k = a.length/2;
		int[] b = new int[k];
		for(int i=0;i<a.length;i++){
			for(int j=b.length-1;j>=0;j--){
				if(b[b.length-1]>=a[i]){
					break;
				}else if(a[i]>b[j]&&a[i]>b[j-1]){
					b[j]=b[j-1];
					if(j==1){
						b[0]=a[i];
					}
				}else if(a[i]>b[j]&&a[i]<b[j-1]){
					b[j] = a[i];
					break;
				}
			}
		}
		System.out.println(Arrays.toString(b));
		long end = System.currentTimeMillis();
		System.out.println(end);
		System.out.println("time："+(end-start));
	}
        /**
         * 编写程序 求解字谜游戏  二维数组上字符串 四个方向
         */
	public static void outPutlogoGriph(String temp,String[] logogriph){
		for(int k=0;k<logogriph.length;k++){
			if(temp.indexOf(logogriph[k])>=0){
				System.out.println(logogriph[k]);
			}
		}
	}
	//比较字谜中的单词
	public static void getLogoGriph(String[][] s,String[] logogriph){
		String temp = "";
		// 查找水平方向上的单词,从左往右的方向
		for(int i=0;i<s.length;i++){
			//正序的
			temp  = "";
			for(int j=0;j<s[i].length;j++){
				temp += s[i][j];
			}
			//比较,并输出字谜中的单词
			outPutlogoGriph(temp,logogriph);
			//逆序的
			temp  = "";
			for(int j=s[i].length-1;j>=0;j--){
				temp += s[i][j];
			}
			//比较,并输出字谜中的单词
			outPutlogoGriph(temp,logogriph);
		}
//		 查找垂直方向上的单词,从上往下的方向
//		 查找垂直方向上的单词,从下往上的方向
		temp = "";
		for(int i=0;i<s[0].length;i++){
			//上下方向的
			temp = "";
			for(int j=0;j<s.length;j++){
				temp += s[j][i];
			}
			//比较,并输出字谜中的单词
			outPutlogoGriph(temp,logogriph);
			//下上方向的
			temp = "";
			for(int j=s.length-1;j>=0;j--){
				temp += s[j][i];
			}
			//比较,并输出字谜中的单词
			outPutlogoGriph(temp,logogriph);
		}
		//查找第一条对角线（从上往下的对角线）上的单词,正方向(针对的是规则的二维数组)
		temp = "";
		for(int i=0;i<s.length;i++){
			temp += s[i][i];
		}
		//正向的
		//比较,并输出字谜中的单词
		outPutlogoGriph(temp,logogriph);
		// 查找对角线上的单词,反方向
		temp = "";
		for(int i= s.length-1;i>=0;i--){
			temp += s[i][i];
		}
		//比较,并输出字谜中的单词
		outPutlogoGriph(temp,logogriph);
		//查找第二条对角线,从下往上的对角线
		temp = "";
		for(int i=0;i<s.length;i++){
			temp += s[s.length-i-1][i];
		}
		//正向的(斜向上)
		//比较,并输出字谜中的单词
		outPutlogoGriph(temp,logogriph);
		temp = "";
		for(int i=0;i<s.length;i++){
			temp += s[i][s.length-i-1];
		}
		//正向的(斜向下)
		//比较,并输出字谜中的单词
		outPutlogoGriph(temp,logogriph);
	}
	@Test
	public  void serchchar(){
		//注意该方法只适用于规则的数组，即不允许String[][]s = new String[4][]这种不规则的数组;
		String[][] s = new String[4][4];
		s[0][0] = "t";
		s[0][1] = "t";
		s[0][2] = "i";
		s[0][3] = "f";
		s[1][0] = "t";
		s[1][1] = "h";
		s[1][2] = "a";
		s[1][3] = "o";
		
		s[2][0] = "w";
		s[2][1] = "t";
		s[2][2] = "a";
		s[2][3] = "w";
		
		s[3][0] = "o";
		s[3][1] = "s";
		s[3][2] = "a";
		s[3][3] = "t";
		String[] logogriph = new String[]{"this","two","fat","that"};
		getLogoGriph(s,logogriph);
	}
	/**
	 * 递归 编写输出1的个数 原理 如果N是奇数那么1的个数等于N/2的二进制中1的个数加1
	 *假如是偶数的话 也是一样的把
	 */
	
	@Test
	public void countone(){
		int i=50;
		System.out.println(count (i));
	}
	public int count(int i){
		if(i==1||i==2){
			return 1;
		}else{
			if(i%2==0){
				return (count(i/2)); 
			}else{
				return (count(i/2)+1); 				
			}
		}
	}
	
	/**
	 * 输出一个字符串的排列组合
	 */
	public static int funself ( String array,ArrayList<String> result){
		int len = array.length();
		if(len==0){
			for(int i=0;i<result.size();i++){
					if(result.get(i).length()==4){
						System.out.println(result.get(i));
					}
			}
			return 0;
		}
		for(int i=0;i<len;i++){ //两块递归 然后前面是子串 后面result 
			ArrayList<String> res  = new ArrayList<String>();
			if(result.size()>0){
				int temp= result.size();
				for(int j=0;j<temp;j++){	 
						res.add( result.get(j)+array.substring(i,i+1));				
				}			
			}else{
				res .add( array.substring(i,i+1));
			}	
			String substring = array.substring(0,i)+array.substring(i+1);
			funself(substring, res);
		}
		return 0;
	}
	@Test
	public void changein(){
		Scanner scaner = new Scanner(System.in);
		ArrayList<String> result = new ArrayList<String>();
//		while (scaner.hasNext()) {
//			String str = scaner.nextLine();
		String str = "1234";
		funself(str, result);
//		}
	}	 
		public static String str = "abcd";
		@Test
	    public void substring()
	    {
	        show(0, new String());
	    }
	    public static void show(int current_recur, String temp)
	    {
	        if(current_recur < str.length())
	        {
	            for(int i = 0; i < str.length(); i++)
	            {
	                if( ! ( temp.contains(str.substring(i, i + 1)) ) )
	                {
	                    System.out.println(temp + str.substring(i, i + 1));
	                    show(current_recur + 1, new String(temp + str.substring(i, i + 1)));
	                }
	            }
	        }
	    }
	
}
