<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath %>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>获取文本框/编辑框/隐藏域的值</title>
</head>
<body background="images/beijing.jpg">
	<form name="form1" action="JSP/dealwith.jsp" method="post" onSubmit="">
		<table width="377" border="1" cellpadding="1" cellspacing="1">
			<tr>
				<td colspan="2" align="center">获取文本框/编辑框/隐藏域的值</td>
			</tr>
			<tr>
				<td align="center" height="20" width="111"><font color="#FFFFFF">文本字段：</font></td>
				<td width="256"><input name="textOne" align="middle" type="text"></td>
			</tr>
			<tr>
				<td align="center" height="20" width="111"><font color="#FFFFFF">文本区域:</font></td>
				<td><textarea name="textTwo" cols="30" rows="8"></textarea></td>
			</tr>
			<tr>
				<td align="center" height="20" ><font color="#FFFFFF">隐藏域的值:</font></td>
				<td align="center" height="20" ><font color="#FFFFFF">&nbsp;软件、图书</font></td>
				<td><input name="textThree" type="hidden" value="软件、图书"></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input name="Submit" type="submit" value="提交"></td>
			</tr>
		</table>
	
	</form>

</body>
</html>