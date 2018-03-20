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
<title>获取单选按钮的值</title>
</head>
<script type="text/javascript">
	function checkEmpty(){
			var objs=document.getElementsByName('radioButton');
			var isSel=false;//判断是否有选中项，默认为无selected
			for(var i=0;i<objs.length;i++){
			  if(objs[i].checked){
			    	isSel=true;
			    	break;
			   }
			}
			if(isSel==false){
				alert("请选择科目！"); 
				return false;
			}else{
			return true;
			}	
	}
</script>

<%String[] evalution = new String[]{"A","B","C","D"}; %>
<body>
	<div align="center">
		<form name="form" action="JSP/dealwith.jsp" method="post" onsubmit="return checkEmpty()">
			<table width="276" border="1">
				<tr>
					<td width="266" align="left">请您对本视频作出评价：</td>
				</tr>
				<%
					for(int i=0;i<evalution.length;i++){
				%>
				<tr>
					<td><input align="left" name="radioButton"  type="radio" value="<%=evalution[i] %>"><%=evalution[i]%></td>
				</tr>
					<% }%>
				<tr>
					<td><input name="submit" type="submit" value="提交"></td>
				</tr>
			
				
			</table>
		</form>
		
	</div>
</body>
</html>