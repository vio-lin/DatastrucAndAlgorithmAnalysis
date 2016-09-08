package com.thinkinginjava.Thread;

public class TT implements Runnable{
	static int b = 100;
	public synchronized void m1() throws InterruptedException{
		b=100;
		Thread.sleep(5000);
		System.out.println("b="+b);
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(2500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			m1();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) throws InterruptedException {
		TT t = new TT();
		Thread t1 = new Thread(t);
		t1.start();
		
		t.m2();
	}
	private synchronized void m2() throws InterruptedException {
		// TODO Auto-generated method stub
		b= 2000; 
		Thread.sleep(2500);
		System.out.println(b);
	}
}
