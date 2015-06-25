package com.ifour.study.biz.impl;

import java.util.List;

import com.ifour.study.biz.IVMessagesBiz;
import com.ifour.study.dao.IVMessagesDao;
import com.ifour.study.dao.impl.VMessagesDaoImpl;
import com.ifour.study.po.VMessages;

public class VMessagesBizImpl implements IVMessagesBiz {

	private IVMessagesDao vMessagesDao;
	
	public VMessagesBizImpl() {
		super();
		this.vMessagesDao = new VMessagesDaoImpl();
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<VMessages> show() {
		// TODO Auto-generated method stub
		return this.vMessagesDao.select();
	}
	public List<VMessages> showreply(int postid) {
		// TODO Auto-generated method stub
		return this.vMessagesDao.selectreply(postid);
	}

}
