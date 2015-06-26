package com.ifour.study.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ifour.study.biz.IPostinfoBiz;
import com.ifour.study.biz.IVMessagesBiz;
import com.ifour.study.biz.impl.PostinfoBizImpl;
import com.ifour.study.biz.impl.VMessagesBizImpl;
import com.ifour.study.dao.IUserinfoDao;
import com.ifour.study.dao.impl.UserinfoDaoImpl;
import com.ifour.study.db.ConnectionManager;
import com.ifour.study.db.DBUtils;
import com.ifour.study.po.Postinfo;
import com.ifour.study.po.Userinfo;
import com.ifour.study.po.VMessages;

/**
 * Servlet implementation class AShowPostServlet
 */
public class AReplyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AReplyServlet() {
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
		 request.setCharacterEncoding("UTF-8");
			
			//--------------------接受数据JSon-----------------
			// 获取终端传入的JSon数据
			String user_data = request.getParameter("user_data");
			String user_id=request.getParameter("user_id").toString().trim();
			String content=request.getParameter("post").toString().trim();
			//int followid = Integer.parseInt(request.getParameter("followid").trim());
			user_id=user_id.replace("\"", "");
			content=content.replace("\"", "");
			System.out.println(user_data);
			//System.out.println(followid);
			// 反序列化形成一个Users对象
			Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd hh:mm:ss").create();
			Postinfo post = gson.fromJson(user_data, Postinfo.class);
			IUserinfoDao iUserinfoDao=new  UserinfoDaoImpl();
			
			System.out.println(user_id);
			Userinfo user=iUserinfoDao.selectById(user_id);
			System.out.println(user.getUserno());
			//if(user!=null){
			     post.setUserno(user.getUserno());//}
			//else{
				 // post.setUserno(2);
			//}
			
			     ConnectionManager  connectionManager=new ConnectionManager();
				 DBUtils dbUtils=new DBUtils();
			     Connection conn = connectionManager.openConnection();
			// 
			     String strSQL = "select post_id from postinfo where content=?";
					Object[] params = new Object[] {content};
					
			     ResultSet resultSet =dbUtils.execQuery(conn, strSQL, params);
			     Postinfo postinfo=new Postinfo();
					try {
						if (resultSet.next()) {
							
							postinfo.setPost_id(resultSet.getInt(1));
												
						} 
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						
					} finally {
				          connectionManager.closeConnection(conn);
					}
				
				//int postid=postinfo.getPost_id();
				
			          
			     
			     
			     
			    // ------------------处理数据-----------------------
			     IPostinfoBiz replyBiz = new PostinfoBizImpl();
			    // Postinfo postinfo2=new Postinfo();
			     post.setReply_id(postinfo.getPost_id());
			     boolean flag = replyBiz.add(post);
			
			
			
			// -------------------响应客户端 JSon----------------
			response.setContentType("text/html; charset=UTF-8");
			response.setCharacterEncoding("UTF-8");
			PrintWriter out = response.getWriter();
			
			String gson_data = gson.toJson(flag);
			
			System.out.println(gson_data);
			out.println(gson_data);
			
			out.flush();
			out.close();
	}

}
