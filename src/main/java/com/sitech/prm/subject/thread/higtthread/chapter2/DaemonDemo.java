package com.sitech.prm.subject.thread.higtthread.chapter2;

public class DaemonDemo {
	
	static class DaemonThread extends Thread{
		public void run(){
			while(true){
				System.out.println("daemon running");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	} 

	public static void main(String[] args) throws InterruptedException {
		DaemonThread daemonThread = new DaemonThread();
		daemonThread.setDaemon(true);
		daemonThread.start();
		
		Thread.sleep(2000);
		System.out.println("ok");

	}

}
