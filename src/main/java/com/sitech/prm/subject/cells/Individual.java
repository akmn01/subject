package com.sitech.prm.subject.cells;

public class Individual {
	private String name;
	private int m_Age;
	private Wife m_Wife;

	

	public Individual(String name, int m_Age, Wife m_Wife) {
		super();
		this.name = name;
		this.m_Age = m_Age;
		this.m_Wife = m_Wife;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return m_Age;
	}

	public Wife getWife() {
		return m_Wife;
	}

}
