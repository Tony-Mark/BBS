package com.xhu.service.impl;

import com.xhu.entity.User;
import com.xhu.mapper.UserMapper;
import com.xhu.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @BelongsProject: BBSboot
 * @Author: XJ
 * @CreateTime: 2023-05-16 09:11
 * @Description: TODO
 * @Version: 1.0
 */
@Service
public class UserServiceImpl implements UserService {
	@Resource
	private UserMapper userMapper;
	
	public User getUserByNumber(String number) {
		return userMapper.getUserByNumber(number);
	}
	
	
	public boolean saveUser(User user) {
		return userMapper.saveUser(user) > 0;
	}
}
