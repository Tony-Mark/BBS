package com.xhu.mapper;

import com.xhu.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @Author: XJ
 * @CreateTime: 2023-05-16 07:52
 * @Description: TODO
 */
@Mapper
public interface UserMapper {

	@Select("select * from user where number = #{number}")
	User getUserByNumber(String number);
	
	@Insert("insert into user (number,userName,password,phone,sex,hobbies,address,date,note,file) " +
			"values (#{number},#{userName},#{password},#{phone},#{sex},#{hobbies},#{address}," +
			"#{date},#{note},#{file})")
	int saveUser(User user);
}
