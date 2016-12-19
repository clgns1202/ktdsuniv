<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script type="text/javascript"
	src="<c:url value="/striped/assets/js/jquery.min.js" />"></script>
<script type="text/javascript"
	src="<c:url value="/striped/assets/js/skel.min.js" />"></script>
<script type="text/javascript"
	src="<c:url value="/striped/assets/js/util.js" />"></script>
<script type="text/javascript"
	src="<c:url value="/striped/assets/js/main.js" />"></script>

<link rel="stylesheet"
	href="<c:url value="/striped/assets/css/main.css" />" />
	
<script type="text/javascript">
	$().ready(function(){
		
		$("#nav").on("click", "a", function(){
			$(this).addClass("current");
			
		});
		
	});
</script>

<title>Insert title here</title>
</head>
<body>

<div id="sidebar">

		<!-- Logo -->
		<h1 id="logo">
			<a href="#">STRIPED</a>
		</h1>

		<!-- Nav -->
		<nav id="nav">
		<ul>
			<li><a href="<c:url value="/room/roomList"/>">강의실 관리</a></li>
			<li><a href="<c:url value="/lecture/list"/>">강의 관리</a></li>
			<li><a href="<c:url value="/user/list"/>">회원 관리</a></li>
			<li><a href="<c:url value="/instructor/list"/>">강사 관리</a></li>
			<li><a href="<c:url value="/category/categoryPage"/>">카테고리 관리</a></li>
		</ul>
		</nav>
		<!-- class="current" -->

		<!-- Text -->
		<section class="box text-style1">
		<div class="inner">
			<p>
				<strong>Striped:</strong> A free and fully responsive HTML5 site
				template designed by <a href="http://twitter.com/ajlkn">AJ</a> for <a
					href="http://html5up.net/">HTML5 UP</a>
			</p>
		</div>
		</section>

		<!-- Copyright -->
		<ul id="copyright">
			<li>&copy; Untitled.</li>
			<li>Design: <a href="http://html5up.net">HTML5 UP</a></li>
		</ul>

	</div>


	<div id="content">
		<!-- <div class="inner">
			<article class="box post post-excerpt">
			<div class="info">
				<ul class="stats">
					<li><a href="#" class="icon fa-comment">16</a></li>
					<li><a href="#" class="icon fa-heart">32</a></li>
					<li><a href="#" class="icon fa-twitter">64</a></li>
					<li><a href="#" class="icon fa-facebook">128</a></li>
				</ul>
			</div>
			</article>
		</div> -->
	
	