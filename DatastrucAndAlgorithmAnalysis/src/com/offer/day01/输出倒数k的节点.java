package com.offer.day01;

public class 输出倒数k的节点 {
    public static void main(String[] args) {
        ListNode head = new ListNode();
        ListNode start,end;
        start = head;
        end = head;
        int k=6;
        if(k<0){
            return;
        }
        if(head == null){
            return;
        }
        while(k!=0&&end!=null){
            end = end.next;
            k--;
        }
        if(k!=0){
            return ;
        }
        while(end!=null){
            start = start.next;
            end = end.next;
        }
        System.out.println(start.data);
    }
}
