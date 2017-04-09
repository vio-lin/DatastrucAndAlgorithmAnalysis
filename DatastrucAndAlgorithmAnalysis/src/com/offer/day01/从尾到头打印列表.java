package com.offer.day01;

import java.util.LinkedList;

public class 从尾到头打印列表 {

    public static void main(String args[]) {
        ListNode node1 = new ListNode();
        ListNode node2 = new ListNode();
        ListNode node3 = new ListNode();
        node1.data = 1;
        node2.data = 2;
        node3.data = 3;
        node1.next = node2;
        node2.next = node3;
        if(node1==null){
            return ;
        }
        PrintNode(node1);
        System.out.println();
        LinkedList<Integer> stack = new LinkedList<Integer>();
       do{
            stack.push(new Integer(node1.data));
            node1 = node1.next;
        }while(node1!=null);
        while(stack.size()!=0){
            System.out.print(stack.pop());
        }
        System.out.println();
    }

    private static void PrintNode(ListNode node1) {
        // TODO Auto-generated method stub
        //使用递归打印的方式
        if(node1.next!=null){
            PrintNode(node1.next);
        }
        System.out.print(node1.data);
    }
}
