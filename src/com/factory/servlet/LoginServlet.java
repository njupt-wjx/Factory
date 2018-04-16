package com.factory.servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.factory.db.JDBCConnection;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		try {
			processLoginServlet(request,response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void processLoginServlet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException, SQLException  {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html,charset=utf-8");
		String admin = request.getParameter("admin");
		String pwd = request.getParameter("pwd");
		
		HttpSession session=((HttpServletRequest)request).getSession();
		session.setAttribute("admin", admin);
		
		String sql = "select * from Admin where Admin='"+admin+"' and "+"Pwd='"+pwd+"'";
		JDBCConnection db = new JDBCConnection();   
		ResultSet rs= db.executeQuery(sql);
		
		if (rs.next()) {
			request.setAttribute("msg", "用户："+admin+",欢迎访问！");
			//request.getRequestDispatcher("index.html").forward(request, response);
			response.sendRedirect("index.html");
			rs.close();
			db.closeConnection();
			return;
		}else{
			//request.setAttribute("msg", "密码错误请重新输入！");  
			rs.close();
			db.closeConnection();
            //request.getRequestDispatcher("JSP/login.jsp").forward(request, response);
			response.sendRedirect("JSP/login.jsp");
			return;
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
