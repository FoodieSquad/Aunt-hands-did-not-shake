
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
<c:set value="${pageContext.request.contextPath}/image/registerPage/" var="imgpth" scope="page"/>
<c:set value="${pageContext.request.contextPath}/css/" var="csspth" scope="page"/>
<c:set value="${pageContext.request.contextPath}/view/" var="jsppth" scope="page"/>
<link rel="stylesheet" type="text/css" href="${csspth}cssForRegisterPage.css">
</head>
<body>
<!--容器-->
<div class="container">
<!--顶部页面属性与后退-->
<div class="headingBox"><img src="${imgpth}backbutton.SVG" id="closebtn" class="closeButtonSize" onclick="javascript:history.back(-1);"/><label for="closebtn" class="headingText">新用户注册</label>
</div>
<!--logo图片-->
<div class="logoBox">
<img src="${imgpth}logo.svg" id="logoimg" class="logoSize"/>
</div>
<form action="../register/submit.do">
<table>
            <tr>
                <td class="td_left"><label for="username">用户名</label></td>
                <td class="td_right"><input class="inputShape" type="text" name="username" id="username" placeholder="请输入用户名"></td>
            </tr>

            <tr>
                <td class="td_left"><label for="password">密码</label></td>
                <td class="td_right"><input class="inputShape" type="password" name="password" id="password" placeholder="请输入密码"></td>
            </tr>

            <tr>
                <td class="td_left"><label for="email">学号</label></td>
                <td class="td_right"><input class="inputShape" type="text" name="stunum" id="stunum" placeholder="请输入学号"></td>
            </tr>

            <tr>
                <td class="td_left"><label for="name">送货地址</label></td>
                <td class="td_right"><input class="inputShape" type="text" name="address" id="address" placeholder="请输入地址"></td>
            </tr>

            <tr>
                <td class="td_left"><label for="tel">手机号</label></td>
                <td class="td_right"><input class="inputShape" type="text" name="tel" id="tel" value="${userPhone}"></td>
            </tr>

            <tr>
                <td class="td_left"><label>性别</label></td>
                <td class="td_right">
                    <input type="radio" name="gender" value="m"> 男
                    <input type="radio" name="gender" value="f"> 女
                </td>
            </tr>

            <tr>
                <td colspan="2" align="center"><input class="submitShape" id="btn_sub" type="submit" value="注册"></td>
            </tr>
        </table>
</form>
<!--附加提醒-->
<div class="addtionBox">
    <p class="additionText" >登录/注册即代表同意<b>服务协议</b></p>
</div>
</div>
  <script type="text/javascript">
/*
//跳转到loginservlet：/Users/hmqhmq/Downloads/FOODIESQUAD/src/java/foodiesquad/servlet/loginServlet.java */
//当前：/Users/hmqhmq/Downloads/FOODIESQUAD/web/views/LoginPage/LoginPage.jsp
  </script>
</body>
</html>