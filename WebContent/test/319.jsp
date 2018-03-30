<%@ page language="java" contentType="text/html" pageEncoding="GBK"%>
<%@ page import="org.jfree.chart.servlet.ServletUtilities,com.factory.test.TimeSeriesUtil"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>Java图书销量统计</title>
  </head>
  <body>
    <%
               String fileName = ServletUtilities.saveChartAsJPEG(TimeSeriesUtil.getTimeSeriesChart(),1000,500,session);
               String graphURL = request.getContextPath() + "/servlet/DisplayChart?filename=" + fileName;
    %>
    <img src="<%=graphURL%>" border="1">
  </body>
</html>