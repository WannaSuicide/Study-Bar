package com.ifour.study.biz.impl;

import com.ifour.study.biz.IUserdynamicinfoBiz;
import com.ifour.study.dao.IUserdynamicinfoDao;
import com.ifour.study.dao.impl.UserdynamicinfoDaoImpl;
import com.ifour.study.po.Userdynamicinfo;

public class UserdynamicinfoBizImpl implements IUserdynamicinfoBiz {

	private IUserdynamicinfoDao iUserdynamicinfoDao;
	
	public UserdynamicinfoBizImpl() {
		super();
		// TODO Auto-generated constructor stub
		this.iUserdynamicinfoDao=new UserdynamicinfoDaoImpl();
	}

	@Override
	public boolean add(Userdynamicinfo user) {
		// TODO Auto-generated method stub
		return this.iUserdynamicinfoDao.insert(user)>0?true:false;
	}

}
