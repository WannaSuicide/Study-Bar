package com.ifour.study.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ifour.study.biz.IUserinfoBiz;
import com.ifour.study.biz.impl.UserinfoBizImpl;
import com.ifour.study.po.Userinfo;

/**
 * Servlet implementation class ARegister
 */
public class ARegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ARegisterServlet() {
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
		System.out.println(user_data);
		// 反序列化形成一个Users对象
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		Userinfo userinfo = gson.fromJson(user_data, Userinfo.class);
		
		//Userinfo userinfo = new Userinfo();
		//.setUser_name("bbbb");
		//userinfo.setUser_pwd("111");
		// -------------------处理数据-----------------------
		IUserinfoBiz userinfoBiz=new UserinfoBizImpl();
		boolean flag= userinfoBiz.add(userinfo);
		
			
		// -------------------响应客户端 JSon----------------
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		String gson_data = gson.toJson(flag);
		
		System.out.println(gson_data);
		out.println(gson_data);
		
		out.flush();
		out.close();
	//	System.out.println("yes");
}
}

