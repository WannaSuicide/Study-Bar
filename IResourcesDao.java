package com.ifour.study.dao;

import java.util.List;

import com.ifour.study.po.Resources;



public interface IResourcesDao {
	public abstract int insert(final Resources resources);
	public abstract List<Resources> selectAll();
	public abstract int deleteById(final int resid);
	public abstract Resources selectById(final int resid);
	public abstract int update(final Resources resources);

}
