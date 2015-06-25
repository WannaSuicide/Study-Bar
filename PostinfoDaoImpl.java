package com.ifour.study.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
//import java.util.Date;
import java.util.List;

import com.ifour.study.dao.IPostinfoDao;
import com.ifour.study.db.ConnectionManager;
import com.ifour.study.db.DBUtils;
import com.ifour.study.db.TransactionManager;
import com.ifour.study.po.Postinfo;
//import com.ifour.study.po.Userinfo;
//import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Text;

public class PostinfoDaoImpl implements IPostinfoDao {
	private ConnectionManager connectionManager;
    private DBUtils dbUtils; 
    public PostinfoDaoImpl() {
		super();
		this.connectionManager=new ConnectionManager();
		this.dbUtils=new DBUtils();
		
		// TODO Auto-generated constructor stub
	}

	@Override
	public int insert(Postinfo postinfo) {
		// TODO Auto-generated method stub
Connection conn=connectionManager.openConnection();
	    
	    TransactionManager.conn=conn;
	    TransactionManager.beginTransaction();
	    
	    //int post_id=postinfo.getPost_id();
		int userno=postinfo.getUserno();
		int reply_id=postinfo.getReply_id();
		String title=postinfo.getTitle();
	    String category=postinfo.getCategory();
		String content=postinfo.getContent();
		String resource=postinfo.getResource();
		int replycount=postinfo.getReplycount();
		int likescount=postinfo.getLikescount();
	    //Date postime=postinfo.getPostime();
	    
	    String strSQL="insert into Postinfo values(null,?,?,?,?,?,?,?,?,now())";
	    
	    Object[] params=new Object[]{userno,reply_id,title,category,content,resource,replycount,likescount};
	    
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
	public List<Postinfo> selectAll() {
		// TODO Auto-generated method stub
		Connection conn=connectionManager.openConnection();
	    
		 
	    
		List<Postinfo> lstPostinfo = new ArrayList<Postinfo>();
		String strSQL="select * from Postinfo order by post_id";
		ResultSet resultSet=this.dbUtils.execQuery(conn, strSQL, new Object[]{});
		
		try {
			while(resultSet.next())
			{
				Postinfo postinfo=new Postinfo();
				postinfo.setPost_id(resultSet.getInt(1));
				postinfo.setUserno(resultSet.getInt(2));
				postinfo.setReply_id(resultSet.getInt(3));
				postinfo.setTitle(resultSet.getString(4));
				postinfo.setCategory(resultSet.getString(5));
				postinfo.setContent(resultSet.getString(6));
				postinfo.setResource(resultSet.getString(7));
				postinfo.setReplycount(resultSet.getInt(8));
				postinfo.setLikescount(resultSet.getInt(9));
				postinfo.setPostime(resultSet.getDate(10));
				lstPostinfo.add(postinfo);
				
			}
			return lstPostinfo;
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
	public int deleteById(int post_id) {
		// TODO Auto-generated method stub
Connection conn=this.connectionManager.openConnection();
		
		TransactionManager.conn=conn;
		TransactionManager.beginTransaction();
		
		String strSQL="delete from postinfo where post_id=?";
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
	public Postinfo selectById(int post_id) {
		// TODO Auto-generated method stub
Connection conn = this.connectionManager.openConnection();
		
		String strSQL = "select * from postinfo where post_id=?";
		Object[] params = new Object[] { post_id};
		
		ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL, params);
	
		try {
			if (resultSet.next()) {
				Postinfo postinfo=new Postinfo();
				postinfo.setPost_id(resultSet.getInt(1));
				postinfo.setUserno(resultSet.getInt(2));
				postinfo.setReply_id(resultSet.getInt(3));
				postinfo.setTitle(resultSet.getString(4));
				postinfo.setCategory(resultSet.getString(5));
				postinfo.setContent(resultSet.getString(6));
				postinfo.setResource(resultSet.getString(7));
				postinfo.setReplycount(resultSet.getInt(8));
				postinfo.setLikescount(resultSet.getInt(9));
				postinfo.setPostime(resultSet.getDate(10));
				return postinfo;
				
				
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
	public int update(Postinfo postinfo) {
		// TODO Auto-generated method stub
Connection conn = this.connectionManager.openConnection();
		
		TransactionManager.conn = conn;
		TransactionManager.beginTransaction();
	
		String strSQL = "update postinfo set userno=?, reply_id=?, title=? ,category=?,content=?,resource=?,replycount=?,likescount=?,postime=?where post_id=?";
		Object[] params = new Object[] {postinfo.getUserno(),postinfo.getReply_id(),postinfo.getTitle(),postinfo.getCategory(),postinfo.getContent(),postinfo.getResource(),postinfo.getReplycount(),postinfo.getLikescount(),postinfo.getPostime(),postinfo.getPost_id()};
		int affectedRwos = this.dbUtils.execOthers(conn, strSQL, params);
			if (affectedRwos > 0) {
			TransactionManager.commit(); // 事务提交
		} else {
			TransactionManager.rollback(); // 事务的回滚
		}
	
		return affectedRwos;
		
	

		
	}
	@Override
	//分类选择帖子
	public List<Postinfo> selectByType(int reply_id,String category) {
		// TODO Auto-generated method stub
		Connection conn = this.connectionManager.openConnection();
		
		String strSQL = "select * from postinfo where reply_id=? and category=? order by postime desc";
		Object[] params = new Object[] { reply_id,category};
		List<Postinfo> postList=new ArrayList<Postinfo>();
		ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL, params);
		try {
			while (resultSet.next()) {
				Postinfo postinfo=new Postinfo();
				postinfo.setPost_id(resultSet.getInt(1));
				postinfo.setUserno(resultSet.getInt(2));
				postinfo.setReply_id(resultSet.getInt(3));
				postinfo.setTitle(resultSet.getString(4));
				postinfo.setCategory(resultSet.getString(5));
				postinfo.setContent(resultSet.getString(6));
				postinfo.setResource(resultSet.getString(7));
				postinfo.setReplycount(resultSet.getInt(8));
				postinfo.setLikescount(resultSet.getInt(9));
				postinfo.setPostime(resultSet.getDate(10));
				postList.add(postinfo);
			}
			return postList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			this.connectionManager.closeConnection(conn);
		}
	}
	@Override
	public int updateLikesCount(int post_id) {
		// TODO Auto-generated method stub
		Connection conn = this.connectionManager.openConnection();
		TransactionManager.conn = conn;
		TransactionManager.beginTransaction();
	
		String strSQL = "update postinfo set likescount=likescount+1 where post_id=?";
		Object[] params = new Object[] {post_id};
		int affectedRwos = this.dbUtils.execOthers(conn, strSQL, params);
			if (affectedRwos > 0) {
			TransactionManager.commit(); // 事务提交
		} else {
			TransactionManager.rollback(); // 事务的回滚
		}
	
		return affectedRwos;
	}

	@Override
	public List<Postinfo> selectByNo(int userno) {
		// TODO Auto-generated method stub
        Connection conn = this.connectionManager.openConnection();
		
		String strSQL = "select * from postinfo where userno=? order by postime desc";
		Object[] params = new Object[] { userno};
		List<Postinfo> postList=new ArrayList<Postinfo>();
		ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL, params);
		try {
			while (resultSet.next()) {
				Postinfo postinfo=new Postinfo();
				postinfo.setPost_id(resultSet.getInt(1));
				postinfo.setUserno(resultSet.getInt(2));
				postinfo.setReply_id(resultSet.getInt(3));
				postinfo.setTitle(resultSet.getString(4));
				postinfo.setCategory(resultSet.getString(5));
				postinfo.setContent(resultSet.getString(6));
				postinfo.setResource(resultSet.getString(7));
				postinfo.setReplycount(resultSet.getInt(8));
				postinfo.setLikescount(resultSet.getInt(9));
				postinfo.setPostime(resultSet.getDate(10));
				postList.add(postinfo);
			}
			return postList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			this.connectionManager.closeConnection(conn);
		}
	}

	@Override
	public List<Postinfo> selectByType(int reply_id) {
		// TODO Auto-generated method stub
		Connection conn = this.connectionManager.openConnection();
		
		String strSQL = "select * from postinfo where reply_id=? order by postime desc";
		Object[] params = new Object[] { reply_id};
		List<Postinfo> postList=new ArrayList<Postinfo>();
		ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL, params);
		try {
			while (resultSet.next()) {
				Postinfo postinfo=new Postinfo();
				postinfo.setPost_id(resultSet.getInt(1));
				postinfo.setUserno(resultSet.getInt(2));
				postinfo.setReply_id(resultSet.getInt(3));
				postinfo.setTitle(resultSet.getString(4));
				postinfo.setCategory(resultSet.getString(5));
				postinfo.setContent(resultSet.getString(6));
				postinfo.setResource(resultSet.getString(7));
				postinfo.setReplycount(resultSet.getInt(8));
				postinfo.setLikescount(resultSet.getInt(9));
				postinfo.setPostime(resultSet.getDate(10));
				postList.add(postinfo);
			}
			return postList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			this.connectionManager.closeConnection(conn);
		}
	}

	public int selectLikes(final int userno) {
		// TODO Auto-generated method stub
Connection conn = this.connectionManager.openConnection();
		
		String strSQL = "select likescount from postinfo where userno=?";
		Object[] params = new Object[] { userno};
		
		ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL, params);
	
		try {
			if (resultSet.next()) {
				int likescount = resultSet.getInt(1);
				return likescount;				
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
	
	public int  selectCount(final int userno) {
		// TODO Auto-generated method stub
Connection conn = this.connectionManager.openConnection();
		
		String strSQL = "select count(post_id) as postscount from postinfo where userno=? and reply_id=0";
		Object[] params = new Object[] { userno};
		
		ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL, params);
	
		try {
			if (resultSet.next()) {
				int postscount = resultSet.getInt(1);
				return postscount;				
			} else {
				return -1;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		} finally {
			this.connectionManager.closeConnection(conn);
		}	
	}

}
