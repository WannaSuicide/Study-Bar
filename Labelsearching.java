package com.ifour.study.po;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Labelsearching implements Serializable {
    private int id;
    private int post_id;
    private String our_label;
	public Labelsearching() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Labelsearching(int id, int post_id, String our_label) {
		super();
		this.id = id;
		this.post_id = post_id;
		this.our_label = our_label;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPost_id() {
		return post_id;
	}
	public void setPost_id(int post_id) {
		this.post_id = post_id;
	}
	public String getOur_label() {
		return our_label;
	}
	public void setOur_label(String our_label) {
		this.our_label = our_label;
	}
	@Override
	public String toString() {
		return "Labelsearching [id=" + id + ", post_id=" + post_id
				+ ", our_label=" + our_label + "]";
	}
    
}
