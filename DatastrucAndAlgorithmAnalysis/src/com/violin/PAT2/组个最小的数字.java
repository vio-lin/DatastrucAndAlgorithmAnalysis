package com.violin.PAT2;
import java.util.Scanner;


public class 组个最小的数字 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while(scan.hasNext()){
			String str = scan.nextLine();
			String[] array = str.split("\\s+");
			int[] num = new int[10];
			for(int i=0;i<10;i++){
				int number = Integer.valueOf(array[i]);
				num[i] = Integer.valueOf(array[i]);
			}
			for(int i=1;i<10;i++){
				if(num[i]!=0){
					System.out.print(i);
					num[i]--;
					break;
				}
			}
			print(num);
		}
	}

	private static void print(int[] num) {
		// TODO Auto-generated method stub
		for(int i=0;i<10;i++){
			int sum = num[i];
			while(sum!=0){
				System.out.print(i);
				sum--;
			}
		}
	}
}
