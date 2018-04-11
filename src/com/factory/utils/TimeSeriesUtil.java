package com.factory.utils;

import java.awt.Color;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.DateTickUnit;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.labels.StandardXYItemLabelGenerator;
import org.jfree.chart.labels.StandardXYSeriesLabelGenerator;
import org.jfree.chart.labels.StandardXYToolTipGenerator;
import org.jfree.chart.labels.XYItemLabelGenerator;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.time.Day;
import org.jfree.data.time.Hour;
import org.jfree.data.time.Minute;
import org.jfree.data.time.Month;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.TextAnchor;
import org.jfree.ui.VerticalAlignment;

import com.factory.db.JDBCConnection;

import javafx.scene.chart.ValueAxis;

public class TimeSeriesUtil {
	
	private static XYDataset getDataset() throws SQLException{
		XYSeriesCollection dataset = new XYSeriesCollection(); //����ʱ��ͼ������ݼ���
        XYSeries dingTimeSeries = new XYSeries("����");//A�����ݶ���
        XYSeries qianTimeSeries = new XYSeries("ǰ����");//B�����ݶ���
        String sql = "select dingSpeed,Speed2,Date from M13"+" where Date between" + "'" + "2018-01-06" + " 07:30:00" + "'"
                + " and " + "'" + "2018-01-06" + " 19:30:00" + "'";
    	JDBCConnection db = new JDBCConnection();   
    	ResultSet rs= db.executeQuery(sql);
		double hour=0.0;
		double   min =0.0;
    	while (rs.next()) {
    		
    		/*dingSpeed.add(rs.getInt("dingSpeed"));
    		qianSpeed.add(rs.getInt("Speed2"));
    		date.add(rs.getString("Date"));    */
    		hour = Double.parseDouble(rs.getString("Date").substring(11, 13));
    		min =Double.parseDouble(rs.getString("Date").substring(14, 16))/60;
    		hour += min;
    		dingTimeSeries.add(hour,rs.getInt("dingSpeed"));
    		qianTimeSeries.add(hour,rs.getInt("Speed2"));
    		
    	}
    		
    		rs.close();
    		db.closeConnection();
        /*for(int i=0;i<dingSpeed.size();i++){
        	
        	dingTimeSeries.add(1, dingSpeed.get(i));
        	qianTimeSeries.add(1,qianSpeed.get(i));
        	
        }
        */
        dataset.addSeries(dingTimeSeries);//�����ݶ�����������ݼ���
        dataset.addSeries(qianTimeSeries); //�����ݶ�����������ݼ���
	
		return dataset;
  }
	
	public static JFreeChart createLineChart() throws SQLException{
		StandardChartTheme standardChartTheme = new StandardChartTheme("CN");  //����������ʽ
        standardChartTheme.setExtraLargeFont(new Font("����", Font.BOLD, 20));    //���ñ�������
        standardChartTheme.setRegularFont(new Font("����", Font.PLAIN, 15));        //����ͼ��������
        standardChartTheme.setLargeFont(new Font("����", Font.PLAIN, 15));          //�������������
        ChartFactory.setChartTheme(standardChartTheme);                                 //����������ʽ                         //����������ʽ
        JFreeChart chart = ChartFactory.createXYLineChart(
                     "����״��",                //����
                     "ʱ��",                                 //�������
                     "ת��",                //�������
                      getDataset(),                      //���ݼ���
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
        subTitle.setFont(new Font("����",Font.BOLD,18));
        chart.addSubtitle(subTitle);    //����ӱ���
        
        //��ͼ������
        XYPlot plot = chart.getXYPlot();
        plot.setBackgroundPaint(Color.WHITE);
        plot.setBackgroundAlpha(0.8f);
        plot.setForegroundAlpha(0.5f);
        plot.setOutlinePaint(Color.black);//�����������ı߽�������ɫ
        plot.setNoDataMessage("û�в�ѯ������");//����û������ʱ��ʾ����Ϣ
        plot.setRangeGridlinePaint(Color.BLUE);//�����������ɫ
        plot.setDomainGridlinePaint(Color.BLACK);//�����������ɫ
        plot.setDomainGridlinesVisible(true);//��ʾ���������
        plot.setRangeGridlinesVisible(true);//��ʾ���������
        //�õ�������
        org.jfree.chart.axis.ValueAxis xAxis = plot.getDomainAxis();
        org.jfree.chart.axis.ValueAxis yAxis = plot.getRangeAxis();
        xAxis.setAxisLinePaint(Color.blue);
        yAxis.setAxisLinePaint(Color.blue);
        xAxis.setLabelFont(new Font("����", Font.BOLD, 18));//����������
        yAxis.setLabelFont(new Font("����", Font.BOLD, 18));//����������
        xAxis.setTickLabelFont(new Font("����",Font.PLAIN,12));
        yAxis.setTickLabelFont(new Font("����",Font.PLAIN,12));
        
        //��Ⱦ
        XYLineAndShapeRenderer renderer = (XYLineAndShapeRenderer) plot.getRenderer();
        renderer.setBaseShapesVisible(true);//���ùյ��Ƿ�ɼ�/�Ƿ���ʾ�յ�
        renderer.setBaseFillPaint(Color.black);
     // ���ùյ㲻ͬ�ò�ͬ����״
        renderer.setDrawOutlines(true);
        //��ʾ�յ���ֵ
        /*renderer.setBaseItemLabelGenerator(new StandardXYItemLabelGenerator());
        renderer.setItemLabelsVisible(true);
        renderer.setBasePositiveItemLabelPosition(new ItemLabelPosition(ItemLabelAnchor.OUTSIDE12,TextAnchor.BASELINE_LEFT));
        renderer.setItemLabelFont(new Font("����", Font.PLAIN, 14));// �������ֵ������С
*/      
       /* renderer.setToolTipGenerator(new StandardXYToolTipGenerator(
        		"{1}={2}", new SimpleDateFormat("MM-dd"),
        		new SimpleDateFormat("MM-dd")));*/
        return chart;
	}
	}
