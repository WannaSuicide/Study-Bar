package com.ifour.study.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;












import com.ifour.study.dao.IUserinfoDao;
import com.ifour.study.db.ConnectionManager;
import com.ifour.study.db.DBUtils;
import com.ifour.study.db.TransactionManager;
import com.ifour.study.po.Userinfo;



public class UserinfoDaoImpl implements IUserinfoDao {
	private ConnectionManager connectionManager;
    private DBUtils dbUtils; 
    public UserinfoDaoImpl() {
		super();
		this.connectionManager=new ConnectionManager();
		this.dbUtils=new DBUtils();
		
		// TODO Auto-generated constructor stub
	}
	@Override
	public int insert(Userinfo user) {
		// TODO Auto-generated method stub
Connection conn=connectionManager.openConnection();
	    
	    TransactionManager.conn=conn;
	    TransactionManager.beginTransaction();
	    
	    String user_id=user.getUser_id();
		String user_pwd=user.getUser_pwd();
		String our_email=user.getOur_email();
		String user_name=user.getUser_name();
		Date birthday=user.getBirthday();
		String gender=user.getGender();
		String school=user.getSchool();
		String College=user.getCollege();
		String major=user.getMajor();
		Date enrollment_date=user.getEnrollment_date();
		String head_photo=user.getHead_photo();
	    
	    String strSQL="insert into Userinfo values(null,?,?,?,?,?,?,?,?,?,?,?)";
	    
	    Object[] params=new Object[]{user_id,user_pwd,our_email,user_name,birthday,gender,school,College,major,enrollment_date,head_photo};
	    
	    int affectedRows=this.dbUtils.execOthers(conn, strSQL, params);
	    
	    if(affectedRows>0)
	    {
	    	TransactionManager.commit(); 
	    	
	    }
	    else
	    {
	    	TransactionManager.rollback();
	    	
	    }
	   return affectedRows;
		
	}

	@Override
	public List<Userinfo> selectAll() {
		// TODO Auto-generated method stub
		 Connection conn=connectionManager.openConnection();
		    
		 
		    
			List<Userinfo> lstUserinfo = new ArrayList<Userinfo>();
			String strSQL="select * from Userinfo order by userno";
			ResultSet resultSet=this.dbUtils.execQuery(conn, strSQL, new Object[]{});
			
			try {
				while(resultSet.next())
				{
					Userinfo user=new Userinfo();
					user.setUserno(resultSet.getInt(1));
					user.setUser_id(resultSet.getString(2));
					user.setUser_pwd(resultSet.getString(3));
					user.setOur_email(resultSet.getString(4));
					user.setUser_name(resultSet.getString(5));
					user.setBirthday(resultSet.getDate(6));
					user.setCollege(resultSet.getString(7));
					user.setGender(resultSet.getString(8));
					user.setCollege(resultSet.getString(9));
					user.setMajor(resultSet.getString(10));
					user.setEnrollment_date(resultSet.getDate(11));
					user.setHead_photo(resultSet.getString(12));
					lstUserinfo.add(user);
					
				}
				return lstUserinfo;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
				}
			
			finally{
				this.connectionManager.closeConnection(conn);
			}
			
			
		}
	
	

	@Override
	public int deleteById(int userno) {
		// TODO Auto-generated method stub
Connection conn=this.connectionManager.openConnection();
		
		TransactionManager.conn=conn;
		TransactionManager.beginTransaction();
		
		String strSQL="delete from userinfo where userno=?";
		Object[] params=new Object[]{userno};
		int affectedRows=this.dbUtils.execOthers(conn, strSQL, params);
		
		if(affectedRows>0)
		{
			TransactionManager.commit();
		}
		else{
			TransactionManager.rollback();
		}
		return affectedRows;
	
	
		
	}

	public Userinfo selectById(String user_id) {
		// TODO Auto-generated method stub
		Connection conn = this.connectionManager.openConnection();
		
		String strSQL = "select * from userinfo where user_id=?";
		Object[] params = new Object[] { user_id};
		
		ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL, params);
	
