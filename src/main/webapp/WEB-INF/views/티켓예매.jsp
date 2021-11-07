<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Ticketing</title>
	<link rel="icon" href="/img/ticket.png">

	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
	<style>
		input#btn { width:145px; height:50px; border:1px white; background-color:lightgrey; color:white; }
		input#btn:hover { color:black; }
	</style>
</head>

<body>
	<!-- 메뉴/상단 -->
	<jsp:include page="menu.jsp"/>

	<!-- 메인 -->
	<div class="w3-center" style="padding:300px 15%">
		<h2>예매가 정상적으로 완료되었습니다.</h2>
		<h3>결제금액 ${price}원</h3>

		<hr>

		<input type="button" id="btn" onclick="location.href='/main'" value="홈"/>
		<input type="button" id="btn" onclick="location.href='/tickets'" value="티켓확인"/>
	</div>
</body>
</html>