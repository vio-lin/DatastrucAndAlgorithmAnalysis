package com.DataStructAndAlgorth.BinaryTree;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * 在一个输入中使用  一行表示原始数据中序遍历构造二叉树 
 * 在下面的三行中分别定义了一个数字表示从里面删除的节点
 * 输出删除节点后的三个值的 先 后 序遍历输出
 * 
 * @author lin
 *
 */

public class Tree {
	private static leaf root ;
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()){
			String line= scanner.nextLine();
			String[] data1 = line.split(" ");
			root = generator(root,0,data1.length-1,data1);
			print(root);
			int re = scanner.nextInt();
			remove(re, root);
			System.out.println();
			midele(root);
		}
	}

	private static leaf generator(leaf root, int i, int length,String[] data) {
		// TODO Auto-generated method stub
		root = new leaf(Integer.valueOf(data[(i+length)/2]));
		if(i!=length){
			root.left = generator(root.left, i,(i+length)/2-1, data);
			root.right =generator(root.right, (i+length)/2+1, length, data);
		}
		return root;
	}
	
	public static void print(leaf root){
		LinkedList<leaf> queen = new LinkedList<leaf>();
		leaf temp = root;
		queen.push(temp);
		while(!queen.isEmpty()){
			temp = queen.poll();
			System.out.print(temp.data);
			if(temp.left!=null)
				queen.offer(temp.left);
			if(temp.right!=null)
				queen.offer(temp.right);
		}
	}
	/**
	 * 查找二叉树的 中序遍历
	 */
	public static void midele(leaf root){
		if(root.left!=null){
			midele(root.left);
		}
		System.out.print(root.data);
		if(root.right!=null){
			midele(root.right);			
		}
	}
	/**
	 * 删除一个可以接受的值
	 * @param i
	 */
	public static leaf remove(int i,leaf root){
		if(root == null){
			return null;
		}
		if(i>root.data){
			root.right = remove(i,root.right);
			return root;
		}else if (i<root.data){
			root.left = remove(i,root.left);
			return root;
		}else{
			if(root.left==null&&root.right==null){
				return null;
			}else if(root.left!=null&&root.right!=null){
				int min = findmin(root.right);
				root.data =min;
				root.right = remove(min,root.right);
				return root;
			}else if(root.left!=null){
				root=root.left;
				root.left = null;
				return root;
			}else{
				root =root.right;
				root.right = null;
				return root;
			}
		}
	}

	private static int findmin(leaf root2) {
		// TODO Auto-generated method stub
		if(root2.left==null){
			return root2.data;
		}else{
			while(root2.left!=null){
				root2 = root2.left;
			}
		}
		return root2.data;
	}
}
class leaf{
	leaf left;
	leaf right;
	int data;
	public leaf(int data) {
		// TODO Auto-generated constructor stub
		this.data = data;
	}
}

