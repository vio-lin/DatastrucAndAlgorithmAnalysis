package com.thinkinginjava.InnerClass;

public class InnerClass {
    class Contents{
        private int i = 11;
        public int value(){
            return i;
        }
    }
    class Destination{
        private String label;
        Destination(String helleo) {
            // TODO Auto-generated method stub
            label = helleo;
        }
        public String readLabel(){
            return label;
        }
    }
    
    public void ship(String dest){
        Contents c = new Contents();
        Destination d = new Destination(dest);
        System.out.println(d.readLabel());
    }
    public static void main(String[] args) {
        InnerClass cla = new InnerClass();
        cla.ship("sada");
    }
}
