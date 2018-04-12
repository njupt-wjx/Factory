package com.factory.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jfree.chart.JFreeChart;
import org.jfree.chart.servlet.ServletUtilities;

import com.factory.utils.TimeSeriesUtil;

/**
 * Servlet implementation class CheckGraph
 */
@WebServlet("/CheckGraph")
public class CheckGraph extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckGraph() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out = response.getWriter();
		String date = request.getParameter("date");
		
		String machineNumber = request.getParameter("machineNumber");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date1 = null;
		try {
			date1 = sdf.parse(date);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date1);
		calendar.add(Calendar.DAY_OF_MONTH, +1);
		date1=calendar.getTime();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String nextdate = formatter.format(date1);
		//String sql = "select dingSpeed,Speed2,Date from M13"+" where Date between" + "'" + "2018-01-06" + " 07:30:00" + "'"
        //        + " and " + "'" + "2018-01-06" + " 19:30:00" + "'";
		String sql = "select dingSpeed,Speed2,Date from " +machineNumber+" where Date between" + "'" + date + " 07:30:00" + "'"
                + " and " + "'" + date+ " 19:30:00" + "'";
		String sql2 = "select dingSpeed,Speed2,Date from " +machineNumber+" where Date between" + "'" + date + " 19:30:00" + "'"
                + " and " + "'" + nextdate+ " 07:30:00" + "'";
		try {
			JFreeChart chart = TimeSeriesUtil.createLineChart(sql);
			String fileName = ServletUtilities.saveChartAsJPEG(chart,1000,500,null);
	        String graphURL = request.getContextPath() + "/servlet/DisplayChart?filename=" + fileName;
			out.print(graphURL);
			
			JFreeChart chart2 = TimeSeriesUtil.createLineChart(sql2);
			String fileName2 = ServletUtilities.saveChartAsJPEG(chart2,1000,500,null);
	        String graphURL2 = request.getContextPath() + "/servlet/DisplayChart?filename=" + fileName2;
			out.print("#"+graphURL2);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
