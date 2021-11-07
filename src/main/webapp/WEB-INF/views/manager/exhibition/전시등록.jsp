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
	<script type="text/javascript">
		function srchPlace() {
			window.open("/manager/exhibition/places", "", "width=500, height=500, left=600px, top=300px");
		}

		function getPlace(place) {
			let txt장소 = document.querySelector("#place");
			txt장소.value = place;
		}

		function 그림파일읽어출력하기(이벤트) {
			var 그림파일 = 이벤트.target.files[0];
			if (!그림파일.type.match("image.*")) {
				alert("지원하는 확장자가 아닙니다.");
				return;
			}

			var 파일리더 = new FileReader();
			파일리더.onload = function(한그림파일) {
				var myimg = document.getElementById("profile");
				myimg.src = 한그림파일.currentTarget.result;
			};
			파일리더.readAsDataURL(그림파일);
		}
		document.getElementById("btnProfile").addEventListener("change", 그림파일읽어출력하기, false);

		function 전시등록하기() {
			var txt제목 = document.querySelector("#title");
			var txt장소 = document.querySelector("#place");
			var txt시작날 = document.querySelector("#startday");
			var txt마지막날 = document.querySelector("#endday");
			var txt관람연령 = document.querySelector("#age");
			var txt성인입장료 = document.querySelector("#adultfee");
			var txt청소년입장료 = document.querySelector("#teenfee");
			var txt어린이입장료 = document.querySelector("#kidfee");
			var file포스터 = document.getElementById("btnPoster");

			if (txt제목.value == "") {
				alert("제목을 입력하세요.");
				return false;
			}
			if (txt장소.value == "") {
				alert("장소를 조회하세요.");
				return false;
			}
			if (txt시작날.value == "") {
				alert("시작날을 선택하세요.");
				return false;
			}
			if (txt마지막날.value == "") {
				alert("마지막날을 선택하세요.");
				return false;
			}
			if (txt관람연령.value == "") {
				alert("관람연령을 입력하세요.");
				return false;
			}
			if (txt성인입장료.value=="0" || txt청소년입장료.value=="0" || txt어린이입장료.value=="0") {
				alert("입장료를 입력하세요.");
				return false;
			}
			if (file포스터.value == "") {
				alert("포스터를 첨부하세요.");
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
		<h1>New Exhibition</h1>
		<p style="color:red">*필수 입력 항목입니다.</p>

		<form onsubmit="return 전시등록하기()" action="/manager/exhibition" enctype="multipart/form-data" method="POST">
			<label style="color:red">*</label>제목 <br>
			<input type="text" id="title" name="title" maxlength="200"/> <br><br>
			<label style="color:red">*</label>장소 <br>
			<input type="text" id="place" name="place" readonly/> <input type="button" value="+" onclick="srchPlace()"/> <br><br>
			전시실 <br>
			<input type="text" id="hall" name="hall" maxlength="50"/> <br><br>
			<label style="color:red">*</label>시작날 <br>
			<input type="date" id="startday" name="startday" pattern="yyyy-MM-dd"/> <br><br>
			<label style="color:red">*</label>마지막날 <br>
			<input type="date" id="endday" name="endday" pattern="yyyy-MM-dd"/> <br><br>
			<label style="color:red">*</label>관람연령 <br>
			<input type="text" id="age" name="age" maxlength="50" placeholder="예) 전체관람가, 48개월 이상"/> <br><br>
			<label style="color:red">*</label>성인입장료 <br>
			<input type="number" id="adultfee" name="adultfee" min="0" value="0"/>원 <br><br>
			<label style="color:red">*</label>청소년입장료 <br>
			<input type="number" id="teenfee" name="teenfee" min="0" value="0"/>원 <br><br>
			<label style="color:red">*</label>어린이입장료 <br>
			<input type="number" id="kidfee" name="kidfee" min="0" value="0"/>원 <br><br>
			<label style="color:red">*</label>포스터 <br>
			<input type="file" id="btnPoster" name="posterFile"/> <br>
			<img id="poster"/>

			<hr>

			<input type="submit" id="btn" value="전시등록"/>
		</form>
	</div>
</body>
</html>