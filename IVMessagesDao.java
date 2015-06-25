package com.ifour.study.dao;

import java.util.List;

import com.ifour.study.po.VMessages;

public interface IVMessagesDao {
	public abstract List<VMessages> select();
	public abstract  List<VMessages> selectreply(final int postid);
}
