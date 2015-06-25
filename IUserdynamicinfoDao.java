package com.ifour.study.dao;

import java.util.List;

import com.ifour.study.po.Userdynamicinfo;


public interface IUserdynamicinfoDao {
	public abstract int insert(final Userdynamicinfo user);
	public abstract List<Userdynamicinfo> selectAll();
	public abstract int deleteById(final int userno);
	public abstract Userdynamicinfo selectById(final int userno);
	public abstract int update(final Userdynamicinfo user);
	public abstract int updateScore(final int likescount,final int postcount,final int userno);
	public abstract int selectScore(final int userno);

}
