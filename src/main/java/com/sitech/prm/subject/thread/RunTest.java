package com.sitech.prm.subject.thread;

public class RunTest {
	
	public static void executeRun() {
		Runnable task = new Runnable() {
			public void run() {
				//此处打印的是主线程main
				System.out.println("通过run()方法调用,真正执行任务的线程:"+Thread.currentThread().getName());
			}
		};
		new Thread(task,"子线程").run();
	}
	public static void executeStart() {
		Runnable task = new Runnable() {
			public void run() {
				//此处打印的是 子线程
				System.out.println("通过start()方法调用,真正执行任务的线程:"+Thread.currentThread().getName());
			}
		};
		
		new Thread(task,"子线程").start();
	}
	
	public static void main(String[] args) {
		executeRun();
		executeStart();
	}
}


