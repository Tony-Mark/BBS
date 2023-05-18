package com.xhu.controller;

import com.xhu.entity.User;
import com.xhu.service.UserService;
import com.xhu.utils.RegisterSqlUtil;
import jakarta.annotation.Resource;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

/**
 * @BelongsProject: BBSboot
 * @Author: XJ
 * @CreateTime: 2023-05-16 09:16
 * @Description: TODO
 * @Version: 1.0
 */
@RestController
@RequestMapping("/users")
public class UserController {
	@Resource
	private UserService userService;
	
	@GetMapping("/{number}")
	public User getUserByNumber(@PathVariable String number){
		return userService.getUserByNumber(number);
	}
	
	@PostMapping
	public boolean saveUser(HttpServletRequest request){
		User user = new User();
		try {
			RegisterSqlUtil.requestToModelHaveFile("user", user, request);
		} catch (ServletException | IOException e) {
			throw new RuntimeException(e);
		}
		User user1 = userService.getUserByNumber(user.getNumber());
		if (user1 == null){
			return userService.saveUser(user);
		}
		return false;
	}
}
