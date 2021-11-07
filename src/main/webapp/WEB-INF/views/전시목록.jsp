<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String 정렬 = request.getParameter("order");
	if (정렬 == null) 정렬 = "0";
%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Ticketing</title>
	<link rel="icon" href="/img/ticket.png">

	<meta name="viewport" content="width=device-width, initial-scale=1">
	<style>
		form { text-align:right; }
		table { border-top:2px solid; border-bottom:2px solid; border-collapse:collapse; }
		table th { background-color:grey; color:white; border-bottom:1px solid black; }
		table td { border-bottom:1px dotted; }
		tbody > tr2:hover { cursor:pointer; }
	</style>
</head>

<body>
	<!-- 메뉴/상단 -->
	<jsp:include page="menu.jsp"/>

	<!-- 메인 -->
	<div style="padding:60px 15%">
		<h1>Exhibition List</h1>

		<!-- 조회 결과가 없는 경우 -->
		<c:if test="${empty exhibitions}">
			조회된 데이터가 없습니다.
		</c:if>

		<!-- 조회 결과가 있는 경우 -->
		<c:if test="${not empty exhibitions}">
			<form action="/exhibitions" method="POST">
				<select name="order">
					<option value="0" <% if (정렬.equals("0")) out.print("selected"); %>>제목순</option>
					<option value="1" <% if (정렬.equals("1")) out.print("selected"); %>>신규순</option>
					<option value="2" <% if (정렬.equals("2")) out.print("selected"); %>>종료순</option>
				</select>
				<input type="submit" value="보기"/>
			</form>

			<br>

			<table>
				<thead>
					<tr>
						<th>전시번호</th> <th>제목</th> <th>장소</th> <th>기간</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="exhibition" items="${exhibitions}" varStatus="status">
					<tr>
						<td width="200px" style="text-align:center">${exhibition.no}</td>
						<td width="600px"><a href="/exhibitions/${exhibition.no}" style="text-decoration:none">${exhibition.title}</a></td>
						<td width="300px" style="text-align:center">${exhibition.place}</td>
						<td width="300px" style="text-align:center">${exhibition.startday} ~ ${exhibition.endday}</td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>
	</div>
</body>
</html>