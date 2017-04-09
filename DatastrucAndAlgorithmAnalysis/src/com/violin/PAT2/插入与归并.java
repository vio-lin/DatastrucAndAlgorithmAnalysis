package com.violin.PAT2;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class 插入与归并 {
	public static ArrayList<String> list = new ArrayList<>();

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while (scan.hasNext()) {
			int sum = scan.nextInt();
			int[] data1 = new int[sum];
			int[] data2 = new int[sum];
			for (int i = 0; i < sum; i++) {
				data1[i] = scan.nextInt();
			}
			for (int i = 0; i < sum; i++) {
				data2[i] = scan.nextInt();
			}
			int[] org = Arrays.copyOf(data1, data1.length);
			List<String> res1 = Insertsort(org);
			int[] temp = new int[data1.length];
			mergeSort(data1, temp, 0, data1.length - 1);
			System.out.println(list);
			if (res1.contains(toString(data2))) {
				System.out.println("Insertion Sort");
				System.out.println(res1.get((res1.indexOf(toString(data2)) + 1)));
			} else {
				System.out.println("Merge Sort");
				System.out.println(list.get((list.indexOf(toString(data2)) + 1)));
			}
		}

	}

	private static void mergeSort(int[] a, int[] b, int left, int right) {
		// TODO Auto-generated method stub
		if (left < right) {
			int center = (left + right) / 2;
			mergeSort(a, b, left, center);
			mergeSort(a, b, center + 1, right);
			merge(a, b, left, center + 1, right);
			list.add(toString(a));
		}
	}

	private static void merge(int[] a, int[] tempArray, int leftPos,
			int righPos, int rightEnd) {
		int leftEnd = righPos - 1;
		int tempPos = leftPos;
		int numElement = rightEnd - leftPos + 1;
		// main
		while (leftPos <= leftEnd && righPos <= rightEnd) {
			if (a[leftPos] < a[righPos])
				tempArray[tempPos++] = a[leftPos++];
			else
				tempArray[tempPos++] = a[righPos++];
		}
		while (leftPos <= leftEnd) {
			tempArray[tempPos++] = a[leftPos++];
		}
		while (righPos <= rightEnd) {
			tempArray[tempPos++] = a[righPos++];
		}

		// copy back
		for (int i = 0; i < numElement; i++, rightEnd--) {
			a[rightEnd] = tempArray[rightEnd];
		}
	}

	private static String toString(int[] insertsort) {
		// TODO Auto-generated method stub
		String res = "";
		for (int i = 0; i < insertsort.length; i++) {
			if (i == insertsort.length - 1) {
				res += insertsort[i];
			} else {
				res += insertsort[i] + " ";
			}
		}
		return res;
	}

	private static List<String> Insertsort(int[] data1) {
		// TODO Auto-generated method stub
		ArrayList<String> list = new ArrayList<>();
		for (int i = 1; i < data1.length; i++) {
			int j;
			int temp = data1[i];
			for (j = i; j > 0 && data1[j - 1] > temp;)
				data1[j--] = data1[j];
			data1[j] = temp;
			list.add(toString(data1));
		}
		return list;
	}
}
