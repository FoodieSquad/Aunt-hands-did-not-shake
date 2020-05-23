
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
<c:set value="${pageContext.request.contextPath}/image/homePage/"
	var="imgpth" scope="page" />
<c:set value="${pageContext.request.contextPath}/css/" var="csspth"
	scope="page" />
<c:set value="${pageContext.request.contextPath}/view/" var="jsppth"
	scope="page" />
<link rel="stylesheet" type="text/css"
	href="${csspth}cssForHomePage.css" />
<link rel="stylesheet" type="text/css" href="${csspth}bootstrap.min.css" />

</head>
<body style=" margin:0 auto;">
	<script>
		$(document).ready(function() {
			var menu = "${sessionScope.menu}";
			var price = "${sessionScope.totalPrice}";
			var verifyCode = "${sessionScope.verifyCode}";
			$("#dealrecord").click(function() {
				//             window.location.href="/FOODIESQUAD/MyOrderingServlet?menu="+menu+"&totalPrice="+price+"&verifyCode="+verifyCode;
			});
		});
	</script>
	<!--首页头部时间状态栏><-->
<div class="mycontainer">
<br>
<!--具体日期-->
<div class="datetext" id="today">${date}</div>
<!--首页头部宣传 中午啦！吃点好的!-->
<div class="title-text"> <label name="sun-moon-logo"> <span>用户:${u.userName} 欢迎您！</span><br/>🌞<span id="abc">中午</span>吃点好的！</label> </div>
<!--横线-->
<div><hr class="line"></div>
<br>
<!--轮播栏-->
<div id="scrolling"><img src="${imgpth}lunbo.svg"></div>
<!--上次吃过&我的收藏:-->
<div class="datetext" style="overflow-y: scroll; height: 100px; box-sizing: border-box;">
<c:if test="${historyItemlist!=null}">	<img src="${imgpth}navigateicon.svg">上次吃过: <c:forEach items="${historyItemlist}" var="historyitem"> <p> 菜名：${historyitem.dishId.dishName}</p> </c:forEach><br> </c:if> <img src="${imgpth}navigateicon.svg">我的收藏: <c:if test="${fdishlist==null}"> 您还没有收藏哦！ </c:if>
<c:if test="${fdishlist!=null}"> <c:forEach items="${fdishlist}" var="dish"> <div class="fujinBox"><label class="text_canteenName"> ${dish.dishName} </label><span id="cn">${dish.dishDiscription}</span></div> </c:forEach> </c:if>
</div>
<!--空格-->
<br>
<form action="../canteen/testshowCanteenPage.do" name="orderform"> <input type="hidden" name="userId" value="${u.userId}">
<!--开始点餐-->
<div class="startordering buttonbox" onclick="document.orderform.submit();">开始点餐</div>
</form>
<br>
<!--点餐记录 && 个人中心-->
<!--点餐记录-->
<div class="row" style="margin-top: 20px;"><div class="myOrdering col-md-6" style="list-style: none; width: 220px; height: 100px; overflow-y: auto;" onclick="window.location.href='../myOrder/test.do'"> <span style="padding-top: 2px"> <img src="${imgpth}ordering.svg" id="dealrecord"> <br>历史记录 </span> </div>
<!--个人中心-->
<div class="personalcenter col-md-6" style="list-style: none; width: 100px; height: 100px;" onclick="window.location.href='../personalCenter/test.do'"> <span style="padding-top: 4px"> <img src="${imgpth}logo.svg"><br><p style="margin-top: 18px">个人中心</p> </span> </div>
</div>
</div>


<script>
			function getMyDay(date) {
				var week;
				if (date.getDay() == 0)
					week = "星期日"
				if (date.getDay() == 1)
					week = "星期一"
				if (date.getDay() == 2)
					week = "星期二"
				if (date.getDay() == 3)
					week = "星期三"
				if (date.getDay() == 4)
					week = "星期四"
				if (date.getDay() == 5)
					week = "星期五"
				if (date.getDay() == 6)
					week = "星期六"
				return week;
			}

			function setdate() {
				var date = new Date();
				var t;
				var s = date.getHours(); //获取当前小时数(0-23)
				if (s > 0 && s < 12) {
					t = "上午啦！ Morning！";
				} else if (s > 12 && s < 13) {
					t = "中午啦！ Noon！";
				} else if (s > 13 && s < 17) {
					t = "下午啦！ Afternoon!";
				} else {
					t = "晚上啦！ Good evening!";
				}
				$("#abc").text(t);
				$("#today").text(
						date.getMonth() + 1 + "月" + date.getDate() + "日" + " "
								+ getMyDay(date));
			}
			setdate();
		</script>
</body>
</html>