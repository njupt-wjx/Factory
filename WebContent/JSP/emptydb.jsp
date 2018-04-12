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
<title>清空数据库</title>
</head>

<jsp:useBean id="connection" scope="page" class="com.factory.db.JDBCConnection"></jsp:useBean>
<script type="text/javascript">
	function Delete(){
		<%
			response.setCharacterEncoding("utf-8");
			String[] tables = request.getParameterValues("checkbox");
			if(tables!=null){
				for(int i=0;i<tables.length;i++){
					String sql = "delete from "+tables[i] + " where Date < DATE_SUB(curdate() , interval 6 month)";
					connection.deleteDatabase(sql);
				}
				connection.closeConnection();
				out.println("<script>window.alert('成功清空数据库!');</script>");//中文乱码
			}
		%>
	}
</script>
<body>
<form name="emptydbform" method="post" action="EmptydbServlet">
	<table>
		<%
		ResultSet rs = connection.getTables("show tables");
		while(rs.next()){
       %>
       <tr>
        <td height="22" bgcolor="#CCFF66">
        <input type="checkbox" name="checkbox" value="<%=rs.getString(1) %>"><%=rs.getString(1) %></td>
      </tr>
      <% 
      
      }
		rs.close();
	    connection.closeConnection();
      %>
    
    <tr>
      <td bgcolor="#66CCFF"><div align="center">
        <input type="submit" name="Submit" value="删除">
      </div></td>
    </tr>
	</table>


</form>
</body>
</html>