package com.thinkinginjava.Thread;

public class TestJoin {
	public static void main(String[] args) {
		MyThread thread = new MyThread("我是进程");
		thread.start();
		try {
			thread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i=0;i<1000;i++){
			System.out.println("主线程+"+i);
		}
	}

}
class MyThread extends Thread{
	
	MyThread(String name){
		super(name);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i =0;i<1000;i++){
			System.out.println(this.getName()+"正在执行"+i);
		}
	}
	
}
