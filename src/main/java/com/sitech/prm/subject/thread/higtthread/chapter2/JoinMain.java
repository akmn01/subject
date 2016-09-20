package com.sitech.prm.subject.thread.higtthread.chapter2;

public class JoinMain {
	
	private volatile static int i =0;
	
	static class WriteThread extends Thread{
		public void run(){
			for(;i<99999999;i++){
				
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		WriteThread writeThread = new WriteThread();
		writeThread.start();
		writeThread.join(100);
		System.out.println(i);
	}

}
