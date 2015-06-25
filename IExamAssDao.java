package com.ifour.study.dao;

import java.util.List;

import com.ifour.study.po.exam_ass;

public interface IExamAssDao {
	public abstract int insert(final exam_ass ass);
	public abstract List<exam_ass> findById(final String user_id);

}
