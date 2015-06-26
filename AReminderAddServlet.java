package com.ifour.study.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ifour.study.biz.IPostinfoBiz;
import com.ifour.study.biz.impl.PostinfoBizImpl;
import com.ifour.study.dao.IExamAssDao;
import com.ifour.study.dao.IUserinfoDao;
import com.ifour.study.dao.impl.ExamAssDaoImpl;
import com.ifour.study.dao.impl.UserinfoDaoImpl;
import com.ifour.study.po.Postinfo;
import com.ifour.study.po.exam_ass;

/**
 * Servlet implementation class AReminderAddServlet
 */
public class AReminderAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AReminderAddServlet() {
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
		String reminder_data = request.getParameter("reminder_data");
		
		System.out.println(reminder_data);
		// 反序列化形成一个对象
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd hh:mm:ss").create();
		exam_ass ass = gson.fromJson(reminder_data,exam_ass.class);
		//String user_id=gson.fromJson(user_id, String.class);
		//HttpSession session = request.getSession();
		//Userinfo user = (Userinfo) session.getAttribute("user");
		IExamAssDao examAssDao=new ExamAssDaoImpl();
		//Userinfo user=iUserinfoDao.selectById(user_id);
		//if(user!=null){
		     //post.setUserno(user.getUserno());}
		//else{
		
		//}
		
		
		// -------------------处理数据-----------------------
		int affectedRows=examAssDao.insert(ass);
		
		
		
		// -------------------响应客户端 JSon----------------
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		if(affectedRows>0){
			String gson_data = gson.toJson(ass);
			System.out.println(gson_data);
			out.println(gson_data);
			out.flush();
			out.close();
		}else{
			exam_ass ass2=null;
			String gson_data = gson.toJson(ass2);
			System.out.println(gson_data);
			out.println(gson_data);
			out.flush();
			out.close();
		}
	}

}
