package com.sitech.prm.subject.guava.observer;

import com.google.common.eventbus.Subscribe;

public class MyObserver {
	
	@Subscribe
	public void function1(String message){
		System.out.println("function1 called:"+message);
	}
	
	@Subscribe
	public void function2(String message){
		System.out.println("function2 called:"+message);
	}
	
	@Subscribe
	public void function3(Integer age){
		System.out.println("function3 called:"+age);
	}

}
