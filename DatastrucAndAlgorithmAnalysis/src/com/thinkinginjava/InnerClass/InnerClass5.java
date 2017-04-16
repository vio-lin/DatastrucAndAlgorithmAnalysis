package com.thinkinginjava.InnerClass;

public class InnerClass5 {
    interface Destination{
        public String readLable();
    }
    //定义内部类在方法中 所以不能使用
    public Destination destination(String s){
        class PDestination implements Destination{
            private String label;
            private  PDestination(String whereTo){
                label = whereTo;
            }
            @Override
            public String readLable() {
                // TODO Auto-generated method stub
                return label;
            }
        }
        return new PDestination(s);
    }
    public static void main(String[] args) {
        InnerClass5 cla = new InnerClass5();
        Destination d = cla.destination("Tasmania");
    }
}
