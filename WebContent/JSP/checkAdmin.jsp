
<%@ page contentType="text/html; charset=GBK" language="java" import="java.sql.*" errorPage="" %>
<jsp:useBean class="com.factory.db.JDBCConnection" scope="page" id="conn"></jsp:useBean>
<%
String admin=new String(request.getParameter("admin").getBytes("ISO-8859-1"),"GBK");
System.out.println("�û�����"+admin);
ResultSet rs=conn.executeQuery("select * from admin where Admin='"+admin+"'");
if (rs.next()){
	//out.println("�ܱ�Ǹ!�û���["+admin+"]�Ѿ���ע��!");
	out.print("����");
}else{
	//out.println("ף����!�û���["+admin+"]û�б�ע��!");
}
%>