<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="false" %>

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
		function enterId() {
			window.open("id", "", "width=500, height=400, left=750px, top=300px");
		}

		function getId(id) {
			let txt아이디 = document.querySelector("#id");
			txt아이디.value = id;
		}

		function 가입하기() {
			var txt아이디 = document.querySelector("#id");
			var txt비밀번호 = document.querySelector("#pw");
			var txt비밀번호2 = document.querySelector("#pw2");
			var txt이름 = document.querySelector("#name");
			var txt휴대전화 = document.querySelector("#phone");
			var txt이메일 = document.querySelector("#email");

			var 비밀번호P = /^[a-zA-Z0-9]{5,15}$/;
			var 이름P = /^[가-힣]{2,10}$/;
			var 휴대전화P = /^01([0|1|6|7|8|9]?)?([0-9]{3,4})?([0-9]{4})$/;
			var 이메일P = /^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/;

			if (txt아이디.value == "") {
				alert("아이디를 입력하세요.");
				return false;
			}
			if (txt비밀번호.value == "") {
				alert("비밀번호를 입력하세요.");
				return false;
			}
			if (비밀번호P.test(txt비밀번호.value) == false) {
				alert("비밀번호는 5~15자의 영문 대소문자, 숫자만 사용 가능합니다.");
				return false;
			}
			if (txt비밀번호.value != txt비밀번호2.value) {
				alert("비밀번호가 일치하지 않습니다.");
				return false;
			}
			if (txt이름.value == "") {
				alert("이름을 입력하세요.");
				return false;
			}
			if (이름P.test(txt이름.value) == false) {
				alert("이름은 2~10자의 한글만 사용 가능합니다.");
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
		<h1>Join</h1>
		<p style="color:red">*필수 입력 항목입니다.</p>

		<form onsubmit="return 가입하기()" action="/join" method="POST">
			<label style="color:red">*</label>아이디 <br>
			<input type="text" id="id" name="id" maxlength="15" readonly/> <input type="button" value="+" onclick="enterId()"> <br><br>
			<label style="color:red">*</label>비밀번호 <br>
			<input type="password" id="pw" name="pw" maxlength="15"/> (5~15자의 영문 대소문자,숫자) <br><br>
			<label style="color:red">*</label>비밀번호 확인 <br>
			<input type="password" id="pw2" name="pw2" maxlength="15"/> <br><br>
			<label style="color:red">*</label>이름 <br>
			<input type="text" id="name" name="name" maxlength="10"/> (2~10자의 한글) <br><br>
			휴대전화 <br>
			<input type="text" id="phone" name="phone" maxlength="11"/> <br><br>
			이메일 <br>
			<input type="text" id="email" name="email"/>

			<hr>

			<input type="submit" id="btn" value="회원가입"/>
		</form>
	</div>
</body>
</html>