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
<title>无刷新验证文本框的值</title>

</head>

<script type="text/javascript" src="JS/checkForm.js"></script>
<body >
	<table width="1014" height="706" border="1" align="center" cellpadding="0" cellspacing="0" background="">
  <tr>
    <td width="133" height="228">&nbsp;</td>
    <td width="750">&nbsp;</td>
    <td width="113">&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td align="center" valign="top"><form name="form_reg" method="post" action="Check_UserInfo" onSubmit="return chkreginfo(form_reg,'all')">
      <table width="620" height="262" border="1" align="center" cellpadding="0" cellspacing="0">
			
                <tr>
                  <td width="200" height="30"><div align="center">用户名：</div></td>
                  <td colspan="3">&nbsp;<input type="text" name="recuser" size="20" class="inputcss" onBlur="checkRegForm(form_reg,0)"><div id="chknew_recuser" style="color:#FF0000"></div></td>
                </tr>
				
                <tr>
                  <td height="30"><div align="center">详细联系地址：</div></td>
                  <td height="30" colspan="3">&nbsp;<input type="text" name="address" size="60" class="inputcss" onBlur="checkRegForm(form_reg,1)"><div id="chknew_address" style="color:#FF0000"></div></td>
                </tr>
                <tr>
                  <td height="30"><div align="center">邮政编码：</div></td>
                  <td height="30" colspan="3">&nbsp;<input type="text" name="postalcode" size="20" class="inputcss" onBlur="checkRegForm(form_reg,2)"><div id="chknew_postalcode" style="color:#FF0000"></div></td>
                </tr>
				<tr>
                  <td height="30"><div align="center">QQ号码：</div></td>
                  <td height="30" colspan="3">&nbsp;<input type="text" name="qq" size="20" class="inputcss" onBlur="checkRegForm(form_reg,3)"><div id="chknew_qq" style="color:#FF0000"></div></td>
                </tr>
				<tr>
                  <td height="30"><div align="center">E-mail：</div></td>
                  <td height="30" colspan="3">&nbsp;<input type="text" name="email" size="20" class="inputcss" onBlur="checkRegForm(form_reg,4)"><div id="chknew_email" style="color:#FF0000"></div></td>
                </tr>
                <tr>
                  <td height="30">&nbsp;</td>
                  <td height="30" colspan="3">&nbsp;<font color="#FF0000">*</font>&nbsp;<font color="#999999">请务必正确填写您的联系地址和邮编，以确保订单和货物顺利达到！</font></td>
				</tr>
                <tr>
                  <td height="30"><div align="center">移动电话：</div></td>
                  <td width="200" >&nbsp;<input  align="middle" type="text" name="mtel" size="20" class="inputcss" onBlur="checkRegForm(form_reg,5)"><div id="chknew_mtel" style="color:#FF0000"></div></td>
                  <td width="200"><div align="center">固定电话：</div></td>
                  <td width="343">&nbsp;<input type="text" name="gtel" size="20" class="inputcss" onBlur="checkRegForm(form_reg,6)"><div id="chknew_gtel" style="color:#FF0000"></div></td>
                </tr>
                <tr>
                  <td height="30">&nbsp;</td>
                  <td height="30" colspan="2"><input type="image"  src="images/form(2).jpg">
    &nbsp;&nbsp;<img src="images/form.jpg" width="72" height="26" onClick="form_reg.reset()" style="cursor:hand"/></td>
                  <td>&nbsp;</td>
                </tr>
        </table>
</form></td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
</table>

</body>
</html>