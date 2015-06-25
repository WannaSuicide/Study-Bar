package com.ifour.study.po;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Post_can implements Serializable {
	private int can_id;
	private int post_id;
	private String user_id;
	public Post_can() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Post_can(int can_id, int post_id, String user_id) {
		super();
		this.can_id = can_id;
		this.post_id = post_id;
		this.user_id = user_id;
	}
	public int getCan_id() {
		return can_id;
	}
	public void setCan_id(int can_id) {
		this.can_id = can_id;
	}
	public int getPost_id() {
		return post_id;
	}
	public void setPost_id(int post_id) {
		this.post_id = post_id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id=user_id;
	}
	@Override
	public String toString() {
		return "Post_can [can_id=" + can_id + ", post_id=" + post_id
				+ ", user_id=" + user_id + "]";
	}
	

}
