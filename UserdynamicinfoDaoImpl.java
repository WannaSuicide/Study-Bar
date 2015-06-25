package com.ifour.study.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ifour.study.dao.IUserdynamicinfoDao;
import com.ifour.study.db.ConnectionManager;
import com.ifour.study.db.DBUtils;
import com.ifour.study.db.TransactionManager;
import com.ifour.study.po.Userdynamicinfo;


public class UserdynamicinfoDaoImpl implements IUserdynamicinfoDao {

	private ConnectionManager connectionManager;
    private DBUtils dbUtils; 
    public UserdynamicinfoDaoImpl() {
		super();
		this.connectionManager=new ConnectionManager();
		this.dbUtils=new DBUtils();
		
		// TODO Auto-generated constructor stub
	}
	@Override
	public int insert(Userdynamicinfo user) {
		// TODO Auto-generated method stub
Connection conn=connectionManager.openConnection();
	    
	    TransactionManager.conn=conn;
	    TransactionManager.beginTransaction();
	    
	   
		int post_count=user.getPost_count();
		int score=user.getScore();
		String rank=user.getRank();
		String nickname=user.getNickname();
		String status=user.getStatus();
		String note=user.getNote();
	    
	    String strSQL="insert into Userdynamicinfo values(null,?,?,?,?,?,?)";
	    
	    Object[] params=new Object[]{post_count,score,rank,nickname,status,note};
	    
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
	public List<Userdynamicinfo> selectAll() {
		// TODO Auto-generated method stub
		 Connection conn=connectionManager.openConnection();
		    
		 
		    
			List<Userdynamicinfo> lstUserdynamicinfo = new ArrayList<Userdynamicinfo>();
			String strSQL="select * from Userdynamicinfo order by userno";
			ResultSet resultSet=this.dbUtils.execQuery(conn, strSQL, new Object[]{});
			
			try {
				while(resultSet.next())
				{
					Userdynamicinfo user=new Userdynamicinfo();
					user.setUserno(resultSet.getInt(1));
					user.setPost_count(resultSet.getInt(2));
					user.setScore(resultSet.getInt(3));
					user.setRank(resultSet.getString(4));
					user.setNickname(resultSet.getString(5));
					user.setStatus(resultSet.getString(6));
					user.setNote(resultSet.getString(7));
					lstUserdynamicinfo.add(user);
					
				}
				return lstUserdynamicinfo;
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
		
		String strSQL="delete from userdynamicinfo where userno=?";
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

	@Override
	public Userdynamicinfo selectById(int userno) {
		// TODO Auto-generated method stub
Connection conn = this.connectionManager.openConnection();
		
		String strSQL = "select * from userdynamicinfo where userno=?";
		Object[] params = new Object[] { userno};
		
		ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL, params);
	
		try {
			if (resultSet.next()) {
				Userdynamicinfo user=new Userdynamicinfo();
				user.setUserno(resultSet.getInt(1));
				user.setPost_count(resultSet.getInt(2));
				user.setScore(resultSet.getInt(3));
				user.setRank(resultSet.getString(4));
				user.setNickname(resultSet.getString(5));
				user.setStatus(resultSet.getString(6));
				user.setNote(resultSet.getString(7));
			
				
				
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
	public int update(Userdynamicinfo user) {
		// TODO Auto-generated method stub
Connection conn = this.connectionManager.openConnection();
		
		TransactionManager.conn = conn;
		TransactionManager.beginTransaction();
	
		String strSQL = "update userdynamicinfo set post_count=?, score=?, rank=? ,nickname=?,status=?,note=? where userno=?";
		Object[] params = new Object[] { user.getPost_count(),user.getScore(),user.getRank(),user.getNickname(),user.getStatus(),user.getNote(),user.getUserno()};

		int affectedRwos = this.dbUtils.execOthers(conn, strSQL, params);
			if (affectedRwos > 0) {
			TransactionManager.commit(); // 事务提交
		} else {
			TransactionManager.rollback(); // 事务的回滚
		}
	
		return affectedRwos;
		
		
	}
	public int updateScore(final int likescount,final int postscount,final int userno) {
		// TODO Auto-generated method stub
Connection conn = this.connectionManager.openConnection();
		
		TransactionManager.conn = conn;
		TransactionManager.beginTransaction();
	
		String strSQL = "update userdynamicinfo set score=?+?*5 ,post_count=? where userno=?";
		Object[] params = new Object[] {likescount,postscount,postscount,userno};
		ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL, params);
		int affectedRwos = this.dbUtils.execOthers(conn, strSQL, params);
		if (affectedRwos > 0) {
		TransactionManager.commit(); // 事务提交
	} else {
		TransactionManager.rollback(); // 事务的回滚
	}

	return affectedRwos;
}

	public int selectScore(final int userno) {
		// TODO Auto-generated method stub
Connection conn = this.connectionManager.openConnection();
		
		TransactionManager.conn = conn;
		TransactionManager.beginTransaction();
	
		String strSQL = "select score from userdynamicinfo where userno=?";
		Object[] params = new Object[] {userno};
		ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL, params);
		try {
			if (resultSet.next()) {
				int score = resultSet.getInt(1);
				return score;				
			} else {
				return 0;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		} finally {
			this.connectionManager.closeConnection(conn);
		}	

	}
}
