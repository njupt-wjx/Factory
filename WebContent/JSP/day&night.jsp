<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.sql.ResultSet"%>
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
<title>每日生产状况</title>
<link rel="stylesheet" type="text/css" href="tcal.css" />
<script type="text/javascript" src="tcal.js"></script> 
<script type="text/javascript" src="JS/AjaxRequest.js"></script>
</head>
<script  type="text/javascript">
	function checkGraph(){
		var date = dayandnightform.date.value;
		var machineNumber = dayandnightform.machineNumber.value;
		
		var loader=new net.AjaxRequest("CheckGraph?date="+date+"&machineNumber="+machineNumber+"&nocache="+new Date().getTime(),deal,onerror,"GET");
		
	}
	
	//错误处理函数
	function onerror(){
		alert("出错了！");
	}
	//回调函数
	function deal(){
		//alert(this.req.responseText);
		//admindiv.innerHTML = this.req.responseText;
		var str = this.req.responseText;
		var arr = str.split("#");
		document.getElementById("imgMorID").src = arr[0];
		document.getElementById("imgNigID").src = arr[1];
		
	}
</script>
<body>
<form name="dayandnightform" method="post" action="#">

<table align="center" width="1000" border="1" cellspacing="0" cellpadding="0">
	<%
		response.setCharacterEncoding("utf-8");
		String date = request.getParameter("date");
		if(date==null){
			Date d = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			date = sdf.format(d);
		}
	%>
	<%
        //String fileName = ServletUtilities.saveChartAsJPEG(TimeSeriesUtil.createLineChart(),1000,500,session);
        //String graphURL = request.getContextPath() + "/servlet/DisplayChart?filename=" + fileName;
    %>
    
  <caption>
    细纱机每日运转状况&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <select name="machineNumber">
    	<%
    	for(int i=1;i<=20;i++){
    	%>
    	<option value="<%="M"+i%>"
    	>
    	<%="M"+i%></option>
    	<%}%>
    </select>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <input type="text" name="date" class="tcal" value="<%=date %>" />
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="button" name="Submit" value="查询" onclick="checkGraph()">
  </caption>
  <tr>
  	<td>早班</td>
  </tr>
  <tr>
  	<td><img id="imgMorID" src="images/mor.png" border="1"></td>
  </tr>
  <tr>
  	<td>晚班</td>
  </tr>
  <tr>
  	<td><img id="imgNigID" src="images/mor.png" border="1"></td>
  </tr>
</table>
</form>
</body>
</html>