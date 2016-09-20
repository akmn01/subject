package com.sitech.prm.subject.thread;

public class ThreadStatusTest {

	public static void main(String[] args) throws InterruptedException {
		Thread thread = new Thread(){
			public void run(){
				try {
					sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName()+" thread is running");
			}
		};
		
		System.out.println(thread.getState() == Thread.State.NEW);
		thread.run();//这样相当于在本线程（main主线程）中执行，知识普通的调用了thread的run方法
		System.out.println(thread.getState() == Thread.State.NEW);
		thread.start();//这样才是新建一个线程 并让这个新线程调用run方法
		System.out.println(thread.getState() == Thread.State.RUNNABLE);
		thread.sleep(1000);//等子线程进入sleep
		System.out.println(thread.getState() == Thread.State.TIMED_WAITING);
		thread.sleep(4000);//等子线程执行完毕
		System.out.println(thread.getState() == Thread.State.TERMINATED);
		
		thread.stop();
		
	}

}
