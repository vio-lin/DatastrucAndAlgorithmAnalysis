package com.hihocoder.oct;

import java.util.Scanner;

public class 建造基地1270 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String hhh;
		int Q = scan.nextInt();
		for (int i = 0; i < Q; i++) {
			int N = scan.nextInt();
			int M = scan.nextInt();
			int K = scan.nextInt();
			int T = scan.nextInt();
			int[] Ai = new int[M];
			int[] Bi = new int[M];
			for (int j = 0; j < M; j++) {
				Ai[j] = scan.nextInt();
			}
			for (int j = 0; j < M; j++) {
				Bi[j] = scan.nextInt();
			}
			long sum = 0;
			for (int j = 0; j < N; j++) {
				long ans = getMinCost(j, M, K, T, Ai, Bi);
				if(ans==Long.MAX_VALUE){
					sum = Long.MAX_VALUE;
					break;
				}
				sum += ans;
			}
			if (sum<Long.MAX_VALUE) {
				System.out.println(sum);
			} else {
				System.out.println("No Answer");
			}
		}
	}
	private static long getMinCost(int n, int m, int k, int t, int[] ai,
			int[] bi) {
		// TODO Auto-generated method stub
		long[] f = new long[k + 1];
		for (int i = 0; i < f.length; i++) {
			f[i] = Long.MAX_VALUE;
		}
		f[0] = 0;
		for (int i = 0; i < m; i++) {
			int bi_ = (int) (bi[i] * Math.pow(1.0 / t, n));
			if(bi_==0){
				continue;
			}
			for (int y = 0; y <= k; y++) {
				int x = y + bi_;
				f[Math.min(x, k)] = Math.min(f[Math.min(x, k)],
						f[y]==Long.MAX_VALUE?f[y]:(f[y] + ai[i]));
			}
		}
		return f[k];
	}
}
