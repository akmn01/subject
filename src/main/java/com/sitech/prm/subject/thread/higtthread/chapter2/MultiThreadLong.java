package com.sitech.prm.subject.thread.higtthread.chapter2;

public class MultiThreadLong {
	public static long t = 0;
	
	public static class WriteT implements Runnable{
		private long to;
		public WriteT(long to){
			this.to = to;
		}
		
		public void run() {
			while(true){
				MultiThreadLong.t = to;
				Thread.yield();
			}
		}
	}
	
	public static class ReadT implements Runnable{
		public void run(){
			while(true){
				long tmp = MultiThreadLong.t;
				if(tmp!=111L && tmp!=-999L && tmp!=333L && tmp!=-444L){
					System.out.println(tmp);
				}
				Thread.yield();
			}
		}
	}
	
	public static void main(String[] args) {
		new Thread(new WriteT(111L)).start();
		new Thread(new WriteT(-999L)).start();
		new Thread(new WriteT(333L)).start();
		new Thread(new WriteT(-444L)).start();
		new Thread(new ReadT()).start();
	}
}
