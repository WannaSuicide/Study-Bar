package com.ifour.study.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ifour.study.dao.IVMessagesDao;
import com.ifour.study.db.ConnectionManager;
import com.ifour.study.db.DBUtils;
import com.ifour.study.po.Postinfo;
import com.ifour.study.po.VMessages;

public class VMessagesDaoImpl implements IVMessagesDao {

	private ConnectionManager connectionManager;
    private DBUtils dbUtils; 
	public VMessagesDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
		this.connectionManager=new ConnectionManager();
		this.dbUtils=new DBUtils();
	}
	@Override
	public List<VMessages> select() {
		// TODO Auto-generated method stub
Connection conn=connectionManager.openConnection();
	    
		 
	    
		List<VMessages> lstPostinfo = new ArrayList<VMessages>();
		String strSQL="select post_id,user_id,reply_id,title,category,content,replycount,likescount,postime from Postinfo,Userinfo where postinfo.userno=userinfo.userno and category='Q&A'";
		ResultSet resultSet=this.dbUtils.execQuery(conn, strSQL, new Object[]{});
		
		try {
			while(resultSet.next())
			{
			    VMessages postinfo=new VMessages();
				postinfo.setPost_id(resultSet.getInt(1));
				postinfo.setUser_id(resultSet.getString(2));
				postinfo.setReply_id(resultSet.getInt(3));
				postinfo.setTitle(resultSet.getString(4));
				postinfo.setCategory(resultSet.getString(5));
				postinfo.setContent(resultSet.getString(6));
				postinfo.setResource("无");
				postinfo.setReplycount(resultSet.getInt(7));
				postinfo.setLikescount(resultSet.getInt(8));
				postinfo.setPostime(resultSet.getDate(9));
				lstPostinfo.add(postinfo);
				
			}
			return lstPostinfo;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
			}
		
	}
	
	
	public List<VMessages> selectreply(int postid) {
		// TODO Auto-generated method stub
   Connection conn=connectionManager.openConnection();
	    
		 
	    
		List<VMessages> lstPostinfo = new ArrayList<VMessages>();
		String strSQL="select post_id,user_id,reply_id,title,category,content,replycount,likescount,postime from Postinfo,Userinfo where postinfo.userno=userinfo.userno and reply_id=? ";
		Object[] params=new Object[]{postid};
		ResultSet resultSet=this.dbUtils.execQuery(conn, strSQL, params);
		
		try {
			while(resultSet.next())
			{
			    VMessages postinfo=new VMessages();
				postinfo.setPost_id(resultSet.getInt(1));
				postinfo.setUser_id(resultSet.getString(2));
				postinfo.setReply_id(resultSet.getInt(3));
				postinfo.setTitle(resultSet.getString(4));
				postinfo.setCategory(resultSet.getString(5));
				postinfo.setContent(resultSet.getString(6));
				postinfo.setResource("无");
				postinfo.setReplycount(resultSet.getInt(7));
				postinfo.setLikescount(resultSet.getInt(8));
				postinfo.setPostime(resultSet.getDate(9));
				lstPostinfo.add(postinfo);
				
			}
			return lstPostinfo;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
			}
		
	}

}
