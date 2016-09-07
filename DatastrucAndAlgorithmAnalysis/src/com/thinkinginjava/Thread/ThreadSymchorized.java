package com.thinkinginjava.Thread;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.concurrent.Executors;

import org.junit.Test;
/**
 * 失败了
 * @author lin
 *
 */
public class ThreadSymchorized {
	public static void main(String[] args) {
		MyThread1 thread1 = new MyThread1();
		MyThread1 thread2 = new MyThread1();
		thread1.setName("第一个进程");
		thread2.setName("第二个进程");
		thread1.start();
		thread2.start();
	}
}

class MyThread1 extends Thread {
	Timer timer = new Timer();

	@Override
	public void run() {
		// TODO Auto-generated method stub
		timer.add(Thread.currentThread().getName());
	}
}

class Timer {
	private static int num = 0;

	public synchronized void add(String name) {
		synchronized (this) {

			num++;
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(name + "你是第" + num + "个使用timer的线程");
		}
	}
}