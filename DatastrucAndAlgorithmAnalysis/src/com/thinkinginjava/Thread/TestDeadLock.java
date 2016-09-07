package com.thinkinginjava.Thread;

/**
 *  死锁的概念  定义两个对象 在一个同步的对象代码中添加另一个代码的对象， 在里的线程里面将操作
 *  然后另一个代码也这样选择。 那么2好线程启动的要求是拿到两个对象  2号线程需要使用 1号对象的锁
 *  但是1好对象只有执行完成之后才可以把解锁 结果导致我需要你需要的才可以给你需要的 死循环
 * @author lin
 *
 */
public class TestDeadLock implements Runnable{
	//给锁的顺序是不一定的
	public int flag = 1;
	static Object o1 = new Object(),o2 = new Object();
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("flag"+flag);
		if(flag == 1){
			synchronized (o1) {
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				synchronized (o2) {
					System.out.println("1");;
				}
			}
		}
		if(flag == 0){
			synchronized (o2) {
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				synchronized (o1) {
					System.out.println("0");
				}
			}
		}
	}
	public static void main(String[] args) {
		TestDeadLock td1 = new TestDeadLock();
		TestDeadLock td2 = new TestDeadLock();
		td1.flag = 1;
		td2.flag = 0;
		Thread t1 = new Thread(td1);
		Thread t2 = new Thread(td2);
		t1.start();
		t2.start();
	}
}
