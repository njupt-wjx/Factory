package com.factory.utils;


import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.CategoryTick;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.DateTickUnit;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.category.BarRenderer3D;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.TextAnchor;
import org.jfree.ui.VerticalAlignment;

import com.factory.db.JDBCConnection;

public class LineChartUtil {

	/**
	 * �������ݼ�
	 */
	public static CategoryDataset getdDataset() throws SQLException{
		DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
		
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String currentDate = sdf.format(date);
		
		String sql = "select dingSpeed,Speed2,Date from M13"+" where Date between" + "'" + "2018-01-06" + " 07:30:00" + "'"
                + " and " + "'" + currentDate + " 19:30:00" + "'";
		JDBCConnection db = new JDBCConnection();   
		ResultSet rs= db.executeQuery(sql);
		
		while (rs.next()) {
			dataSet.addValue(rs.getInt("dingSpeed"), "����", rs.getString("Date").substring(11, 16));
			dataSet.addValue(rs.getInt("Speed2"), "ǰ����", rs.getString("Date").substring(11, 16));
			
		}
			//request.setAttribute("msg", "����������������룡");  
			rs.close();
			db.closeConnection();
		return dataSet;
	}
	
	/**
	 * ����LineChart
	 * @throws SQLException 
	 */
	public static JFreeChart createLineChart() throws SQLException{
		StandardChartTheme standardChartTheme = new StandardChartTheme("CN");  //����������ʽ
        standardChartTheme.setExtraLargeFont(new Font("����", Font.BOLD, 20));    //���ñ�������
        standardChartTheme.setRegularFont(new Font("����", Font.PLAIN, 15));        //����ͼ��������
        standardChartTheme.setLargeFont(new Font("����", Font.PLAIN, 15));          //�������������
        ChartFactory.setChartTheme(standardChartTheme);                                 //����������ʽ
        JFreeChart chart = ChartFactory.createLineChart(
                     "����״��",                //����
                     "ʱ��",                                 //�������
                     "ת��",                //�������
                     getdDataset(),                      //���ݼ���
                     PlotOrientation.VERTICAL,    //ͼ����
                     true,                              //�Ƿ���ʾͼ����ʶ
                     true,                              //�Ƿ���ʾtoolTips
                     false);                             //�Ƿ����ɳ�����
      //���ñ�������
        chart.getTitle().setFont(new Font("����",Font.BOLD,25));
        //����ͼ���������
        chart.getLegend().setItemFont(new Font("����",Font.PLAIN,12));
        chart.setBorderVisible(true);   //������ʾ�߿�
        //ʵ����TextTitle����
        TextTitle subTitle = new TextTitle("���");
        //���þ�����ʾ
        subTitle.setVerticalAlignment(VerticalAlignment.BOTTOM);
        chart.addSubtitle(subTitle);    //����ӱ���
        
        //��ȡ��ͼ������
        CategoryPlot plot = chart.getCategoryPlot();
        
        // ���ñ�����ɫ
        plot.setBackgroundPaint(Color.WHITE);
        // ��������������ɫ
        plot.setDomainGridlinePaint(Color.pink);
     // �������������ɫ
        plot.setRangeGridlinePaint(Color.pink);
        plot.setNoDataMessage("����������ʾ��");// û��������ʾ��ʱ����ʾ�����ʾ
        
        
        plot.setForegroundAlpha(1F);  //���û�ͼ��ǰ��ɫ͸����
        plot.setBackgroundAlpha(1F);  //���û�ͼ������ɫ͸����
        //plot.setBackgroundImage(image); //���û�ͼ������ͼƬ
       
        //��ȡ���������
        CategoryAxis categoryAxis = plot.getDomainAxis();        
        //���������������
        categoryAxis.setLabelFont(new Font("����",Font.PLAIN,12));
        //������������ֵ����
       categoryAxis.setTickLabelFont(new Font("����",Font.PLAIN,12));
        //���������������ת�Ƕ�
        categoryAxis.setCategoryLabelPositions(CategoryLabelPositions.UP_90);
       
        // �������������
        NumberAxis numberAxis = (NumberAxis)plot.getRangeAxis();
        numberAxis.setLabelFont(new Font("����", Font.PLAIN, 18));
        numberAxis.setUpperMargin(0.15);//�������������ʾ�붥�˵ľ���
        numberAxis.setLowerMargin(2);//������͵�һ��ֵ��ͼƬ�׶˵ľ���
        
     // ��ȡ��ʾ�����Ķ���
        LineAndShapeRenderer lasp = (LineAndShapeRenderer) plot.getRenderer();
     // ���ùյ��Ƿ�ɼ�/�Ƿ���ʾ�յ�
        lasp.setBaseShapesVisible(true);
     // ���ùյ㲻ͬ�ò�ͬ����״
        lasp.setDrawOutlines(true);
     // ���������Ƿ���ʾ�����ɫ
        lasp.setUseFillPaint(true);
     // ���ùյ���ɫ
        //lasp.setBaseFillPaint(Color.blue);//��ɫ
     // �������߼Ӵ�
      //lasp.setSeriesStroke(0, new BasicStroke(3F));
        //lasp.setSeriesOutlineStroke(0, new BasicStroke(4.5F));//�����۵�Ĵ�С
        
     

        
        return chart;
	}
}
