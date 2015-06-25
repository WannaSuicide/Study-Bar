package com.ifour.study.dao;

import java.util.List;

import com.ifour.study.po.Fans;




public interface IFansDao {
	public abstract int insert(final Fans fans);
	public abstract List<Fans> selectAll();
	public abstract int deleteById(final int fans_id);
	public abstract int delete(final Fans fans);
	public abstract Fans selectById(final int fans_id);
	public abstract List<Fans> selectByUid(final String user_id);
	public abstract List<Fans> selectByUse_Uid(final String use_userid);
	public abstract int update(final Fans fans);
	public abstract boolean selectByObject(final Fans fans);
	

}
