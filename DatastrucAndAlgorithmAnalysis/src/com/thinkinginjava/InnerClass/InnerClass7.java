package com.thinkinginjava.InnerClass;

public class InnerClass7 {
    public interface Contents{
        int value();
    }
    public Contents contents(){
        return new Contents(){
            private int value =1 ;
            @Override
            public int value() {
                // TODO Auto-generated method stub
                return value;
            }
        };//定义这边的东西
        //这边直接teturn 另一
//        return new MyContent();
    }
    
    //或者使用这样的方式 
    public class MyContent implements Contents{
        private int value = 3;
        @Override
        public int value() {
            // TODO Auto-generated method stub
            return value;
        }}
    public static void main(String[] args) {
        InnerClass7 cla = new InnerClass7();
        Contents c = cla.contents();
    }
}
