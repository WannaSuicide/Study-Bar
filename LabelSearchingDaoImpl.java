package com.ifour.study.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ifour.study.dao.ILabelSearchingDao;
import com.ifour.study.db.ConnectionManager;
import com.ifour.study.db.DBUtils;
import com.ifour.study.db.TransactionManager;
import com.ifour.study.po.Labelsearching;

public class LabelSearchingDaoImpl implements ILabelSearchingDao {

	private ConnectionManager connectionManager;
    private DBUtils dbUtils; 
    public LabelSearchingDaoImpl() {
		super();
		this.connectionManager=new ConnectionManager();
		this.dbUtils=new DBUtils();
		
		// TODO Auto-generated constructor stub
	}
	@Override
	public int insert(Labelsearching labelSearching) {
		// TODO Auto-generated method stub
Connection conn=connectionManager.openConnection();
	    
	    TransactionManager.conn=conn;
	    TransactionManager.beginTransaction();
	    
	    //int fans_id=fans.getFans_id();
	    
	  int post_id=labelSearching.getPost_id();
	  String our_label=labelSearching.getOur_label();
	    
	  String strSQL="insert into labelsearching values(null,?,?)";
	    
	  Object[] params=new Object[]{post_id,our_label};
	    
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
	public List<Labelsearching> selectAll() {
		// TODO Auto-generated method stub
		Connection conn=connectionManager.openConnection();
	    
		 
	    
		List<Labelsearching> lstlabel = new ArrayList<Labelsearching>();
		String strSQL="select * from  Labelsearching order by id";
		ResultSet resultSet=this.dbUtils.execQuery(conn, strSQL, new Object[]{});
		
		try {
			while(resultSet.next())
			{
				Labelsearching label=new Labelsearching();
				label.setId(resultSet.getInt(1));
				label.setPost_id(resultSet.getInt(2));
				label.setOur_label(resultSet.getString(3));
				lstlabel.add(label);
				
			}
			return lstlabel;
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
		
		String strSQL="delete from Labelsearching where post_id=?";
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
	public Labelsearching selectById(int id) {
		// TODO Auto-generated method stub
Connection conn = this.connectionManager.openConnection();
		
		String strSQL = "select * from Labelsearching where id=?";
		Object[] params = new Object[] { id};
		
		ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL, params);
	
		try {
			if (resultSet.next()) {
				Labelsearching label=new Labelsearching();
				label.setId(resultSet.getInt(1));
				label.setPost_id(resultSet.getInt(2));
				label.setOur_label(resultSet.getString(3));
				
				
				
				return label ;
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
	public int update(Labelsearching labelSearching) {
		// TODO Auto-generated method stub
Connection conn = this.connectionManager.openConnection();
		
		TransactionManager.conn = conn;
		TransactionManager.beginTransaction();
	
		String strSQL = "update labelSearching set post_id=?, our_label=? where id=?";
		Object[] params = new Object[] { labelSearching.getPost_id(),labelSearching.getOur_label(),labelSearching.getId()};

		int affectedRwos = this.dbUtils.execOthers(conn, strSQL, params);
			if (affectedRwos > 0) {
			TransactionManager.commit(); // 事务提交
		} else {
			TransactionManager.rollback(); // 事务的回滚
		}
	
		return affectedRwos;
	
	}
	@Override
	public List<Integer> select(String our_label) {
		String strSQL = "select post_id from LabelSearching where our_label=?";
		Object[] params = new Object[]{our_label};
		Connection conn = this.connectionManager.openConnection();
		ResultSet resultSet = this.dbUtils.execQuery(conn, strSQL,params);
		List<Integer> lstLabels = new ArrayList<Integer>();
		try {
			while(resultSet.next()){
				//Label label = new Label();
                //label.setId(resultSet.getInt(1));
               // label.setPost_id(resultSet.getInt(2));
                //label.setOur_Label(resultSet.getString(3));
				//lstLabels.add(label.getPost_id());
				lstLabels.add(resultSet.getInt(1));
			}
			return lstLabels;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally{
			this.connectionManager.closeConnection(conn);
		}
	}

}
