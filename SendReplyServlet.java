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
import javax.servlet.http.HttpSession;





//import com.chinasofti.sendreply.biz.ISendReplyBiz;
//import com.chinasofti.sendreply.biz.impl.SendReplyBizImpl;
//import com.chinasofti.sendreply.po.Test;
import com.ifour.study.biz.IPostinfoBiz;
import com.ifour.study.biz.impl.PostinfoBizImpl;
import com.ifour.study.db.ConnectionManager;
import com.ifour.study.db.DBUtils;
import com.ifour.study.po.Postinfo;
import com.ifour.study.po.Userinfo;

/**
 * Servlet implementation class SendReplyServlet
 */
public class SendReplyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SendReplyServlet() {
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
		// 步骤2：接受客户端传入的数据
		int followid = Integer.parseInt(request.getParameter("followid").trim());
		String content = request.getParameter("content").trim();
		//String account = "匿名者";
		// 步骤3：将其进行对象封装
		//Postinfo postinfo=new Postinfo();
		
		DBUtils dbUtils=new DBUtils();
		ConnectionManager connectionManager=new ConnectionManager();
	    Connection conn=connectionManager.openConnection();
	    
	    String strSQL="update postinfo set replycount=replycount+1 where post_id=?";
	    Object[] params=new Object[]{followid};
	    dbUtils.execOthers(conn, strSQL, params);
		
		Postinfo postinfo=new Postinfo();
		postinfo.setCategory("回复");
		postinfo.setContent(content);
		postinfo.setLikescount(0);
		postinfo.setReply_id(followid);
		postinfo.setReplycount(0);
		postinfo.setResource("无");
		postinfo.setTitle("回复");
		HttpSession session = request.getSession();
		Userinfo user = (Userinfo) session.getAttribute("user");
		postinfo.setUserno(user.getUserno());
		// 步骤4：调用Biz层业务实现回复动作
		IPostinfoBiz replyBiz = new PostinfoBizImpl();
		boolean flag = replyBiz.add(postinfo);
		 
		    String sql="select post_id from postinfo where title=? and content=?";
		    Object[] params2=new Object[]{postinfo.getTitle(),postinfo.getContent()};
		    ResultSet resultSet=dbUtils.execQuery(conn, sql, params2);
		    try {
				if(resultSet.next()) postinfo.setPost_id(resultSet.getInt(1));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		// 步骤5：根据动作结果响应客户端
		if(flag){
			//response.sendRedirect("jsp/showMessages.jsp");
			 request.setAttribute("postid", followid);
			    RequestDispatcher dispatcher=request.getRequestDispatcher("detail2.jsp");
			    dispatcher.forward(request, response);
				
		}else{
			System.out.println("回复失败！");
		}
	
	}

}
