package com.violin.PAT2;
import java.util.Scanner;


public class 统计同成绩学生 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while(scan.hasNext()){
			int[] grade = new int[101];
			int sum = scan.nextInt();
			for(int i=0;i<sum;i++){
				int temp = scan.nextInt();
				grade[temp]++;
			}
			int count = scan.nextInt();
			for(int i=0;i<count;i++){
				if(i==0){
					System.out.print("");
				}else{
					System.out.print(" ");
				}
				int temp = scan.nextInt();
				System.out.print(grade[temp]);
			}
		}
	}
}
