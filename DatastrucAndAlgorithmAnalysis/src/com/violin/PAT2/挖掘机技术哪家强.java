package com.violin.PAT2;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;


public class 挖掘机技术哪家强 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		ArrayList<School> list = new ArrayList<>();
		while(scan.hasNext()){
			int count = scan.nextInt();
			for(int i=0;i<count;i++){
				int number  = scan.nextInt();
				int grade = scan.nextInt();
				School sc = new School(number,grade);
				if(list.contains(sc)){
					list.get(list.indexOf(sc)).add(grade);
				}else{
					list.add(sc);
				}
			}
			Collections.sort(list,new Comparator<School>() {

				@Override
				public int compare(School o1, School o2) {
					// TODO Auto-generated method stub
					return o2.grades-o1.grades;
				}
			});
			System.out.println(list.get(0).number+" "+list.get(0).grades);
		}
	}
}
class School{
	public int  number;
	public int grades;
	
	public School(int number,int grade){
		this.number = number;
		this.grades = grade;
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		School ob = (School) obj;
		return this.number==ob.number;
	}
	
	public void add(int grade){
		this.grades += grade;
	}
}
