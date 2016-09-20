/**   
 * @Title: ServletTest.java 
 * @Package: com.sitech.servlet 
 * @CopyRright (c)2008-2020: si-tech 
 * @Project: 易企算 subject
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author 14K sunyz@si-tech.com.cn
 * @date 2016-9-4 下午10:30:07 
 * @version V2.0   
 */
package com.sitech.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

/**   
 * @Title: ServletTest
 * @Description: TODO(用一句话描述这个类的作用) 
 * @author 14K  sunyz@si-tech.com.cn
 */
public class ServletTest implements Servlet {

	private int count;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("ServletTest init");
	}

	@Override
	public ServletConfig getServletConfig() {
		return null;
	}

	
	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		PrintWriter printWriter = res.getWriter();
		printWriter.print(count++);
		printWriter.close();
		HttpServletResponse reponse = (HttpServletResponse)res;
		reponse.addCookie(new Cookie("count",""+count));  
	}

	
	@Override
	public String getServletInfo() {
		return null;
	}

	/**
	 * @Description: TODO(用一句话描述这个变量表示什么) 
	 * @author:14K sunyz@si-tech.com.cn
	 * @update:[日期YYYY-MM-DD] [更改人姓名][变更描述]
	 */
	
	@Override
	public void destroy() {
		System.out.println("ServletTest destroy");
	}

}
