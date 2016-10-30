package com.violin.PAT2;
import java.util.Scanner;

/**
 * @author lin
 */
public class 石头剪刀布 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while(scan.hasNext()){
			int num = scan.nextInt();
			int C1=0,J1=0,B1=0,C2=0,J2=0,B2=0;
			int win=0,equl=0,lose=0;
			scan.nextLine();
			for(int i=0;i<num;i++){
				String line = scan.nextLine();
				String[] context = line.split(" ");
				if(context[1].equals(context[0])){
					equl++;
				}else if(challange(context[0],context[1])){
					if(context[0].equals("J")){
						J1++;
					}else if(context[0].equals("C")){
						C1++;
					}else{
						B1++;
					}
					win++;
				}else{
					if(context[0].equals("B")){
						J2++;
					}else if(context[0].equals("J")){
						C2++;
					}else{
						B2++;
					}
					lose++;
				}
			}
			System.out.println(win+" "+equl+" "+lose);
			System.out.println(lose+" "+equl+" "+win);
			System.out.println(max(J1,C1,B1)+" "+ max(J2,C2,B2));
 		}
	}

	private static String max(int j2, int c2, int b2) {
		// TODO Auto-generated method stub
		if(b2>=c2&&b2>=j2){
			return "B";
		}
		if(c2>=b2&&c2>=j2){
			return "C";
		}
		return "J";
	}

	private static boolean challange(String string, String string2) {
		// TODO Auto-generated method stub
		if("C".equals(string)&&"J".equals(string2)){
			return true;
		}
		if("J".equals(string)&&"B".equals(string2)){
			return true;
		}
		if("B".equals(string)&&"C".equals(string2)){
			return true;
		}
		return false;
	}
}
