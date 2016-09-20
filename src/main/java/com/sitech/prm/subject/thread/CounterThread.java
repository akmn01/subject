package com.sitech.prm.subject.thread;


public class CounterThread extends Thread{

	private final Counter counter;
	public CounterThread(Counter counter){
		this.counter = counter;
	}
	public void run(){
		counter.add();
	}
	
	public static void main(String[] args) {
		Counter counter = new Counter();
		CounterThread thread1 = new CounterThread(counter);
		CounterThread thread2 = new CounterThread(counter);
		
		thread1.start();
		thread2.start();
	}
}

class Counter{
	private int number = 0;
	public synchronized int add(){
		System.out.println(this);
		return number++;
	}
}


