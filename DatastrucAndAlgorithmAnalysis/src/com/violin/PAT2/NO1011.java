package com.violin.PAT2;

import java.util.Scanner;

public class NO1011 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while(scan.hasNext()){
			int num = scan.nextInt();
			scan.nextLine();
			for(int i = 0;i<num;i++){
				String data = scan.nextLine();
				String[] a = data.split("\\s+");
				Long paraA = Long.valueOf(a[0]);
				Long paraB = Long.valueOf(a[1]);
				Long paraC = Long.valueOf(a[2]);
				System.out.println("Case #"+(i+1)+": "+(paraA+paraB>paraC));
			}
		}
	}
}
