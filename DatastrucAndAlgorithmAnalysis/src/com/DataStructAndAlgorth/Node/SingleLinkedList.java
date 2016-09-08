package com.DataStructAndAlgorth.Node;

public class SingleLinkedList {
	public static void main(String[] args) {
		Node ss = new Node(5);
		int[] a = new int[] { 5, 6, 8, 2, 8, 354, 23, 5, 24, 2, 6, 8, 7, };
		for (int i = 0; i < a.length; i++) {
			ss.add(a[i]);
		}
		while (ss.hasnext()) {
			System.out.println(ss.delete());
		}
	}
}

class Node {
	Node next;
	int data;

	public Node(int data) {
		this.data = data;
	}

	public void add(int data) {
		if (next == null) {
			next = new Node(data);
			return;
		}
		Node temp = next;
		while (temp.next != null) {
			temp = temp.next;
		}
		temp.next = new Node(data);
	}

	public Node delete() {
		if (next == null) {
			return null;
		}
		Node temp = next;
		if (temp.next == null) {
			Node ans = temp;
			next = null;
			return ans;
		}
		while (temp.next.next != null) {
			temp = temp.next;
		}
		Node ans = temp.next;
		temp.next = null;
		return ans;

	}

	public boolean hasnext() {
		if (next == null) {
			return false;
		} else {
			return true;
		}
	}
	
	public String toString() {
		return data + "";
	}
}
