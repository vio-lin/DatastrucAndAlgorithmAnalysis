package com.thinkinginjava.InnerClass;

public class InnerClass9 {
    public interface Destination{
          public String readLabel();
    }
    //上面传入的参数 必须为final 才可以使用 
    public Destination destination(final String dest){
        return new Destination() {
            private  String label = dest;
            @Override
            public String readLabel() {
                // TODO Auto-generated method stub
                return null;
            }
        };
        
    }
}
