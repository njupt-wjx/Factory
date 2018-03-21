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
<title>欢迎登录细纱机管理系统</title>
<link rel="stylesheet" type="text/css" href="CSS/style.css">
</head> 

<script  type="text/javascript">
	function checkEmpty(form){
		for(i=0;i<form.length;i++){
			if(form.elements[i].value==""){
				alert("用户名与密码不能为空");
				return false;
			}
		}
}
</script>

<body bgcolor="#BFEFFF">
<p align="center">&nbsp;</p>
<p align="center">&nbsp;</p>
<p align="center"><font color="#9A32CD" size="6">欢迎登录细纱机管理系统</font></p>
<p align="center">&nbsp;</p>
		<form name="form" action="LoginServlet" method="post" onsubmit="return checkEmpty(form)">
			<table background="images/bj.JPG" border="0" width="333" height="218" cellpadding="0" cellspacing="0" align="center">
				<tr>
					<td height="50">&nbsp;</td>
				</tr>
				<tr>
					<td align="center">管理员：</td>
					<td align="left"><input name="admin" type="text" size="20"></td>
				</tr> 
				 
				<tr>
					<td align="center">密码：</td>
					<td align="left"><input name="pwd" type="password" value="" size="20" ></td>
				</tr>
				<tr>
					<td align="center" colspan="2"><input name="login" type="submit" value="登录">&nbsp;&nbsp;&nbsp;
					<input name="reset" type="reset" value="重置"></td>
					
				</tr>
			</table>
		</form>
</body>
</html>