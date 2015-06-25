package com.ifour.study.dao;

import java.util.List;

import com.ifour.study.po.Labelsearching;



public interface ILabelSearchingDao {
	public abstract int insert(final Labelsearching labelSearching);
	public abstract List<Labelsearching> selectAll();
	public abstract int deleteById(final int post_id);
	public abstract Labelsearching selectById(final int id);
	public abstract int update(final Labelsearching labelSearching);
	public abstract List<Integer> select(String our_label);
}
