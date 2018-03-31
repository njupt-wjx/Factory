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
 * �Զ����ͼ������
 * @author Li Yong Qiang
 */
public class ChartUtil {

/*ʵ�������ȴ������ݼ��϶���DefaultCategoryDataset��������ĸ����ȵ��������ݣ���ؼ��������£�*/
    /**
     * �������ݼ���
     * @return CategoryDataset����
     */
    public static CategoryDataset createDataSet() {
        //ʵ����DefaultCategoryDataset����
        DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
        //��ӵ�һ��������
        dataSet.addValue(6000, "��һ����", "J2SE��");
        dataSet.addValue(3000, "��һ����", "J2ME��");
        dataSet.addValue(12000, "��һ����", "J2EE��");
        //��ӵڶ���������
        dataSet.addValue(8000, "�ڶ�����", "J2SE��");
        dataSet.addValue(4000, "�ڶ�����", "J2ME��");
        dataSet.addValue(6000, "�ڶ�����", "J2EE��");
        //��ӵ�����������
        dataSet.addValue(5000, "��������", "J2SE��");
        dataSet.addValue(4000, "��������", "J2ME��");
        dataSet.addValue(8000, "��������", "J2EE��");
        //��ӵ��ļ�������
        dataSet.addValue(8000, "���ļ���", "J2SE��");
        dataSet.addValue(2000, "���ļ���", "J2ME��");
        dataSet.addValue(9000, "���ļ���", "J2EE��");
        return dataSet;
    }
/*   createDataSet()����������ChartUtil���У�����һ���Զ������ͼ�����ࡣ�ڴ����У�������������ͼ����ķ���createChart()����������ͼ������ؼ��������£�                       */
    /**
     * ����JFreeChart����
     * @return JFreeChart����
     */

    public static JFreeChart createChart() {
        //ͨ��ChartFactory����JFreeChart
        JFreeChart chart = ChartFactory.createBarChart3D(
                "JAVAͼ������ͳ��",           //ͼ�����
                "JAVAͼ��",                   //�������
                "����������",                //�������
                createDataSet(),            //���ݼ��� 
                PlotOrientation.VERTICAL,   //ͼ����
                true,                       //�Ƿ���ʾͼ����ʶ
                true,                      //�Ƿ���ʾtooltips
                false);                     //�Ƿ�֧�ֳ�����
        //����ͼƬ
        Image image = null;
        /*try {
            //��������ͼƬ
            image = ImageIO.read(ChartUtil.class.getResource("images/beijing.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        //���ñ�������
        chart.getTitle().setFont(new Font("����",Font.BOLD,25));
        //����ͼ���������
        chart.getLegend().setItemFont(new Font("����",Font.PLAIN,12));
        chart.setBorderVisible(true);   //������ʾ�߿�
        //ʵ����TextTitle����
        TextTitle subTitle = new TextTitle("2009��Java��ͼ��ȫ������ͳ�ƣ�J2SE��J2ME��J2EE��");
        //���þ�����ʾ
        subTitle.setVerticalAlignment(VerticalAlignment.BOTTOM);
        chart.addSubtitle(subTitle);    //����ӱ���
        //��ȡ��ͼ������
        CategoryPlot plot = chart.getCategoryPlot();
        plot.setForegroundAlpha(0.8F);  //���û�ͼ��ǰ��ɫ͸����
        plot.setBackgroundAlpha(0.5F);  //���û�ͼ������ɫ͸����
        //plot.setBackgroundImage(image); //���û�ͼ������ͼƬ
        //��ȡ���������
        CategoryAxis categoryAxis = plot.getDomainAxis();
        //�����������������
        categoryAxis.setLabelFont(new Font("����",Font.PLAIN,12));
        //������������ֵ����
        categoryAxis.setTickLabelFont(new Font("����",Font.PLAIN,12));
        //���������������ת�Ƕ�
        categoryAxis.setCategoryLabelPositions(CategoryLabelPositions.UP_45);
        //��ȡ���������
        ValueAxis valueAxis = plot.getRangeAxis();
        //��������������
        valueAxis.setLabelFont(new Font("����",Font.PLAIN,12));
        //��ȡͼƬ��Ⱦ����
        BarRenderer3D renderer = new BarRenderer3D();
        renderer.setItemMargin(0.5);   //�������Ӽ�ļ��
        plot.setRenderer(renderer);     //����ͼƬ��Ⱦ����
        return chart;
    }
}
