<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>每日生产状况</title>
<link rel="stylesheet" type="text/css" href="tcal.css" />
<script type="text/javascript" src="tcal.js"></script> 
</head>
<jsp:useBean id="db" scope="request" class="com.factory.db.JDBCConnection"></jsp:useBean>
<body>
<form name="dailyform" method="post" action="JSP/daily.jsp">

<table align="center" width="870" border="1" cellspacing="0" cellpadding="0">
	<%
		response.setCharacterEncoding("utf-8");
		String date = request.getParameter("date");
		if(date==null){
			Date d = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			date = sdf.format(d);
		}
	%>
  <caption>
    每日生产状况&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="date" class="tcal" value="<%=date %>" />
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" name="Submit" value="查询" >
  </caption>
  <tr>
  	<td>日期</td>
  	<td>班次</td>
  	<td>员工姓名</td>
  	<td>产品种类</td>
  	<td>负责机器</td>
  	<td>产量</td>
  </tr>
  
  <%
  if(date!=null){
  	try{
  		String sql = "select * from daily_production where Date ='"+date+"'";
  		ResultSet rs = db.executeQuery(sql);
  		if(!rs.next()){
  			out.print("<script>window.alert('没有上传数据，请联系相关人员！');</script>");
  		}else{
  		while(rs.next()){
  %>
  <tr bordercolor="#6894D5">
  	<td><%=rs.getString(2) %></td>
  	<td><%=rs.getString(3) %></td>
  	<td><%=rs.getString(4) %></td>
  	<td><%=rs.getString(5) %></td>
  	<td><%=rs.getString(6) %></td>
  	<td><%=rs.getString(7) %></td>
  </tr>
  
  <%}}rs.close();db.closeConnection();}catch(Exception e){} }%>
</table>
</form>
</body>
</html>