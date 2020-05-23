
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
<c:set value="${pageContext.request.contextPath}/image/loginPage/" var="imgpth" scope="page"/>
<c:set value="${pageContext.request.contextPath}/css/" var="csspth" scope="page"/>
<c:set value="${pageContext.request.contextPath}/view/" var="jsppth" scope="page"/>
<link rel="stylesheet" type="text/css" href="${csspth}cssForLoginPage.css">
</head>
<body>
<!--容器-->
<div class="container">
<!--顶部页面属性与后退-->
<div class="headingBox"><img src="${imgpth}closebutton.svg" id="closebtn" class="closeButtonSize"/><label for="closebtn" class="headingText">手机登录/注册</label>
</div>
<!--logo图片-->
<div class="logoBox">
<img src="${imgpth}logo.svg" id="logoimg" class="logoSize"/>
</div>
<form style="margin-top: 52px;">
<!--电话号码-->
<div class="inputBox">
<input type="text" id="cellphonenumber" class="inputShape inputText" placeholder="请输入您的手机号" />
</div>
</form>
<!--附加提醒-->
<div class="addtionBox">
    <p class="additionText" onclick="call()" ><span style="font-size:20px;border:1px solid 	#D0D0D0;border-radius: 15px;padding:5px 100px;cursor: pointer;"><b>登录</b></span><br/><br/>登录/注册即代表同意<b>服务协议</b></p>
</div>
</div>
  <script type="text/javascript">
    function call(){
    var cellnum=document.getElementById("cellphonenumber").value;
    window.location.href="../typeCaptcha/test.do?cellnum="+cellnum;
    }
/*
//跳转到loginservlet：/Users/hmqhmq/Downloads/FOODIESQUAD/src/java/foodiesquad/servlet/loginServlet.java */
//当前：/Users/hmqhmq/Downloads/FOODIESQUAD/web/views/LoginPage/LoginPage.jsp
  </script>
</body>
</html>