package com.violin.PAT2;
import java.util.Scanner;

public class 在霍格沃茨找零钱 {
	// “一个加隆(Galleon)兑十七个银西可(Sickle)，一个西可兑二十九个纳特(Knut)
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while (scan.hasNext()) {
			String[] lin = scan.nextLine().split(" ");
			long a = parse(lin[0]);
			long b = parse(lin[1]);
			long c = b -a;
			if (c < 0) {
				System.out.print("-");
				print(-c);
			}else{
				print(c);
			}
		}
	}

	private static void print(long l) {
		// TODO Auto-generated method stub
		System.out.print(l/(17*29)+".");
		System.out.print(l%(17*29)/29+".");
		System.out.print(l%(29));
	}

	private static long parse(String str) {
		// TODO Auto-generated method stub
		String[] temp = str.split("\\.");
		long res = Integer.parseInt(temp[0]) * 17 + Integer.parseInt(temp[1]);
		res = res * 29 + Integer.parseInt(temp[2]);
		return res;
	}
}
