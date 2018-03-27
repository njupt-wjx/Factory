/**
 * 计算相关工艺参数
 * 在processPara.jsp中使用
 */

function processPara(){
	var Rov = processParaForm.Rov.value;//粗纱定量
	var SpindleSpeed = processParaForm.txtSpindleSpeed.value;//锭速
	var MainShaftSpeed = processParaForm.txtMainShaftSpeed.value;//主轴
	var NfrSpeed = processParaForm.txtNfrSpeed.value;//前罗拉
	var NbrSpeed = processParaForm.txtNbrSpeed.value;//后罗拉
	var Tex = processParaForm.txtTex.value;//细纱号数
	var Dt =  processParaForm.txtDt.value;//牵伸倍数
	var T = processParaForm.txtT.value;//细纱捻度
	var P = processParaForm.txtP.value;//千锭产量
	
	
	if(Rov==""){
		alert("请填写粗纱定量！");
		return false;
	}
	if(processParaForm.txtNbrSpeed.value!=0){//牵伸倍数
		Dt = NfrSpeed / NbrSpeed;
		processParaForm.txtDt.value = Dt.toFixed(2);
	}
	if (Rov != "" && Dt != 0){//细纱号数
        Tex = Rov / Dt;
        processParaForm.txtTex.value = Tex.toFixed(2);
    }
	if (NfrSpeed != 0){//捻度
		var mySelect = document.getElementById("combDr").value;
        T = (1000*SpindleSpeed)/(3.14*mySelect*NfrSpeed);
        processParaForm.txtT.value = T.toFixed(2);
    }
	if (T!=0)
    {
        P = (SpindleSpeed * 60 * Tex * 1000) / (T * 1000 * 1000);//千锭小时产量
        processParaForm.txtP.value = P.toFixed(2);
    }
	
}

/*private void btnSave_Click(object sender, EventArgs e)
{
    if (NbrSpeed!=0.0)
    {
        Dt = NfrSpeed / NbrSpeed;
        txtDt.Text = Dt.ToString("0.00");//牵伸倍数,保留两位小数
    }
    else
    {
        txtDt.Text = "0.00";
    }
     ////////////////////////////////////
    if (txtRov.Text != "" && Dt != 0)
    {
        Tex = Double.Parse(txtRov.Text) / Dt;//细纱号数
        txtTex.Text = Tex.ToString("0.00");
    }
    else
    {
        txtTex.Text = "0.00";
    }
     ///////////////////////////////////
     if (NfrSpeed != 0)
     {
         T = (1000*SpindleSpeed)/(3.14*Double.Parse(combDr.Text)*NfrSpeed);//捻度
         txtT.Text = T.ToString("0.00");
     }
     else
     {
         txtT.Text = "0.00";
     }
     ////////////////////////////////////
     if (T!=0)
     {
         P = (SpindleSpeed * 60 * Tex * 1000) / (T * 1000 * 1000);//千锭小时产量
         txtP.Text = P.ToString("0.00");
     }
     else
     {
         txtP.Text = "0.00";
     }

 }*/