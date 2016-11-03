package com.hihocoder.oct;

//可能是所谓构建的字典树
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while(scan.hasNext()){
			int num = scan.nextInt();
			scan.nextLine();
			TrieTree tree = new TrieTree();
			for(int i=0;i<num;i++){
				String str = scan.nextLine();
				construt(tree,str);
			}
			int finnum = scan.nextInt();
			scan.nextLine();
			for(int i=0;i<finnum;i++){
				String str = scan.nextLine();
				System.out.println(find(tree,str));
			}
		}
	}

	private static int find(TrieTree tree, String str) {
		// TODO Auto-generated method stub
		if(str.equals("")){
			return tree.sumson;
		}else{
			if(tree.map.get(str.charAt(0))!=null){
				return find(tree.map.get(str.charAt(0)), str.substring(1));
			}else{
				return 0;
			}
		}
	}

	private static void construt(TrieTree tree, String str) {
		// TODO Auto-generated method stub
			if(str.length()>0){
				tree.sumson++;
				if(tree.map.containsKey(str.charAt(0))==true){
					construt(tree.map.get(str.charAt(0)),str.substring(1));
				}else{
					TrieTree teemp = new TrieTree();
					construt(teemp, str.substring(1));
					tree.map.put(str.charAt(0), teemp);
//				tree.map.put(str.charAt(i), new TrieTree(str.substring(i, str.length())));
				}
			}
	}
}
class TrieTree{
	int sumson = 0;
	Map<Character, TrieTree> map = new HashMap<Character, TrieTree>();
	public TrieTree(){}
}
