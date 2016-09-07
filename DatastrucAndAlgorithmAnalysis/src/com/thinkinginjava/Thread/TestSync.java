package com.thinkinginjava.Thread;
/**
 * 线程之间的先后
 * @author lin
 *
 */
public class TestSync implements Runnable{
	Timer1 timer = new Timer1();
	
	public static void main(String[] args) {
		TestSync test = new TestSync();
		Thread t1 =new Thread(test);
		Thread t2 = new Thread(test);
		t1.setName("t1");
		t2.setName("t2");
		t1.start();
		t2.start();
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		timer.add(Thread.currentThread().getName());
	}

}
class Timer1{
	private static int num = 0;
	public synchronized void add(String name){
		num++;
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(name+"你是第"+num+"个使用timeer的线程");
	}
}