/**   
 * @Title: Husband.java 
 * @Package: com.sitech.prm.subject.cells 
 * @CopyRright (c)2008-2020: si-tech 
 * @Project: 易企算 subject
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author 14K sunyz@si-tech.com.cn
 * @date 2016-7-21 下午4:15:40 
 * @version V2.0   
 */
package com.sitech.prm.subject.cells;

import java.util.ArrayList;

/**   
 * @Title: Husband
 * @Description: TODO(用一句话描述这个类的作用) 
 * @author 14K  sunyz@si-tech.com.cn
 */
public class Husband {

	private String LOGIN_NAME;
	private int m_Age;
	private ArrayList<Wife> m_Wives;

	

	public Husband(String lOGIN_NAME, int m_Age, ArrayList<Wife> m_Wives) {
		super();
		LOGIN_NAME = lOGIN_NAME;
		this.m_Age = m_Age;
		this.m_Wives = m_Wives;
	}

	public String getLOGIN_NAME() {
		return LOGIN_NAME;
	}

	public void setLOGIN_NAME(String lOGIN_NAME) {
		LOGIN_NAME = lOGIN_NAME;
	}

	public int getAge() {
		return m_Age;
	}

	public ArrayList<Wife> getWives() {
		return m_Wives;
	}

}
