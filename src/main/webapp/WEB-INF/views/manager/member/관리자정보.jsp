<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Manager</title>
	<link rel="icon" href="/img/ticket.png">

	<meta name="viewport" content="width=device-width, initial-scale=1">
</head>

<body>
	<!-- 메뉴/상단 -->
	<jsp:include page="../menu.jsp"/>

	<!-- 메인 -->
	<div style="padding:60px 15%">
		<h1>Manager Profile</h1>

		<table>
			<tr>
				<td style="width:100px">아이디　　|</td> <td>${member.id}</td>
			</tr>
			<tr>
				<td>비밀번호　|</td> <td>${member.pw}</td>
			</tr>
			<tr>
				<td>이름　　　|</td> <td>${member.name}</td>
			</tr>
			<tr>
				<td>휴대전화　|</td> <td>${member.phone}</td>
			</tr>
			<tr>
				<td>이메일　　|</td> <td>${member.email}</td>
			</tr>
		</table>
	</div>
</body>
</html>