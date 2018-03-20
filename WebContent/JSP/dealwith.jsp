<%@ page contentType="text/html; charset=utf-8" language="java"  errorPage="" pageEncoding="utf-8"%>
    <%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath %>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>获取文本框/编辑框/隐藏域的值</title>
</head>
<%request.setCharacterEncoding("utf-8");%>
<body background="images/beijing.jpg">
<div align="center">
  
    <table width="377" border="1" cellpadding="1" cellspacing="1" bordercolor="#2D619D" bgcolor="#FFFFFF">
      <tr>
        <td height="41" colspan="2" align="center" background="beijing.jpg" bgcolor="#3D76AE"><strong><font color="#FFFFFF">文本字段/文本区域/隐藏域的值</font></strong></td>
      </tr>
      <tr>
        <td width="111" height="20" align="right" background="beijing.jpg" bgcolor="#3D76AE"><font color="#FFFFFF">文本字段：</font></td>
        <td width="256" background="beijing.jpg" bgcolor="#3D76AE"><%=request.getParameter("textOne") %></td>
      </tr>
      <tr>
        <td height="119" align="right" background="beijing.jpg" bgcolor="#3D76AE"><font color="#FFFFFF">文本区域：</font></td>
        <td background="beijing.jpg" bgcolor="#3D76AE"><font color="#FFFFFF"><%=request.getParameter("textTwo") %></font></td>
      </tr>
      <tr>
        <td height="26" align="right" background="beijing.jpg" bgcolor="#3D76AE"><font color="#FFFFFF">隐藏域的值：</font></td>
        <td background="beijing.jpg" bgcolor="#3D76AE"><font color="#FFFFFF"><%=request.getParameter("textThree") %></font></td>
         
      </tr>
      <tr>
        <td height="26" colspan="2" align="center" background="beijing.jpg" bgcolor="#3D76AE"><a href="JSP/1_1.jsp">返回</a></td>
      </tr>
    </table>
 
</div>
</body>
</html>
