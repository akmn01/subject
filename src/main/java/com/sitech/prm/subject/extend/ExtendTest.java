/**   
 * @Title: ExtendTest.java 
 * @Package: com.sitech.prm.subject.extend 
 * @CopyRright (c)2008-2020: si-tech 
 * @Project: 易企算 subject
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author 14K sunyz@si-tech.com.cn
 * @date 2016-8-25 下午3:50:20 
 * @version V2.0   
 */
package com.sitech.prm.subject.extend;

/**   
 * @Title: ExtendTest
 * @Description: TODO(用一句话描述这个类的作用) 
 * @author 14K  sunyz@si-tech.com.cn
 */
public class ExtendTest {
	
	public static void main(String[] args) {
		BigSon bigson = new BigSon();
		bigson.name="bigson";
		System.out.println(bigson.name);
		System.out.println(new BigSon().name);
		SmallSon smallSon = new SmallSon();
		System.out.println(smallSon.name);
	}

}
