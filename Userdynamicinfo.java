package com.ifour.study.po;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Userdynamicinfo implements Serializable {
	private int userno;
	private int post_count;
	private int score;
	private String rank;
	private String nickname;
	private String status;
	private String note;
	public Userdynamicinfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Userdynamicinfo(int userno, int post_count, int score, String rank,
			String nickname, String status, String note) {
		super();
		this.userno = userno;
		this.post_count = post_count;
		this.score = score;
		this.rank = rank;
		this.nickname = nickname;
		this.status = status;
		this.note = note;
	}

	public int getUserno() {
		return userno;
	}
	public void setUserno(int userno) {
		this.userno = userno;
	}
	public int getPost_count() {
		return post_count;
	}
	public void setPost_count(int post_count) {
		this.post_count = post_count;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String getRank() {
		return rank;
	}
	public void setRank(String rank) {
		this.rank = rank;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}

	@Override
	public String toString() {
		return "Userdynamicinfo [userno=" + userno + ", post_count="
				+ post_count + ", score=" + score + ", rank=" + rank
				+ ", nickname=" + nickname + ", status=" + status + ", note="
				+ note + "]";
	}
	
	
	

}
