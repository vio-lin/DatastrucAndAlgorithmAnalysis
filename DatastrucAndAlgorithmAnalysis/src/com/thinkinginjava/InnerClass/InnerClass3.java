package com.thinkinginjava.InnerClass;

public class InnerClass3 {
    class contents{
        private int i =22;
        public int value(){
            return i ;
        }
    }
    class Destination{
        private String label;
        Destination(String whereTo){
            label = whereTo;
        }
        String label(){
            return label;
        }
    }
    
    public static void main(String[] args) {
        InnerClass3 iner = new InnerClass3();
        InnerClass3.contents conten = iner.new contents();
    }
}
