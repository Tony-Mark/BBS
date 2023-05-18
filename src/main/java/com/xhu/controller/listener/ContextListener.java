package com.xhu.controller.listener;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebListener;

import java.io.*;

/**
 * @BelongsProject: BBS
 * @Author: XJ
 * @CreateTime: 2023-05-09 19:17
 * @Description: TODO
 * @Version: 1.0
 */
@WebListener
public class ContextListener implements ServletContextAttributeListener, ServletContextListener {
	@Override
	public void attributeReplaced(ServletContextAttributeEvent scae) {
	
	}
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		/*web容器开始启动初始化时*/
		
		/*获取ServletContext对象*/
		ServletContext servletContext = sce.getServletContext();
		servletContext.log(servletContext.getServletContextName()+"开始初始化");
		try {
			BufferedReader reader = new BufferedReader(new FileReader("E:\\Code\\IDEAWeb\\BBSboot\\src\\main\\resources\\static\\webResources\\DB\\count.txt"));
			/*将文件中的数据读出*/
			String s = reader.readLine();
			reader.close();
			/*将数据转换成整形并写入context中*/
			servletContext.setAttribute("number", Integer.parseInt(s));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		/*当web容器停止时将context中的数据写回文本中保存*/
		
		/*获取ServletContext对象*/
		ServletContext context = sce.getServletContext();
		/*读出context中的数据*/
		String number = context.getAttribute("number").toString();
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("E:\\Code\\IDEAWeb\\BBSboot\\src\\main\\resources\\static\\webResources\\DB\\count.txt"));
			/*将数据写回文件*/
			writer.write(number);
			writer.close();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
