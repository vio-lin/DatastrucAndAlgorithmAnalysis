package com.violin.PAT2;
import java.util.Scanner;


public class 打印沙漏 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while(scan.hasNext()){
			int sum = scan.nextInt();
			String str = scan.nextLine();
			char c = str.charAt(str.length()-1);
			int floor = count(sum);
			print(floor,c);
			System.out.println(sum-(floor*floor-1)*2-1);
		}
	}

	private static void print(int floor, char c) {
		// TODO Auto-generated method stub
		for(int i=floor;i>0;i--){
			for(int j=0;j<floor-i;j++){
				System.out.print(" ");
			}
			for(int j=0;j<i*2-1;j++){
				System.out.print(c);
			}
			System.out.println();
		}
		for(int i=2;i<=floor;i++){
			for(int j=0;j<floor-i;j++){
				System.out.print(" ");
			}
			for(int j=0;j<i*2-1;j++){
				System.out.print(c);
			}
			System.out.println();
		}
	}

	private static int count(int sum) {
		// TODO Auto-generated method stub
		int count = 0;
		int floor=0;
		while(count<sum){
			floor++;
			count = (floor*floor-1)*2-1;
		}
		return floor-1;
	}
}
