package com.btf.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;

import com.btf.web.dao.UserDao;;

@SuppressWarnings("serial")
public class Login extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
		System.out.println("登录中...");
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ServletContext servletContext = getServletContext();
		ApplicationContext ctx = (ApplicationContext) servletContext.getAttribute("ApplicationContext");
		
		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
	    PrintWriter out=response.getWriter();
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		UserDao userDaoImpl=ctx.getBean(UserDao.class);
		boolean b=userDaoImpl.login(username,password);
		if (b) {
			out.write("登录成功");
			System.out.println("登录成功...");
		}
		else {
			out.write("登录失败");
			System.out.println("登录失败...");
		}
		out.flush();
		out.close();
	}

}
