package com.xhu.entity;

/**
 * @BelongsProject: BBS
 * @Author: XJ
 * @CreateTime: 2023-05-02 15:22
 * @Description: TODO
 * @Version: 1.0
 */
public class User {
	private String number;
	private String userName;
	private String password;
	private String phone;
	private String sex;
	private String hobbies;
	private String address;
	private String date;
	private String note;
	private String file;
	
	public User() {
		number = "";
		userName = "";
		password = "";
		phone = "";
		sex = "";
		hobbies = "";
		address = "";
		date = "";
		note = "";
		file = "";
	}
	
	public User(String number, String userName, String password, String phone, String sex,
	            String hobbies, String address, String date, String note, String file) {
		this.number = number;
		this.userName = userName;
		this.password = password;
		this.phone = phone;
		this.sex = sex;
		this.hobbies = hobbies;
		this.address = address;
		this.date = date;
		this.note = note;
		this.file = file;
	}
	
	@Override
	public String toString() {
		return "User{" +
				"number='" + number + '\'' +
				", userName='" + userName + '\'' +
				", password='" + password + '\'' +
				", phone='" + phone + '\'' +
				", sex='" + sex + '\'' +
				", hobbies=" + hobbies +
				", address=" + address +
				", date=" + date +
				", note='" + note + '\'' +
				", file=" + file +
				'}';
	}
	
	public String getNumber() {
		return number;
	}
	
	public void setNumber(String number) {
		this.number = number;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getSex() {
		return sex;
	}
	
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	public String getHobbies() {
		return hobbies;
	}
	
	public void setHobbies(String hobbies) {
		this.hobbies = hobbies;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getDate() {
		return date;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
	
	public String getNote() {
		return note;
	}
	
	public void setNote(String note) {
		this.note = note;
	}
	
	public String getFile() {
		return file;
	}
	
	public void setFile(String file) {
		this.file = file;
	}
}
