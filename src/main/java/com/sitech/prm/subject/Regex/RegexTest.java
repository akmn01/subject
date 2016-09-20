/**   
 * @Title: RegexTest.java 
 * @Package: com.sitech.prm.subject.Regex 
 * @CopyRright (c)2008-2020: si-tech 
 * @Project: 易企算 subject
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author 14K sunyz@si-tech.com.cn
 * @date 2016-8-4 下午2:58:28 
 * @version V2.0   
 */
package com.sitech.prm.subject.Regex;


/**   
 * @Title: RegexTest
 * @Description: TODO(用一句话描述这个类的作用) 
 * @author 14K  sunyz@si-tech.com.cn
 */
public class RegexTest {
	
	public static void main(String[] args) {
		String stringTobeParsed = "${AB_0}使用Excel模板导出测试${AB_1}编码是${AB_2}...";
		stringTobeParsed = stringTobeParsed.replaceAll("\\$\\{[^\\}]*\\}", "_");
		System.out.println(stringTobeParsed);
	}

}
