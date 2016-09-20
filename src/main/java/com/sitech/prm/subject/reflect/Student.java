package com.sitech.prm.subject.reflect;

public class Student{
	private String id;
	private String name;
	
	private Student(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + "]";
	}
}

