package com.violin.PAT2;
import java.util.Scanner;


public class 福尔摩斯的约会 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while(scan.hasNext()){
			String str1 = scan.nextLine();
			String str2 = scan.nextLine();
			String str3 = scan.nextLine();
			String str4 = scan.nextLine();
			boolean flag = true;
			for(int i=0;i<str1.length();i++){
				if(str1.charAt(i)==str2.charAt(i)){
					if(flag&&('A'<=str1.charAt(i)&&str1.charAt(i)<='Z')){
						System.out.print(changetoday(str1.charAt(i)-'A')+" ");
						flag = false;
					}else if(flag == false){
						System.out.print(changetotime(str1.charAt(i))+":");
						break;
					}
				}
			}
			
			for(int i = 0;i < str3.length();i++){
				if(str3.charAt(i)==str4.charAt(i)&&Character.isAlphabetic(str3.charAt(i))){
					if(i<10){
						System.out.print("0"+i);						
					}else{
						System.out.print(i+"");
					}
					break;
				}
			}
		}
	}
	
	private static String changetotime(char charAt) {
		// TODO Auto-generated method stub
		if(charAt>='0'&&charAt<='9'){
			return "0"+(charAt-'0');
		}else{
			return Character.toUpperCase(charAt) - 'A' + 10+"";
		}
	}

	/**
	 * 即MON表示星期一，TUE表示星期二，WED表示星期三，THU表示星期
四，FRI表示星期五，SAT表示星期六，SUN表示星期日。题目输入保证每个测试存在唯一解。
	 * @param i
	 * @return
	 */
	public static String changetoday(int i){
		String day= "";
		switch(i){
		case 0 :  day = "MON";
			break;
		case 1 :  day = "TUE";
		break;
		case 2 :  day = "WED";
		break;
		case 3 :  day = "THU";
		break;
		case 4 :  day = "FRI";
		break;
		case 5 :  day = "SAT";
		break;
		case 6 :  day = "SUN";
		break;
		}
		return day;
	}
}
