package com.ifour.study.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.ifour.study.biz.IUserinfoBiz;
import com.ifour.study.biz.impl.UserinfoBizImpl;
import com.ifour.study.po.Userinfo;

/**
 * Servlet implementation class FindUserByIdServlet
 */
public class FindUserByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindUserByIdServlet() {
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
		
		int userno=Integer.parseInt(request.getParameter("userno"));
		IUserinfoBiz userinfoBiz=new UserinfoBizImpl();
		Userinfo user=userinfoBiz.findById(userno);
		request.setAttribute("user", user);
		RequestDispatcher dispatcher=request.getRequestDispatcher("updateuser.jsp");
		dispatcher.forward(request, response);
		
	}

}
