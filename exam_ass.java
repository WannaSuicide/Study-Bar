package com.ifour.study.po;

import java.io.Serializable;

public class exam_ass implements Serializable {
	private int num;
	private String user_id;
	private String exam_time;
	private String exam_name;
	public exam_ass() {
		super();
		// TODO Auto-generated constructor stub
	}
	public exam_ass(int num, String user_id, String exam_time, String exam_name) {
		super();
		this.num = num;
		this.user_id = user_id;
		this.exam_time = exam_time;
		this.exam_name = exam_name;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getExam_time() {
		return exam_time;
	}
	public void setExam_time(String exam_time) {
		this.exam_time = exam_time;
	}
	public String getExam_name() {
		return exam_name;
	}
	public void setExam_name(String exam_name) {
		this.exam_name = exam_name;
	}
	@Override
	public String toString() {
		return "exam_ass [num=" + num + ", user_id=" + user_id + ", exam_time="
				+ exam_time + ", exam_name=" + exam_name + "]";
	}
	
	
}
