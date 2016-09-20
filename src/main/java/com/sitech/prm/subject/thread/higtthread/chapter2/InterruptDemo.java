package com.sitech.prm.subject.thread.higtthread.chapter2;

public class InterruptDemo {
	
	static class UnInterruptableTask implements Runnable{
		public void run(){
			while(Thread.interrupted()){//不加上中断标志位判断  线程是不会停的
				Thread.yield();
			}
		}
	}
	
	static class InterruptSleepingTask implements Runnable{
		public void run(){
			
			while(true){
				if(Thread.currentThread().isInterrupted()){
					System.out.println("interrupted!");
					break;
				}
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					System.out.println("I was innterrupted while sleeping");
					Thread.currentThread().interrupt();
				}
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		Thread thread = new Thread(new UnInterruptableTask());
		thread.start();
		Thread.sleep(100);
		thread.interrupt();
		
		thread = new Thread(new InterruptSleepingTask());
		thread.start();
		Thread.sleep(1000);
		thread.interrupt();
	}

}
