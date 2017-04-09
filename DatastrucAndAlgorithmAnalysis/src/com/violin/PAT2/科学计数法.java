package com.violin.PAT2;
import java.util.Scanner;


public class 科学计数法 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while(scan.hasNext()){
			String line = scan.nextLine();
			char pm = line.charAt(0);
			if(pm=='-'){
				System.out.print("-");
			}
			int zero = Integer.parseInt(line.split("E")[1]);
			String num = line.substring(1).split("E")[0];
			if(zero<0){
				System.out.print(0.);
				for(int i=-zero;i>2;i--){
					System.out.print(0);
				}
				System.out.print(num.replace(".",""));
			}else if(zero==0){
				System.out.print(num.replace(".",""));
			}else{
				if(num.length()-2>zero){
					System.out.print(num.replace(".","").substring(0,zero+1)+".");
					System.out.print(num.replace(".","").substring(zero+1));
				}else{
					System.out.print(num.replace(".",""));
					for(int i=0;i<zero-num.length()+2;i++){
						System.out.print("0");
					}
				}
			}
		}
	}
}
