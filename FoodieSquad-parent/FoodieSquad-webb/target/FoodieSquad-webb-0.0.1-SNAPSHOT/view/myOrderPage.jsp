
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
<c:set value="${pageContext.request.contextPath}/image/myOrderPage/" var="imgpth" scope="page"/>
<c:set value="${pageContext.request.contextPath}/css/" var="csspth" scope="page"/>
<c:set value="${pageContext.request.contextPath}/view/" var="jsppth" scope="page"/>
<link rel="stylesheet" type="text/css" href="${csspth}cssForMyOrderPage.css"/>
</head>
	<body>
            <script>
         $(document).ready(
    function(){
// //         var menu="${sessionScope.menu}";
// //         var price="${sessionScope.totalPrice}";
//         var verifyCode="${sessionScope.verifyCode}";
//         $("#verifyCode").html(verifyCode);
    });
         </script>
		<!--容器-->
		<div class="container">
			<!--顶部页面标题*我的订单*与后退svg-->
			<div class="headingBox">
				<img src="${imgpth}returnbutton.svg" id="returnbtn" class="returnButtonSize"
                     onclick="javascript:history.back(-1);"/>
                                    
				<label class=" headingText">我的订单</label>
			</div>
			<!--正在进行的订单-->
			<!-- <div class="ModuleTitleBox">
				<p class="ModuleTitleText"><b>正在进行的订单</b></p>
			</div> -->
			<!--取餐号-->
			<div class="Takingfoodpanel">
				<br>
				<p class="Takingfoodnumber"id="verifyCode" ><b >${sessionScope.verifyCode}</b></p>
				<p class="Takingfoodtext" >取餐号</p>
				<p class="Takingfoodaddtion">请凭借取餐号到对应窗口取餐</p>
				<br>
			</div>
			
			
			
			
			<!--历史订单-->
			<div class="ModuleTitleBox">
				<p class="ModuleTitleText"><b>历史订单</b></p>
			</div>
			 <c:if test="${orderlist==null}">
		 您还没有历史订单哦！快去点餐吧～
		 </c:if>
       <c:if test="${orderlist!=null}">
       <c:set var="ddh" value="1" scope="page"></c:set>
       <div style="overflow-y: scroll;
    height: 527px;
    box-sizing: border-box;
    padding-left: 20px;">
			<c:forEach items="${orderlist}" var="order">
			  <p >您的${ddh}号订单为</p>
			   <div>
			     <p > 订单号：${order.orderId}</p>
				 <p > 起始时间：${order.orderStartTime}</p>
				 <p > 订单类型：${order.orderType }</p>
				 <p> 订单总价：${order.orderPrice}</p>
				 <p> 支付类型：${order.orderPayType}</p>
				 <p> 快递员号：${order.deliverId}</p>
			<c:forEach items="${historyItemlist}" var="historyitem">
			<c:if test="${historyitem.orderId==order.orderId}">
			<p> 菜名：${historyitem.dishId.dishName}</p>
			</c:if>
		
			</c:forEach>
				 
				 
			</div>
			
			
			<c:set var="ddh" value="${ddh+1}"></c:set>	
			<br>
			</c:forEach>
			
			</div>
			
		
			
		
		  </c:if>
       
			<!--订单详情-->
			<!--部分数据应通过服务器调用-->
			<%-- <div class="OrderHistorypanel">
				<div class="OrderHistoryBox">
					<div>
						<br>
						<label class="OrderHistoryText"><b>订单详情</b></label>
						<label class="OrderHistorydateplace">${order.orderStartTime}</label>
						<div class="clear"></div>
					</div>
					<hr>

                   
					<img src="${imgpth}1.jpg" id="img1" class="OrderHistoryimg" alt="">
					<label class="OrderHistoryfoodname">&nbsp;&nbsp;<b>麻婆豆腐</b></label>
					<label class="OrderHistoryamount1">&nbsp;&nbsp;<b> ￥</b><b>3.00</b></label>
					<br><br>
					<label class="OrderHistoryText">&nbsp;&nbsp;&nbsp;&nbsp;*<b>10</b></label>
					<label class="OrderHistoryamount1"><b> ￥</b><b>30.00</b></label>
					<br><br><div class="clear"></div>

                    <hr>
					<label class="OrderHistorynumber">订单编号：${order.orderId}</label>
					<label class="OrderHistoryamount2"><b>&nbsp;&nbsp;${order.orderPrice}</b></label>
					<label class="OrderHistoryamount1"><b>小计 ￥</b></label>
					<br>
				</div>
			</div> --%>
		</div>
	</body>
</html>

