package com.xhu.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @BelongsProject: BBS
 * @Author: XJ
 * @CreateTime: 2023-05-04 19:54
 * @Description: TODO
 * @Version: 1.0
 */
public class Bbs {
	@JSONField(ordinal = 1)
	private Integer id;
	@JSONField(ordinal = 2)
	private String title;
	@JSONField(ordinal = 3)
	private String content;
	@JSONField(ordinal = 4)
	private String auth;
	@JSONField(ordinal = 5)
	private String pic;
	@JSONField(ordinal = 6)
	private String greatNo;
	@JSONField(ordinal = 7)
	private String dropNo;
	@JSONField(ordinal = 8)
	private String repNo;
	@JSONField(ordinal = 9)
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date fbDate;
	
	public Bbs() {
	}
	
	public Bbs(Integer id, String title, String content, String auth, String pic, String greatNo, String dropNo, String repNo, Date fbDate) {
		this.id = id;
		this.title = title;
		this.content = content;
		this.auth = auth;
		this.pic = pic;
		this.greatNo = greatNo;
		this.dropNo = dropNo;
		this.repNo = repNo;
		this.fbDate = fbDate;
	}
	
	@Override
	public String toString() {
		return "Bbs{" +
				"id=" + id +
				", title='" + title + '\'' +
				", content='" + content + '\'' +
				", auth='" + auth + '\'' +
				", pic='" + pic + '\'' +
				", greatNo='" + greatNo + '\'' +
				", dropNo='" + dropNo + '\'' +
				", repNo='" + repNo + '\'' +
				", fbDate=" + fbDate +
				'}';
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public String getAuth() {
		return auth;
	}
	
	public void setAuth(String auth) {
		this.auth = auth;
	}
	
	public String getPic() {
		return pic;
	}
	
	public void setPic(String pic) {
		this.pic = pic;
	}
	
	public String getGreatNo() {
		return greatNo;
	}
	
	public void setGreatNo(String greatNo) {
		this.greatNo = greatNo;
	}
	
	public String getDropNo() {
		return dropNo;
	}
	
	public void setDropNo(String dropNo) {
		this.dropNo = dropNo;
	}
	
	public String getRepNo() {
		return repNo;
	}
	
	public void setRepNo(String repNo) {
		this.repNo = repNo;
	}
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	public Date getFbDate() {
		return fbDate;
	}
	
	public void setFbDate(Date fbDate) {
		this.fbDate = fbDate;
	}
}
