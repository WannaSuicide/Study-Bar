package com.ifour.study.biz;

import java.util.List;

import com.ifour.study.po.Fans;

public interface IFansBiz {
	public abstract boolean add(final Fans fans);
	public abstract boolean del(final Fans fans);
	public abstract List<Fans> selectByUid(final String user_id);
	public abstract List<Fans> selectByUse_Uid(final String use_userid);
}
