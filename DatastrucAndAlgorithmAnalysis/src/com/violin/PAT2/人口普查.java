package com.violin.PAT2;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeMap;



public class 人口普查 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while(scan.hasNext()){
			int sum = scan.nextInt();
			scan.nextLine();
			String max ;
			String min;
			TreeMap<String, String> peoples = new TreeMap<>(new Comparator<String>() {

				@Override
				public int compare(String o1, String o2) {
					// TODO Auto-generated method stub
					return o1.compareTo(o2);
				}
			});
			int res = 0;
			for(int i=0;i<sum;i++){
				String temp = scan.nextLine();
				String name = temp.split(" ")[0];
				String date = temp.split(" ")[1];
				if(date.compareTo("2014/09/06")>0||date.compareTo("1814/09/06")<0){
					continue;
				}else{
					res++;
					peoples.put(date, name);
				}
			}
			System.out.println(res+" "+peoples.firstEntry().getValue()+" "+peoples.lastEntry().getValue());
		}
	}
}
