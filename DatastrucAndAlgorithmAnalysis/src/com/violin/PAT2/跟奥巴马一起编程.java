package com.violin.PAT2;
import java.util.Scanner;

public class 跟奥巴马一起编程 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while (scan.hasNext()) {
			int a = scan.nextInt();
			char ch = scan.nextLine().charAt(1);
			for (int i = 0; i < (int)(a/2.0+0.5); i++) {
				if (i == 0 || i+1 == (int)(a/2.0+0.5)) {
					for (int j = 0; j < a; j++) {
						System.out.print(ch);
					}
					System.out.println();
				}else{
					System.out.print(ch);
					for (int j = 0; j < a-2; j++) {
						System.out.print(" ");
					}
					System.out.print(ch);
					System.out.println();
				}
			}
		}
	}
}
