package com.thinkinginjava.Thread;

import java.util.Stack;

public class ProducerConsumer {
	public static void main(String[] args){
		SyncStack ss = new SyncStack();
		Proceduer p = new Proceduer(ss);
		Consumer c = new Consumer(ss);
		new Thread(c).start();
		new Thread(p).start();
		
	}
}
class WoTou{
	int id;
	WoTou(int id){
		this.id = id;
	}
	public String toString(){
		return "窝头"+id;
	}
}

class SyncStack{
	int index = 0;
	WoTou[] arrWT = new WoTou[6];
	
	public synchronized void push(WoTou wt)  {
		while(index == arrWT.length){
			try{
				this.wait();				
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
		this.notifyAll();
		arrWT[index] = wt;
		index++;
	}
	
	public synchronized WoTou pop() {
		while(index == 0){
			try{
				
				this.wait();
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
		this.notifyAll();
		index--;
		return arrWT[index];
	}
}
class Proceduer implements Runnable{
	SyncStack ss = null;
	public Proceduer(SyncStack ss) {
		// TODO Auto-generated constructor stub
		this.ss = ss;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i =0;i<20;i++){
			WoTou wt = new WoTou(i);
			System.out.println("生产了"+wt);
			ss.push(wt);
			try {
				Thread.sleep((long) (Math.random()*1000));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
class Consumer implements Runnable{
	SyncStack ss = new SyncStack();
	public Consumer(SyncStack ss){
		this.ss = ss;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0;i<20;i++){
			WoTou wt = ss.pop(); 
			System.out.println("消费"+wt);
			try{
				Thread.sleep((long) (Math.random()*1000));
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
	}
}