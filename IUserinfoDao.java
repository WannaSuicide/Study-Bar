package com.ifour.study.dao;

import java.util.List;



import com.ifour.study.po.Userinfo;

public interface IUserinfoDao {
	public abstract int insert(final Userinfo user);
	public abstract List<Userinfo> selectAll();
	public abstract int deleteById(final int userno);
	public abstract Userinfo selectById(final String user_id);
	public abstract int update(final Userinfo user);
	public abstract Userinfo selectByObject(final String user_id,final String user_pwd);
	public abstract Userinfo selectByNo(final int userno);
}
