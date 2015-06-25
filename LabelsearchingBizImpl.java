package com.ifour.study.biz.impl;

import com.ifour.study.biz.ILabelsearchingBiz;
import com.ifour.study.dao.ILabelSearchingDao;
import com.ifour.study.dao.impl.LabelSearchingDaoImpl;
import com.ifour.study.po.Labelsearching;

public class LabelsearchingBizImpl implements ILabelsearchingBiz {

	private ILabelSearchingDao searchingDao;
	
	public LabelsearchingBizImpl() {
		super();
		// TODO Auto-generated constructor stub
		this.searchingDao=new LabelSearchingDaoImpl();
	}

	@Override
	public boolean add(Labelsearching labelsearching) {
		// TODO Auto-generated method stub
		
		return this.searchingDao.insert(labelsearching)>0?true:false;
	}

	@Override
	public boolean deleteById(int post_id) {
		// TODO Auto-generated method stub
		return this.searchingDao.deleteById(post_id)>0?true:false;
	}

}
