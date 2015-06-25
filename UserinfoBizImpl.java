package com.ifour.study.biz.impl;

import com.ifour.study.biz.IUserinfoBiz;
import com.ifour.study.dao.IUserinfoDao;
import com.ifour.study.dao.impl.UserinfoDaoImpl;
import com.ifour.study.po.Userinfo;

public class UserinfoBizImpl implements IUserinfoBiz {

	private IUserinfoDao iUserinfoDao;
	
	
	public UserinfoBizImpl() {
		super();
		// TODO Auto-generated constructor stub
		this.iUserinfoDao=new UserinfoDaoImpl();
	}


	@Override
	public boolean add(Userinfo user) {
		// TODO Auto-generated method stub
		if(this.iUserinfoDao.selectById(user.getUser_id())==null){
			if(user.getUser_id()!=null&&user.getUser_pwd()!=null&&user.getOur_email()!=null&&user.getUser_name()!=null&&user.getEnrollment_date()!=null&&user.getGender()!=null&&user.getSchool()!=null&&user.getCollege()!=null&&user.getMajor()!=null)
			{
			
			   return this.iUserinfoDao.insert(user)>0?true:false;
			}
			else{
				return false;
			}
			
		}	
		else
		{
			return false;
		}
			
		
	}


	@Override
	public Userinfo findById(int userno) {
		// TODO Auto-generated method stub
		return this.iUserinfoDao.selectByNo(userno);
	}


	@Override
	public boolean modify(Userinfo user) {
		// TODO Auto-generated method stub
		return this.iUserinfoDao.update(user)>0?true:false;
	}

}
