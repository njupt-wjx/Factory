package com.factory.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.factory.db.JDBCConnection;

/**
 * Servlet implementation class EmptydbServlet
 */
@WebServlet("/EmptydbServlet")
public class EmptydbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmptydbServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("utf-8");
		//response.setContentType("text/html,charset=utf-8");
		response.setCharacterEncoding("utf-8");
		String[] tables = request.getParameterValues("checkbox");
		JDBCConnection db = new JDBCConnection(); 
		PrintWriter out = response.getWriter();
		if(tables!=null){
			for(int i=0;i<tables.length;i++){
				String sql = "delete from "+tables[i] ;//+ " where Date < DATE_SUB(curdate() , interval 6 month)";
				db.deleteDatabase(sql);
			}
			db.closeConnection();
			out.println("<script>window.alert('成功清空数据库!');</script>");//中文乱码
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
