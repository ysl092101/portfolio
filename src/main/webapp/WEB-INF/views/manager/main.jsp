<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="false" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Manager</title>
	<link rel="icon" href="/img/ticket.png">

	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>

<body>
	<!-- 메뉴/상단 -->
	<jsp:include page="menu.jsp"/>

	<!-- 메인 -->
	<div class="w3-center" style="padding:15%">
		<h1>❝Manager Page❞</h1>

		<div class="w3-padding-32">
			<div class="w3-bar w3-border">
				<a href="/manager/members" class="w3-bar-item w3-button w3-light-grey">Member List</a>
				<a href="/manager/places" class="w3-bar-item w3-button">Place List</a>
				<a href="/manager/exhibitions" class="w3-bar-item w3-button w3-light-grey">Exhibition List</a>
				<a href="/manager/finished" class="w3-bar-item w3-button">Finished Exhibition</a>
			</div>
		</div>
	</div>

	<!-- 하단 -->
	<footer class="w3-bottom w3-padding-64 w3-light-grey w3-center">
		Copyright ⓒ 2021 Lee Young Seo All Rights Reserved
	</footer>
</body>
</html>