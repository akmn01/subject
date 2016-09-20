/**   
 * @Title: Wife.java 
 * @Package: com.sitech.prm.subject.cells 
 * @CopyRright (c)2008-2020: si-tech 
 * @Project: 易企算 subject
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author 14K sunyz@si-tech.com.cn
 * @date 2016-7-21 下午4:15:15 
 * @version V2.0   
 */
package com.sitech.prm.subject.cells;

/**   
 * @Title: Wife
 * @Description: TODO(用一句话描述这个类的作用) 
 * @author 14K  sunyz@si-tech.com.cn
 */
public class Wife {

	private String m_Name;
	private int m_Age;

	public Wife(String name, int age) {
		this.m_Name = name;
		this.m_Age = age;
	}

	public String getName() {
		return m_Name;
	}

	public int getAge() {
		return m_Age;
	}

}
