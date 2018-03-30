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
	 * 创建数据集
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
			dataSet.addValue(rs.getInt("dingSpeed"), "锭速", rs.getString("Date").substring(11, 16));
			dataSet.addValue(rs.getInt("Speed2"), "前罗拉", rs.getString("Date").substring(11, 16));
			
		}
			//request.setAttribute("msg", "密码错误请重新输入！");  
			rs.close();
			db.closeConnection();
		return dataSet;
	}
	
	/**
	 * 创建LineChart
	 * @throws SQLException 
	 */
	public static JFreeChart createLineChart() throws SQLException{
		StandardChartTheme standardChartTheme = new StandardChartTheme("CN");  //创建主题样式
        standardChartTheme.setExtraLargeFont(new Font("隶书", Font.BOLD, 20));    //设置标题字体
        standardChartTheme.setRegularFont(new Font("宋体", Font.PLAIN, 15));        //设置图例的字体
        standardChartTheme.setLargeFont(new Font("宋体", Font.PLAIN, 15));          //设置轴向的字体
        ChartFactory.setChartTheme(standardChartTheme);                                 //设置主题样式
        JFreeChart chart = ChartFactory.createLineChart(
                     "运行状况",                //标题
                     "时间",                                 //横轴标题
                     "转速",                //纵轴标题
                     getdDataset(),                      //数据集合
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
        chart.addSubtitle(subTitle);    //添加子标题
        
        //获取绘图区对象
        CategoryPlot plot = chart.getCategoryPlot();
        
        // 设置背景颜色
        plot.setBackgroundPaint(Color.WHITE);
        // 设置网格竖线颜色
        plot.setDomainGridlinePaint(Color.pink);
     // 设置网格横线颜色
        plot.setRangeGridlinePaint(Color.pink);
        plot.setNoDataMessage("暂无数据显示！");// 没有数据显示的时候显示这个提示
        
        
        plot.setForegroundAlpha(1F);  //设置绘图区前景色透明度
        plot.setBackgroundAlpha(1F);  //设置绘图区背景色透明度
        //plot.setBackgroundImage(image); //设置绘图区背景图片
       
        //获取坐标轴对象
        CategoryAxis categoryAxis = plot.getDomainAxis();        
        //设置坐标轴标题字
        categoryAxis.setLabelFont(new Font("黑体",Font.PLAIN,12));
        //设置坐标轴标尺值字体
       categoryAxis.setTickLabelFont(new Font("宋体",Font.PLAIN,12));
        //设置坐标轴标题旋转角度
        categoryAxis.setCategoryLabelPositions(CategoryLabelPositions.UP_90);
       
        // 设置纵轴的字体
        NumberAxis numberAxis = (NumberAxis)plot.getRangeAxis();
        numberAxis.setLabelFont(new Font("黑体", Font.PLAIN, 18));
        numberAxis.setUpperMargin(0.15);//设置最高数据显示与顶端的距离
        numberAxis.setLowerMargin(2);//设置最低的一个值与图片底端的距离
        
     // 获取显示线条的对象
        LineAndShapeRenderer lasp = (LineAndShapeRenderer) plot.getRenderer();
     // 设置拐点是否可见/是否显示拐点
        lasp.setBaseShapesVisible(true);
     // 设置拐点不同用不同的形状
        lasp.setDrawOutlines(true);
     // 设置线条是否被显示填充颜色
        lasp.setUseFillPaint(true);
     // 设置拐点颜色
        //lasp.setBaseFillPaint(Color.blue);//蓝色
     // 设置折线加粗
      //lasp.setSeriesStroke(0, new BasicStroke(3F));
        //lasp.setSeriesOutlineStroke(0, new BasicStroke(4.5F));//设置折点的大小
        
     

        
        return chart;
	}
}
