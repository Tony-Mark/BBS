package com.xhu.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.xhu.entity.session.UserBasics;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @BelongsProject: BBSboot
 * @Author: XJ
 * @CreateTime: 2023-05-16 15:26
 * @Description: TODO
 * @Version: 1.0
 */
@RestController
@RequestMapping("/getSession")
public class SessionController {
	/**
	*@description: TODO 获取当前在线用户
	*@param: [request]
	*@return: com.alibaba.fastjson.JSONArray
	*/
	@GetMapping
	public JSONArray getSessionUser(HttpServletRequest request){
		ServletContext application = request.getSession().getServletContext();
		String number = application.getAttribute("number").toString();
		/*获取session中的online对象*/
		Map<String, UserBasics> users = (Map<String, UserBasics>) application.getAttribute("online");
		JSONArray jsonArray = new JSONArray();
		for (String id : users.keySet()) {
			JSONObject object = new JSONObject(true);
			object.put("用户名", users.get(id).getUserName());
			object.put("IP地址", users.get(id).getIp());
			object.put("网站访问总量", number);
			jsonArray.add(object);
		}
		return jsonArray;
	}
	/**
	*@description: TODO 获取当前登录的用户名
	*@param: [sessionName, request]
	*@return: java.lang.String
	*/
	@PostMapping
	public String getSessionValue(@RequestParam("sessionName") String sessionName,HttpServletRequest request) {
		return request.getSession().getAttribute(sessionName).toString();
	}
}
