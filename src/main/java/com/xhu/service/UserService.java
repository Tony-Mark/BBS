package com.xhu.service;

import com.xhu.entity.User;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: XJ
 * @CreateTime: 2023-05-16 09:04
 * @Description: TODO
 */
@Transactional
public interface UserService {
	
	/**
	 * 按账号进行查询
	 * @param number
	 * @return
	 */
	User getUserByNumber(String number);
	/**
	 * 保存新用户
	 * @param user
	 * @return
	 */
	boolean saveUser(User user);
}
