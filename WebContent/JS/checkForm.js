/**
 * RegExp ：正则表达式
 * 验证手机号码格式
 */
function checkregtel(regtel){
	var str = regtel;
	var Expression = /^13(\d{9})$|^15(\d{9})$/;
	var objExp = new RegExp(Expression);
	if(objExp.test(str)==true){
		return true;
	}else {
		return false;
	}
}

/**
 * RegExp ：正则表达式
 * 验证座机号码格式
 */
function checkregtels(regtels){
	var str = regtel;
	var Expression = /^(\d{3}-)(\d{8})$|^(\d{4}-)(\d{7})$|^(\d{4}-)(\d{8})$/;
	var objExp = new RegExp(Expression);
	if(objExp.test(str)==true){
		return true;
	}else {
		return false;
	}
}

/**
 * 对输入字段验证
 * @param form ：表单名
 * @param mark ：标记第几个
 */

function checkRegForm(form,mark){
	if(mark==0 || mark == "all"){
		if(form.recuser.value==""){
			chknew_recuser.innerHTML = "请输入用户名！";
			form.recuser.style.backgroundColor = "#FF0000";
			return false;
		}else{
			chknew_recuser.innerHTML = "";
			form.recuser.style.backgroundColor = "#FFFFFF";
		}
	}
	
	//*****************验证邮编**********************//
	if(mark==2 || mark==""){
		if(form.postalcode.value==""){
			chknew_postalcode.innerHTML = "请输入邮编！";
			form.postalcode.style.backgroundColor = "red";
			return false;
		}else if(isNaN(form.postalcode.value)){
			chknew_postalcode.innerHTML = "邮编由数字组成";
			form.postalcode.style.backgroundColor = "red";
			return false;
		}else if(form.postalcode.value.lenght != 6){
			chknew_postalcode.innerHTML = "邮编由6位数字组成！";
			form.postalcode.style.backgroundColor = "red";
			return false;
		}else {
			chknew_postalcode.innerHTML = "";
			form.postalcode.style.backgroundColor = "#FFFFFF";
		}
	}
	
	//*******************验证qq号**********************//
	if(mark==3 || mark==""){
		if(form.qq.value == ""){
			chknew_qq.innerHTML = "请输入qq号";
			form.qq.style.backgroundColor = "red";
			return false;
		}else if(isNaN(form.qq.value)){
			chknew_qq.innerHTML = "qq号由数字组成";
			form.qq.style.backgroundColor = "red";
			return false;
		}else{
			chknew_qq.innerHTML = "";
			form.qq.style.backgroundColor = "#FFFFFF";
		}
	}
	
	//****************验证Email**********************//
	if(mark==4 || mark=="all"){
		if(form.email.value == ""){
			chknew_email.innerHTML == "请输入Email地址！";
			form.email.style.backgroundColor = "red";
			return false;
		}else{
			var i=form.email.value.indexOf("@");
			var j=form.email.value.indexOf(".");
			if(i<0 || j<0 ||(i-j)>0){
				chknew_email.innerHTML = "email地址格式有误";
				form.email.style.backgroundColor = "red";
				return false;
			}else{
				 chknew_email.innerHTML="";
	             form.email.style.backgroundColor="#FFFFFF";
			}
		}
	}
	
	//*****************验证电话号码******************//
	if(mark==5 || mark=="all"){
        if(form.mtel.value==""){
            chknew_mtel.innerHTML="请输入电话号码！";
            form.mtel.style.backgroundColor="#FF0000";
            return false;
        }else if(!checkregtel(form.mtel.value)){
            chknew_mtel.innerHTML="电话号码的格式不正确！";
            form.mtel.style.backgroundColor="#FF0000";
            return false;
        }else if(isNaN(form.mtel.value)){
            chknew_mtel.innerHTML="电话号由数字组成！";
            form.mtel.style.backgroundColor="#FF0000";
            return false;
        }else{
            chknew_mtel.innerHTML="";
            form.mtel.style.backgroundColor="#FFFFFF";
        }
    }


    if(mark==6 || mark=="all"){
        if(form.gtel.value==""){
            chknew_gtel.innerHTML="请输入电话号码！";
            form.gtel.style.backgroundColor="#FF0000";
            return false;
        }else if(!checkregtels(form.gtel.value)){
            chknew_gtel.innerHTML="电话号码的格式不正确！";
            form.gtel.style.backgroundColor="#FF0000";
            return false;
        }else{
            chknew_gtel.innerHTML="";
            form.gtel.style.backgroundColor="#FFFFFF";
        }
    }
	
	
}