package com.xhu.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @BelongsProject: BBS
 * @Author: XJ
 * @CreateTime: 2023-05-04 19:58
 * @Description: TODO
 * @Version: 1.0
 */
public class BbsRep {
	private String id;
	private String tzid;
	private String content;
	private String repl;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	private Date repDate;
	private String clickNo;
	
	public BbsRep() {
	}
	
	public BbsRep(String id, String tzid, String content, String repl, Date repDate, String clickNo) {
		this.id = id;
		this.tzid = tzid;
		this.content = content;
		this.repl = repl;
		this.repDate = repDate;
		this.clickNo = clickNo;
	}
	
	@Override
	public String toString() {
		return "BbsRep{" +
				"id='" + id + '\'' +
				", tzid='" + tzid + '\'' +
				", content='" + content + '\'' +
				", repl='" + repl + '\'' +
				", repDate='" + repDate + '\'' +
				", clickNo='" + clickNo + '\'' +
				'}';
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getTzid() {
		return tzid;
	}
	
	public void setTzid(String tzid) {
		this.tzid = tzid;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public String getRepl() {
		return repl;
	}
	
	public void setRepl(String repl) {
		this.repl = repl;
	}
	
	public Date getRepDate() {
		return repDate;
	}
	
	public void setRepDate(Date repDate) {
		this.repDate = repDate;
	}
	
	public String getClickNo() {
		return clickNo;
	}
	
	public void setClickNo(String clickNo) {
		this.clickNo = clickNo;
	}
}
