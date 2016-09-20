package com.violin.qlcode;

import java.awt.Image;

//贪心算法
public class bieodary {
	public static void main(String[] args) {
		int[] produ = new int[] { 32, 33, 44, 72, 87, 100, 101, 108, 111, 114 };
		for (int j = 1; j < 100; j++) {
			int count=0;
			for (int i = 0; i < produ.length; i++) {
				if(produ[i]%j>10||produ[i]/j>10){
					count++;
				}
			}
			if(count==0){
				System.out.println(j);
			}
		}

	}
}
