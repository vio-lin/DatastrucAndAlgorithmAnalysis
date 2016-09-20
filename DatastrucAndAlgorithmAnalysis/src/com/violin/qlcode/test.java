package com.violin.qlcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.TreeMap;

import org.junit.Test;

public class test {
	public static void main(String[] args) {
		List<String> list;
		list =  Arrays.asList("askdj,asdasd,asdas,d,rg,gt,yt,u,ui,ui,".split(","));
		System.out.println(list);
	}
	
	@Test
	public void testtreemap(){
		TreeMap<String,Integer> map = new TreeMap<>(new Comparator<String>() {
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				int len = o1.length()>o2.length()?o2.length():o1.length();
				char[] a1 = o1.toCharArray();
				char[] a2 = o2.toCharArray();
				for(int i=0;i<len;i++){
					if(a1[i]==a2[i]){
						continue;
					}else{
						return a1[i]-a2[i];
					}
				}
				return 0;
			}
		});
		map.put("Thunder", 45);
		map.put("Wind",878 );
		map.put("Soil", 145);
		System.out.println(map);
		System.out.println(map.keySet());
	}
}
