<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Manager</title>
	<link rel="icon" href="/img/ticket.png">

	<meta name="viewport" content="width=device-width, initial-scale=1">
	<style>
		table { border-top:2px solid; border-bottom:2px solid; border-collapse:collapse; }
		table th { background-color:grey; color:white; border-bottom:1px solid black; }
		table td { border-bottom:1px dotted; }
		tbody > tr2:hover { cursor:pointer; }
	</style>
</head>

<body>
	<!-- 메뉴/상단 -->
	<jsp:include page="../menu.jsp"/>

	<!-- 메인 -->
	<div style="padding:60px 15%">
		<h1>Member's Ticket List</h1>

		<!-- 조회 결과가 없는 경우 -->
		<c:if test="${empty tickets}">
			조회된 데이터가 없습니다.
		</c:if>

		<!-- 조회 결과가 있는 경우 -->
		<c:if test="${not empty tickets}">
			<table>
				<thead>
					<tr>
						<th>예매번호</th> <th>상품명</th> <th>예매일</th> <th>취소가능일</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="ticket" items="${tickets}" varStatus="status">
					<tr>
						<td width="200px" style="text-align:center">${ticket.no}</td>
						<td width="600px"><a href="/manager/tickets/${ticket.no}" style="text-decoration:none">${ticket.exhibition.title}</a></td>
						<td width="300px" style="text-align:center">${ticket.wdate}</td>
						<td width="300px" style="text-align:center">${ticket.exhibition.endday}</td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>
	</div>
</body>
</html>