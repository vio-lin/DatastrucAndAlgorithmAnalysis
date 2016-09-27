package com.data.Algorith;

import org.junit.Test;

public class 矩阵相乘最小的解法 {
	public static void optMatrix(int[] c,long[][] m,int[][] lastchange){
		int n =c.length-1;
		for(int left=1;left<=n;left++)
			m[left][left] = 0;
		for(int k=1;k<n;k++){
			for(int left=1;left<=n-k;left++){
				//for each position 
				int right = left+k;
				m[left][right] = Long.MAX_VALUE;
				for(int i=left;i<right;i++){
					long thisCost = m[left][i]+m[i+1][right]+
							c[left-1]*c[i]*c[right];
					if(thisCost<m[left][right]){
						m[left][right] = thisCost;
						lastchange[left][right] = i;
					}
				}
			}
		}
	}
	
	@Test
	public void test(){
		int[] a;
		a= new int[]{50,10,40,30,5};
		int[][] c = new int[a.length][a.length];
		long[][] b = new  long[a.length][a.length];
		 optMatrix(a,b,c);
		 for(int i=0;i<b.length;i++){
			 for(int j=0;j<b[i].length;j++){
				 System.out.format("%8d  ",b[i][j]);
			 }
			 System.out.println();
		 }
	}
}
