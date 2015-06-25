package com.ifour.study.dao;

import java.util.List;

import com.ifour.study.po.Postinfo;
import com.ifour.study.po.Userinfo;



public interface IPostinfoDao {
	public abstract int insert(final Postinfo postinfo);
	public abstract List<Postinfo> selectAll();
	public abstract int deleteById(final int post_id);
	public abstract Postinfo selectById(final int post_id );
	public abstract int update(final Postinfo postinfo);
	public abstract int updateLikesCount(final int post_id);
	public abstract List<Postinfo>selectByType(final int reply_id,final String category);
	public abstract List<Postinfo>selectByType(final int reply_id);
	public abstract List<Postinfo>selectByNo(final int userno);
	public abstract int selectLikes(final int userno);	
	public abstract int selectCount(final int userno);

}
