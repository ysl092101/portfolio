<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="false" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Ticketing</title>
	<link rel="icon" href="/img/ticket.png">

	<link rel="stylesheet" href="https://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.css">
	<script src="https://code.jquery.com/jquery-1.11.1.min.js"></script>
	<script src="https://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	<script type="text/javascript">
		function 중복검사하기() {
			var txt아이디 = document.querySelector("#id");

			var 아이디P = /^[a-z0-9]{5,15}$/;

			if (txt아이디.value == "") {
				alert("아이디를 입력하세요.");
				location.reload();
				return false;
			}
			else if (아이디P.test(txt아이디.value) == false) {
				alert("아이디는 5~15자의 영문 소문자, 숫자만 사용 가능합니다.");
				location.reload();
				return false;
			}
			else {
				$.ajax({type : "POST",
						url : "/id",
						data : {id:txt아이디.value},
						success : function(data) {
							console.log(data);
							if (data == false) {
								alert("이미 사용 중인 아이디입니다.");
								location.reload();
								return false;
							}
							else {
								let 아이디 = txt아이디.value;
								opener.getId(아이디);
								close();
							}
						}
				});
			}
		}
	</script>
</head>

<body onresize="parent.resizeTo(500,400)" onload="parent.resizeTo(500,400)">
	<form onsubmit="return 중복검사하기()" action="/id" method="POST">
		<table>
			<tr>
				<td><input type="text" id="id" name="id" size="100" maxlength="15"/></td>
				<td><input type="submit" data-mini="true" value="중복검사"/></td>
			</tr>
		</table>
		<br><br>
		<div style="text-align:center">
			<p>아이디는 5~15자의 영문 소문자, 숫자만 사용 가능합니다.</p>
			<p>공백 또는 특수문자가 포함된 아이디는 사용할 수 없습니다.</p>
		</div>
	</form>
</body>
</html>