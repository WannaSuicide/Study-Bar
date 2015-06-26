package com.ifour.study.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ifour.study.db.ConnectionManager;
import com.ifour.study.db.DBUtils;

/**
 * Servlet implementation class SendPost4Servlet
 */
public class SendPost4Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SendPost4Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		DBUtils dbUtils=new DBUtils();
		ConnectionManager connectionManager=new ConnectionManager();
	    Connection conn= connectionManager.openConnection();
	    String sql="select post_id from postinfo where category='期考' order by likescount desc";
	    ResultSet resultSet=dbUtils.execQuery(conn, sql);
	    int post_id=0;
	    
	    try {
			if(resultSet.next()) {
				post_id=resultSet.getInt(1);
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    try {
			resultSet.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		request.setCharacterEncoding("UTF-8");
	    //int postid=Integer.parseInt(request.getParameter("post_id").trim());
	    System.out.println(post_id);
	    request.setAttribute("postid", post_id);
	    RequestDispatcher dispatcher=request.getRequestDispatcher("detail2.jsp");
	    dispatcher.forward(request, response);
		
	}

}
