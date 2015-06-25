package com.ifour.study.biz.impl;

import com.ifour.study.biz.IResourcesBiz;
import com.ifour.study.dao.IResourcesDao;
import com.ifour.study.dao.impl.ResourcesDaoImpl;
import com.ifour.study.po.Resources;

public class ResourcesBizImpl implements IResourcesBiz {

	private IResourcesDao resourcesDao;
	
	public ResourcesBizImpl() {
		super();
		// TODO Auto-generated constructor stub
		this.resourcesDao=new ResourcesDaoImpl();
	}

	@Override
	public boolean add(Resources resources) {
		// TODO Auto-generated method stub
		return resourcesDao.insert(resources)>0?true:false;
	}

}
