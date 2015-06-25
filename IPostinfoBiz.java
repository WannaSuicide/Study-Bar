package com.ifour.study.biz;

import java.util.List;

import com.ifour.study.po.Postinfo;

public interface IPostinfoBiz {
	public abstract boolean add(final Postinfo postinfo);
	public abstract boolean deleteById(final int post_id);
	public abstract int selectByPost(final Postinfo postinfo);
	public abstract List<Postinfo> show();

}
