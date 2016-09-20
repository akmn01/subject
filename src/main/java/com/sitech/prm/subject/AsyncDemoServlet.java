/*************************************************
 * 北京思特奇信息技术股份有限公司版权所有
 * Copyright (C), Si-tech.
 * @Title: AsyncDemoServlet.java   
 * @Package com.sitech.prm.subject   
 * @Description: TODO(用一句话描述该文件做什么)   
 * @author Administrator
 * @date 2016-1-20 下午5:54:20   
 * @version V1.0
 * History:
 *	1. Date:2016-1-20
 *     Author:Administrator
 *     Modification:(描述修改了什么内容)
 *  2. ...
*************************************************/
package com.sitech.prm.subject;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>Title: AsyncDemoServlet.java</p>
 * <p>Description: TODO(这里用一句话描述这个方法的作用) </p>
 * <p>Copyright: Copyright (c) 2015</p>
 * <p>Company: SI-TECH </p>
 * @author SUNYZ
 * @version 1.0
 * @create 2016-1-20
 * 修改日期  修改人  修改目的
 */

@WebServlet(urlPatterns = "/demo", asyncSupported = true
	,initParams={@WebInitParam(name="username",value="sunyz")}
	,largeIcon="/nrs/cat.ico",smallIcon="/nrs/cat.ico")
public class AsyncDemoServlet extends HttpServlet {
	
	@Override
	public void init() throws ServletException {
		System.out.println("username:"+this.getInitParameter("username"));
	};
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
    throws IOException, ServletException {
    	
    	System.out.println(new Date());
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.println(req.getServletContext().getInitParameter("username")+"进入Servlet的时间：" + new Date() + ".");
        out.flush();

        //在子线程中执行业务调用，并由其负责输出响应，主线程退出
        AsyncContext ctx = req.startAsync();
        new Thread(new Executor(ctx)).start();

        out.println("结束Servlet的时间：" + new Date() + ".");
        out.flush();
    }
}
