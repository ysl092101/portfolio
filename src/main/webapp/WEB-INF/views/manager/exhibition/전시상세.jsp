<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Manager</title>
	<link rel="icon" href="/img/ticket.png">

	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
	<style>
		input#btn { width:100%; height:50px; border:1px white; background-color:lightgrey; color:white; }
		input#btn:hover { color:black; }
	</style>
</head>

<body>
	<!-- 메뉴/상단 -->
	<jsp:include page="../menu.jsp"/>

	<!-- 메인 -->
	<div class="w3-panel" style="padding:50px 15%">
		<h1>Exhibition Details</h1>

		<table>
			<tr>
				<td width="330px" rowspan="7"><img src="/poster/${exhibition.no}"/></td>
				<td width="870px" colspan="2"><h2>${exhibition.title}</h2></td>
			</tr>
			<tr>
				<td style="width:100px">장소　　　|</td>
				<td>${exhibition.place} ${exhibition.hall} <button onclick="document.getElementById('modal').style.display='block'" class="w3-button">▶</button></td>
			</tr>
			<tr>
				<td>기간　　　|</td> <td>${exhibition.startday} ~ ${exhibition.endday}</td>
			</tr>
			<tr>
				<td>관람연령　|</td> <td>${exhibition.age}</td>
			</tr>
			<tr>
				<td>가격　　　|</td> <td>성　인　${exhibition.adultfee}원</td>
			</tr>
			<tr>
				<td></td> <td>청소년　${exhibition.teenfee}원</td>
			</tr>
			<tr>
				<td></td> <td>어린이　${exhibition.kidfee}원</td>
			</tr>
		</table>

		<!-- 장소상세 -->
		<div id="modal" class="w3-modal w3-animate-opacity">
			<div class="w3-modal-content w3-card-4">
				<div class="w3-container">
					<span onclick="document.getElementById('modal').style.display='none'" class="w3-button w3-large w3-display-topright">&times;</span>
					<h4>전시장 정보</h4>
					<b>${place.name}</b>
					<p>[${place.post}] ${place.address}</p>
					<p>${place.tel}</p>
					<a href="${place.page}">${place.page}</a>
				</div>
			</div>
		</div>

		<hr>

		<form action="/manager/exhibitions/delete" method="POST">
			<input type="hidden" id="no" name="no" value="${exhibition.no}"/>
			<input type="submit" id="btn" value="전시삭제"/>
		</form>
	</div>
</body>
</html>