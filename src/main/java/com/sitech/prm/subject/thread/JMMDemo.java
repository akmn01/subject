package com.sitech.prm.subject.thread;

public class JMMDemo implements Runnable{
	private final Variable object3 = new Variable();
	public void run(){
		methodOne();
		methodTwo();
	}
	
	public void methodOne(){
		int localVariable1 =1;
		Variable localVariable2 = object3;
	}
	
	public void methodTwo(){
		Variable localVariable1 = new Variable();
	}

	public static void main(String[] args) {
		JMMDemo jmmDemo = new JMMDemo();
		for(int i=0;i<2;i++){
			new Thread(jmmDemo).start();
		}

	}

}

class Variable{
	
	public int object2;
	public String object4;
	
	
}
