/**
 * 
 */
package com.sitech.prm.subject.string;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;



/**
 * TODO  Created on 2016-6-20
 * <p>Title: 统一报表平台</p>
 * <p>Copyright: Copyright (c) 2015-2025</p>
 * <p>Company: 北京思特奇信息技术股份有限公司</p>
 * <p>Department: PRM-PSD</p>
 * @author 孙耀宗  sunyz@si-tech.com.cn
 * @version 1.0
 * @update 修改日期 修改描述
 */
public class StringTest {
	
	private int size;
	private Min  min;
	
	class Min{
		int minPositin;
		int secondMinPositin;
	}
	
	public static void main(String[] args) {
		String str = "123456dssfdsffdf";
		System.out.println(StringUtils.substring(str, 0, 5));
		System.out.println(StringUtils.substring(str, 5, 10));
		
		System.out.println(new SimpleDateFormat("M").format(new Date()));
		
	}
}


