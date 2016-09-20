package com.sitech.prm.subject.thread.higtthread.chapter2;

public class StopThreadUnsafe {
	
	private static User user = new User();
	
	
	
	static class WriteTask implements Runnable{
		public boolean canStop =false;
		public void run(){
			while(true){
				if(canStop){
					System.out.println("I was fucked");
					break;
				}
				synchronized (user) {
					String id = System.currentTimeMillis()+"";
					user.id = id;
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					user.name=id;
				}
				Thread.yield();
			}
		}
		
		public void stopMe(){
			canStop = true;
		}
	}
	
	static class ReadTask implements Runnable{
		public void run(){
			while(true){
				synchronized (user) {
					if(!user.isValid()){
						System.out.println(user.toString());
					}
				}
				Thread.yield();
			}
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		new Thread(new ReadTask()).start();
		while(true){
			WriteTask writeTask = new WriteTask();
			Thread writer = new Thread(writeTask);
			writer.start();
			Thread.sleep(150);
			//writer.stop();//错误的关闭方法
			writeTask.stopMe();
			
		}
	}
	
	
	static class User{
		public String id = "0";
		public String name = "0";
		
		public User(){
			
		}
		public User(String id, String name) {
			super();
			this.id = id;
			this.name = name;
		}
		public synchronized boolean isValid(){
			return this.id.equals(this.name);
		}
		public String toString() {
			return "User [id=" + id + ", name=" + name + "]";
		}
		
	}

}
