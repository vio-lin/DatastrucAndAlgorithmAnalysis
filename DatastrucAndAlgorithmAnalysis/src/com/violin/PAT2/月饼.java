package com.violin.PAT2;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class 月饼 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while (scan.hasNext()) {
			int kinds = scan.nextInt();
			int weight = scan.nextInt();
			scan.nextLine();
			String[] weis = scan.nextLine().split(" ");
			String[] pric = scan.nextLine().split(" ");
			ArrayList<Factory> list = new ArrayList<>();
			for (int i = 0; i < kinds; i++) {
				int wei = Integer.valueOf(weis[i]);
				int price = Integer.valueOf(pric[i]);
				Factory fac = new Factory(wei, price);
				list.add(fac);
			}
			Collections.sort(list, new Comparator<Factory>() {
				@Override
				public int compare(Factory o1, Factory o2) {
					// TODO Auto-generated method stub
					
					if(Math.abs(o2.pricede - o1.pricede)<0.00000001){
						return 0;
					}else{
						return (o2.pricede - o1.pricede)>0?1:-1;
					}
				}
			});
			float res = 0;
			for (int i = 0; i < list.size(); i++) {
				Factory fac = list.get(i);
				if (weight > fac.weight) {
					weight -= fac.weight;
					res += fac.price;
				} else {
					res += weight * fac.pricede;
					break;
				}
			}
			System.out.printf("%.2f", res);
		}
	}
}

class Factory {
	public int weight;
	public int price;
	public float pricede;

	public Factory(int weight, int price) {
		this.weight = weight;
		this.price = price;
		this.pricede = ((float) price) / weight;
	}

}
