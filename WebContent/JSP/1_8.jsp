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
<title>限制文本域输入字符个数</title>
<link rel="stylesheet" type="text/css" href="CSS/style1">
</head>

<script type="text/javascript">
function check(){
	if(form1.content.value==""){
		alert("留言内容不允许为空！");form1.content.focus();return;
	}
	form1.submit();
}
</script>
<SCRIPT type=text/JavaScript>

var LastCount =0;
function CountStrByte(Message,Total,Used,Remain){ //字节统计
 var ByteCount = 0;
 var StrValue  = Message.value;
 var StrLength = Message.value.length;
 var MaxValue  = Total.value;

 if(LastCount != StrLength) { // 在此判断，减少循环次数
	for (i=0;i<StrLength;i++){
		ByteCount  = (StrValue.charCodeAt(i)<=256) ? ByteCount + 1 : ByteCount + 2;
      if (ByteCount>MaxValue) {
      	Message.value = StrValue.substring(0,i);
			alert("留言内容最多不能超过 " +MaxValue+ " 个字节！\n注意：一个汉字为两字节。");
         ByteCount = MaxValue;
         break;
      }
	}
   Used.value = ByteCount;
   Remain.value = MaxValue - ByteCount;
   LastCount = StrLength;
 }
}

</SCRIPT>
<body>
	<div id="toolTipLayer" style="visibility: hidden;position: absolute;">&nbsp;</div>
	
	<table width="777" height="341" border="1" align="center" cellpadding="-2" cellspacing="-2" class="tableBorder">
		<tr bgcolor="#9CA6C6">
			<td height="8"></td>
		</tr>
		<tr>
			<td></td>
		</tr>
		<tr>
			<td height="2"></td>
		</tr>
		<tr>
			<td valign="top">
				<table width="100%" height="205" border="0" cellpadding="-2" cellspacing="-2" class="tableBorder">
					<tr>
						<td width="13" height="32" background="images/board_left.gif">&nbsp;</td>
						<td width="689" background="images/board_left.gif" style="color:#FFFFFF"> ≡ 签写留言=</td>
						<td width="73" background="images/board_right.gif">&nbsp;</td>
					</tr>
					<tr valign="top">
          <td height="171" colspan="3"><table width="100%" height="129"  border="0" cellpadding="-2" cellspacing="-2">
            <tr>
              <td valign="top">
	  			  <table width="100%" height="292"  border="0" cellpadding="-2" cellspacing="-2" class="tableBorder_Top">
			  <tr>
			  <td height="5"></td>
			  </tr>
                <tr>
                  <td width="236" height="263" valign="top"><div align="center">
                    <p>
                       === 留言人信息 ===<br>
                      明日科技</p>


                    <p>我是：开发团队</p>
                    <p>
                        <img src="images/email.gif" alt="的Email是：" width="16" height="16"> ********</p>
                    <p>
					    <img src="images/oicq.gif" alt="的QQ号码是：" width="16" height="16"> QQ:*********</p>
                    <p>
					      <img src="images/ip.gif" alt="IP为：" width="16" height="15"> IP：192.168.1.59</p>
                  </div></td>
                  <td width="1" background="images/line.gif"></td>
                  <td width="532" valign="top">
				  <form action="" method="post" name="form" onsubmit=" return check">
				  <table width="100%"  border="0" cellspacing="-2" cellpadding="-2">
                    <tr>
                      <td width="11%" height="90" align="center">表情：</td>
                      <td width="89%"><INPUT name=emote type=radio class="noborder" value=0 checked>
                        <IMG height=20 
            src="images/Face/face0.gif" width=20 align=middle border=0>
                        <INPUT name=emote type=radio class="noborder" value=1>
                        <IMG height=19 
            src="images/Face/face1.gif" width=19 align=middle border=0>
                        <INPUT name=emote type=radio class="noborder" value=2>
                        <IMG height=20 
            src="images/Face/face2.gif" width=20 align=middle border=0>
                        <INPUT name=emote type=radio class="noborder" value=3>
                        <IMG height=20 
            src="images/Face/face3.gif" width=20 align=middle border=0>
                        <INPUT name=emote type=radio class="noborder" value=4>
                        <IMG height=20 
            src="images/Face/face4.gif" width=20 align=middle border=0>
                        <INPUT name=emote type=radio class="noborder" value=5>
                        <IMG height=20 
            src="images/Face/face5.gif" width=20 align=middle border=0>
                        <INPUT name=emote type=radio class="noborder" value=6>
                        <IMG height=20 
            src="images/Face/face6.gif" width=20 align=middle border=0>
                        <INPUT name=emote type=radio class="noborder" value=7>
                        <img height=20 
            src="images/Face/face7.gif" width=20 align=middle border=0><br>
                        <INPUT name=emote type=radio class="noborder" value=8>
                        <IMG height=20 
            src="images/Face/face8.gif" width=20 align=middle border=0>
                        <INPUT name=emote type=radio class="noborder" value=9>
                        <IMG height=20 
            src="images/Face/face9.gif" width=20 align=middle border=0> 
			            <INPUT name=emote type=radio class="noborder" value=10>
                        <IMG height=20 
            src="images/Face/face10.gif" width=20 align=middle border=0>
                        <INPUT name=emote type=radio class="noborder" value=11>
                        <IMG height=20 
            src="images/Face/face11.gif" width=20 align=middle border=0>
                        <INPUT name=emote type=radio class="noborder" value=12>
                        <IMG height=20 
            src="images/Face/face12.gif" width=20 align=middle border=0>
                        <INPUT name=emote type=radio class="noborder" value=13>
                        <IMG height=20 
            src="images/Face/face13.gif" width=20 align=middle border=0>
                        <INPUT name=emote type=radio class="noborder" value=14>
                        <IMG height=20 
            src="images/Face/face14.gif" width=20 align=middle border=0>
                        <INPUT name=emote type=radio class="noborder" value=15>
                        <img height=20 
            src="images/Face/face15.gif" width=20 align=middle border=0><br>
                        <INPUT name=emote type=radio class="noborder" value=16>
                        <IMG height=20 
            src="images/Face/face16.gif" width=20 align=middle border=0>
                        <INPUT name=emote type=radio class="noborder" value=17>
                        <IMG height=20 
            src="images/Face/face17.gif" width=20 align=middle border=0>
                        <INPUT name=emote type=radio class="noborder" value=18>
                        <IMG height=20 
            src="images/Face/face18.gif" width=20 align=middle border=0>
                        <INPUT name=emote type=radio class="noborder" value=19>
                        <IMG height=19 
            src="images/Face/face19.gif" width=19 align=middle border=0>
                        <INPUT name=emote type=radio class="noborder" value=20>
                        <IMG height=19 
            src="images/Face/face20.gif" width=19 align=middle border=0>
                        <INPUT name=emote type=radio class="noborder" value=21>
                        <IMG height=19 
            src="images/Face/face21.gif" width=19 align=middle border=0>
                        <INPUT name=emote type=radio class="noborder" value=22>
                        <IMG height=19 
            src="images/Face/face22.gif" width=19 align=middle border=0>
                        <INPUT name=emote type=radio class="noborder" value=23>
                        <IMG height=19 
            src="images/Face/face23.gif" width=19 align=middle border=0></td>
                    </tr>
           
                    <tr>
                      <td height="145" align="center">留言：</td>
                      <td><textarea name="content" cols="50" rows="9" class="wenbenkuang" id="content" onKeyDown="CountStrByte(this.form.content,this.form.total,this.form.used,this.form.remain);"
					    onkeyup="CountStrByte(this.form.content,this.form.total,this.form.used,this.form.remain);"></textarea></td>
                    </tr>
                    <tr>
                      <td height="33" align="center" style="padding-left:10px"><p>字节：</p>                        </td>
                      <td style="padding-left:10px" class="word_grey">最多允许 
                        <input name="total" type="text" disabled class="noborder" id="total"  value="1600" size="4"> 
                        个字节 已用字节：&nbsp;
                        <input name="used" type="text" disabled class="noborder" id="used"  value="0" size="4">                        
                        剩余字节：
                        <input name="remain" type="text" disabled class="noborder" id="remain" value="1600" size="4">
                        <input name="HIP" type="hidden" id="HIP" value=""></td>
                    </tr>
                    <tr>
                      <td height="34" align="center" style="padding-left:10px">&nbsp;</td>
                      <td class="word_grey"><input name="Button" type="button" class="btn_grey" value="提交留言">                          
                        <input name="Submit2" type="reset" class="btn_grey" value="重写留言"></td></tr>
                  </table>
				    </form>
				  
				
				  </td>
                </tr>
                <tr>
                  <td valign="top"></td>
                  <td background="images/line.gif"></td>
                  <td>&nbsp;</td>
                </tr>
				<tr>
				<td height="5"></td>
				</tr>
              </table>			  </td>
            </tr>
          </table>
		  </td>
        </tr>
				</table>
				<table width="777" height="89" border="0" align="center" cellpadding="-2" cellspacing="-2">
  					<tr>
    					<td align="center"><div align="center" style="color:#666666 ">本站请用IE5.0或以上版本浏览，1024*768为最佳效果<br>
  							CopyRight &copy; 2018 南京邮电大学</div></td>
  					</tr>
				</table>
</td>
</tr>
</table>
</body>
</html>