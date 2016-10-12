package com.violin.qlcode;

//贪心算法
public class 最大不超过  {
	private String a ="s";
	public static void main(String[] args) {	
		int[] produ = new int[]{509,838,924,645,604,793,564,651,697,649,747,787,701,605,644};
		int sum =0;
		while(max(produ)!=-1){ 
			if(sum+produ[max(produ)]<=5000){
				sum+=produ[max(produ)];
				System.out.println(max(produ));
				produ[max(produ)]=0;
			}else{ 
				produ[max(produ)]=0;
			}
		}
		System.out.println(sum);
	}
	public static int max(int[] pro){
		int max=1;
		int index =-1;
		for(int i=0;i<pro.length;i++){
			if(max<pro[i]){
				max=pro[i];
				index=i;
			}
		}
		return index;
	}
}

