package com.ifour.study.servlet;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
//import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;













//import javax.servlet.RequestDispatcher;
//import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.ifour.study.biz.ILabelsearchingBiz;
import com.ifour.study.biz.IPostinfoBiz;
import com.ifour.study.biz.IResourcesBiz;
import com.ifour.study.biz.impl.LabelsearchingBizImpl;
import com.ifour.study.biz.impl.PostinfoBizImpl;
import com.ifour.study.biz.impl.ResourcesBizImpl;


import com.ifour.study.db.ConnectionManager;
import com.ifour.study.db.DBUtils;
import com.ifour.study.po.Labelsearching;
//import com.ifour.study.po.Labelsearching;
import com.ifour.study.po.Postinfo;
import com.ifour.study.po.Resources;
import com.ifour.study.po.Userinfo;
//import com.mysql.jdbc.Connection;
//import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Text;

/**
 * Servlet implementation class AddPostServlet
 */
public class AddPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPostServlet() {
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
		String fileUploadPath = this.getServletContext().getRealPath(
				"/upload/file");
		System.out.println("[SingleFileUploadServlet] 设置服务器接受客户端上传文件的位置是："
				+ fileUploadPath);
		// 1-2：设置服务器临时缓冲区的位置（临时缓冲的文件夹）
		File fileUploadTempPath = new File(this.getServletContext()
				.getRealPath("/tempDir"));
		if (!fileUploadTempPath.exists()) {
			// 创建一个全新的
			fileUploadTempPath.mkdir();
		}
		System.out.println("[SingleFileUploadServlet] 设置服务器接受客户端上传文件的临时位置是："
				+ fileUploadTempPath.getPath());

