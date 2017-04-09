package com.violin.PAT2;
import java.util.Scanner;

public class 身份证校验 {
	public static void main(String[] args) {
		int[] priproty = new int[] { 7, 9, 10, 5, 8, 4, 2, 1,6, 3, 7, 9, 10, 5,
				8, 4, 2 };
		char[] chage = new char[] { '1', '0', 'X', '9', '8', '7', '6', '5',
				'4', '3', '2' };
		Scanner scan = new Scanner(System.in);
		while (scan.hasNext()) {
			int count = scan.nextInt();
			scan.nextLine();
			boolean flag = true;
			for (int i = 0; i < count; i++) {
				char[] ch = scan.nextLine().toCharArray();
				int z = 0;
				boolean fla = true;
				for (int j = 0; j < 17; j++) {
					if(ch[j]-'0'<0||ch[j]-'0'>9){
						fla = false;
						break;
					}
					z = (z + (ch[j]-'0')*priproty[j])%11;	
				}
				if(ch[17]!=chage[z]||!fla){
					System.out.println(ch);
					flag = false;
				}
			}
			if(flag){
				System.out.println("All passed");
			}
		}
	}
}
