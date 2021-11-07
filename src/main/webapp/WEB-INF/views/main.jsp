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
</head>

<body>
	<!-- 메뉴/상단 -->
	<jsp:include page="menu.jsp"/>

	<!-- 메인 -->
	<div class="w3-center" style="padding:35px 0px">
		<jsp:include page="carousel.jsp"/>

		<br><br><br>

		<!-- 예매수 많은 전시 3개 -->
		<div class="container">
			<h2 class="text-center">T O P</h2>
			<p class="text-center">인 기 전 시</p>
			<br>
			<c:forEach var="exhibition" items="${exhibitions1}" varStatus="status">
				<div class="col-sm-4">
					<div class="w3-container w3-hover-opacity">
						<a href="/exhibitions/${exhibition.no}"><img src="/poster/${exhibition.no}" width="300" height="400"/></a>
						<footer class="w3-container">
							<h4><b>${exhibition.title}</b></h4>
							<p>${exhibition.place}</p>
							<p>${exhibition.startday} ~ ${exhibition.endday}</p>
						</footer>
					</div>
				</div>
			</c:forEach>
		</div>

		<hr>

		<!-- 새로 등록된 전시 3개 -->
		<div class="container">
			<h2 class="text-center">N E W</h2>
			<p class="text-center">신 규 전 시</p>
			<br>
			<c:forEach var="exhibition" items="${exhibitions2}" varStatus="status">
				<div class="col-sm-4">
					<div class="w3-container w3-hover-opacity">
						<a href="/exhibitions/${exhibition.no}"><img src="/poster/${exhibition.no}" width="300" height="400"/></a>
						<footer class="w3-container">
							<h4><b>${exhibition.title}</b></h4>
							<p>${exhibition.place}</p>
							<p>${exhibition.startday} ~ ${exhibition.endday}</p>
						</footer>
					</div>
				</div>
			</c:forEach>
		</div>

		<hr>

		<!-- 곧 종료될 전시 3개 -->
		<div class="container">
			<h2 class="text-center">C L O S E</h2>
			<p class="text-center">종 료 임 박</p>
			<br>
			<c:forEach var="exhibition" items="${exhibitions3}" varStatus="status">
				<div class="col-sm-4">
					<div class="w3-container w3-hover-opacity">
						<a href="/exhibitions/${exhibition.no}"><img src="/poster/${exhibition.no}" width="300" height="400"/></a>
						<footer class="w3-container">
							<h4><b>${exhibition.title}</b></h4>
							<p>${exhibition.place}</p>
							<p>${exhibition.startday} ~ ${exhibition.endday}</p>
						</footer>
					</div>
				</div>
			</c:forEach>
		</div>

		<hr>

		<!-- 동영상 -->
		<div class="container">
			<video src="/img/video.mp4" width="1000px" controls autoplay loop muted></video>
		</div>
	</div>

	<!-- 하단 -->
	<footer class="w3-padding-64 w3-light-grey w3-center">
		Copyright ⓒ 2021 Lee Young Seo All Rights Reserved
	</footer>
</body>
</html>