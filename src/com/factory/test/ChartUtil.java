package com.factory.test;

import java.awt.Font;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer3D;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.VerticalAlignment;
/**
 * 自定义绘图工具类
 * @author Li Yong Qiang
 */
public class ChartUtil {

/*实例中首先创建数据集合对象DefaultCategoryDataset，并添加四个季度的销量数据，其关键代码如下：*/
    /**
     * 创建数据集合
     * @return CategoryDataset对象
     */
    public static CategoryDataset createDataSet() {
        //实例化DefaultCategoryDataset对象
        DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
        //添加第一季度数据
        dataSet.addValue(6000, "第一季度", "J2SE类");
        dataSet.addValue(3000, "第一季度", "J2ME类");
        dataSet.addValue(12000, "第一季度", "J2EE类");
        //添加第二季度数据
        dataSet.addValue(8000, "第二季度", "J2SE类");
        dataSet.addValue(4000, "第二季度", "J2ME类");
        dataSet.addValue(6000, "第二季度", "J2EE类");
        //添加第三季度数据
        dataSet.addValue(5000, "第三季度", "J2SE类");
        dataSet.addValue(4000, "第三季度", "J2ME类");
        dataSet.addValue(8000, "第三季度", "J2EE类");
        //添加第四季度数据
        dataSet.addValue(8000, "第四季度", "J2SE类");
        dataSet.addValue(2000, "第四季度", "J2ME类");
        dataSet.addValue(9000, "第四季度", "J2EE类");
        return dataSet;
    }
/*   createDataSet()方法定义在ChartUtil类中，它是一个自定义的制图工具类。在此类中，还包含创建制图对象的方法createChart()，用于柱形图对象，其关键代码如下：                       */
    /**
     * 创建JFreeChart对象
     * @return JFreeChart对象
     */

    public static JFreeChart createChart() {
        //通过ChartFactory创建JFreeChart
        JFreeChart chart = ChartFactory.createBarChart3D(
                "JAVA图书销量统计",           //图表标题
                "JAVA图书",                   //横轴标题
                "销量（本）",                //纵轴标题
                createDataSet(),            //数据集合 
                PlotOrientation.VERTICAL,   //图表方向
                true,                       //是否显示图例标识
                true,                      //是否显示tooltips
                false);                     //是否支持超链接
        //背景图片
        Image image = null;
        /*try {
            //创建背景图片
            image = ImageIO.read(ChartUtil.class.getResource("images/beijing.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        //设置标题字体
        chart.getTitle().setFont(new Font("隶书",Font.BOLD,25));
        //设置图例类别字体
        chart.getLegend().setItemFont(new Font("黑体",Font.PLAIN,12));
        chart.setBorderVisible(true);   //设置显示边框
        //实例化TextTitle对象
        TextTitle subTitle = new TextTitle("2009年Java类图书全国销量统计（J2SE、J2ME、J2EE）");
        //设置居中显示
        subTitle.setVerticalAlignment(VerticalAlignment.BOTTOM);
        chart.addSubtitle(subTitle);    //添加子标题
        //获取绘图区对象
        CategoryPlot plot = chart.getCategoryPlot();
        plot.setForegroundAlpha(0.8F);  //设置绘图区前景色透明度
        plot.setBackgroundAlpha(0.5F);  //设置绘图区背景色透明度
        //plot.setBackgroundImage(image); //设置绘图区背景图片
        //获取坐标轴对象
        CategoryAxis categoryAxis = plot.getDomainAxis();
        //设置坐标轴标题字体
        categoryAxis.setLabelFont(new Font("黑体",Font.PLAIN,12));
        //设置坐标轴标尺值字体
        categoryAxis.setTickLabelFont(new Font("宋体",Font.PLAIN,12));
        //设置坐标轴标题旋转角度
        categoryAxis.setCategoryLabelPositions(CategoryLabelPositions.UP_45);
        //获取数据轴对象
        ValueAxis valueAxis = plot.getRangeAxis();
        //设置数据轴字体
        valueAxis.setLabelFont(new Font("宋体",Font.PLAIN,12));
        //获取图片渲染对象
        BarRenderer3D renderer = new BarRenderer3D();
        renderer.setItemMargin(0.5);   //设置柱子间的间距
        plot.setRenderer(renderer);     //设置图片渲染对象
        return chart;
    }
}
