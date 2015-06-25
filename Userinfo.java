package com.ifour.study.po;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class Userinfo implements Serializable {
	private int userno;
	private String user_id;
	private String user_pwd;
	private String our_email;
	private String user_name;
	private Date birthday;
	private String gender;
	private String school;
	private String college;
	private String major;
	private Date enrollment_date;
	private String head_photo;
	@Override
	public String toString() {
		return "Userinfo [userno=" + userno + ", user_id=" + user_id
				+ ", user_pwd=" + user_pwd + ",our_email="+our_email+", user_name=" + user_name
				+ ", birthday=" + birthday + ", gender=" + gender + ", school="
				+ school + ", college=" + college + ", major=" + major
				+ ", enrollment_date=" + enrollment_date +",head_photo="+head_photo+ "]";
	}
	public Userinfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getUserno() {
		return userno;
	}
	public void setUserno(int userno) {
		this.userno = userno;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_pwd() {
		return user_pwd;
	}
	public void setUser_pwd(String user_pwd) {
		this.user_pwd = user_pwd;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public String getCollege() {
		return college;
	}
	public void setCollege(String college) {
		this.college = college;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public Date getEnrollment_date() {
		return enrollment_date;
	}
	public void setEnrollment_date(Date enrollment_date) {
		this.enrollment_date = enrollment_date;
	}
	public Userinfo(int userno, String user_id, String user_pwd,String our_email, String user_name,
			Date birthday, String gender, String school, String college,
			String major, Date enrollment_date, String head_photo) {
		super();
		this.userno = userno;
		this.user_id = user_id;
		this.user_pwd = user_pwd;
		this.our_email=our_email;
		this.user_name = user_name;
		this.birthday = birthday;
		this.gender = gender;
		this.school = school;
		this.college = college;
		this.major = major;
		this.enrollment_date = enrollment_date;
		this.head_photo=head_photo;
	}
	public String getOur_email() {
		return our_email;
	}
	public void setOur_email(String our_email) {
		this.our_email = our_email;
	}
	public String getHead_photo() {
		return head_photo;
	}
	public void setHead_photo(String head_photo) {
		this.head_photo = head_photo;
	}
	
	

}
