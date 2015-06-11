package com.ifour.study.po;

import java.io.Serializable;
import java.util.Date;

//import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Text;

@SuppressWarnings("serial")
public class Postinfo implements Serializable {

	private int post_id;
	private int userno;
	private int reply_id;
	private String title;
	private String category;
	private String content;
	private String resource;
	private int replycount;
	private int likescount;
	private Date postime;
	public Postinfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Postinfo(int post_id, int userno, int reply_id, String title,
			String category, String content, String resource, int replycount,
			int likescount, Date postime) {
		super();
		this.post_id = post_id;
		this.userno = userno;
		this.reply_id = reply_id;
		this.title = title;
		this.category= category;
		this.content = content;
		this.resource = resource;
		this.replycount = replycount;
		this.likescount = likescount;
		this.postime = postime;
	}
	public int getPost_id() {
		return post_id;
	}
	public void setPost_id(int post_id) {
		this.post_id = post_id;
	}
	public int getUserno() {
		return userno;
	}
	public void setUserno(int userno) {
		this.userno = userno;
	}
	public int getReply_id() {
		return reply_id;
	}
	public void setReply_id(int reply_id) {
		this.reply_id = reply_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category =category;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getResource() {
		return resource;
	}
	public void setResource(String resource) {
		this.resource = resource;
	}
	public int getReplycount() {
		return replycount;
	}
	public void setReplycount(int replycount) {
		this.replycount = replycount;
	}
	public int getLikescount() {
		return likescount;
	}
	public void setLikescount(int likescount) {
		this.likescount = likescount;
	}
	public Date getPostime() {
		return postime;
	}
	public void setPostime(Date postime) {
		this.postime = postime;
	}
	@Override
	public String toString() {
		return "Postinfo [post_id=" + post_id + ", userno=" + userno
				+ ", reply_id=" + reply_id + ", title=" + title + ", category="
				+ category + ", content=" + content + ", resource=" + resource
				+ ", replycount=" + replycount + ", likescount=" + likescount
				+ ", postime=" + postime + "]";
	}
	
}
