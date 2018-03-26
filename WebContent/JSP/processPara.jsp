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
<title>工艺参数</title>
<jsp:useBean id="connection" scope="request" class="com.factory.db.JDBCConnection"></jsp:useBean>
</head>
<body onload="JSP/processPara.jsp">
<div align="center">
  <table width="900" border="1" align="center">
    <tr>
      <td colspan="4" align="center">工艺参数</td>
    </tr>
    <tr>
      <td align="right">参数设定</td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
    </tr>
    <tr>
      <td>&nbsp;</td>
      <td>锭盘直径<select name="comD"><option selected="selected">20.5</option><option>22.0</option><option>24.0</option></select> mm</td>
      <td>滚盘直径
        <select name="combod">
          <option selected="selected">220</option>
          <option>250</option>
      </select>mm</td>
      <td>修正系数<input name="txtCoefficient" type="text" value="0.59"/></td>
    </tr>
    <tr>
      <td>&nbsp;</td>
      <td>罗拉直径<select name="combDr"><option selected="selected">25</option><option>27</option></select>mm</td>
      <td>粗纱定量<input name="Rov" type="text" size="10"/>g/km</td>
      <td><button type="button" onclick="">保&nbsp;&nbsp;存</button></td>
    </tr>
  </table>
  <table width="900" border="1" cellspacing="0" cellpadding="0">
    <tr>
      <td width="96" align="right">参数显示</td>
      <td width="402">&nbsp;</td>
      <td width="402">&nbsp;</td>
    </tr>
    
    <%
    	String sql = "select * from M1";//string sql = "select Speed1,Speed2,Speed4,dingSpeed from " + comboBox1.Text.ToString() + " order by ID desc limit 1";
    	try{
    		ResultSet rs = connection.executeQuery(sql);
    		if(rs.next()){
    %>
    
    <tr>
      <td>&nbsp;</td>
      <td>锭子转速&nbsp;&nbsp;&nbsp;&nbsp;<input name="txtSpindleSpeed" type="text" value="<%=rs.getString("dingSpeed")%>"/>r/min</td>
      <td>细纱号数<input name="txtTex" type="text"/>g/km</td>
    </tr>
    <tr>
      <td>&nbsp;</td>
      <td>主轴转速&nbsp;&nbsp;&nbsp;&nbsp;<input name="txtMainShaftSpeed" type="text" value="<%=rs.getString("Speed1")%>"/>r/min</td>
      <td>牵伸倍数<input name="txtDt" type="text"/>times</td>
    </tr>
    <tr>
      <td>&nbsp;</td>
      <td>前拉入转速<input name="txtNfrSpeed" type="text"/ value="<%=rs.getString("Speed2")%>">r/min</td>
      <td>细纱捻度<input name="txtT" type="text"/>T/m</td>
    </tr>
    <tr>
      <td>&nbsp;</td>
      <td>后罗拉转速<input name="txtNbrSpeed" type="text"/ value="<%=rs.getString("Speed4")%>">r/min</td>
      <td>千锭产量<input name="txtP" type="text"/>kg/ks.h</td>
    </tr>
    
    <%}}catch(Exception e){e.printStackTrace();}  %>
  </table>
  <p>选择机器<select name="machineNumber" onchange="JSP/processPara.jsp" ><option>M1</option>
  			<option>M2</option>
            <option>M3</option>
          	<option>M4</option>
            <option>M5</option>
            <option>M6</option>
  </select></p>
</div>
</body>
</html>