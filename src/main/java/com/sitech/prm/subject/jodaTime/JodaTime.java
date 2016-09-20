package com.sitech.prm.subject.jodaTime;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * 
 * jodaTime是线程安全的  Created on 2016-5-31
 * <p>Title: 统一报表平台</p>
 * <p>Copyright: Copyright (c) 2015-2025</p>
 * <p>Company: 北京思特奇信息技术股份有限公司</p>
 * <p>Department: PRM-PSD</p>
 * @author 孙耀宗  sunyz@si-tech.com.cn
 * @version 1.0
 * @update 修改日期 修改描述
 */
public class JodaTime {
	
	static DateTime datetime = null;
	

	@Test
	public void plusDays() {
		int beforeDayOfWeek = datetime.getDayOfWeek();
		datetime.plusDays(2);
		assertThat("plusDays并不改变原始值",beforeDayOfWeek, equalTo(datetime.getDayOfWeek()));
	}
	
	@Test
	public void monthIndex() {
		System.out.println(datetime.monthOfYear().getAsText());
	}
	
	@Test
	public void formatDate() {
		DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd hh:mm:ss.SSS");
		String dateTimeText = formatter.print(datetime);
		System.out.println("dateTimeText:"+dateTimeText);
		assertThat(datetime, equalTo(formatter.parseDateTime(dateTimeText)));
	}
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		datetime = new DateTime();
	}

	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		datetime = null;
	}

	
	@Before
	public void setUp() throws Exception {
	}

	
	@After
	public void tearDown() throws Exception {
		datetime = DateTime.now();
	}

}
