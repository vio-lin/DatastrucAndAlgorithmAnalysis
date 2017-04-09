package com.offer.day01;

import java.util.ArrayList;
import java.util.LinkedList;

public class ConstructTree {
    static int[] pre = new int[] { 1, 2, 4, 7, 3, 5, 6, 8 };
    static int[] mid = new int[] { 4, 7, 2, 1, 5, 3, 8, 6 };

    public static void main(String[] args) {
        // 重构树
        LinkedList<Integer> list = new LinkedList<Integer>();
        ArrayList<Integer> al = new ArrayList<Integer>();
        al.addAll(list);
        Tree root = constroTree(0, pre.length - 1, 0, mid.length - 1);
        // 来一个广度优先的遍历
        LinkedList<Tree> queue = new LinkedList<Tree>();
        queue.add(root);
        int i = 1;
        int[][] a = new int[5][];
        //设定每层一个子节点 的计数 有的话进行处理  只有前序 和后序 求不出来树
        while (queue.size() > 0) {
            Tree temp = queue.pop();
            System.out.print(null==temp?"null":temp.value);
            if (null!=temp.left) {
                queue.offer(temp.left);
            }
            if (null!=temp.right)
                queue.offer(temp.right);
        }
        System.out.println();
        pritafter(root);
    }

    private static void pritafter(Tree root) {
        // TODO Auto-generated method stub
        if(root.left!=null){
            pritafter(root.left);
        }
        if(root.right!=null)
            pritafter(root.right);
        System.out.print(root.value);
    }

    static Tree constroTree(int ps, int pe, int ms, int me) {
        Tree tree = new Tree();
        if(ps>pe){
            return null;
        }
        tree.value = pre[ps];
        if (ps == pe) {
            return tree;
        }
        int ke = 0;
        int ks = 0;
        for (int i = ms; i <= me; i++) {
            if (mid[i] == pre[ps]) {
                ke = i;
            }
        }
        Tree left = constroTree(ps + 1, ps + ke - ms, ms, ke - 1);
        Tree right = constroTree(pe+ke-me+1, pe, ke+1, me);
        tree.left = left;
        tree.right = right;
        return tree;
    }
}

class Tree {
    int value;
    Tree left;
    Tree right;

    public Tree(int value, Tree left, Tree right) {
        super();
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public Tree() {
        // TODO Auto-generated constructor stub
    }
}
