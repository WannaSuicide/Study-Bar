package com.ifour.study.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ifour.study.dao.IExamAssDao;
import com.ifour.study.db.ConnectionManager;
import com.ifour.study.db.DBUtils;
import com.ifour.study.db.TransactionManager;
import com.ifour.study.po.Fans;
import com.ifour.study.po.exam_ass;

public class ExamAssDaoImpl implements IExamAssDao {
	
	private ConnectionManager connectionManager;
	private DBUtils dbUtils;

	public ExamAssDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
		this.connectionManager=new ConnectionManager();
		this.dbUtils=new DBUtils();
	}

	@Override
	public int insert(exam_ass ass) {
		// TODO Auto-generated method stub
		Connection conn=connectionManager.openConnection();
	    
	    TransactionManager.conn=conn;
	    TransactionManager.beginTransaction();
	    
	    
		String user_id=ass.getUser_id();
		String exam_time=ass.getExam_time();
		String exam_name=ass.getExam_name();
	    
	    String strSQL="insert into exam_ass values(null,?,?,?)";
	    
	    Object[] params=new Object[]{user_id,exam_time,exam_name};
	    
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
	public List<exam_ass> findById(String user_id) {
		// TODO Auto-generated method stub
		Connection conn = this.connectionManager.openConnection();
		
		String strSQL = "select * from exam_ass where user_id=?";
		Object[] params = new Object[] { user_id};
		List<exam_ass> lstExamAss=new ArrayList<exam_ass>();
		
		ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL, params);
	
		try {
			while (resultSet.next()) {
				exam_ass ass=new exam_ass();
				ass.setNum(resultSet.getInt(1));
				System.out.println(resultSet.getInt(1));
				ass.setUser_id(resultSet.getString(2));
				ass.setExam_time(resultSet.getString(3));
				ass.setExam_name(resultSet.getString(4));
			    lstExamAss.add(ass);
	
			}
			return lstExamAss;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			this.connectionManager.closeConnection(conn);
		}
	}

}
