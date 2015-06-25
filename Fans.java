package com.ifour.study.po;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Fans implements Serializable {
	private int fans_id;
	private String user_id;
	private String use_userid;
	public Fans() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Fans [fans_id=" + fans_id + ", user_id=" + user_id
				+ ", use_userid=" + use_userid + "]";
	}
	public int getFans_id() {
		return fans_id;
	}
	public void setFans_id(int fans_id) {
		this.fans_id = fans_id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUse_userid() {
		return use_userid;
	}
	public void setUse_userid(String use_userid) {
		this.use_userid = use_userid;
	}
	public Fans(int fans_id, String user_id, String use_userid) {
		super();
		this.fans_id = fans_id;
		this.user_id = user_id;
		this.use_userid = use_userid;
	}
	
	

}
