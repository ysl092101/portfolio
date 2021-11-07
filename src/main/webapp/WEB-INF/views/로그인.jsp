<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="false" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Ticketing</title>
	<link rel="icon" href="/img/ticket.png">

	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
	<style>
		input#id, input#pw { width:300px; height:40px; }
		input#btn { width:145px; height:50px; border:1px white; background-color:lightgrey; color:white; }
		input#btn:hover { color:black; }
	</style>
</head>

<body>
	<!-- 메뉴/상단 -->
	<jsp:include page="menu.jsp"/>

	<!-- 메인 -->
	<div class="w3-center" style="padding:250px 15%">
		<h1>L O G I N</h1>

		<br>

		<form action="/login" method="POST">
			<input type="text" id="id" name="id" placeholder="아이디"/> <br><br>
			<input type="password" id="pw" name="pw" placeholder="비밀번호"/> <br>
			<p style="color:red">${message}</p>

			<hr>

			<input type="submit" id="btn" value="로그인"/>
			<input type="button" id="btn" onclick="location.href='/join'" value="회원가입"/>
		</form>
	</div>
</body>
</html>