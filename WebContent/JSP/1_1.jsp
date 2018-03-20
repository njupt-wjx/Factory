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
<script  type="text/javascript">
function checkEmpty(form){
for(i=0;i<form.length;i++){
if(form.elements[i].value==""){
alert("表单信息不能为空");
return false;
}
}
}
</script>
<body background="images/beijing.jpg">
<div align="center">
  <form name="form" method="post" action="JSP/dealwith.jsp" onSubmit="return checkEmpty(form)">
    <table width="377" border="1" cellpadding="1" cellspacing="1" bordercolor="#2D619D" bgcolor="#FFFFFF">
      <tr>
        <td height="41" colspan="2" align="center" background="beijing.jpg" bgcolor="#3D76AE"><strong><font color="#FFFFFF">文本字段/文本区域/隐藏域的值</font></strong></td>
      </tr>
      <tr>
        <td width="111" height="20" align="right" background="beijing.jpg" bgcolor="#3D76AE"><font color="#FFFFFF">文本字段：</font></td>
        <td width="256" background="beijing.jpg" bgcolor="#3D76AE"><input name="textOne" type="text"></td>
      </tr>
      <tr>
        <td height="119" align="right" background="beijing.jpg" bgcolor="#3D76AE"><font color="#FFFFFF">文本区域：</font></td>
        <td background="beijing.jpg" bgcolor="#3D76AE"><textarea name="textTwo" cols="30" rows="8" ></textarea></td>
      </tr>
      <tr>
        <td height="26" align="right" background="beijing.jpg" bgcolor="#3D76AE"><font color="#FFFFFF">隐藏域的值：</font></td>
        <td background="beijing.jpg" bgcolor="#3D76AE"><font color="#FFFFFF">&nbsp;软件、图书</font>
          <input name="textThree" type="hidden" value="软件、图书"></td>
      </tr>
      <tr>
        <td height="26" colspan="2" align="center" background="beijing.jpg" bgcolor="#3D76AE"><input type="submit" name="Submit" value="提交"></td>
      </tr>
    </table>
  </form>
</div>
</body>
</html>
