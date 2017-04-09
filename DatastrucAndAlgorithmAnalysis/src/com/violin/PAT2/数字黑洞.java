package com.violin.PAT2;
import java.util.Scanner;


public class 数字黑洞 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while(scan.hasNext()){
			int num = scan.nextInt();
			StringBuilder sb = new StringBuilder(num+"");
			while(sb.length()<4){
				sb.insert(0, '0');
			}
			sb = Sort(sb);
			String m2 = sb.toString();
			String m1 = sb.reverse().toString();
			int res = Integer.parseInt(m1)-Integer.parseInt(m2);
			if(res==0){
				System.out.println(m1+" - "+m2+" = "+"0000");
				return;
			}
			System.out.println(m1+" - "+m2+" = "+res);
			BlackHook(res);
		}
	}

	private static void BlackHook(int num) {
		// TODO Auto-generated method stub
		if(num==6174){
			return;
		}else{
			StringBuilder sb = new StringBuilder(num+"");
			sb = Sort(sb);
			String m2 = sb.toString();
			String m1 = sb.reverse().toString();
			int res = Integer.parseInt(m1)-Integer.parseInt(m2);
			System.out.println(m1+" - "+m2+" = "+res);
			BlackHook(res);
		}
	}

	private static StringBuilder Sort(StringBuilder sb) {
		// TODO Auto-generated method stub
		StringBuilder temp = new StringBuilder();
		for(int i=0;i<sb.length();i++){
			int t=-1;
			for(int j=0;j<temp.length();j++){
				t= j;
				if(sb.charAt(i)<=temp.charAt(j))
				{
					temp.insert(j,sb.charAt(i));
					break;
				}
			}
			if(t==temp.length()-1){
				temp.insert(temp.length(),sb.charAt(i));
			}
		}
		return temp;
	}
}
