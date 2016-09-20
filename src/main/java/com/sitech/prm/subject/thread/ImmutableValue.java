package com.sitech.prm.subject.thread;

public class ImmutableValue {
	
	private int value = 0;
	 
	public ImmutableValue(int value){
		this.value = value;
	}
 
	public int getValue(){
		return this.value;
	}
 
	public ImmutableValue add(int valueToAdd){
		return new ImmutableValue(this.value + valueToAdd);
	}

	public static void main(String[] args) {
		final ImmutableValue immutableValue = new ImmutableValue(13);
		Runnable task = new Runnable() {
			public void run() {
				System.out.println(Thread.currentThread().getName()+"--"+immutableValue.getValue());
			}
		};
		for (int i = 0; i < 100; i++) {
			new Thread(task).start();
			
		}
	}

}
