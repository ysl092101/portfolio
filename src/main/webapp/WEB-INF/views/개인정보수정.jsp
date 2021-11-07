<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Ticketing</title>
	<link rel="icon" href="/img/ticket.png">

	<meta name="viewport" content="width=device-width, initial-scale=1">
	<style>
		input#btn { width:100%; height:50px; border:1px white; background-color:lightgrey; color:white; }
		input#btn:hover { color:black; }
	</style>
	<script type="text/javascript">
		function 정보수정하기() {
			var txt비밀번호 = document.querySelector("#pw");
			var txt비밀번호2 = document.querySelector("#pw2");
			var txt휴대전화 = document.querySelector("#phone");
			var txt이메일 = document.querySelector("#email");

			var 휴대전화P = /^01([0|1|6|7|8|9]?)?([0-9]{3,4})?([0-9]{4})$/;
			var 이메일P = /^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/;

			if (txt비밀번호.value == "") {
				alert("비밀번호를 입력하세요.");
				return false;
			}
			if (txt비밀번호.value != txt비밀번호2.value) {
				alert("비밀번호가 일치하지 않습니다.");
				return false;
			}
			if (txt휴대전화.value!="" && 휴대전화P.test(txt휴대전화.value)==false) {
				alert("휴대전화를 다시 확인해주세요.");
				return false;
			}
			if (txt이메일.value!="" && 이메일P.test(txt이메일.value)==false) {
				alert("이메일 주소를 다시 확인해주세요.");
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
		<h1>Profile Modify</h1>

		<form onsubmit="return 정보수정하기()" action="/member/${member.no}/updated" method="POST">
			<table>
				<tr>
					<td style="width:100px">아이디　　|</td> <td>${member.id}</td>
				</tr>
				<tr>
					<td>비밀번호　|</td> <td><input type="password" id="pw" name="pw" maxlength="15"/></td>
				</tr>
				<tr>
					<td>재입력　　|</td> <td><input type="password" id="pw2" name="pw2" maxlength="15"/></td>
				</tr>
				<tr>
					<td>이름　　　|</td> <td>${member.name}</td>
				</tr>
				<tr>
					<td>휴대전화　|</td> <td><input type="text" id="phone" name="phone" maxlength="11" value="${member.phone}"/></td>
				</tr>
				<tr>
					<td>이메일　　|</td> <td><input type="text" id="email" name="email" value="${member.email}"/></td>
				</tr>
			</table>

			<hr>

			<input type="submit" id="btn" value="정보수정"/>
		</form>
	</div>
</body>
</html>