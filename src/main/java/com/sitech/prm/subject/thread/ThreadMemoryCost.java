package com.sitech.prm.subject.thread;

/**
 * 
 * 1、开启N个线程，什么都不做就等待，也花费很多内存，产生代价
 * 2、wait()方法是任何Object都有的，他必须在线程同步中使用
 */
public class ThreadMemoryCost {
	
	public static void main(String[] args) {
		for (int i = 0; i < 10000; i++) {
			new Thread(){
				public void run(){
					try {
						synchronized (this) {
							wait();
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}.start();
			
		}
	}
}
