<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="false" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Ticketing</title>
	<link rel="icon" href="/img/ticket.png">

	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>

<body>
	<div id="myCarousel" class="carousel slide" data-role="carousel">
		<ol class="carousel-indicators">
			<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
			<li data-target="#myCarousel" data-slide-to="1"></li>
			<li data-target="#myCarousel" data-slide-to="2"></li>
			<li data-target="#myCarousel" data-slide-to="3"></li>
		</ol>

		<center>
			<div class="carousel-inner" role="listbox">
				<div class="item active">
					<img src="/img/carousel01.jpg" style="heigth:100%"/>
				</div>
				<div class="item">
					<img src="/img/carousel02.jpg" style="heigth:100%"/>
				</div>
				<div class="item">
					<img src="/img/carousel03.jpg" style="heigth:100%"/>
				</div>
				<div class="item">
					<img src="/img/carousel04.jpg" style="heigth:100%"/>
				</div>
			</div>
		</center>

		<a href="#myCarousel" role="button" data-slide="prev" class="left carousel-control">
			<span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
			<span class="sr-only">Previous</span>
		</a>
		<a href="#myCarousel" role="button" data-slide="next" class="right carousel-control">
			<span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
			<span class="sr-only">Next</span>
		</a>
	</div>
</body>
</html>