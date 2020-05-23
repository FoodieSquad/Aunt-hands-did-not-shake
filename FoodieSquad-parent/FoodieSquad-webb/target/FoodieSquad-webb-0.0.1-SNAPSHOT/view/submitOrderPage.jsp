
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
<c:set value="${pageContext.request.contextPath}/image/submitOrderPage/" var="imgpth" scope="page"/>
<c:set value="${pageContext.request.contextPath}/css/" var="csspth" scope="page"/>
<c:set value="${pageContext.request.contextPath}/view/" var="jsppth" scope="page"/>
<link rel="stylesheet" type="text/css" href="${csspth}cssForSubmitOrderPage.css">
</head>
<body>
    <script>
    $(document).ready(
    	    function(){

    	  $("#d4_d1").click(
    	    function(){
    	        $("#im1").attr("src","${imgpth}homeb.svg");
    	        $("#im2").attr("src","${imgpth}homeblack.svg");
    	   $("#d4_d1").css(
    	   "background","rgba(61,126,255,0.28)" );
    	  $("#d4_d1").css("color","#3D7EFF" );
    	   $("#d4_d2").css("color","#C7C7CC" );
    	 $("#d4_d2").css("background", "#FFFFFF");
    	    }
    	    );

    	$("#d4_d2").click(
    	    function(){
    	        $("#d4_d2").css(
    	   "background", "rgba(61,126,255,0.28)"
    	            );
    	         $("#d4_d1").css(
    	   "background","#FFFFFF");
    	         $("#d4_d1").css("color","#C7C7CC" );
    	         $("#d4_d2").css("color","#3D7EFF" );

    	        $("#im2").attr("src","${imgpth}homeb.svg");
    	        $("#im1").attr("src","${imgpth}homeblack.svg");
    	    }
    	    );
    	$("#d7_s2").click(function(){
    	    window.location.href="/FOODIESQUAD/SubmitOrderingServlet?menu="+menu+"&totalPrice="+price;
    	});

    	$("#d5_d1").click(
    		    function(){
    		        $("#d5_d1").css(
    		   "background", "rgba(61,126,255,0.28)"
    		            );
    		         $("#d5_d2").css(
    		   "background","#FFFFFF");

    		    }
    		    );

    	$("#d5_d2").click(
    		    function(){
    		        $("#d5_d2").css(
    		   "background", "rgba(61,126,255,0.28)"
    		            );
    		         $("#d5_d1").css(
    		   "background","#FFFFFF");

    		    }
    		    );
    	});
function setOrderPayType(orderPayType){
	var PayType=document.getElementById("kkk");
	PayType.value=orderPayType;
	
}
</script>
       <div class="mycontainer">    

    <!-- 标题组头部 -->
    <div id="d1">
        <!-- 返回符号.svg-->
        <img src="${imgpth}return.svg" onclick="javascript:history.back(-1);">
        <!--选择餐厅label-->
        <label style="">提交订单</label>
     </div>
<div id="d1_5">
    <!--p2 海南大学第五食堂-->
     <div id="d2">
        <p id="d2_p1">${canteenName}</p>
        <p id="d2_p2">麻辣香锅店</p>
        <p id="d2_p3">订单编号：201927642187923749</p>
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
        <span id="d3_sp4">小计：</span>
        <span id="d3_sp5">¥ ${totalPrice}</span>
    </div>
    <!--p4就餐方式-->
    <form action="../successPaid/test.do" name="success">
    <input type="hidden" id="kkk" name="orderPayType">
    <div id="d4">
        <label id="d4_l">就餐方式</label>
        <br>
        <div id="d4_d1"><img id="im1"src="${imgpth}homeblack.svg">
                                  食堂就餐</div>
        <div id="d4_d2"><img id="im2"src="${imgpth}homeblack.svg">打包带走</div>
    </div>
    <!--p5支付方式-->
     <div id="d5">
        <label id="d5_l1">支付方式</label>
        <div id="d5_d1" style="padding:10px;border-radius:5px;"  onclick="setOrderPayType('微信')"><img src="${imgpth}wx.svg" style="margin: 0 auto;"></div>
        <div id="d5_d2" style="padding:10px;border-radius:5px;" onclick="setOrderPayType('支付宝')"><img src="${imgpth}zfb.svg" style="margin: 0 auto;"></div>
        
    </div>
    
    
    
    <!--p6联系方式-->
     <div id="d6">
        <span id="d6_s1">联系方式</span>
        <input type="text" placeholder="${userTele}" id="d6_s2"/>
      
     </div>
     <!--p7支付bar-->
     <div id="d7" onclick="document.success.submit()">
        <img id="d7_i1" src="${imgpth}money.svg">
        <span id="d7_s1">¥ <span id="d7_s3">${totalPrice}</span></span>
        <span id="d7_s2">去结算</span>
        <img id="d7_i2" src="${imgpth}moveon.svg">
     </div>
     </form>
</div>
     

   
        

       </div>


</body></html>
