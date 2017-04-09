package com.violin.PAT2;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;


public class 旧键盘 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while(scan.hasNext()){
			char[] a = scan.nextLine().toCharArray();
			char[] b = scan.nextLine().toCharArray();
			int j = 0;
			List<Character> list = new ArrayList<Character>();
			for(int i=0;i<a.length;i++){
				if(j<b.length){
					if(a[i]==b[j]){
						j++;
					}else{
						if(list.contains(Character.toUpperCase(a[i]))){
							continue;
						}
						list.add(Character.toUpperCase(a[i]));
						System.out.print(Character.toUpperCase(a[i]));
					}
				}else{
					if(list.contains(Character.toUpperCase(a[i]))){
						continue;
					}
					list.add(Character.toUpperCase(a[i]));
					System.out.print(Character.toUpperCase(a[i]));
				}
				
			}
		}
	}
}
