package com.sitech.prm.subject.thread.higtthread.chapter2;

public class GoodSuspend2 {
	public static Object u = new Object();
	
	public static class ChangeObjectThread extends Thread{
		volatile boolean suspendme = false;
		
		public void suspendMe(){
			suspendme = true;
		}
		
		public void resumeMe(){
			suspendme = false;
			synchronized (u) {
				u.notify();
			}
		}
		
		public void run(){
			while(true){
				synchronized (u) {
					while(suspendme){
						try {
							System.out.println("in ChangeObjectThread");
							u.wait();
						} catch (Exception e) {
						}
					}
				}
				
				Thread.yield();
			}
		}
	}
	
	public static class ReadObjectThread extends Thread{
		public void run(){
			while(true){
				synchronized (u) {
					System.out.println("in ReadObjectThread");
				}
				
				Thread.yield();
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		ChangeObjectThread t1 = new ChangeObjectThread();
		ReadObjectThread t2 = new ReadObjectThread();
		
		t1.start();
		//t2.start();
		Thread.sleep(1000);
		t1.suspendMe();
		System.out.println("suspend t1 5 seconds");
		Thread.sleep(5000);
		t1.resumeMe();

	}

}
