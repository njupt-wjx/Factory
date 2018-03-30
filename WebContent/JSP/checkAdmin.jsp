
<%@ page contentType="text/html; charset=GBK" language="java" import="java.sql.*" errorPage="" %>
<jsp:useBean class="com.factory.db.JDBCConnection" scope="page" id="conn"></jsp:useBean>
<%
String admin=new String(request.getParameter("admin").getBytes("ISO-8859-1"),"GBK");
System.out.println("用户名："+admin);
ResultSet rs=conn.executeQuery("select * from admin where Admin='"+admin+"'");
if (rs.next()){
	//out.println("很报歉!用户名["+admin+"]已经被注册!");
	out.print("存在");
}else{
	//out.println("祝贺您!用户名["+admin+"]没有被注册!");
}
%>