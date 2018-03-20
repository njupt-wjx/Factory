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

<script type="text/javascript">
	function checkEmpty(form){
		for(var i=0;i<form.length;i++){
			if(form.elements[i].value==""){
				alert("请选择");
				return false;
			}
		}
	}
</script>
</head>
<body>
	<div align="center">
		<form name="form" action="JSP/dealwith1_4.jsp" method="post" onsubmit="return checkEmpty(form)">
			<table width="256" bgcolor="#FFF000" border="1">
				<tr>
					<th>请选择图书：</th>
				</tr>
				<tr>
					<td>
						<select name="select" >
							<option>请选择</option>
							<option value="JSP数据库开发手册">JSP数据库开发手册</option>
							<option value="JSP案例精选">JSP案例精选</option>
							<option value="JSP技术大全">JSP技术大全</option>
							<option value="A">A</option>
							<option value="B">B</option>
							<option value="C">C</option>
						</select>
					</td>
				</tr>
				<tr>
					<td><input name="submit" type="submit" value="提交"></td>
				</tr>
			</table>
		</form>
	</div>

</body>
</html>


