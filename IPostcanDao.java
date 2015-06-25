package com.ifour.study.dao;

import java.util.List;

import com.ifour.study.po.Post_can;



public interface IPostcanDao {
	public abstract int insert(final Post_can postcan);
	public abstract List<Post_can> selectAll();
	public abstract List<Post_can> selectByUser(final String user_id);
	public abstract int deleteById(final int can_id);
	public abstract int deleteByPostId(final int post_id);
	public abstract Post_can selectById(final int can_id);
	public abstract int update(final Post_can postcan);
	public abstract boolean selectByObject(final Post_can postcan);
	public abstract int deleteByObject(final Post_can post_can);

}
