/**
 * 
 */
package com.sitech.prm.subject.aspectj;

import org.springframework.stereotype.Service;

/**
 * TODO  Created on 2016-6-17
 * <p>Title: 统一报表平台</p>
 * <p>Copyright: Copyright (c) 2015-2025</p>
 * <p>Company: 北京思特奇信息技术股份有限公司</p>
 * <p>Department: PRM-PSD</p>
 * @author 孙耀宗  sunyz@si-tech.com.cn
 * @version 1.0
 * @update 修改日期 修改描述
 */

@Service
public class HelloWorldServiceImpl  implements IHelloWorldService{

	@Log(logLevel=LogLevel.LOG_WITHOUT_INPARAM)
	@Override
	public void hello(String param) {
		System.out.println("hello there :"+param);
		
	}

	
	@Log(logLevel=LogLevel.NO_LOG)
	@Override
	public void fuck(@ReportDetail String reportCode, String yourName) {
		System.out.println("fuck:" +reportCode+"["+yourName+"]");
		
	}



	/**
	 * <p>Description:[方法功能中文描述]</p>
	 * @param param
	 * @author:孙耀宗
	 * @update:[日期YYYY-MM-DD] [更改人姓名][变更描述]
	 */
	
	@Override
	@Log(logLevel = LogLevel.NO_LOG)
	public void goodbye(String param) {
		System.out.println("goodbye:"+param);
		
	}


	/**
	 * <p>Description:[方法功能中文描述]</p>
	 * @param yourName
	 * @param reportInfo
	 * @author:孙耀宗
	 * @update:[日期YYYY-MM-DD] [更改人姓名][变更描述]
	 */
	
	@Override
	@Log(logLevel = LogLevel.LOG_WITHOUT_OUTPARAM)
	public void sleep(String yourName, @ReportDetail ReportInfo reportInfo) {
		System.out.println("sleep:"+yourName+"["+reportInfo.getReportCode()+"]");
		
	}
}
