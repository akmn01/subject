package com.sitech.prm.subject.guava.observer;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.google.common.eventbus.EventBus;

public class EventBusTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		System.out.println("test------");
		EventBus eventBus = new EventBus();
		eventBus.register(new MyObserver());
		eventBus.post("sunyaozong");
	}
	
	@Test
	public void test2() {
		System.out.println("test2------");
		EventBus eventBus = new EventBus();
		eventBus.register(new MyObserver());
		eventBus.post(Integer.MAX_VALUE);
	}

}
