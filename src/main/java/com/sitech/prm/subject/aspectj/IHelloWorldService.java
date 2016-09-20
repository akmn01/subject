/**
 * 
 */
package com.sitech.prm.subject.aspectj;

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
public interface IHelloWorldService {
	
	//@Log(logLevel=LogLevel.LOG_WITHOUT_INPARAM)
	public void hello(String param);
	
	@Log(logLevel=LogLevel.LOG_WITHOUT_OUTPARAM)
	public void sleep(String yourName,@ReportDetail ReportInfo reportInfo);
	
	@Log(logLevel=LogLevel.NO_LOG)
	public void fuck(@ReportDetail String reportCode,String yourName);
	
	@Log(logLevel=LogLevel.NO_LOG)
	public void goodbye(String param);

}
