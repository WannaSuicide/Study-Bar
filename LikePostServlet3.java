package com.ifour.study.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ifour.study.dao.IPostinfoDao;
import com.ifour.study.dao.impl.PostinfoDaoImpl;

/**
 * Servlet implementation class LikePostServlet3
 */
public class LikePostServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LikePostServlet3() {
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
		//从客户端获得帖子id号
		int post_id=Integer.parseInt(request.getParameter("post_id"));
		//更新postinfo表中的数据，使likescount属性值加1
		IPostinfoDao postinfoDao=new PostinfoDaoImpl();
		int affectedRows=postinfoDao.updateLikesCount(post_id);
		int flag1=0;
		//响应客户端
		if(affectedRows>0){
			flag1=1;
			request.setAttribute("flag1", flag1);
			RequestDispatcher dispatcher=request.getRequestDispatcher("Q&A.jsp");
			dispatcher.forward(request, response);
		}
	}

}
