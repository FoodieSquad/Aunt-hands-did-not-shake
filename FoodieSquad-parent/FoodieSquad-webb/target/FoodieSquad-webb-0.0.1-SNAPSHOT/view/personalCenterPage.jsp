
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
<c:set value="${pageContext.request.contextPath}/image/personalCenterPage/" var="imgpth" scope="page"/>
<c:set value="${pageContext.request.contextPath}/css/" var="csspth" scope="page"/>
<c:set value="${pageContext.request.contextPath}/view/" var="jsppth" scope="page"/>
<link rel="stylesheet" type="text/css" href="${csspth}cssForPersonalCenterPage.css"/>
</head>
<body>
<!--容器-->
<div class="container">
<!--顶部页面属性与后退-->
<div class="headingBox">
<div class="backButtonBox" onclick="javascript:history.back(-1);">
<img src="${imgpth}backbutton.SVG" id="backbtn" class="backButtonSize"
     />
</div>
<!--头像图片-->
<div class="logoBox">
<img src="${imgpth}logo.svg" id="logoimg" class="logoSize"/>
</div>
<div class="personalPanelBox">
<!--用户名-->
<div class="personalPanelTextBox">
<p class="personalPanelText">${userName}</p>
</div>
<!--大妈号-->
<div class="addtionBox">
<p class="additionText"><span style="font-family: PingFangSC-Semibold;
color: #8E8E93;
letter-spacing: 0;
text-align: center;
line-height: 34px;
font-size: 20px;
-webkit-font-smoothing: antialiased;
border: 1px solid  #d0d0d0ad;
border-radius: 15px;
padding: 5px 75px;
cursor: pointer;" onclick="window.location.href='logout.do'"><b>退出登录</b></span></p>
</div>
</div>
</div>
<div class="pageDispatcherBox">
<div class="myOrderListBox">
<img src="${imgpth}myorderlist.svg" id="myorderlistbtn" class="myOrderListImg" onclick="window.location.href='../myOrder/test.do'"/>
<br/>
<!--附加信息-->
<label for="myorderlistbtn" class="additionText" style="text-align:left;" onclick="window.location.href='../myOrder/test.do'">我的订单</label>
</div>
</div>
<!--版权信息-->
<div class="addtionBox">
<p class="additionText" style="margin-top:100px;">©️Foodie squad 大妈手不抖</p>
</div>
</div>
</body>
</html>