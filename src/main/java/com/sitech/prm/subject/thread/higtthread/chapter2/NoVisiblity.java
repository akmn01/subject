package com.sitech.prm.subject.thread.higtthread.chapter2;

public class NoVisiblity {

	public static volatile boolean canSkip = false;
	public static int number ;
	
	static class ReaderThread extends Thread{
		public void run(){
			while(!canSkip){
				
			}
			System.out.println(number);
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		ReaderThread readerThread = new ReaderThread();
		readerThread.start();
		Thread.sleep(1000);
		//readerThread.join(2000);
		number = 12;
		canSkip = true;
		

	}

}
