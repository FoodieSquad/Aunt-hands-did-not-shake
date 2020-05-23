
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
<c:set value="${pageContext.request.contextPath}/image/successPaidPage/" var="imgpth" scope="page"/>
<c:set value="${pageContext.request.contextPath}/css/" var="csspth" scope="page"/>
<c:set value="${pageContext.request.contextPath}/view/" var="jsppth" scope="page"/>
<link rel="stylesheet" type="text/css" href="${csspth}cssForSuccessPaidPage.css">
</head>
<body>
    <script>
        $(document).ready(
    function(){

    	$("#back").click(function(){
    	    window.location.href="../home/test.do";
    	});
    });
        
        </script>
       <div class="mycontainer">    

    <!-- 标题组头部 -->
    <div id="d1">
        <!-- 返回符号.svg-->
        <img src="${imgpth}return.svg" id="back">
        <!--选择餐厅label-->
        <label style="">提交订单</label>
     </div>
<div id="d1_5">
    <!--p2 海南大学第五食堂-->
     <div id="d2">
        <p id="d2_p1">${verifyCode}</p>
        <p id="d2_p2">取餐号</p>
        <p id="d2_p3">订单编号：${orderNumber}</p>
     </div>
     <!--p3产品详情-->
     <div id="d3">
        <p>餐品详情</p>
        <br>
      <ul class="menu" id="ordermenu" style="list-style: none;width:300px;height:100px;overflow-y:auto;">
        <c:forEach items="${cartItemList}" var="cartItem">
        <li>${cartItem.dishId.dishName}<span class="menuspan"> ¥ ${cartItem.dishId.dishPrice} × ${cartItem.dishCount}</span></li>
        </c:forEach>
	</ul>
        <span id="d3_sp4">小计：¥</span>
        <span id="d3_sp5">${totalPrice}</span>
    </div>
  
    <!--p6联系方式-->
     <div id="d6">
        <span id="d6_s1">联系方式</span>
        <span id="d6_s2">${phoneNumber}</span>
     </div>
    

   
        

       </div>


</body></html>