/**
 * 
 */
package com.sitech.prm.subject.aspectj;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

/**
 * TODO  Created on 2016-6-16
 * <p>Title: 统一报表平台</p>
 * <p>Copyright: Copyright (c) 2015-2025</p>
 * <p>Company: 北京思特奇信息技术股份有限公司</p>
 * <p>Department: PRM-PSD</p>
 * @author 孙耀宗  sunyz@si-tech.com.cn
 * @version 1.0
 * @update 修改日期 修改描述
 */
@Component
@Aspect
public class Aspectj {
	@Pointcut(value="execution(* com.sitech.prm.subject.aspectj.HelloWorldServiceImpl.*(..)) && @annotation(com.sitech.prm.subject.aspectj.Log)")  
	public void pointcut() {}  
	
	@Around("pointcut()")
	public Object doAround(ProceedingJoinPoint point) throws Throwable{
		System.out.println("["+point.getSignature().getName()+"]"+"===========before");
		Object returnObj =  null;
		long startTime =0L,endTime = 0L;
		String runSuccessFlag = "T";
		try {
			String reportCode = getReportCode(point);
			System.err.println("["+point.getSignature().getName()+"]"+"reportCode:"+reportCode);
			System.err.println("["+point.getSignature().getName()+"]"+"LogLevel:"+getLogLevel(point));
			startTime = System.currentTimeMillis();
			returnObj = point.proceed(point.getArgs());
			endTime = System.currentTimeMillis();
			
			return returnObj;
		} catch (Throwable e) {
			runSuccessFlag = "N";
			e.printStackTrace();
			returnObj = e.getMessage();
			throw e;
		} finally{
			System.out.println("["+point.getSignature().getName()+"]"+"===========after\n\n");
			//writeLog(point,startTime,endTime,runSuccessFlag,returnObj);
		}
	}
	
	private LogLevel getLogLevel(ProceedingJoinPoint point){
		MethodSignature joinPointObject = (MethodSignature) point.getSignature();
		Method method = joinPointObject.getMethod(); 
		Log log = method.getAnnotation(Log.class);
		if(null == log){
			return null;
		}
		return log.logLevel();
	}
	
	private String getReportCode(ProceedingJoinPoint point){
		int reportDetailParamPosition = getReportDetailParamPosition(point);
		if(-1 != reportDetailParamPosition){
			Object reportDetail = point.getArgs()[reportDetailParamPosition];
			if(null == reportDetail){
				return null;
			}else if(reportDetail instanceof String){
				return String.valueOf(reportDetail);
			}else if(reportDetail instanceof ReportInfo){
				return ((ReportInfo) reportDetail).getReportCode();
			}else{
				return "meiyou";
			}
		}
		return null;
	}
	
	private int getReportDetailParamPosition(ProceedingJoinPoint point){
		MethodSignature joinPointObject = (MethodSignature) point.getSignature();
		Method method = joinPointObject.getMethod();    
		Annotation[][]  allParamAnnotations =  method.getParameterAnnotations();
		Annotation[] currentParamAnnotations = null;
		int reportDetailParamPosition = -1;
		for(int paramIndex=0;paramIndex<allParamAnnotations.length;paramIndex++){
			currentParamAnnotations = allParamAnnotations[paramIndex];
			for(Annotation annotation : currentParamAnnotations){
				if(annotation instanceof ReportDetail){
					reportDetailParamPosition = paramIndex;
					return reportDetailParamPosition;
				}
			}
		}
		return -1;
	}
	
	@Test  
	public void testAnnotationBeforeAdvice() {  
	    ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-advice.xml");  
	    IHelloWorldService helloworldService = ctx.getBean("helloWorldServiceImpl", IHelloWorldService.class);  
	    helloworldService.hello("孙耀宗");  
	    helloworldService.sleep("xiaoxiao", new ReportInfo("11234"));
	    helloworldService.fuck("10003", "xiaoxiao");
	    helloworldService.goodbye("bitch");
	}  

}
