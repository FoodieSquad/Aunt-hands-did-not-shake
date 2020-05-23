
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
<c:set value="${pageContext.request.contextPath}/image/chooseFoodPage/" var="imgpth" scope="page"/>
<c:set value="${pageContext.request.contextPath}/css/" var="csspth" scope="page"/>
<c:set value="${pageContext.request.contextPath}/view/" var="jsppth" scope="page"/>
<link rel="stylesheet" type="text/css" href="${csspth}cssForChooseFoodPage.css">
<script>
$(document).ready(function(){
$("#d7_s2").click(function(){
var i=1;
var rs=new Array();
$(".cash").each(function(){
var num=$(this).find(".number").text();
num=parseInt(num);
if(num>0)
{
rs.push($(this).find(".dish_id").val());
rs.push(num);
}
i++;
});
var totalp=$("#totalPrice").text();
alert(rs+"\nTotal Price: "+$("#totalPrice").text());
var str = rs.join(',');
// $.post('/FOODIESQUAD/ChooseFoodServlet',{'menu':rs,'totalPrice':totalp});
window.location.href="submit.do?menu="+rs;
});
});
</script>
</head>
<body>
<!--容器-->
<div class="container">
<!--顶部页面属性与后退-->
<div class="headingBox" style="background-image:url(${imgpth}headbackimg.png);">
<!--后退按钮-->
<div class="backButtonBox">
<img src="${imgpth}backbutton.SVG" id="backbtn" class="backButtonSize"
     onclick="javascript:history.back(-1);"/><!-- 跳转修改 -->
</div>
<!--食堂信息-->
<div class="canteenInfoBox">
<div class="canteenInfoTextBox">
<p id="canteeninfo" class="canteenInfoText">${canteenName}</p>
<label for="canteeninfo" class="canteenTextReconmmendText">推荐：五谷鱼粉，麻辣香锅</label>
</div>
</div>
</div>

<!--吃货头条-->
<div class="foodieHeadingBox">
<img src="${imgpth}foodieheadingimg.png" id="foodieheading" class="foodieHeadingSize"/>
</div>
<!--点菜垂直分栏-->
<div class="orderSubfieldBox" style="height: 422px;">
<!--左侧餐点栏-->
<div class="tab"><!-- for loop -->
  <c:forEach items="${windowList}" var="window" varStatus="window_id">
<button class="tablinks" onclick="openCity(event, 'window${window_id.index}')" id="button${window_id.index}">${window.windowName}</button>
			</c:forEach>
</div>

<c:forEach items="${dishListList}" var="dishList" varStatus="dishList_id">
<div id="window${dishList_id.index}" class="tabcontent">
<c:forEach items="${dishList}" var="dish" varStatus="dish_id">
<div class="cash">
<table>
<tr height="40%">
<td rowspan="2" width="35%">
<!--菜肴图片-->
<img src="${imgpth}dishpic.svg" class="cashimg"/>
</td>
<!--菜肴名称-->
<td colspan="2" width="50%"><p  class="cashName">${dish.dishName}<input class="dish_id"type="hidden" value="${dish.dishId}"></p></td>
</tr>
<tr height="60%">
<!--菜肴单价和数量-->
<td width="30%" style="align:left;"><label  class="price"><small>¥ </small><span id="price_${dishList_id.index}_${dish_id.index}">${dish.dishPrice}</span></label></td>
<td width="70%"><img  src="${imgpth}minusbutton.svg" onclick="minus('cashnum_${dishList_id.index}_${dish_id.index}','price_${dishList_id.index}_${dish_id.index}')"/> &nbsp <label id="cashnum_${dishList_id.index}_${dish_id.index}" class="number">0</label> &nbsp <img onclick="plus('cashnum_${dishList_id.index}_${dish_id.index}','price_${dishList_id.index}_${dish_id.index}')" src="${imgpth}plusbutton.png"/></td>
</tr>
</tr>
</table>  
</div>
			</c:forEach>
</div>
			</c:forEach>
<!-- temp1.1 -->
<!--结算栏-->
<div class="settleAccountBox" style="	margin-top:347px;">
<div id="d7">
        <img id="d7_i1" src="${imgpth}money.svg">
        <span id="d7_s1">¥ <span id="totalPrice">0</span></span>
        <span id="d7_s2">去结算</span>
        <img id="d7_i2" src="${imgpth}moveon.svg">
</div>
</div>
</div>
<script>
function openCity(evt, cityName) {
    var i, tabcontent, tablinks;
    tabcontent = document.getElementsByClassName("tabcontent");
    for (i = 0; i < tabcontent.length; i++) {
        tabcontent[i].style.display = "none";
    }
    tablinks = document.getElementsByClassName("tablinks");
    for (i = 0; i < tablinks.length; i++) {
        tablinks[i].className = tablinks[i].className.replace(" active", "");
    }
    document.getElementById(cityName).style.display = "block";
    evt.currentTarget.className += " active";
}
function plus(name,price){
	var lab=document.getElementById(name);
	var num=parseInt(lab.innerHTML);
	num+=1;
	lab.innerHTML=""+num;
	var total=document.getElementById("totalPrice").innerHTML;
	var addprice=document.getElementById(price).innerHTML;
	var newTotal=eval(total+"+"+addprice);
	newTotal = newTotal.toFixed(2);
	document.getElementById("totalPrice").innerHTML=newTotal;
}
function minus(name,price){
	var lab=document.getElementById(name);
	var num=parseInt(lab.innerHTML);
	if(num>0)
	{
	num-=1;
	lab.innerHTML=""+num;
		var total=document.getElementById("totalPrice").innerHTML;
	var addprice=document.getElementById(price).innerHTML;
	var newTotal=eval(total+"-"+addprice);
	newTotal = newTotal.toFixed(2);
	document.getElementById("totalPrice").innerHTML=newTotal;
	}
}
// 触发 id="defaultOpen" click 事件
document.getElementById("button0").click();
</script>
</body>
</html>