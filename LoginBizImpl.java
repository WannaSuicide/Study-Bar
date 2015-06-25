package com.ifour.study.biz.impl;

import com.ifour.study.po.Userinfo;
import com.ifour.study.biz.ILoginBiz;
import com.ifour.study.dao.*;
import com.ifour.study.dao.impl.*;

public class LoginBizImpl implements ILoginBiz {

	private IUserinfoDao userinfoDao;
	
	public LoginBizImpl() {
		super();
		// TODO Auto-generated constructor stub
		this.userinfoDao = new UserinfoDaoImpl();
	}

	@Override
	public Userinfo isLogin(String user_id,String user_pwd) {
		// TODO Auto-generated method stub
		return this.userinfoDao.selectByObject(user_id, user_pwd);
	
	}

}
