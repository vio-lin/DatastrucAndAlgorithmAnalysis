package com.offer.day01;

import java.util.Arrays;

public class 重构二叉树 {
    public static void main(String[] args) {
        int[] pre =  new int[]{1,2,4,7,3,5,6,8};
        int[] beh = new int[]{4,7,2,1,5,3,8,6};
        BinaryTreeNode tree = ConstructTree(pre,beh);
    }

    private static BinaryTreeNode ConstructTree(int[] pre, int[] beh) {
        // TODO Auto-generated method stub
        if(pre==null||beh==null){
            return null;
        }
        if(pre.length!=beh.length||pre.length==0){
            return null;
        }
        BinaryTreeNode tree = new BinaryTreeNode();
        int value = pre[0];
        int index=0;
        for(int i =0;i<beh.length;i++){
            if(pre[0]==beh[i]){
                index=i;
                System.out.println(value);
            }
        }
        tree.value = value;
        BinaryTreeNode left = ConstructTree(Arrays.copyOfRange(pre,1,1+index),Arrays.copyOfRange(beh,0,index));
        BinaryTreeNode right = ConstructTree(Arrays.copyOfRange(pre,1+index,pre.length),Arrays.copyOfRange(beh,index+1,beh.length));
        tree.left =left;
        tree.right = right;
        return tree;
    }
}
