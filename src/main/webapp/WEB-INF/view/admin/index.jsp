<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../common/header.jsp"></jsp:include>
<script type="text/javascript">
	
	$().ready(function(){
		
		$("#nav").on("click", "a", function(){
			var selected = $(this).attr("href").replace(/\#/g, '');
			$("#content").load("/AdminPage/"+selected);
		});
		
	});

</script>

	<div id="sidebar">

		<!-- Logo -->
		<h1 id="logo">
			<a href="#">STRIPED</a>
		</h1>

		<!-- Nav -->
		<nav id="nav">
		<ul>
			<li><a href="#/room/roomList">강의실 관리</a></li>
			<li><a href="#/lecture/list">강의 관리</a></li>
			<li><a href="#/user/list">회원 관리</a></li>
			<li><a href="#/instructor/list">강사 관리</a></li>
			<li><a href="#/category/categoryPage">카테고리 관리</a></li>
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
	</div>

<jsp:include page="../common/footer.jsp"></jsp:include>