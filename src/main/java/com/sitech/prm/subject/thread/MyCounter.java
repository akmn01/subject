package com.sitech.prm.subject.thread;


public class MyCounter {
	private int num = 0;
	
	public int add(int addby){
		Lock lock = new Lock();
		try {
			lock.lock();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		int sum = num +  addby;
		lock.unlock();
		return sum;
		
	}
	
	class Lock{
		private boolean isInvoked = false;
		public synchronized void lock() throws InterruptedException{
			while(!isInvoked){
				this.wait();
			}
		}
		public synchronized void unlock(){
			this.isInvoked = true;
			this.notify();
		}
	}
}
