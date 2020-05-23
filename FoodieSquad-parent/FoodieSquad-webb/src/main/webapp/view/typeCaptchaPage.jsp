
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1.0,user-scalable=no">
<script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<c:set value="${pageContext.request.contextPath}/image/typeCaptchaPage/" var="imgpth" scope="page"/>
<c:set value="${pageContext.request.contextPath}/css/" var="csspth" scope="page"/>
<c:set value="${pageContext.request.contextPath}/view/" var="jsppth" scope="page"/>
<link rel="stylesheet" type="text/css" href="${csspth}cssForTypeCaptchaPage.css">
<script>
$(document).ready(
	    function(){

	  $(".inputBox").click(
	    function(){
	    	$("#verificationcode").focus();
	    }
	    );

	});
function enterVerificationcode(val,obj){
	var list = document.getElementById("enterUL").getElementsByTagName("li");
	var len=val.length;
        
    for(var i = 0; i < list.length; i++) {
            
			if(i<len){
				list[i].classList.add("active");
				list[i].innerHTML=val.charAt(i);
			}
			else{
				list[i].classList.remove("active");
				list[i].innerHTML="";
			}

        }
        if(len==4)
        {
            if(val==${verifyCode})
            {
                alert("Success");
                window.location.href="../login/verifyuser.do?userphone=${cellnum}";
//                 window.location.href="/FOODIESQUAD/UserServlet";
               
            }
            else
            {
                alert("Failed");
            }
        }
        obj.focus();
      　　var len = obj.value.length;
      　　if (document.selection) {
          　　var sel = obj.createTextRange();
          　　sel.moveStart('character',len);
          　　sel.collapse();
          　　sel.select();
     	
      　　} else if (typeof obj.selectionStart == 'number' && typeof obj.selectionEnd == 'number') {
          　　obj.selectionStart = obj.selectionEnd = len;
     	
      　　　　}
		
}
</script>
</head>
<body>
<!--容器-->
<div class="container">
<!--顶部页面属性与后退-->
<div class="headingBox"><img src="${imgpth}backbutton.SVG" id="backbtn" class="backButtonSize" onclick="javascript:history.back(-1);"/>
</div>
<!--首部文本-->
<div class="topTextBox">
<p class="topText">输入验证码</p>
</div>
<!--附加提醒-->
<div class="addtionBox">
<p class="additionText">验证码已发送至...</p>
</div>
<form>
<!--输入验证码-->
<div class="inputBox" >

  <div class="verificationCode">
   <input id="verificationcode" type="tel" maxlength="4" pattern="d*" autocomplete="off"	class="verificationCodeInput" autofocus="autofocus" onkeyup="enterVerificationcode(this.value,this)"/>
   <ul id="enterUL" class="verificationCodeText">
    <li class="active"><i></i></li>
    <li><i></i></li>
    <li><i></i></li>
    <li><i></i></li>
   </ul>
  </div>

</div>
</form>
<!--附加提醒-->
<div class="addtionBox">
<p class="additionText">收不到验证码？</p>
</div>
</div>

</body>
</html>