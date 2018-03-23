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
<title>定义文本框、下拉列表和按钮的样式</title>
<link rel="stylesheet" type="text/css" href="CSS/style.css">
</head> 

<body >
		<form name="form" action="" method="post" >
			<table background="images/bj.JPG" border="0" width="333" height="218" cellpadding="1" cellspacing="1" align="center">
				<tr>
					<td height="30">&nbsp;</td>
				</tr>
				<tr>
					<td align="center">管理员:</td>
					<td align="left"><input name="admin" type="text"></td>
				</tr> 
				 <tr>
					<td align="center">权限:</td>
					<td align="left">
						<select name="select">
							<option>员工管理员</option>
							<option>经理管理员</option>
							<option>super管理员</option>
						</select>
					</td>
				</tr> 
				<tr>
					<td align="center">密码：</td>
					<td align="left"><input name="pwd" type="password" value="请输入密码" maxlength="20"></td>
				</tr>
				<tr>
					<td align="center" colspan="2"><input name="login" type="submit" value="登录">&nbsp;&nbsp;&nbsp;
					<input name="reset" type="reset" value="重置"></td>
					
				</tr>
			</table>
		</form>
</body>
</html>