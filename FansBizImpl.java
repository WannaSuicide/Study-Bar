package com.ifour.study.biz.impl;

import java.util.List;

import com.ifour.study.biz.IFansBiz;
import com.ifour.study.dao.IFansDao;
import com.ifour.study.dao.impl.FansDaoImpl;
import com.ifour.study.po.Fans;

public class FansBizImpl implements IFansBiz {

	private IFansDao iFansDao;
	public FansBizImpl() {
		super();
		// TODO Auto-generated constructor stub
		this.iFansDao=new FansDaoImpl();

}
	
	public List<Fans> selectByUid(String user_id) {
		// TODO Auto-generated method stub
		return this.iFansDao.selectByUid(user_id);
	}

	@Override
	public List<Fans> selectByUse_Uid(String use_userid) {
		// TODO Auto-generated method stub
		return this.iFansDao.selectByUse_Uid(use_userid);
	}
	
	@Override
	public boolean add(Fans fans) {
		// TODO Auto-generated method stub
		
			
			
			   return this.iFansDao.insert(fans)>0?true:false;
			
		}	
		
	
	
	
	@Override
	public boolean del(Fans fans) {
		// TODO Auto-generated method stub
		return this.iFansDao.delete(fans)>0?true:false;
	}

}
