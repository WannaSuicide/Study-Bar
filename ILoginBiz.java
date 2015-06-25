package com.ifour.study.biz;
import com.ifour.study.po.Userinfo;
public interface ILoginBiz {
	public abstract Userinfo isLogin(final String account, final String password);

}
