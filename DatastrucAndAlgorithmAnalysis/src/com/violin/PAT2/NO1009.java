package com.violin.PAT2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class NO1009 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in); 
		while(scan.hasNext()){
			String str = scan.nextLine();
			String[] arr = str.split(" ");
			LinkedList<String> list = new LinkedList<String>();
			list.addAll(Arrays.asList(arr));
			while(list.size()>0){
				System.out.print(list.removeLast());
				if(list.size()!=0)
				{
					System.out.print(" ");
				}
			}
		}
	}
}
