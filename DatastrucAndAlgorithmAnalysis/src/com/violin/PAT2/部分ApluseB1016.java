package com.violin.PAT2;
import java.util.Scanner;


/**
 * 2016年10月30日17:26:57
 * @author lin
 */
public class 部分ApluseB1016 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while(scan.hasNext()){
			String line = scan.nextLine();
			String[] context = line.split(" ");
			int cou = Countchar(context[0],context[1],0);
			int cou2 = Countchar(context[2], context[3], 0);
			int var1 = get(cou,context[1]);
			int var2 = get(cou2,context[3]);
			System.out.println(var1+var2);
		}
	}

	private static int get(int cou, String string) {
		// TODO Auto-generated method stub
		int res = 0;
		while(cou!=0){
			res=res*10+(string.toCharArray()[0]-'0');
			cou--;
		}
		return res;
	}

	private static int Countchar(String stringseq, String matcher, int index) {
		// TODO Auto-generated method stub
		int res = stringseq.indexOf(matcher,index);
		if(res == -1){
			return 0;			
		}else{
			return 1+Countchar(stringseq, matcher, res+1);
		}
	}
}
