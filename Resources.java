package com.ifour.study.po;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Resources implements Serializable {
   
	private int resid;
	private String restype;
	private String reslocation;
	public Resources() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Resources(int resid, String restype, String reslocation) {
		super();
		this.resid = resid;
		this.restype = restype;
		this.reslocation = reslocation;
	}
	public int getResid() {
		return resid;
	}
	public void setResid(int resid) {
		this.resid = resid;
	}
	public String getRestype() {
		return restype;
	}
	public void setRestype(String restype) {
		this.restype = restype;
	}
	public String getReslocation() {
		return reslocation;
	}
	public void setReslocation(String reslocation) {
		this.reslocation = reslocation;
	}
	@Override
	public String toString() {
		return "Resources [resid=" + resid + ", restype=" + restype
				+ ", reslocation=" + reslocation + "]";
	}
	
	
}
