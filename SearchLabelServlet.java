package com.ifour.study.servlet;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ifour.study.dao.ILabelSearchingDao;
import com.ifour.study.dao.IPostinfoDao;
import com.ifour.study.dao.impl.LabelSearchingDaoImpl;
import com.ifour.study.dao.impl.PostinfoDaoImpl;
import com.ifour.study.po.Postinfo;



/**
 * Servlet implementation class AddDeptServlet
 */
public class SearchLabelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchLabelServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 步骤1：调用doPost方法
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 步骤2：设置请求对象的字符集
		request.setCharacterEncoding("UTF-8");
		// 步骤3：获取提交表单上传服务器的数据
		String our_label = request.getParameter("our_label");
		String school=request.getParameter("school");
		System.out.println(our_label);
		//1.通过our_label 查找 id
		ILabelSearchingDao labelDao = new LabelSearchingDaoImpl();
		List<Integer> lstLabel = labelDao.select(our_label);
		ILabelSearchingDao labelDao2 = new LabelSearchingDaoImpl();
		List<Integer> lstLabel2 = labelDao2.select(school);
		//2.通过id 查找 帖子
		IPostinfoDao postsDao = new PostinfoDaoImpl();
		List<Postinfo> lstPosts=new ArrayList<Postinfo>();
		
		for (int i=0;i<lstLabel.size();i++)
		{	
			for(int j=0;j<lstLabel2.size();j++)
			{
				if(lstLabel.get(i)==lstLabel2.get(j))
				{			
			Postinfo post = postsDao.selectById(lstLabel.get(i));
			lstPosts.add(post);}
			
		          else{
			            continue;
		            }
			}
		}
			// 步骤3：将获取的数据添加到request级别对象中
			request.setAttribute("lstPosts", lstPosts);
			// 步骤4：使用请求转发模式完成界面的跳转（可以携带reuqest对象进行跳转）
			RequestDispatcher dispatcher = request.getRequestDispatcher("showPosts.jsp");
			dispatcher.forward(request, response);

		
