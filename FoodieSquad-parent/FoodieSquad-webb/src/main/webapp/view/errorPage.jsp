
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
<c:set value="${pageContext.request.contextPath}/image/errorPage/" var="imgpth" scope="page"/>
<c:set value="${pageContext.request.contextPath}/css/" var="csspth" scope="page"/>
<c:set value="${pageContext.request.contextPath}/view/" var="jsppth" scope="page"/>
<link rel="stylesheet" type="text/css" href="${csspth}cssForErrorPage.css">
</head>
<body>
<div class="container">
<!--顶部页面属性与后退-->
<div class="headingBox"><img src="${imgpth}returnbutton.svg" id="returnbtn" class="closeButtonSize" onclick="javascript:history.back(-1);"/><label for="returnbtn" class="headingText">错误页面</label>
</div>
<!--logo图片-->
<div class="logoBox">
<img src="${imgpth}logo.svg" id="logoimg" class="logoSize"/>
</div>

<!--错误信息-->
<div class="infoBox">
<c:choose> 

     <c:when test="${exc!=null}">   
	<p class="infoText">${exc}</p>
 </c:when>      

     <c:otherwise> 
<p class="infoText">404 Error Can't find page</p>
  </c:otherwise> 

</c:choose>
</div>

<!--附加提醒-->
<div class="addtionBox">
    <p class="additionText" onclick="call()" >抱歉，由于服务器出错<br/><b onclick="javascript:history.back(-1);">请返回上一级页面</b></p>
</div>
</div>
</body>
</html>