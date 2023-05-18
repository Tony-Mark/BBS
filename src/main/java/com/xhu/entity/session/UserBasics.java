package com.xhu.entity.session;

/**
 * @BelongsProject: BBSboot
 * @Author: XJ
 * @CreateTime: 2023-05-16 17:40
 * @Description: TODO 用于保存用户登录时的信息
 * @Version: 1.0
 */
public class UserBasics {
	private String userName;
	private String Ip;
	
	public UserBasics() {
	}
	
	public UserBasics(String userName, String ip) {
		this.userName = userName;
		Ip = ip;
	}
	
	@Override
	public String toString() {
		return "UserBasics{" +
				"userName='" + userName + '\'' +
				", Ip='" + Ip + '\'' +
				'}';
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getIp() {
		return Ip;
	}
	
	public void setIp(String ip) {
		Ip = ip;
	}
}
