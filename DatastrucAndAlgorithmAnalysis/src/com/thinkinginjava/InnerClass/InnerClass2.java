package com.thinkinginjava.InnerClass;

public class InnerClass2 {
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
    
    public Destination to(String s){
        return new Destination(s);
    }
    
    public Contents contents(){
        return new Contents();
    }
    
    public void ship(String dest){
        Contents c = new Contents();
        Destination d = to(dest);
        System.out.println(d.readLabel());
    }
    public static void main(String[] args) {
        InnerClass2 cla = new InnerClass2();
        cla.ship("sada");
        InnerClass2.Contents content = cla.contents(); 
    }
}
