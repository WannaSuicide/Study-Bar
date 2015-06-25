package com.ifour.study.biz.impl;

import com.ifour.study.biz.IPostCanBiz;
import com.ifour.study.dao.IPostcanDao;
import com.ifour.study.dao.impl.PostcanDaoImpl;

public class PostCanBizImpl implements IPostCanBiz {

	private IPostcanDao postcanDao;
	public PostCanBizImpl() {
		super();
		// TODO Auto-generated constructor stub
		this.postcanDao=new PostcanDaoImpl();
	}
	@Override
	public boolean deleteByPostId(int post_id) {
		// TODO Auto-generated method stub
		return this.postcanDao.deleteByPostId(post_id)>0?true:false;
	}

}
