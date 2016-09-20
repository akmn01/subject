package com.sitech.prm.subject.thread.higtthread.chapter2;

public class GoodSuspend {
	public static Object u = new Object();
	
	public static class ChangeObjectThread extends Thread{
		volatile boolean suspendme = false;
		
		public void suspendMe(){
			suspendme = true;
		}
		
		public void resumeMe(){
			suspendme = false;
			synchronized (this) {
				this.notify();
			}
		}
		
		public void run(){
			while(true){
				synchronized (this) {
					while(suspendme){
						try {
							System.out.println(this);
							this.wait();
						} catch (Exception e) {
						}
					}
				}
				
				synchronized (u) {
					System.out.println("in ChangeObjectThread" + this);
				}
				
				Thread.yield();
			}
		}
	}
	
	public static class ReadObjectThread extends Thread{
		public void run(){
			while(true){
				synchronized (u) {
					System.out.println("in ReadObjectThread"+this);
				}
				
				Thread.yield();
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		ChangeObjectThread t1 = new ChangeObjectThread();
		ReadObjectThread t2 = new ReadObjectThread();
		
		t1.start();
		t2.start();
		Thread.sleep(1000);
		t1.suspendMe();
		System.out.println("suspend t1 5 seconds");
		Thread.sleep(5000);
		t1.resumeMe();

	}

}
