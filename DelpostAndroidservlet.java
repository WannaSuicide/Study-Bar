package com.ifour.study.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ifour.study.biz.ILabelsearchingBiz;
import com.ifour.study.biz.IPostCanBiz;
import com.ifour.study.biz.IPostinfoBiz;
import com.ifour.study.biz.impl.LabelsearchingBizImpl;
import com.ifour.study.biz.impl.PostCanBizImpl;
import com.ifour.study.biz.impl.PostinfoBizImpl;

/**
 * Servlet implementation class DelpostAndroidServlet
 */
public class DelpostAndroidServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DelpostAndroidServlet() {
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
		String post_data = request.getParameter("user_data");
		System.out.println(post_data);
		int test = Integer.parseInt(post_data);
		System.out.println(test);
		// 反序列化形成一个Users对象
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd hh:mm:ss").create();
		int post_id = gson.fromJson(post_data, Integer.class);
		
		IPostinfoBiz postinfoBiz=new PostinfoBizImpl();
		IPostCanBiz postCanBiz=new PostCanBizImpl();
		ILabelsearchingBiz labelsearchingBiz=new LabelsearchingBizImpl();
		boolean flag2=postCanBiz.deleteByPostId(post_id);
		boolean flag1=postinfoBiz.deleteById(post_id);
		
		boolean flag3=labelsearchingBiz.deleteById(post_id);
		
//		if(flag1)
//		{
//			response.sendRedirect("personalhomepage.jsp");
//		}
//		else{
//			System.out.println("出错");
//		}
		
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		String gson_data = gson.toJson(flag1);
		
		System.out.println(gson_data);
		out.println(gson_data);
		
		out.flush();
		out.close();
	}

}
