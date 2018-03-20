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
<title>选择下拉列表/菜单的内容</title>
</head>
<%request.setCharacterEncoding("utf-8"); %>
<body>
	<div align="center">
		<form>
			<table width="256" bgcolor="#FFF000" border="1">
				<tr>
					<th>选择图书是：</th>
				</tr>
				<tr>
					<td><%=request.getParameter("select") %></td>
				</tr>
			</table>
		</form>
	</div>

</body>
</html>


