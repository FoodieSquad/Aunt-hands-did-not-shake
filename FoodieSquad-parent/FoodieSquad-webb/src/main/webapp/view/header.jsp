<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Insert title here</title>

<script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>
 <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
 <link rel="stylesheet" type="text/css" href="${csspth}cssForCCP.css">
 <c:set value="${pageContext.request.contextPath}/image/chooseCanteenPage/" var="imgpth" scope="page"/>
</head>
<body>
   <div id="overlay" class="mask"></div>    
    <div id="model">
     <div id="content">
 <p ><img src="${imgpth}home.svg">&nbsp;&nbsp;<span id="p1">海南大学食堂</span></p>
</body>
</html>