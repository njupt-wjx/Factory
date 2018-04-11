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
		XYSeriesCollection dataset = new XYSeriesCollection(); //创建时序图表的数据集合
        XYSeries dingTimeSeries = new XYSeries("锭速");//A股数据对象
        XYSeries qianTimeSeries = new XYSeries("前罗拉");//B股数据对象
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
        dataset.addSeries(dingTimeSeries);//将数据对象添加至数据集合
        dataset.addSeries(qianTimeSeries); //将数据对象添加至数据集合
	
		return dataset;
  }
	
	public static JFreeChart createLineChart() throws SQLException{
		StandardChartTheme standardChartTheme = new StandardChartTheme("CN");  //创建主题样式
        standardChartTheme.setExtraLargeFont(new Font("隶书", Font.BOLD, 20));    //设置标题字体
        standardChartTheme.setRegularFont(new Font("宋体", Font.PLAIN, 15));        //设置图例的字体
        standardChartTheme.setLargeFont(new Font("宋体", Font.PLAIN, 15));          //设置轴向的字体
        ChartFactory.setChartTheme(standardChartTheme);                                 //设置主题样式                         //设置主题样式
        JFreeChart chart = ChartFactory.createXYLineChart(
                     "运行状况",                //标题
                     "时间",                                 //横轴标题
                     "转速",                //纵轴标题
                      getDataset(),                      //数据集合
                     PlotOrientation.VERTICAL,    //图表方向
                     true,                              //是否显示图例标识
                     true,                              //是否显示toolTips
                     false);                             //是否生成超链接
        //设置标题字体
        chart.getTitle().setFont(new Font("隶书",Font.BOLD,25));
        //设置图例类别字体
        chart.getLegend().setItemFont(new Font("黑体",Font.PLAIN,12));
        chart.setBorderVisible(true);   //设置显示边框
        //实例化TextTitle对象
        TextTitle subTitle = new TextTitle("早班");
        //设置居中显示
        subTitle.setVerticalAlignment(VerticalAlignment.BOTTOM);
        subTitle.setFont(new Font("隶书",Font.BOLD,18));
        chart.addSubtitle(subTitle);    //添加子标题
        
        //绘图区对象
        XYPlot plot = chart.getXYPlot();
        plot.setBackgroundPaint(Color.WHITE);
        plot.setBackgroundAlpha(0.8f);
        plot.setForegroundAlpha(0.5f);
        plot.setOutlinePaint(Color.black);//设置数据区的边界线条颜色
        plot.setNoDataMessage("没有查询到数据");//设置没有数据时显示的消息
        plot.setRangeGridlinePaint(Color.BLUE);//纵坐标格线颜色
        plot.setDomainGridlinePaint(Color.BLACK);//横坐标格线颜色
        plot.setDomainGridlinesVisible(true);//显示横坐标格线
        plot.setRangeGridlinesVisible(true);//显示纵坐标格线
        //得到坐标轴
        org.jfree.chart.axis.ValueAxis xAxis = plot.getDomainAxis();
        org.jfree.chart.axis.ValueAxis yAxis = plot.getRangeAxis();
        xAxis.setAxisLinePaint(Color.blue);
        yAxis.setAxisLinePaint(Color.blue);
        xAxis.setLabelFont(new Font("黑体", Font.BOLD, 18));//横坐标名称
        yAxis.setLabelFont(new Font("黑体", Font.BOLD, 18));//纵坐标名称
        xAxis.setTickLabelFont(new Font("宋体",Font.PLAIN,12));
        yAxis.setTickLabelFont(new Font("宋体",Font.PLAIN,12));
        
        //渲染
        XYLineAndShapeRenderer renderer = (XYLineAndShapeRenderer) plot.getRenderer();
        renderer.setBaseShapesVisible(true);//设置拐点是否可见/是否显示拐点
        renderer.setBaseFillPaint(Color.black);
     // 设置拐点不同用不同的形状
        renderer.setDrawOutlines(true);
        //显示拐点数值
        /*renderer.setBaseItemLabelGenerator(new StandardXYItemLabelGenerator());
        renderer.setItemLabelsVisible(true);
        renderer.setBasePositiveItemLabelPosition(new ItemLabelPosition(ItemLabelAnchor.OUTSIDE12,TextAnchor.BASELINE_LEFT));
        renderer.setItemLabelFont(new Font("黑体", Font.PLAIN, 14));// 设置数字的字体大小
*/      
       /* renderer.setToolTipGenerator(new StandardXYToolTipGenerator(
        		"{1}={2}", new SimpleDateFormat("MM-dd"),
        		new SimpleDateFormat("MM-dd")));*/
        return chart;
	}
	}
