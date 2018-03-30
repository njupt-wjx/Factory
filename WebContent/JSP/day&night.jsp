<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="org.jfree.chart.servlet.ServletUtilities,com.factory.utils.TimeSeriesUtil"%>
    <%
    String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
 <%
               String fileName = ServletUtilities.saveChartAsJPEG(TimeSeriesUtil.createLineChart(),1000,500,session);
               String graphURL = request.getContextPath() + "/servlet/DisplayChart?filename=" + fileName;
    %>
    <img src="<%=graphURL%>" border="1">
    <cewolf:map tooltipgeneratorid=""/>
</body>
</html>