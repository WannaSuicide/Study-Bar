package com.ifour.study.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ifour.study.dao.IPostcanDao;
import com.ifour.study.dao.impl.PostcanDaoImpl;
import com.ifour.study.po.Post_can;
import com.ifour.study.po.Userinfo;

/**
 * Servlet implementation class CancelSaveServlet2
 */
public class CancelSaveServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CancelSaveServlet2() {
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
		//获得客户端数据
		int post_id=Integer.parseInt(request.getParameter("post_id").trim());
	    //获得在线用户的no
		HttpSession session = request.getSession();
		Userinfo user=(Userinfo)session.getAttribute("user");
		String user_id=user.getUser_id();
		//封装
		Post_can savePost=new Post_can();
		savePost.setCan_id(0);
		savePost.setPost_id(post_id);
		savePost.setUser_id(user_id);
		int my_flag=0;
		//判断是否已经收藏
		IPostcanDao postcanDao=new PostcanDaoImpl();
		if(postcanDao.selectByObject(savePost)==false){
			//已经收藏
			int affectedRows=postcanDao.deleteByObject(savePost);
			if(affectedRows>0){
				my_flag=2;
			}
		}else{
			//还未收藏
			my_flag=1;
		}
		request.setAttribute("my_flag", my_flag);
		RequestDispatcher dispatcher=request.getRequestDispatcher("furtherstudy.jsp");
		dispatcher.forward(request, response);
	}

}
