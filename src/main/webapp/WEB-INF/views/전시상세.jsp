<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	HttpSession session = request.getSession(false);
	if (session!=null && session.getAttribute("name")==null) {
		session = null;
	}
%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Ticketing</title>
	<link rel="icon" href="/img/ticket.png">

	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
	<style>
		input#btn { width:100px; height:50px; border:1px white; background-color:lightgrey; color:white; }
		input#btn:hover { color:black; }
	</style>
	<script type="text/javascript">
		function 예매하기() {
			var txt성인 = document.querySelector("#adult");
			var txt청소년 = document.querySelector("#teen");
			var txt어린이 = document.querySelector("#kid");

			if (txt성인.value=="" && txt청소년.value=="" && txt어린이.value=="") {
				alert("최소 1명은 예매해야 합니다.");
				return false;
			}
			if (txt성인.value==0 && txt청소년.value==0 && txt어린이.value==0) {
				alert("최소 1명은 예매해야 합니다.");
				return false;
			}

			return true;
		}
	</script>
</head>

<body>
	<!-- 메뉴/상단 -->
	<jsp:include page="menu.jsp"/>

	<!-- 메인 -->
	<div style="padding:60px 15%">
		<h1>Exhibition Details</h1>

		<table>
			<tr>
				<td width="330px" rowspan="7"><img src="/poster/${exhibition.no}"/></td>
				<td width="870px" colspan="2"><h2>${exhibition.title}</h2></td>
				<!-- 티켓예매 -->
				<% if (session != null) { %>
				<td width="200px" rowspan="7" style="text-align:center; border:1px dotted lightgrey;">
					<p>예매를 진행하세요.</p> <br>
					<form onsubmit="return 예매하기()" action="/ticket" method="POST">
						<label>성　인 </label>
						<select id="adult" name="adult">
							<% for (int i=0; i<11; i++) { %>
							<option value="<%= i %>"><%= i %>매</option>
							<% } %>
						</select> <br><br>
						<label>청소년 </label>
						<select id="teen" name="teen">
							<% for (int i=0; i<11; i++) { %>
							<option value="<%= i %>"><%= i %>매</option>
							<% } %>
						</select> <br><br>
						<label>어린이 </label>
						<select id="kid" name="kid">
							<% for (int i=0; i<11; i++) { %>
							<option value="<%= i %>"><%= i %>매</option>
							<% } %>
						</select> <br><br><br>
						<input type="hidden" id="exhibition_no" name="exhibition_no" value="${exhibition.no}"/>
						<input type="submit" id="btn" value="예매하기"/>
					</form>
				</td>
				<% } %>
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
					<b>${place.name}</b> <a href="/places/${place.no}" style="text-decoration:none">▶</a>
					<p>[${place.post}] ${place.address}</p>
					<p>${place.tel}</p>
					<a href="${place.page}">${place.page}</a>
				</div>
			</div>
		</div>
	</div>
</body>
</html>