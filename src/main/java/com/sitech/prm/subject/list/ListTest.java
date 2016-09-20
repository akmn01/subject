/**   
 * @Title: ListTest.java 
 * @Package: com.sitech.prm.subject.list 
 * @CopyRright (c)2008-2020: si-tech 
 * @Project: 易企算 subject
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author 14K sunyz@si-tech.com.cn
 * @date 2016-9-7 上午11:31:58 
 * @version V2.0   
 */
package com.sitech.prm.subject.list;

import java.util.ArrayList;
import java.util.List;

/**   
 * @Title: ListTest
 * @Description: TODO(用一句话描述这个类的作用) 
 * @author 14K  sunyz@si-tech.com.cn
 */
public class ListTest {
	
	public static void main(String[] args) {
		List<String> smallList = new ArrayList<String>();
		smallList.add("1");
		smallList.add("2");
		smallList.add("3");
		
		List<String> bigList = new ArrayList<String>();
		bigList.addAll(smallList);
		
		smallList.remove(0);
		
		System.out.println(bigList);
		System.out.println(smallList);
	}

}
