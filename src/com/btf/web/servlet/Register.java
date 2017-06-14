package com.btf.web.servlet;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;

import com.btf.web.dao.UserDao;
import com.btf.web.entity.User;
import com.btf.web.json.JsonUtil;
import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;

@SuppressWarnings("serial")
public class Register extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {

		doPost(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {


		ServletContext servletContext = getServletContext();
		ApplicationContext ctx = (ApplicationContext) servletContext.getAttribute("ApplicationContext");
		
		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out=response.getWriter();
		String jsondata=request.getParameter("jsonstring");
		
		
		System.out.println(jsondata);
		List<User> list= JsonUtil.getObjectList(jsondata, User.class);
		User user = list.get(0);
		System.out.println(user.getMobile());
		System.out.println(user.getNickname());
		System.out.println(user.getPassword());
		UserDao userDaoImpl= ctx.getBean(UserDao.class);		
		boolean b = userDaoImpl.register(user);
		//boolean b = true;
		if (b) {
			out.write("t");
		}else {
			out.write("f");
		}
		out.flush();
		out.close();
	}
}
