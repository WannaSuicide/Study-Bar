package com.ifour.study.biz;

import java.util.List;

import com.ifour.study.po.VMessages;

public interface IVMessagesBiz {

	public abstract List<VMessages> show();
	public abstract List<VMessages> showreply(final int postid);

}