		try {
			if (resultSet.next()) {
				Userinfo user=new Userinfo();
				user.setUserno(resultSet.getInt(1));
				user.setUser_id(resultSet.getString(2));
				user.setUser_pwd(resultSet.getString(3));
				user.setOur_email(resultSet.getString(4));
				user.setUser_name(resultSet.getString(5));
				user.setBirthday(resultSet.getDate(6));
				user.setCollege(resultSet.getString(7));
				user.setGender(resultSet.getString(8));
				user.setCollege(resultSet.getString(9));
				user.setMajor(resultSet.getString(10));
				user.setEnrollment_date(resultSet.getDate(11));
				user.setHead_photo(resultSet.getString(12));
				
				return user;
			} else {
				return null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			this.connectionManager.closeConnection(conn);
		}
	
	}

	@Override
	public int update(Userinfo user) {
		// TODO Auto-generated method stub
		Connection conn = this.connectionManager.openConnection();
		
		TransactionManager.conn = conn;
		TransactionManager.beginTransaction();
	
		String strSQL = "update userinfo set user_id=?, user_pwd=?, our_email=?,user_name=? ,birthday=?,gender=?,school=?,college=?,major=?,enrollment_date=?,head_photo=? where userno=?";
		Object[] params = new Object[] { user.getUser_id(),user.getUser_pwd(),user.getOur_email(),user.getUser_name(),user.getBirthday(),user.getGender(),user.getSchool(),user.getCollege(),user.getMajor(),user.getEnrollment_date(),user.getHead_photo(),user.getUserno()};

		int affectedRwos = this.dbUtils.execOthers(conn, strSQL, params);
			if (affectedRwos > 0) {
			TransactionManager.commit(); // 事务提交
		} else {
			TransactionManager.rollback(); // 事务的回滚
		}
	
		return affectedRwos;
		
	}
	public Userinfo selectByObject(String user_id,String user_pwd)
	{
		Connection conn = this.connectionManager.openConnection();
		
		String strSQL = "select * from userinfo where user_id=? and user_pwd=?";
		Object[] params = new Object[]{user_id, user_pwd};
		
		ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL, params);
		try {
			if(resultSet.next()){
				Userinfo user = new Userinfo();
				user.setUserno(resultSet.getInt(1));
				user.setUser_id(resultSet.getString(2));
				user.setUser_pwd(resultSet.getString(3));
				user.setOur_email(resultSet.getString(4));
				user.setUser_name(resultSet.getString(5));
				user.setBirthday(resultSet.getDate(6));
				user.setGender(resultSet.getString(7));
				user.setSchool(resultSet.getString(8));
				user.setCollege(resultSet.getString(9));
				user.setMajor(resultSet.getString(10));
				user.setEnrollment_date(resultSet.getDate(11));
				user.setHead_photo(resultSet.getString(12));
				
				return user;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return  null;
		} finally{
			this.connectionManager.closeConnection(conn);
		}	
		return null;
	}
	@Override
	public Userinfo selectByNo(int userno) {
		// TODO Auto-generated method stub
		Connection conn = this.connectionManager.openConnection();
		
		String strSQL = "select * from userinfo where userno=?";
		Object[] params = new Object[] { userno};
		
		ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL, params);
	
		try {
			if (resultSet.next()) {
				Userinfo user=new Userinfo();
				user.setUserno(resultSet.getInt(1));
				user.setUser_id(resultSet.getString(2));
				user.setUser_pwd(resultSet.getString(3));
				user.setOur_email(resultSet.getString(4));
				user.setUser_name(resultSet.getString(5));
				user.setBirthday(resultSet.getDate(6));
				user.setCollege(resultSet.getString(7));
				user.setGender(resultSet.getString(8));
				user.setCollege(resultSet.getString(9));
				user.setMajor(resultSet.getString(10));
				user.setEnrollment_date(resultSet.getDate(11));
				user.setHead_photo(resultSet.getString(12));
				
				return user;
			} else {
				return null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			this.connectionManager.closeConnection(conn);
		}
	}
	


}
