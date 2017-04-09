package com.offer.day01;

public class 删除节点使用O1时间 {
    public static void main(String[] args) {
        ListNode head=new ListNode();
        ListNode second=new ListNode();
        ListNode third=new ListNode();
        head.next=second;
        second.next=third; 
        head.data=1; 
        second.data=2; 
        third.data=3;
        deleteNode(head, second);
        System.out.println(head.next.data);
    }

    private static void deleteNode(ListNode head, ListNode second) {
        // TODO Auto-generated method stub
        //看有哪些情况 
        //1.有多个节点 且不是最后的节点. 节点为中间接点 直接在这一点赋值下一个点的值
        //2.该点 是最后一个点 我们需要遍历到最后一个点 然后 开始 把 前面一个置 为0
        //3.只有一个节点 设置Hea 为 null 只有两个节点  删除头元素没有问题 删除尾元素 没问题
        if(head==null||second==null){
            return;
        }
        if(head.next==null){
            head = null;
        }
        if(second.next==null){
            //找到倒数第二个节点 置空
            ListNode now = head;
            while(now.next!=second){
                now = now.next;
            }
            now.next = null;
        }else{
            ListNode next= second.next;
            second.data = next.data;
            second.next = next.next;
        }
        
    }
}
