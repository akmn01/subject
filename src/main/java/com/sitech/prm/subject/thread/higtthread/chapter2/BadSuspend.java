package com.sitech.prm.subject.thread.higtthread.chapter2;

public class BadSuspend {
	public static Object u = new Object();
	static ChangeObjectThread t1 = new ChangeObjectThread("t1");
	static ChangeObjectThread t2 = new ChangeObjectThread("t2");
	
	static class ChangeObjectThread extends Thread{
		public ChangeObjectThread(String name){
			super.setName(name);
		}
		
		public void run(){
			synchronized (u) {
				System.out.println("in " + this.getName());
				Thread.currentThread().suspend();//挂起但是不释放资源
				System.out.println("suspend over " + this.getName());
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		t1.start();
		Thread.sleep(1000);//等t1挂起完成
		t2.start();//t2应该无法进入 无法挂起
		t1.resume();//t1恢复 应该会打印suspend over  接着t2进入并挂起
		//Thread.sleep(1000);//等待t2挂起完成 防止信号丢失
		t2.resume();//这里t2就可以从挂起中恢复 没有上面那一句有可能会出现还没挂起就恢复 信号丢失
		t1.join();
		t2.join();
	}

}
