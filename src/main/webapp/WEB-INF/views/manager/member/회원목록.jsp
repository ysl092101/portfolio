<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String srchId = request.getParameter("srchId");
	if (srchId == null) srchId = "";
%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Manager</title>
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
	<jsp:include page="../menu.jsp"/>

	<!-- 메인 -->
	<div style="padding:60px 15%">
		<h1>Member List</h1>

		<!-- 조회 결과가 없는 경우 -->
		<c:if test="${empty members}">
			조회된 데이터가 없습니다.
		</c:if>

		<!-- 조회 결과가 있는 경우 -->
		<c:if test="${not empty members}">
			<form action="/manager/members/search" method="POST">
				<input type="text" id="srchId" name="srchId" placeholder="아이디" value="<%= srchId %>"/>
				<button type="submit">검색</button>
			</form>

			<br>

			<table>
				<thead>
					<tr>
						<th>회원번호</th> <th>아이디</th> <th>비밀번호</th> <th>이름</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="member" items="${members}" varStatus="status">
					<tr>
						<td width="200px" style="text-align:center">${member.no}</td>
						<td width="300px" style="text-align:center"><a href="/manager/members/${member.no}" style="text-decoration:none">${member.id}</a></td>
						<td width="600px">${member.pw}</td>
						<td width="300px" style="text-align:center">${member.name}</td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>
	</div>
</body>
</html>