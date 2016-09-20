/**   
 * @Title: Role2.java 
 * @Package: com.sitech.prm.subject.cells 
 * @CopyRright (c)2008-2020: si-tech 
 * @Project: 易企算 subject
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author 14K sunyz@si-tech.com.cn
 * @date 2016-7-22 上午9:30:22 
 * @version V2.0   
 */
package com.sitech.prm.subject.cells;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.gson.annotations.Expose;

import sun.misc.BASE64Encoder;

/**   
 * @Title: Role2
 * @Description: TODO(用一句话描述这个类的作用) 
 * @author 14K  sunyz@si-tech.com.cn
 */
public class Role3{
	
	@JsonIgnore
	public String name;
	public String age;
	
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public Role3(String name, String age) {
		super();
		this.name = name;
		this.age = age;
	}
	@Override
	public String toString() {
		return "Role3 [name=" + name + ", age=" + age + "]";
	}
	
	
	
}
