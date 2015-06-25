package com.ifour.study.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ifour.study.dao.IFansDao;
import com.ifour.study.db.ConnectionManager;
import com.ifour.study.db.DBUtils;
import com.ifour.study.db.TransactionManager;
import com.ifour.study.po.Fans;
//import com.ifour.study.po.Post_can;


public class FansDaoImpl implements IFansDao {

	private ConnectionManager connectionManager;
    private DBUtils dbUtils; 
    public FansDaoImpl() {
		super();
		this.connectionManager=new ConnectionManager();
		this.dbUtils=new DBUtils();
		
		// TODO Auto-generated constructor stub
	}
	@Override
	public int insert(Fans fans) {
		// TODO Auto-generated method stub
Connection conn=connectionManager.openConnection();
	    
	    TransactionManager.conn=conn;
	    TransactionManager.beginTransaction();
	    
	    //int fans_id=fans.getFans_id();
		String user_id=fans.getUser_id();
		String use_userid=fans.getUse_userid();
	    
	    String strSQL="insert into fans values(null,?,?)";
	    
	    Object[] params=new Object[]{user_id,use_userid};
	    
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
	public List<Fans> selectAll() {
		// TODO Auto-generated method stub
		 Connection conn=connectionManager.openConnection();
		    
		 
		    
			List<Fans> lstFans = new ArrayList<Fans>();
			String strSQL="select * from Fans order by fans_id";
			ResultSet resultSet=this.dbUtils.execQuery(conn, strSQL, new Object[]{});
			
			try {
				while(resultSet.next())
				{
					Fans fans=new Fans();
					fans.setFans_id(resultSet.getInt(1));
					fans.setUser_id(resultSet.getString(2));
					fans.setUse_userid(resultSet.getString(3));
					lstFans.add(fans);
					
				}
				return lstFans;
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
	public int deleteById(int fans_id) {
		// TODO Auto-generated method stub
        Connection conn=this.connectionManager.openConnection();
		
		TransactionManager.conn=conn;
		TransactionManager.beginTransaction();
		
		String strSQL="delete from Fans where fans_id=?";
		Object[] params=new Object[]{fans_id};
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

	
	public int delete(Fans fans) {
		// TODO Auto-generated method stub
        Connection conn=this.connectionManager.openConnection();
		
		TransactionManager.conn=conn;
		TransactionManager.beginTransaction();
		
		String user_id=fans.getUser_id();
		String use_userid=fans.getUse_userid();
		
		String strSQL="delete from Fans where user_id=?&&use_userid=?";
		Object[] params=new Object[]{user_id,use_userid};
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
	
	@Override
	public Fans selectById(int fans_id) {
		// TODO Auto-generated method stub
Connection conn = this.connectionManager.openConnection();
		
		String strSQL = "select * from fans where fans_id=?";
		Object[] params = new Object[] { fans_id};
		
		ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL, params);
	
		try {
			if (resultSet.next()) {
				Fans fans=new Fans();
				fans.setFans_id(resultSet.getInt(1));
				fans.setUser_id(resultSet.getString(2));
				fans.setUse_userid(resultSet.getString(3));
				
				
				
				return fans ;
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

	public List<Fans> selectByUid(String user_id) {
		// TODO Auto-generated method stub
Connection conn = this.connectionManager.openConnection();
		
		String strSQL = "select * from fans where user_id=?";
		Object[] params = new Object[] { user_id};
		List<Fans> lstFans=new ArrayList<Fans>();
		
		ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL, params);
	
		try {
			while (resultSet.next()) {
				Fans fans=new Fans();
				fans.setFans_id(resultSet.getInt(1));
				fans.setUser_id(resultSet.getString(2));
				fans.setUse_userid(resultSet.getString(3));
			    lstFans.add(fans);
	
			}
			return lstFans;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			this.connectionManager.closeConnection(conn);
		}
		
	}
	
	
	@Override
	public List<Fans> selectByUse_Uid(String use_userid) {
		// TODO Auto-generated method stub
        Connection conn = this.connectionManager.openConnection();
		
		String strSQL = "select * from fans where use_userid=?";
		Object[] params = new Object[] { use_userid};
		List<Fans> lstFans=new ArrayList<Fans>();
		ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL, params);
	
		try {
			while(resultSet.next()) {
				Fans fans=new Fans();
				fans.setFans_id(resultSet.getInt(1));
				fans.setUser_id(resultSet.getString(2));
				fans.setUse_userid(resultSet.getString(3));
				lstFans.add(fans);
			}
			return lstFans;
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			this.connectionManager.closeConnection(conn);
		}
		
	}
	
	
	@Override
	public int update(Fans fans) {
		// TODO Auto-generated method stub
Connection conn = this.connectionManager.openConnection();
		
		TransactionManager.conn = conn;
		TransactionManager.beginTransaction();
	
		String strSQL = "update fans set user_id=?, use_userid=? where fans_id=?";
		Object[] params = new Object[] { fans.getUser_id(),fans.getUse_userid(),fans.getFans_id()};

		int affectedRwos = this.dbUtils.execOthers(conn, strSQL, params);
			if (affectedRwos > 0) {
			TransactionManager.commit(); // 事务提交
		} else {
			TransactionManager.rollback(); // 事务的回滚
		}
	
		return affectedRwos;
		
	
	}
	@Override
	public boolean selectByObject(Fans fans) {
		// TODO Auto-generated method stub
		
			// TODO Auto-generated method stub
			
			String user_id=fans.getUser_id();
			String use_userid=fans.getUse_userid();
			//在数据库中查询
			Connection conn=this.connectionManager.openConnection();
			Object[] param={user_id,use_userid};
			String mySQL="select * from fans where user_id=? and use_userid=?";
			ResultSet resultSet=this.dbUtils.execQuery(conn, mySQL, param);
			try {
				if(!resultSet.next()){
					return true;
				}else{
					return false;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
	}
	

}
