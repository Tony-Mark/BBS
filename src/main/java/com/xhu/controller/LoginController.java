package com.xhu.controller;

import com.xhu.entity.User;
import com.xhu.service.UserService;
import com.xhu.utils.IPUtils;
import jakarta.annotation.Resource;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.*;

/**
 * @BelongsProject: BBSboot
 * @Author: XJ
 * @CreateTime: 2023-05-16 14:13
 * @Description: TODO
 * @Version: 1.0
 */
@RestController
@RequestMapping("/login")
public class LoginController {
	@Resource
	private UserService userService;
	
	@PostMapping
	public boolean login(User user,HttpServletRequest request, HttpServletResponse response){
		/*查询是否用户中有该用户*/
		User user1 = userService.getUserByNumber(user.getNumber());
		if (user1 != null && user.getPassword().equals(user1.getPassword())){
			HttpSession session = request.getSession();
			/*访问人数+1*/
			int number = Integer.parseInt(session.getServletContext().getAttribute("number").toString());
			number++;
			/*添加cookie和session*/
			Cookie c1 = new Cookie("number", user1.getNumber());
			Cookie c2 = new Cookie("password", user1.getPassword());
			/*第一次设置就会进入监听器*/
			session.setAttribute("userName", user1.getUserName());
			session.setAttribute("ip", IPUtils.getClientIpAddr(request));
			/*网站整体的访问数量*/
			session.getServletContext().setAttribute("number", number);
			//保存7天有效
			c1.setMaxAge(60*60*24*7);
			c2.setMaxAge(60*60*24*7);
			//添加到标头，返回浏览器
			response.addCookie(c1);
			response.addCookie(c2);
			return true;
		}
		return false;
	}
}
