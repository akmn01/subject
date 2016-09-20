package com.sitech.prm.subject.thread;

public class WaitDemo {
	private static boolean isInvoked = false;
	public static void main(String[] args) throws InterruptedException {
		MyLock myLock = new MyLock();
		MyTask mytask = new MyTask(myLock);
		for(int i=0;i<10;i++){
			new Thread(mytask).start();
		}
		
		Thread.sleep(3000);
		notify(myLock);
	}
	
	public static void notify(MyLock myLock){
		synchronized (myLock) {
			myLock.isInvoked = true;
			myLock.notifyAll();
		}
	}

}

class MyTask implements Runnable{
	public MyLock myLock = null;
	public MyTask(MyLock myLock) {
		this.myLock = myLock;
	}
	public void run(){
		synchronized (myLock) {
			try {
				System.out.println("myTask is running");
				while(!myLock.isInvoked){
					myLock.wait();
				}
				myLock.isInvoked =false;
				System.out.println("myTask is vocked");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("myTask is done");
		}
		
	}
}

class MyLock{
	public  boolean isInvoked = false;
}
