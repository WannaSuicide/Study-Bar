package com.ifour.study.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ifour.study.biz.ILoginBiz;
import com.ifour.study.biz.IPostinfoBiz;
import com.ifour.study.biz.impl.LoginBizImpl;
import com.ifour.study.biz.impl.PostinfoBizImpl;
import com.ifour.study.dao.IUserinfoDao;
import com.ifour.study.dao.impl.UserinfoDaoImpl;
import com.ifour.study.po.Postinfo;
import com.ifour.study.po.Userinfo;

/**
 * Servlet implementation class APostServlet
 */
public class APostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public APostServlet() {
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
			user_id=user_id.replace("\"", "");
			System.out.println(user_data);
			// 反序列化形成一个Users对象
			Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd hh:mm:ss").create();
			Postinfo post = gson.fromJson(user_data, Postinfo.class);
			//String user_id=gson.fromJson(user_id, String.class);
			//HttpSession session = request.getSession();
			//Userinfo user = (Userinfo) session.getAttribute("user");
			IUserinfoDao iUserinfoDao=new  UserinfoDaoImpl();
			System.out.println(user_id);
			Userinfo user=iUserinfoDao.selectById(user_id);
			System.out.println(user.getUserno());
			//if(user!=null){
			     post.setUserno(user.getUserno());//}
			//else{
				 // post.setUserno(2);
			//}
			
			
			// -------------------处理数据-----------------------
			IPostinfoBiz postinfoBiz=new PostinfoBizImpl();
			boolean flag=postinfoBiz.add(post);
			
			
			
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
