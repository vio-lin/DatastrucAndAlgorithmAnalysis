package com.violin.PAT2;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import javax.swing.plaf.metal.MetalIconFactory.TreeLeafIcon;

public class 德才论 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while(scan.hasNext()){
			int N = scan.nextInt();
			int L = scan.nextInt();
			int H = scan.nextInt();
			//all
			List<people> list1 = new ArrayList<people>();
			//d>l
			List<people> list2 = new ArrayList<people>();
			//d>c
			List<people> list3 = new ArrayList<people>();
			//c>l
			List<people> list4 = new ArrayList<people>();
			scan.nextLine();
			for(int i = 0;i<N;i++){
				String line = scan.nextLine();
				String[] context = line.split(" ");
				people  temp = new people();
				temp.num = context[0];
				temp.virtune = Integer.valueOf(context[1]);
				temp.skill = Integer.valueOf(context[2]);
				if(temp.virtune>=H&&temp.skill>=H){
					list1.add(temp);
				}else if(temp.virtune>=L&&temp.skill>=L){
					if(temp.virtune>=H){
						list2.add(temp);
					}else if(temp.virtune>=temp.skill){
						list3.add(temp);
					}else{
						list4.add(temp);
					}
				}
			}
			Comparator<people> mycomparator = new Comparator<people>(){

				@Override
				public int compare(people o1, people o2) {
					// TODO Auto-generated method stub
					int sum = o1.skill+o1.virtune;
					int sum2 = o2.skill+o2.virtune; 
					if(sum!=sum2){
						return sum2-sum;						
					}else if(o1.virtune!=o2.virtune){
						return o2.virtune -o1.virtune;
					}else{
						return o1.num.compareTo(o2.num);
					}
					}
				};
			Collections.sort(list1,mycomparator);
			Collections.sort(list2,mycomparator);
			Collections.sort(list3,mycomparator);
			Collections.sort(list4,mycomparator);
			list1.addAll(list2);
			list1.addAll(list3);
			list1.addAll(list4);
			System.out.println(list1.size());
			for(people temp:list1){
				System.out.println(temp.num +" "+ temp.virtune +" "+temp.skill);
			}
		}
	}
}

class people {
	public String num;
	public int  virtune; // 美德通过歌谣在传唱
	public int  skill;
}