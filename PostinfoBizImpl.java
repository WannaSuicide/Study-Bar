package com.ifour.study.biz.impl;

import java.util.List;

import com.ifour.study.biz.IPostinfoBiz;
import com.ifour.study.dao.IPostinfoDao;
import com.ifour.study.dao.impl.PostinfoDaoImpl;
import com.ifour.study.po.Postinfo;

public class PostinfoBizImpl implements IPostinfoBiz {

	private IPostinfoDao postinfoDao;
	public PostinfoBizImpl() {
		super();
		// TODO Auto-generated constructor stub
		this.postinfoDao=new PostinfoDaoImpl();
	}
	@Override
	public boolean add(Postinfo postinfo) {
		// TODO Auto-generated method stub
		return postinfoDao.insert(postinfo)>0?true:false;
	}
	@Override
	public int selectByPost(Postinfo postinfo) {
		// TODO Auto-generated method stub
		return postinfo.getPost_id();
	}
	@Override
	public boolean deleteById(int post_id) {
		// TODO Auto-generated method stub
		return this.postinfoDao.deleteById(post_id)>0?true:false;
	}
	@Override
	public List<Postinfo> show() {
		// TODO Auto-generated method stub
		return this.postinfoDao.selectAll();
	}

}
