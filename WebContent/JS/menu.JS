

var menuOffX=0;		//菜单距连接文字最左端距离
var menuOffY=18;	//菜单距连接文字顶端距离
var fo_shadows=new Array();
var linkset=new Array();
var IE=document.all&&navigator.userAgent.indexOf("Opera")==-1;
var netscape6=document.getElementById&&!document.all;
var netscape4=document.layers;
//初始化要显示的菜单
function showmenu(e,vmenu,mod){
	if (!document.all&&!document.getElementById&&!document.layers)
		return
	which=vmenu;
	clearhidemenu();
	IE_clearshadow();
	menuobj=IE? document.all.popmenu : netscape6? document.getElementById("popmenu") : netscape4? document.popmenu : "";
	menuobj.thestyle=(IE||netscape6)? menuobj.style : menuobj;
	
	if (IE||netscape6)
		menuobj.innerHTML=which
	else{
		menuobj.document.write('<layer name="other" bgColor="#E6E6E6" width="165" onmouseover="clearhidemenu()" onmouseout="hidemenu()">'+which+'</layer>');
		menuobj.document.close();
	}
	menuobj.contentwidth=(IE||netscape6)? menuobj.offsetWidth : menuobj.document.other.document.width
	menuobj.contentheight=(IE||netscape6)? menuobj.offsetHeight : menuobj.document.other.document.height
	
	eventX=IE? event.clientX : netscape6? e.clientX : e.x
	eventY=IE? event.clientY : netscape6? e.clientY : e.y
	
	var rightedge=IE? document.body.clientWidth-eventX : window.innerWidth-eventX;
	var bottomedge=IE? document.body.clientHeight-eventY : window.innerHeight-eventY;
	if (rightedge<menuobj.contentwidth)
		menuobj.thestyle.left=IE? document.body.scrollLeft+eventX-menuobj.contentwidth+menuOffX : netscape6? window.pageXOffset+eventX-menuobj.contentwidth : eventX-menuobj.contentwidth
	else
		menuobj.thestyle.left=IE? IE_x(event.srcElement)+menuOffX : netscape6? window.pageXOffset+eventX : eventX
	
	if (bottomedge<menuobj.contentheight&&mod!=0)
		menuobj.thestyle.top=IE? document.body.scrollTop+eventY-menuobj.contentheight-event.offsetY+menuOffY-23 : netscape6? window.pageYOffset+eventY-menuobj.contentheight-10 : eventY-menuobj.contentheight
	else
		menuobj.thestyle.top=IE? IE_y(event.srcElement)+menuOffY : netscape6? window.pageYOffset+eventY+10 : eventY
	menuobj.thestyle.visibility="visible";
	IE_dropshadow(menuobj,"#999999",3);
	return false;
}
//计算y轴的坐标
function IE_y(e){  
	var t=e.offsetTop;  
	while(e=e.offsetParent){  
		t+=e.offsetTop;  
	}  
	return t;  
}  
//计算x轴的坐标
function IE_x(e){  
	var l=e.offsetLeft;  
	while(e=e.offsetParent){  
		l+=e.offsetLeft;  
	}  
	return l;  
}  
//显示菜单
function IE_dropshadow(el, color, size) {
	var i;
	for (i=size; i>0; i--){
		var rect = document.createElement('div');
		var rs = rect.style
		rs.position = 'absolute';
		rs.left = (el.style.posLeft + i) + 'px';
		rs.top = (el.style.posTop + i) + 'px';
		rs.width = el.offsetWidth + 'px';
		rs.height = el.offsetHeight + 'px';
		rs.zIndex = el.style.zIndex - i;
		rs.backgroundColor = color;
		var opacity = 1 - i / (i + 1);
		rs.filter = 'alpha(opacity=' + (100 * opacity) + ')';
		fo_shadows[fo_shadows.length] = rect;
	}
}
//清除显示
function IE_clearshadow(){
	for(var i=0;i<fo_shadows.length;i++){
		if (fo_shadows[i])
			fo_shadows[i].style.display="none"
	}
	fo_shadows=new Array();
}
//隐藏菜单
function hidemenu(){
	if (window.menuobj)
		menuobj.thestyle.visibility=(IE||netscape6)? "hidden" : "hide"
	IE_clearshadow()
}
//动态隐藏
function dynamichide(e){
	if (IE&&!menuobj.contains(e.toElement))
		hidemenu()
	else if (netscape6&&e.currentTarget!= e.relatedTarget&& !contains_netscape6(e.currentTarget, e.relatedTarget))
		hidemenu()
}
//延迟隐藏菜单
function delayhidemenu(){
	if (IE||netscape6||netscape4)
		delayhide=setTimeout("hidemenu()",100)
}
//停止延迟隐藏菜单
function clearhidemenu(){
	if (window.delayhide)
		clearTimeout(delayhide)
}
function highlightmenu(e,state){
	if (document.all)
		source_el=event.srcElement
	else if (document.getElementById)
		source_el=e.target
	if (source_el.className=="menuitems"){
		source_el.id=(state=="on")? "mouseoverstyle" : ""
	}
	else{
		while(source_el.id!="popmenu"){
			source_el=document.getElementById? source_el.parentNode : source_el.parentElement
			if (source_el.className=="menuitems"){
				source_el.id=(state=="on")? "mouseoverstyle" : ""
			}
		}
	}
}
//设置菜单背景
function overbg(tdbg){
tdbg.style.background='url(Images/item_over.gif)'
tdbg.style.border=' #9CA6C6 1px solid'
}
function outbg(tdbg){
tdbg.style.background='url(Images/item_out.gif)'
tdbg.style.border=''
}
var sysmenu='<table  width=80><tr><td bgcolor=#B3EE3A id=operationCondition onMouseOver=overbg(operationCondition) onMouseOut=outbg(operationCondition)><a href=#>细纱机运行状况</a></td></tr>\
<tr><td  bgcolor=#B3EE3A id=manager onMouseOver=overbg(manager) onMouseOut=outbg(manager)><a href=#>早晚班运行状况</a></td></tr>\
<tr><td bgcolor=#B3EE3A id=para onMouseOver=overbg(para) onMouseOut=outbg(para)><a href=JSP/processPara.jsp>工艺参数</a></td></tr>\
</table>'
var readermenu='<table width=80><tr><td bgcolor=#B3EE3A id=readerType onMouseOver=overbg(readerType) onMouseOut=outbg(readerType)><a href=JSP/daily.jsp>每日生产状况</a></td></tr>\
</table>'
var bookmenu='<table width=80><tr><td bgcolor=#B3EE3A id=bookType onMouseOver=overbg(bookType) onMouseOut=outbg(bookType)><a href=emplinfo.html>基础信息</a></td></tr>\
</table>'
var borrowmenu='<table width=80><tr><td bgcolor=#B3EE3A id=Borrow onMouseOver=overbg(Borrow) onMouseOut=outbg(Borrow)><a href=JSP/emptydb.jsp>清空数据库</a></td></tr>\
</table>'
var querymenu='<table width=80><tr><td bgcolor=#B3EE3A id=bookQuery onMouseOver=overbg(bookQuery) onMouseOut=outbg(bookQuery)><a href=JSP/login.jsp>重新登录</a></td></tr>\
<tr><td bgcolor=#B3EE3A id=borrowQuery onMouseOver=overbg(borrowQuery) onMouseOut=outbg(borrowQuery)><a href=#>用户设置</a></td></tr>\
<tr><td bgcolor=#B3EE3A id=givebackQuery onMouseOver=overbg(givebackQuery) onMouseOut=outbg(givebackQuery)><a href=JSP/login.jsp>系统退出</a></td></tr>\
</table>'
var sortmenu='<table width=80><tr><td bgcolor=#B3EE3A id=readerSort onMouseOver=overbg(readerSort) onMouseOut=outbg(readerSort)><a href=help.html>系统帮助</a></td></tr>\
</table>'
var aboutmenu='<table width=80><tr><td bgcolor=#B3EE3A id=aboutmenu onMouseOver=overbg(aboutmenu) onMouseOut=outbg(aboutmenu)><a href=about.html>关于</a></td></tr>\
</table>'