		// 步骤2：判断表单是否符合上传要求
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		if (isMultipart) {
			// 步骤3：设置文件上传缓冲区对象
			DiskFileItemFactory factory = new DiskFileItemFactory();
			// 3-1:缓冲区对象与磁盘物理位置的绑定
			factory.setRepository(fileUploadTempPath);
			// 3-2：设置缓冲区对象的大小（4*1024 字节）
			factory.setSizeThreshold(4 * 1024);
			System.out
					.println("[SingleFileUploadServlet] 初始化服务器接受客户端上传文件的临时位置完毕！");

			// 步骤4：解析客户端表单待上传的数据
			// 4-1:创建一个ServletFileUpload对象完成对二进制表单数据的解析，并实现服务器上传功能
			ServletFileUpload sfu = new ServletFileUpload(factory);

			try {
				// ★★特别注意★★ 在循环遍历表单数据之前创建实体类对象
				Postinfo postinfo=new Postinfo();
				Resources resources=new Resources();
	            ArrayList<String> array=new ArrayList<String>();
				//Labelsearching labelsearching=new Labelsearching();
				String school="";
				
				
				

				// 4-2:将解析到的二进制文件封装到FileItem的对象中
				@SuppressWarnings("unchecked")
				List<FileItem> fileItems = sfu.parseRequest(request);
				for (FileItem fileItem : fileItems) {
					// 扩展3：判断当前解析的请求数据是否为普通表单数据
					if (fileItem.isFormField()) {
						// 获取客户端表单输入元素的name属性的值
						String name = fileItem.getFieldName().trim();
						// 判断数据为哪个字段数据
						if ("school".equalsIgnoreCase(name)) {
							String value = fileItem.getString();
							value = new String(value.getBytes("iso8859-1"),
									"UTF-8");
							school=value;
                           
							System.out.println("测试-注册账号：> " + value);
						}
						if ("category".equalsIgnoreCase(name)) {
							String value = fileItem.getString();
							value = new String(value.getBytes("iso8859-1"),
									"UTF-8");
							postinfo.setCategory(value);
							System.out.println("测试-注册密码：> " + value);
						}
						if ("title".equalsIgnoreCase(name)) {
							String value =fileItem.getString();
							value = new String(value.getBytes("iso8859-1"),
									"UTF-8");
						
							postinfo.setTitle(value);
							System.out.println("测试-用户昵称：> " + value);
						}
						if ("content".equalsIgnoreCase(name)) {
							String value = fileItem.getString();
							value = new String(value.getBytes("iso8859-1"),
									"UTF-8");
							
							postinfo.setContent(value);
							System.out.println("测试-注册账号：> " + value);
						}
						for(int i=0;i<16;i++){
							String m=String.valueOf(i);
						if (m.equalsIgnoreCase(name)) {
							//int j=1;
							String value = fileItem.getString();
							value = new String(value.getBytes("iso8859-1"),
									"UTF-8");
							array.add(value);
							//j++;
							
							System.out.println("测试-注册账号：> " + value);
						}
						}
						HttpSession session = request.getSession();
						Userinfo user = (Userinfo) session.getAttribute("user");
						postinfo.setUserno(user.getUserno());
						//postinfo.setUserno(1);
						

						
						
						
						
						} else {
						if(fileItem.getName().trim()!=""){
						// 4-3:获取上传文件的名称
						String fileName = fileItem.getName().trim();
						// 扩展1：唯一命名
						System.out.println(fileName+"?");
						String fileExtName = fileName.substring(fileName
								.lastIndexOf("."));
						fileName = generateUnqieName() + fileExtName;
						resources.setReslocation(fileName);
						resources.setRestype(fileExtName);
						IResourcesBiz resourcesBiz=new  ResourcesBizImpl();
						resourcesBiz.add(resources);	
							
						
						String resource="";
						resource=resource+fileName;
						postinfo.setResource(resource);
						

						// ★★特别注意★★ 在这个位置为头像属性赋值
						

						// 扩展2：限制上传文件类型
						/*String[] allowedTypes = new String[] { ".jpg", ".jpeg",
								".png", ".bmp" };
						Arrays.sort(allowedTypes);
						int searchIndex = Arrays.binarySearch(allowedTypes,
								fileExtName);
						if (searchIndex < 0) {
							System.out
									.println("[SingleFileUploadServlet] 该类型文件不允许上传！");
							return;
						}*/

						System.out.println("[SingleFileUploadServlet] 获取上传文件的名称为: "
										+ fileName);
						// 4-4:封装上传文件对象并写入到服务器
						File saveFile = new File(fileUploadPath, fileName);
						fileItem.write(saveFile);
						System.out.println("[SingleFileUploadServlet] 上传文件成功！");
						}
					}
				}
				postinfo.setLikescount(0);
				postinfo.setReply_id(0);
				postinfo.setReplycount(0);
				
				//查找post_id
				
			    
				
				
				//postinfo.setPost_id(Postinfo.post);
                IPostinfoBiz postinfoBiz=new PostinfoBizImpl();
                boolean flag=postinfoBiz.add(postinfo);
                DBUtils dbUtils=new DBUtils();
				ConnectionManager connectionManager=new ConnectionManager();
			    Connection conn=connectionManager.openConnection();
			    String sql="select post_id from postinfo where title=? and content=?";
			    Object[] params=new Object[]{postinfo.getTitle(),postinfo.getContent()};
			    ResultSet resultSet=dbUtils.execQuery(conn, sql, params);
			    if(resultSet.next()) postinfo.setPost_id(resultSet.getInt(1));
			    
                
			    Labelsearching labelsearching1=new Labelsearching();
            	labelsearching1.setPost_id(postinfo.getPost_id());
            	labelsearching1.setOur_label(school);
            	ILabelsearchingBiz labelsearchingBiz1=new LabelsearchingBizImpl();
            	labelsearchingBiz1.add(labelsearching1);
                
                
                for(int i=0;i<array.size();i++)
                {
                
                	Labelsearching labelsearching=new Labelsearching();
                	labelsearching.setPost_id(postinfo.getPost_id());
                	labelsearching.setOur_label(array.get(i));
                	ILabelsearchingBiz labelsearchingBiz=new LabelsearchingBizImpl();
                	labelsearchingBiz.add(labelsearching);
                }
						
					
				if (flag) {
					// 跳转至登录页面
					//request.setAttribute("post_id", Postinfo.post_id);
					//RequestDispatcher dispatcher = request
						//	.getRequestDispatcher("detail.jsp");
				//	dispatcher.forward(request, response);
					response.sendRedirect("toptopic.jsp");
					//Postinfo.post++;
				} else {
					System.out.println("发帖失败！！！！！");
				}

			} catch (FileUploadException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			System.out.println("客户端表单不符合上传要求！");
		}
	}

	// 自定义方法完成上传文件名称的自动生成
	private synchronized String generateUnqieName() {
		return String.valueOf(System.nanoTime());
		
	
		
		
	}

}
