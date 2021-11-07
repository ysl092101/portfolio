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
	<!-- 메뉴 -->
	<nav class="w3-sidebar w3-bar-block w3-card w3-top w3-animate-left" style="display:none; padding:40px 85px; z-index:2; width:15%; min-width:300px" id="mySidebar">
		<h3 class="w3-center">❝<br>Manager<br>Menu<br>❞</h3>

		<br>

		<b>myInfo</b>
		<a href="/manager/myinfo" class="w3-bar-item w3-button" onclick="w3_close()">관리자정보</a>
		<br>
		<b>회원관리</b>
		<a href="/manager/members" class="w3-bar-item w3-button" onclick="w3_close()">회원목록</a>
		<br>
		<b>장소관리</b>
		<a href="/manager/place" class="w3-bar-item w3-button" onclick="w3_close()">장소등록</a>
		<a href="/manager/places" class="w3-bar-item w3-button" onclick="w3_close()">장소목록</a>
		<br>
		<b>전시관리</b>
		<a href="/manager/exhibition" class="w3-bar-item w3-button" onclick="w3_close()">전시등록</a>
		<a href="/manager/exhibitions" class="w3-bar-item w3-button" onclick="w3_close()">전시목록</a>
		<a href="/manager/finished" class="w3-bar-item w3-button" onclick="w3_close()">지난전시목록</a>

		<br><br>

		<a href="" class="w3-bar-item w3-button w3-center" onclick="w3_close()">xxxxxxxxxx<br>close<br>xxxxxxxxxx</a>
	</nav>
	<script>
		function w3_open() { document.getElementById("mySidebar").style.display = "block"; }
		function w3_close() { document.getElementById("mySidebar").style.display = "none"; }
	</script>

	<!-- 상단 -->
	<div class="w3-top">
		<div class="w3-bar w3-padding w3-white" style="letter-spacing:3px;">
			<div class="w3-left">
				<div class="w3-button w3-left" onclick="w3_open()">&#9776;</div>
				<a href="/manager/main" class="w3-bar-item w3-button">TICKETING</a>
			</div>

			<div class="w3-right">
				<a href="/logout" class="w3-bar-item w3-button">logOut</a>
				<a href="/manager/myinfo" class="w3-bar-item w3-button">myInfo</a>
			</div>
		</div>
	</div>
</body>
</html>