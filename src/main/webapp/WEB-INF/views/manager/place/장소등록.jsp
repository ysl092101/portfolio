<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="false" %>

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
	<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<script type="text/javascript">
		function srchPost() {
			new daum.Postcode({
				oncomplete: function(data) {
					var roadAddr = data.roadAddress;
					var extraRoadAddr = '';

					if (data.bname !== '' && /[동|로|가]$/g.test(data.bname)) {
						extraRoadAddr += data.bname;
					}
					if (data.buildingName !== '' && data.apartment === 'Y') {
						extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
					}
					if (extraRoadAddr !== '') {
						extraRoadAddr = ' (' + extraRoadAddr + ')';
					}

					document.getElementById("post").value = data.zonecode;
					document.getElementById("address").value = roadAddr;
					document.getElementById("tel").focus();
				}
			}).open();
		}

		function 장소등록하기() {
			var txt이름 = document.querySelector("#name");
			var txt우편번호 = document.querySelector("#post");

			if (txt이름.value == "") {
				alert("이름을 입력하세요.");
				return false;
			}
			if (txt우편번호.value == "") {
				alert("우편번호를 조회하세요.");
				return false;
			}

			return true;
		}
	</script>
</head>

<body>
	<!-- 메뉴/상단 -->
	<jsp:include page="../menu.jsp"/>

	<!-- 메인 -->
	<div style="padding:60px 15%">
		<h1>New Place</h1>
		<p style="color:red">*필수 입력 항목입니다.</p>

		<form onsubmit="return 장소등록하기()" action="/manager/place" method="POST">
			<label style="color:red">*</label>이름 <br>
			<input type="text" id="name" name="name" maxlength="50"/> <br><br>
			<label style="color:red">*</label>우편번호 <br>
			<input type="text" id="post" name="post" readonly/>	<input type="button" value="+" onclick="srchPost()"/> <br><br>
			<label style="color:red">*</label>주소 <br>
			<input type="text" id="address" name="address" readonly/> <br><br>
			전화번호 <br>
			<input type="text" id="tel" name="tel" maxlength="11"/> <br><br>
			홈페이지 <br>
			<input type="text" id="page" name="page" maxlength="200"/>

			<hr>

			<input type="submit" id="btn" value="장소등록"/>
		</form>
	</div>
</body>
</html>