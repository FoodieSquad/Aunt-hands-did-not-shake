<%-- 
    Document   : chooseCanteenPage
    Created on : 2019-12-18, 20:00:01
    Author     : hmqhmq
--%>

<%-- <%@page import="foodiesquad.entity.Canteen"%>
<%@page import="foodiesquad.service.serviceimpl.CanteenServiceImpl"%>
<%@page import="foodiesquad.service.CanteenService"%>
<%@page import="foodiesquad.entity.Menu"%> --%>
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
<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=··············"></script> 
<script type="text/javascript" src="http://developer.baidu.com/map/jsdemo/demo/convertor.js"></script> 
<c:set
	value="${pageContext.request.contextPath}/image/chooseCanteenPage/"
	var="imgpth" scope="page" />
<c:set value="${pageContext.request.contextPath}/css/" var="csspth"
	scope="session" />
<c:set value="${pageContext.request.contextPath}/view/" var="jsppth"
	scope="session" />
<link rel="stylesheet" type="text/css" href="${csspth}cssForCCP.css">

</head>
<body>

<div class="mycontainer">

<div id="overlay" class="mask"></div>    


<div id="model">  
<div id="content">
<p ><img src="${imgpth}home.svg">&nbsp;&nbsp;<span id="p1">海南大学食堂</span></p>
<p class="text_recommand"><span>推荐:</span> <span id="q2">canteenName</span></p>
<label class="text_canteenBusy">! 餐厅密集，请注意区分。</label>
<form action="../chooseFood/test.do" method="post" name="chooseform" style="background: #FFFFFF;width: 355px;height:200px;">
<input type="hidden" id="www" name="canteenId">
<input type="hidden" id="kkk" name="orderType">
<p name="xzdc" id="op1" onmouseover="$(this).css('color','blue');" onmouseout=" $(this).css('color','grey');" onclick="setorderType('堂食')"> <img src="${imgpth}unchecked.svg" name="im" id="im1"> 现在点餐 支付成功后取餐 <span>Now</span></p>
<p name="xzdc" id="op2" onmouseover="$(this).css('color','blue');" onmouseout=" $(this).css('color','grey');" onclick="setorderType('外卖')"> <img src="${imgpth}unchecked.svg" name="im" id="im2" >&nbsp;预约点餐 到食堂后取餐<span>Later</span> </p>
<p id="jcfs">请选择就餐方式:</p>
<div name="jcfs">
<div id="no1" onmouseover="$(this).find('span').css('color','blue');" onmouseout=" $(this).find('span').css('color','grey');"> <img src="${imgpth}cloud.svg">  <span onclick="document.chooseform.submit();">食堂就餐</span> <span name="sp">Dine in</span> </div>
<div id="no2" onmouseover="$(this).find('span').css('color','blue');" onmouseout=" $(this).find('span').css('color','grey');"> <img src="${imgpth}cloud.svg"> <span onclick="document.chooseform.submit();">打包带走</span> <span name="sp">Take Away</span> </div>
</div>
</form>
</div>
</div>


<!-- 标题组头部 -->
<div class="bg_1 text_title ">
		<!-- 返回符号.svg-->
		<img id="img1" src="${imgpth}return.svg"
			onclick="javascript:history.back(-1);">
		<!--选择餐厅label-->
		<label style="padding-bottom: 4px;">选择餐厅</label>
</div>
<form action="testsearch.do" name="searchform">
	<!-- 搜索区 -->
	<div class="searchBar">
		<!--搜索框 搜索bar/下拉菜单-->
		<div class="search">
			<!-- 海南大学 徽章-->
			<label class="text_HNU">海南大学<img src="${imgpth}path.svg"></label>
			
              <input type="text" class="text_label"
				placeholder="搜索菜名/食堂名" list="canteensForChoose" name="searchtext"/>
			<datalist id="canteensForChoose">
				<c:forEach items="${canteenlist}" var="canteen">
					<option value="${canteen.canteenName}">
				</c:forEach>
			</datalist>

		<span onclick="document.searchform.submit()"> <img src="${imgpth}searchicon.svg">
			</span>
</form>

<div style="padding-left: 10px;">
<!--海大食堂title-->
<div class="text_canteen">
			<!--标签：海大食堂-->
			<label>海大食堂</label>
			<!--tab-->
			<hr class="tab"></hr>

</div>
<!--食堂-->
<div id="fujin" class="fujinBox"  style="overflow-y: scroll; height: 100px; box-sizing: border-box;">
<!--label:0.15公里-->
<!-- label:推荐-->
<label class="text_canteenBusy">&nbsp;&nbsp;! 餐厅密集，请注意区分。</label><br/>
<label class="text_nearby">附近</label>

<c:choose> 

     <c:when test="${dishlist!=null}">    <!--如果 --> 
