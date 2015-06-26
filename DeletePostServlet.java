package com.ifour.study.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;






import com.ifour.study.biz.ILabelsearchingBiz;
import com.ifour.study.biz.IPostCanBiz;
import com.ifour.study.biz.IPostinfoBiz;
import com.ifour.study.biz.impl.LabelsearchingBizImpl;
import com.ifour.study.biz.impl.PostCanBizImpl;
import com.ifour.study.biz.impl.PostinfoBizImpl;

/**
 * Servlet implementation class DeletePostServlet
 */
public class DeletePostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeletePostServlet() {
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
		/*int cusid = Integer.parseInt(request.getParameter("cusid"));
		// 步骤2：创建Biz层对象，调用响应的方法实现对数据库的删除操作
		ICustomersBiz customersBiz = new CustomersBizImpl();
		boolean flag = customersBiz.deleteById(cusid);
		// 步骤3：根据步骤2的操作结果进行页面的响应
		if(flag){
			response.sendRedirect("jsp/showCustomers.jsp");
		}else{
			response.sendRedirect("jsp/Error.jsp");
		}*/
		int post_id=Integer.parseInt(request.getParameter("post_id"));
		IPostinfoBiz postinfoBiz=new PostinfoBizImpl();
		IPostCanBiz postCanBiz=new PostCanBizImpl();
		ILabelsearchingBiz labelsearchingBiz=new LabelsearchingBizImpl();
		boolean flag2=postCanBiz.deleteByPostId(post_id);
		boolean flag1=postinfoBiz.deleteById(post_id);
		
		boolean flag3=labelsearchingBiz.deleteById(post_id);
		if(flag1)
		{
			response.sendRedirect("personalhomepage.jsp");
		}
		else{
			System.out.println("出错");
		
		}
	}

}
