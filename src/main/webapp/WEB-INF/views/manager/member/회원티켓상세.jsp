<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import ="com.stone.common_ticket.Ticket" %>
<%@ page import ="java.util.Date" %>
<%@ page import ="java.text.SimpleDateFormat" %>
<%
	Ticket ticket = (Ticket)request.getAttribute("ticket");
	String str = ticket.getExhibition().getEndday();
	String endday = str.substring(0,4) + str.substring(5,7) + str.substring(8,10);

	Date date = new Date();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
	String today = sdf.format(date);
%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Manager</title>
	<link rel="icon" href="/img/ticket.png">

	<meta name="viewport" content="width=device-width, initial-scale=1">
	<style>
		input#btn { width:100%; height:50px; border:1px white; background-color:lightgrey; color:white; }
		input#btn:hover { color:black; }
	</style>
</head>

<body>
	<!-- 메뉴/상단 -->
	<jsp:include page="../menu.jsp"/>

	<!-- 메인 -->
	<div style="padding:60px 15%">
		<h1>Ticket Details</h1>

		<table>
			<tr>
				<td width="330px" rowspan="8"><img src="/poster/${ticket.exhibition.no}"/></td>
				<td width="600px" colspan="2"><h3>${ticket.exhibition.title}</h3></td>
			</tr>
			<tr>
				<td style="width:130px">예매번호</td>
				<td>${ticket.no}</td>
			</tr>
			<tr>
				<td>예매자</td>
				<td>${ticket.member.name}</td>
			</tr>
			<tr>
				<td>예매자수</td>
				<td>
					<% if (ticket.getAdult() != 0) { %> 성인 ${ticket.adult}명 <% } %>
					<% if (ticket.getTeen() != 0) { %> 청소년 ${ticket.teen}명 <% } %>
					<% if (ticket.getKid() != 0) { %> 어린이 ${ticket.kid}명 <% } %>
				</td>
			</tr>
			<tr>
				<td>예매일</td>
				<td>${ticket.wdate}</td>
			</tr>
			<tr>
				<td>취소가능일</td>
				<td>${ticket.exhibition.endday}</td>
			</tr>
			<tr>
				<td>결제금액</td>
				<td>${ticket.price}원</td>
			</tr>
			<tr>
				<td>예매상태</td>
				<% if (ticket.getState() == 0) { %>
				<td style="color:blue">발권완료</td>
				<% } else { %>
				<td style="color:red">사용완료</td>
				<% } %>
			</tr>
		</table>

		<% if (ticket.getState()==0 && Integer.parseInt(endday)>Integer.parseInt(today)) { %>
		<hr>
		<form action="/manager/tickets/${ticket.no}/update" method="POST">
			<input type="submit" id="btn" value="티켓사용"/>
		</form>
		<% } %>
	</div>
</body>
</html>