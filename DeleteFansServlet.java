package com.ifour.study.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ifour.study.biz.IFansBiz;
import com.ifour.study.biz.impl.FansBizImpl;
import com.ifour.study.po.Fans;
import com.ifour.study.po.Userinfo;

/**
 * Servlet implementation class DeleteFansServlet
 */
public class DeleteFansServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteFansServlet() {
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
		String use_userid = request.getParameter("use_userid");
		System.out.println(use_userid);
		// 步骤2：创建Biz层对象，调用响应的方法实现对数据库的删除操作
		HttpSession session = request.getSession();
		Userinfo user = (Userinfo) session.getAttribute("user");
		Fans fans=new Fans();
		fans.setUse_userid(use_userid);
		fans.setUser_id(user.getUser_id());
		IFansBiz fansBiz = new FansBizImpl();
		
		boolean flag = fansBiz.del(fans);
		// 步骤3：根据步骤2的操作结果进行页面的响应
		if(flag){
			response.sendRedirect("personalhomepage.jsp");
		}else{
			//response.sendRedirect("jsp/Error.jsp");
			System.out.println("error");
		}
	}

}
