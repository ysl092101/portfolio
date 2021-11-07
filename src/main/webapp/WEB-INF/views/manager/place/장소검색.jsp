<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import ="com.stone.common_place.Place" %>
<%@ page import ="com.stone.common_ticket.Ticket" %>
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
	<link rel="stylesheet" href="https://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.css">
	<script src="https://code.jquery.com/jquery-1.11.1.min.js"></script>
	<script src="https://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.js"></script>
	<script type="text/javascript">
		function sendPlace(장소명) {
			opener.getPlace(장소명);
			close();
		}
	</script>
</head>

<body onresize="parent.resizeTo(500,500)" onload="parent.resizeTo(500,500)">
	<form action="/manager/exhibition/places/search" method="POST">
		<table>
			<tr>
				<td><input type="text" id="srchName" name="srchName" size="100" placeholder="예) 국립중앙박물관" value="<%= srchName %>"/></td>
				<td><input type="submit" data-mini="true" value="검색"/></td>
			</tr>
		</table>
	</form>

	<br>

	<ul data-role="listview">
		<c:forEach var="place" items="${places}" varStatus="status">
		<li><a onclick="sendPlace('${place.name}')">
			<h6>${place.name}</h6>
			<p>[${place.post}] ${place.address}</p>
		</a></li>
		</c:forEach>
	</ul>
</body>
</html>