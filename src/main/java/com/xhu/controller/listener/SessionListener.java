package com.xhu.controller.listener;

import com.xhu.entity.session.UserBasics;
import jakarta.servlet.ServletContext;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.*;

import java.util.Hashtable;
import java.util.Map;

/**
 * @BelongsProject: BBS
 * @Author: XJ
 * @CreateTime: 2023-05-09 19:46
 * @Description: TODO
 * @Version: 1.0
 */
@WebListener
public class SessionListener implements HttpSessionListener, HttpSessionAttributeListener, HttpSessionActivationListener {
	public SessionListener() {
	}
	
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		// 发生新用户的进来时发生.把新用户信息放到应用的Context上下文件对象中，以便其它所有网页可以共用
		HttpSession session1 = se.getSession();
		ServletContext app1 = session1.getServletContext();
		//取得系统给该用户分得的Id
		String sessionId = session1.getId();
		//如果是第一次新的会话，也就是说本网站应用启动后，此用户是第一个进来
		Map<String, UserBasics> users = (Map<String, UserBasics>) app1.getAttribute("online");
		if (users == null){
			users = new Hashtable<>();
		}
		String userName = "";
		String ip = "";
		UserBasics userBasics = new UserBasics(userName, ip);
		if (session1.isNew()) {
			if (session1.getAttribute("userName") == null){
				userBasics.setUserName("root");
				userBasics.setIp("127.0.0.1");
			}
			//把新用户在线信息放到map
			users.put(sessionId, userBasics);
			app1.setAttribute("online", users);
		}
	}
	
	@Override
	public void attributeAdded(HttpSessionBindingEvent se) {
		HttpSession session1 = se.getSession();
		ServletContext app1 = session1.getServletContext();
		//取得系统给该用户分得的Id
		String sessionId = session1.getId();
		String userName = session1.getAttribute("userName").toString();
		Object ip0 = session1.getAttribute("ip");
		String ip = "";
		if (ip0 == null){
			ip = "127.0.0.1";
		}else{
			ip = ip0.toString();
		}
		/*将用户名和ip地址放进实体类，便于以后查询*/
		UserBasics userBasics = new UserBasics(userName, ip);
		Map<String, UserBasics> users = (Map<String, UserBasics>) app1.getAttribute("online");
		//把新用户在线信息放到map
		users.put(sessionId, userBasics);
		app1.setAttribute("online", users);
	}
	
	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		// 当用户与服务器断开时触发
		HttpSession session1 = se.getSession();
		ServletContext app1 = session1.getServletContext();
		String sessionId = session1.getId();
		Map<String, UserBasics> users = (Map<String, UserBasics>) app1.getAttribute("online");
		if (users != null) {
			//删除该用户的在线信息
			users.remove(sessionId);
		}
		//把删除后的结果重新写回context对象
		app1.setAttribute("online", users);
	}
}
