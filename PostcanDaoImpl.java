package com.ifour.study.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ifour.study.dao.IPostcanDao;
import com.ifour.study.db.ConnectionManager;
import com.ifour.study.db.DBUtils;
import com.ifour.study.db.TransactionManager;
import com.ifour.study.po.Post_can;

public class PostcanDaoImpl implements IPostcanDao {

	private ConnectionManager connectionManager;
    private DBUtils dbUtils; 
    public PostcanDaoImpl() {
		super();
		this.connectionManager=new ConnectionManager();
		this.dbUtils=new DBUtils();
		
		// TODO Auto-generated constructor stub
	}
	@Override
	public int insert(Post_can postcan) {
		// TODO Auto-generated method stub
Connection conn=connectionManager.openConnection();
	    
	    TransactionManager.conn=conn;
	    TransactionManager.beginTransaction();
	    
	    //int can_id=postcan.getCan_id();
		int post_id=postcan.getPost_id();
		String user_id=postcan.getUser_id();
	    
	    String strSQL="insert into post_can values(null,?,?)";
	    
	    Object[] params=new Object[]{post_id,user_id};
	    
	    int affectedRows=this.dbUtils.execOthers(conn, strSQL, params);
	    
	    if(affectedRows>0)
	    {
	    	TransactionManager.commit(); 
	    	
	    }
	    else
	    {
	    	TransactionManager.rollback();
	    	
	    }
	   System.out.println("userid"+user_id);
	   System.out.println("postid"+post_id);
	   return affectedRows;
		
	
		
	}

	@Override
	public List<Post_can> selectAll() {
		// TODO Auto-generated method stub
		 Connection conn=connectionManager.openConnection();
		    
		 
		    
			List<Post_can> lstPostcan = new ArrayList<Post_can>();
			String strSQL="select * from Post_can order by can_id";
			ResultSet resultSet=this.dbUtils.execQuery(conn, strSQL, new Object[]{});
			
			try {
				while(resultSet.next())
				{
					Post_can postcan =new Post_can();
					postcan.setCan_id(resultSet.getInt(1));
					postcan.setPost_id(resultSet.getInt(2));
					postcan.setUser_id(resultSet.getString(3));
					lstPostcan.add(postcan);
					
				}
				return lstPostcan;
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
	public int deleteById(int can_id) {
		// TODO Auto-generated method stub
Connection conn=this.connectionManager.openConnection();
		
		TransactionManager.conn=conn;
		TransactionManager.beginTransaction();
		
		String strSQL="delete from Post_can where can_id=?";
		Object[] params=new Object[]{can_id};
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
	public Post_can selectById(int can_id) {
		// TODO Auto-generated method stub
Connection conn = this.connectionManager.openConnection();
		
		String strSQL = "select * from post_can where can_id=?";
		Object[] params = new Object[] { can_id};
		
		ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL, params);
	
		try {
			if (resultSet.next()) {
				
				Post_can postcan =new Post_can();
				postcan.setCan_id(resultSet.getInt(1));
				postcan.setPost_id(resultSet.getInt(2));
				postcan.setUser_id(resultSet.getString(3));
				
				
				
				
				return postcan ;
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
	public int update(Post_can postcan) {
		// TODO Auto-generated method stub
Connection conn = this.connectionManager.openConnection();
		
		TransactionManager.conn = conn;
		TransactionManager.beginTransaction();
	
		String strSQL = "update post_can set post_id=?, userno=? where can_id=?";
		Object[] params = new Object[] { postcan.getPost_id(),postcan.getUser_id(),postcan.getCan_id()};

		int affectedRwos = this.dbUtils.execOthers(conn, strSQL, params);
			if (affectedRwos > 0) {
			TransactionManager.commit(); // 事务提交
		} else {
			TransactionManager.rollback(); // 事务的回滚
		}
	
		return affectedRwos;
		
	
		
	}
	@Override
	public boolean selectByObject(Post_can postcan) {
		// TODO Auto-generated method stub
		int post_id=postcan.getPost_id();
		String user_id=postcan.getUser_id();
		//在数据库中查询
		Connection conn=this.connectionManager.openConnection();
		Object[] param={post_id,user_id};
		String mySQL="select * from post_can where post_id=? and user_id=?";
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
	@Override
	public int deleteByPostId(int post_id) {
		// TODO Auto-generated method stub
Connection conn=this.connectionManager.openConnection();
		
		TransactionManager.conn=conn;
		TransactionManager.beginTransaction();
		
		String strSQL="delete from Post_can where post_id=?";
		Object[] params=new Object[]{post_id};
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
	public int deleteByObject(Post_can post_can) {
		// TODO Auto-generated method stub
	       Connection conn=this.connectionManager.openConnection();
			TransactionManager.conn=conn;
			TransactionManager.beginTransaction();
			int post_id=post_can.getPost_id();
			String user_id=post_can.getUser_id();
			String strSQL="delete from Post_can where post_id=? and user_id=?";
			Object[] params=new Object[]{post_id,user_id};
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
	public List<Post_can> selectByUser(String user_id) {
		// TODO Auto-generated method stub
		Connection conn=connectionManager.openConnection();
	    
		 
	    
		List<Post_can> lstPostcan = new ArrayList<Post_can>();
		String strSQL="select * from Post_can where user_id=?";
		ResultSet resultSet=this.dbUtils.execQuery(conn, strSQL, new Object[]{user_id});
		
		try {
			while(resultSet.next())
			{
				Post_can postcan =new Post_can();
				postcan.setCan_id(resultSet.getInt(1));
				postcan.setPost_id(resultSet.getInt(2));
				postcan.setUser_id(resultSet.getString(3));
				lstPostcan.add(postcan);
				
			}
			return lstPostcan;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
			}
		
		finally{
			this.connectionManager.closeConnection(conn);
		}
	}

}
