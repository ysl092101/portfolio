<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String srchName = request.getParameter("srchName");
	if (srchName == null) srchName = "";
%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Manager</title>
	<link rel="icon" href="/img/ticket.png">

	<meta name="viewport" content="width=device-width, initial-scale=1">
	<style>
		form#form { text-align:right; }
		table { border-top:2px solid; border-bottom:2px solid; border-collapse:collapse; }
		table th { background-color:grey; color:white; border-bottom:1px solid black; }
		table td { border-bottom:1px dotted; }
		input#btn { border:1px white; background-color:white; }
		input#btn:hover { background-color:lightgrey; }
	</style>
</head>

<body>
	<!-- 메뉴/상단 -->
	<jsp:include page="../menu.jsp"/>

	<!-- 메인 -->
	<div style="padding:60px 15%">
		<h1>Place List</h1>

		<!-- 조회 결과가 없는 경우 -->
		<c:if test="${empty places}">
			조회된 데이터가 없습니다.
		</c:if>

		<!-- 조회 결과가 있는 경우 -->
		<c:if test="${not empty places}">
			<form id="form" action="/manager/places/search" method="POST">
				<input type="text" id="srchName" name="srchName" value="<%= srchName %>" placeholder="이름"/>
				<button type="submit">검색</button>
			</form>

			<br>

			<table>
				<thead>
					<tr>
						<th>이름</th> <th>주소</th> <th>전화번호</th> <th>홈페이지</th> <th></th>
					</tr>
				</thead>
				<tbody>
				<c:forEach var="place" items="${places}" varStatus="status">
					<tr>
						<td width="300px">${place.name}</td>
						<td width="500px">[${place.post}] ${place.address}</td>
						<td width="250px">${place.tel}</td>
						<td width="250px">${place.page}</td>
						<td width="100px" style="text-align:center">
							<form action="/manager/places/delete" method="POST">
								<input type="hidden" id="no" name="no" value="${place.no}"/>
								<input type="submit" id="btn" value="삭제"/>
							</form>
						</td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
		</c:if>
	</div>
</body>
</html>