<!--  左边区域 -->
<table>
<tr>
<td width="50%">
<div>
           	<!--标签：附近-->
			
			<c:set value="0.5" var="i" />
       
			<c:forEach items="${canteenlist}" var="canteen">
				<div style="height:33.6px;margin:12px 0px;"
					onclick="showb($(this).find('.text_canteenName').text(),$(this).find('#cn').text(),$(this).find('#canteenId').text());">
					<label class="text_canteenName" hidden="true">${canteen.canteenName}</label>
					<p class="text_recommand" style="color: #535151;font-size: 12px;">
						 <span id="cn">${canteen.canteenName}</span>
						<span id="canteenId">${canteen.canteenId}</span>
					</p>
				</div>

			</c:forEach>
</div>
</td>


<!--  右边区域 -->
<td width="50%">
<div>
    <c:forEach items="${dishlist}" var="dish">
	<div style="height:33.6px;margin:12px 5px;">
		<label style="font-family: PingFangSC-Medium;
font-size: 12px;
color: #8E8E93;
letter-spacing: 0;
line-height: 34px;
height: 20px; 
text-align: justify;">${dish.dishName}</label> 


		</div>
    </c:forEach>
</div>
</td>

</tr>
</table>
 </c:when>      

     <c:otherwise>  <!--否则 -->    
<div>
           	<!--标签：附近-->
			<c:set value="0.5" var="i" />
       
			<c:forEach items="${canteenlist}" var="canteen">
				<div
					onclick="showb($(this).find('.text_canteenName').text(),$(this).find('#cn').text(),$(this).find('#canteenId').text());">
					<label class="text_canteenName">${canteen.canteenName}
					</label> <label class="text_distance"> ${i=i+1}公里</label>
					<p class="text_recommand">
						<span>&nbsp;&nbsp;推荐:</span> <span id="cn">${canteen.canteenName}</span>
						<span id="canteenId">${canteen.canteenId}</span>
					</p>
				</div>

			</c:forEach>
</div>
  </c:otherwise> 

</c:choose>



</div>
<br>
<p class="text_mycollection">您当前的位置为：</p>
 <!-- 显示当前位置 -->
<div id="map" style="height:50px;overflow-y: scroll;"></div> 
<!--我的收藏-->
	<div class="text_mycollection">我的收藏</div>
		<c:if test="${fdishlist==null}">
	 <div class="circle" >
     	<!--微笑.svg-->
     	<img src="${imgpth}smile.svg">
     	<!--标签-->
     	<p class="text_mylabel">左滑上方的餐厅列表可以收藏餐厅哦</p>
     	
     </div>
     </c:if>
     
		<br /> <br />
			<c:if test="${fdishlist!=null}">
			
			<c:forEach items="${fdishlist}" var="dish">
			<div class="fujinBox"
				style="overflow-y: scroll; height: 100px; box-sizing: border-box;">
				<label class="text_canteenName"> ${dish.dishName} </label>

				<%-- <label class="text_canteenName" >
               ${dish.CanteenName} 
        </label> --%>
				<span id="cn">${dish.dishDiscription}</span>
			</div>

		</c:forEach>
			
			</c:if>
		
</body>
<script>
$(function(){ 
	navigator.geolocation.getCurrentPosition(translatePoint); //定位 
	}); 
	function translatePoint(position){ 
	var currentLat = position.coords.latitude; 
	var currentLon = position.coords.longitude; 
	var gpsPoint = new BMap.Point(currentLon, currentLat); 
	BMap.Convertor.translate(gpsPoint, 0, initMap); //转换坐标 
	} 
	function initMap(point){ 
	//初始化地图 
	map = new BMap.Map("map"); 
	map.addControl(new BMap.NavigationControl()); 
	map.addControl(new BMap.ScaleControl()); 
	map.addControl(new BMap.OverviewMapControl()); 
	map.centerAndZoom(point, 15); 
	map.addOverlay(new BMap.Marker(point)) 
	} 

	var cId;
	console.log("cId:", cId);
	function showb(canteenAddress, canteenName, canteenId) {
		console.log(canteenId);
		$("#overlay").show();
		$("#model").slideDown();

		$("#overlay").click(function() {
			$("#model").slideUp();
			$("#overlay").hide();
		});
		$("#p1").text(canteenAddress);
		$("#q2").text(canteenName);
		console.log("canteenId:", canteenId);
		cId = canteenId;

		var xxx = document.getElementById("www");
		xxx.value = cId;

		$("#op1").click(function() {
			$("#im1").attr("src", "${imgpth}checked.svg");
			$("#im2").attr("src", "${imgpth}unchecked.svg");
		});

		$("#op2").click(function() {
			$("#im2").attr("src", "${imgpth}checked.svg");
			$("#im1").attr("src", "${imgpth}unchecked.svg");
		});
	}

	
	function setorderType(orderType){
		console.log(orderType);
		var kkk=document.getElementById("kkk");
		kkk.value=orderType;
	}
</script>



</html>
