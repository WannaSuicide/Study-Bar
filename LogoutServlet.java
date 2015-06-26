package com.ifour.study.servlet;

import java.io.IOException;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;

import com.ifour.study.po.Userinfo;

/**
 * Servlet implementation class LogoutServlet
 */
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogoutServlet() {
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
		//通过session获得当前登录账号
		HttpSession session = request.getSession();
		Userinfo user=(Userinfo)session.getAttribute("user");
		//销毁session
		session.removeAttribute("user");
		session.invalidate();
		//从在线列表中删除
		List<String> usersOnLineList = (List<String>) this.getServletContext().getAttribute("usersOnLineList");
		usersOnLineList.remove(user.getUser_id());  // 移除
		this.getServletContext().setAttribute("usersOnLineList", usersOnLineList);  // 刷新在线列表
		//页面跳转
		response.sendRedirect("login.jsp");
	}

}
