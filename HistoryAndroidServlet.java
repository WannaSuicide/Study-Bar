package com.ifour.study.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ifour.study.biz.IUserinfoBiz;
import com.ifour.study.biz.impl.UserinfoBizImpl;
import com.ifour.study.dao.IPostinfoDao;
import com.ifour.study.dao.impl.PostinfoDaoImpl;
import com.ifour.study.po.Postinfo;
import com.ifour.study.po.Userinfo;

/**
 * Servlet implementation class HistoryAndroidServlet
 */
public class HistoryAndroidServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HistoryAndroidServlet() {
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
		    
			IPostinfoDao postinfoDao = new PostinfoDaoImpl();
			List<Postinfo> lstPostinfo = postinfoDao.selectByNo(3);
			// 步骤1：创建Gson对象
			Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd hh:mm:ss").create();
			String gson_data = gson.toJson(lstPostinfo);
			
			response.setContentType("text/html; charset=UTF-8");
			response.setCharacterEncoding("UTF-8");
			
			
			PrintWriter out = response.getWriter();
			
			out.print(gson_data);
			System.out.println(lstPostinfo);
			
			out.flush();
			out.close();
	}

}
