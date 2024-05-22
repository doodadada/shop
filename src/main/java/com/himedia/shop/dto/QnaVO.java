package com.himedia.shop.dto;

import java.sql.Timestamp;

public class QnaVO {
	
	private Integer qseq;
	private String subject;
	private String content;
	private String reply;
	private String userid;
	private Timestamp indate;
	
	public Integer getQseq() {
		return qseq;
	}
	public void setQseq(Integer qseq) {
		this.qseq = qseq;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getReply() {
		return reply;
	}
	public void setReply(String reply) {
		this.reply = reply;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public Timestamp getIndate() {
		return indate;
	}
	public void setIndate(Timestamp indate) {
		this.indate = indate;
	}
	@Override
	public String toString() {
		return "QnaVO [qseq=" + qseq + ", subject=" + subject + ", content=" + content + ", reply=" + reply
				+ ", userid=" + userid + ", indate=" + indate + "]";
	}
	
	
	
}
