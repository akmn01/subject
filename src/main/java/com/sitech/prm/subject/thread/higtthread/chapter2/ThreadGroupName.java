package com.sitech.prm.subject.thread.higtthread.chapter2;

public class ThreadGroupName implements Runnable{

	public void run(){
		String groupAndName = Thread.currentThread().getName()+"@"
					+Thread.currentThread().getThreadGroup().getName();
		System.out.println(this+"----"+groupAndName);
	}
	public static void main(String[] args) {
		ThreadGroup group = new ThreadGroup("嘻嘻哈哈组");
		Thread xixi = new Thread(group, new ThreadGroupName(),"xixi");
		Thread haha = new Thread(group, new ThreadGroupName(),"haha");
		
		xixi.start();
		haha.start();
		
		System.out.println(group.activeCount());
		
		group.list();
		

	}

}
