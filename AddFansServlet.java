package com.ifour.study.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ifour.study.biz.IFansBiz;
import com.ifour.study.biz.impl.FansBizImpl;
import com.ifour.study.dao.IFansDao;
import com.ifour.study.dao.IUserinfoDao;
import com.ifour.study.dao.impl.FansDaoImpl;
import com.ifour.study.dao.impl.UserinfoDaoImpl;
import com.ifour.study.po.Fans;
import com.ifour.study.po.Userinfo;

/**
 * Servlet implementation class FansServlet
 */
public class AddFansServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddFansServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		HttpSession session= request.getSession();
		Userinfo user= (Userinfo) session.getAttribute("user");
        IUserinfoDao userinfoDao=new UserinfoDaoImpl();
        String user_id=user.getUser_id();
		String use_userid=request.getParameter("use_userid").trim();
		
		Fans fans=new Fans();
		fans.setUser_id(user_id);
		fans.setUse_userid(use_userid);
		System.out.println(fans.toString());
		System.out.println(fans.toString());
		IFansBiz fansBiz=new FansBizImpl();
		IFansDao fansDao=new FansDaoImpl();
		int msgcode=0;
		if(user_id.equals(use_userid))
		{
			msgcode=3;
		}
			
		else {if(userinfoDao.selectById(use_userid)==null)
			
			    {       
			             msgcode=4;
			    }
		else{
		             if(fansDao.selectByObject(fans)==false){
			              msgcode=2;
		               }else{
			                    boolean flag=fansBiz.add(fans);
			                       if(flag){
				                        msgcode=1;
				                           }
		                  }
		    }
		}
		
			
			request.setAttribute("msgcode", msgcode);
			RequestDispatcher dispatcher=request.getRequestDispatcher("personalhomepage.jsp");
			dispatcher.forward(request, response);
			
		}
		
					
	

}
