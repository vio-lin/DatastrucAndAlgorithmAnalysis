package com.offer.day01;

import java.util.Stack;

public class 使用两个栈完成一个队列 <T>{
    private Stack<T> stack1 = new Stack<T>();
    private Stack<T> stack2 = new Stack<T>();
    public void insert(T t){
        stack1.push(t);
    }
    public T get(){
        if(stack2.isEmpty()){
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        if(stack2.isEmpty()){
            System.out.print("队列为空");
        }
        return stack2.pop();
    }
    public static void main(String[] args) {
                                使用两个栈完成一个队列<Integer> pe = new 使用两个栈完成一个队列<>();
           pe.insert(8);
           pe.insert(7);
           pe.insert(1);
           System.out.println(pe.get());
           pe.insert(6);
           System.out.println(pe.get());
           
    }
}
