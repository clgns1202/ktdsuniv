<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<link rel="stylesheet" type="text/css" href="/AdminPage/css/decorateAdmin.css" />
<link rel="stylesheet" href="http://netdna.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>category</title>
</head>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script type="text/javascript" src="/AdminPage/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript">
	$().ready(function(){
		//카테고리 아이디를 설정한다.
		$("#categoryId").val("ctgr0");
		$("#parentId").val("ctgr0");
		$("#level").val("0");
		
		//카테고리 이름을 클릭했을 때 이벤트		
		$("#ctgr_content").on("click","li a", function(){
			//현재 태그의 부모(li)의 id를 가져온다.
			clickedText=$(this).parents().attr("id");
			
			//hidden input의 value에 id를 넣는다.
			$("#parentId").val(clickedText);
			//hidden input의 value에 이름을 넣는다.
			//$("#selected_info").val($(this).text());
			$("#level").val($(this).siblings(".level").val());
			
			console.log("click한 데이터 : "+clickedText);			
 			console.log("form으로 전달할 데이터 : "+$("#parentId").val());
			
 			//선택된 앵커 태그에 클래스를 추가한다. 			
			if (!$(this).hasClass("selected")){				
				//클릭한 앵커 태그만 클래스가 추가되어야 하기 때문에 나머지 모든 태그는 클래스를 제거한다.
				$("#ctgr_content a").removeClass("selected");
				//선택한 태그에 클래스 추가
				$(this).addClass("selected");
			}	
			else {
				//selected 클래스를 가졌다면 클래스를 제거한다.
				$(this).removeClass("selected");
			}
		});
		
		//추가버튼 이벤트
		$("#ctgr_title").on("click", "#addBtn", function(){
			if($("#ctgr_input").val() != ""){
				$.post( "<c:url value="/category/doAddCategory"/>"
						,$("#categoryForm").serialize()
						,function(data){
							var categoryId = $("#"+data.parentId);
							if (categoryId.text() == "0") {
								console.log("123");
								categoryId.append("<ul><li id='"+data.id+"'><a href='javascript:addCategory("+data.id+");'>"+data.categoryName+"</a></li></ul>");
							}
							else if (categoryId.find("ul")) {
								/* <input type="hidden" class="level" value='"+data.level+"'> */
								var level = data.level;
								console.log(level);
								categoryId.children("ul").append("<li id='"+data.id+"'><input type='hidden' class='level' value='"+level+"'><a href='javascritp:void(0);'>"+data.categoryName+"</a></li>");
								/* categoryId.children("ul").append("<li id='"+data.id+"'><a href='javascript:addCategory("+data.id+");'>"+data.categoryName+"</a></li>"); */
							}
							else {
								console.log("789");
								categoryId.append("<ul><li id='"+data.id+"'><a href='javascript:addCategory("+data.id+");'>"+data.categoryName+"</a></li></ul>");							
							}
								
							//추가와 동시에 효과도 추가한다.
							if(!categoryId.hasClass("hasSubmenu")){
								categoryId.prepend("<a href='javascript:void(0);'><i class='fa fa-minus-circle'></i><i style='display:none;' class='fa fa-plus-circle'></i></a>");
								categoryId.children("a").not(":last").removeClass().addClass("toogle");
							}
							categoryId.addClass("hasSubmenu");
							categoryId.children("ul").css("border-left", "1px dashed #cccccc");
							categoryId.mouseenter(function(){
								$(this).children("a").css({"font-weight":"bold","color":"#336b9b"});
							});
									
							categoryId.mouseleave(function(){
								$(this).children("a").css({"font-weight":"normal","color":"#428bca"});
							});
									
							$("#ctgr_content ul li.hasSubmenu a.toogle").click(function(){
								// 클릭하면 하위 ul은 toggle 효과를 준다.
								$(this).closest("li").children("ul").toggle("slow");
								//toogle 클래스가 추가된 a 태그의 하위 i태그에 toggle효과를 준다.
								$(this).children("i").toggle();
								return false;
							});	
				});
			}
			else{
				alert("카테고리 이름을 입력해주세요.");				
			}
		});
		
		//수정버튼 이벤트
		$("#ctgr_title").on("click", "#modifyBtn", function(){
			var categoryId = $("#parentId");
			if($("#ctgr_input").val()!=""){
				$.post( "<c:url value="/category/doUpdateCategory/"/>"+categoryId.val()
						,$("#categoryForm").serialize()
						,function(data){
								var categoryId = $("#"+data.id);
									categoryId.find("a").eq(1).text(data.categoryName);
									categoryId.children("a:nth-child(2)").text($("#ctgr_input").val());
						});
			}
			else if($("#parentId").val()==""){
				alert("수정할 파일을 선택해주세요.");
			}
			else{
				alert("수정할 이름을 입력해주세요.");				
			}
		});
		
		//삭제버튼 이벤트
		$("#ctgr_title").on("click", "#deleteBtn", function(){
			var categoryId = $("#parentId");
			var grandParent = $("#parentId").parent().parent();
			if($("#parentId").val() != ""){
				$.post( "<c:url value="/category/doDeleteCategory/"/>"+categoryId.val()
					, $("#categoryForm").serialize()
					, function(data){
						if(data!=false){
							if( confirm("정말 삭제하시겠습니까?" )){
								grandParent.addClass("the node child was deleted");
								$("#"+data.parentId).remove();
								var count = grandParent.children("ul").children("li").length;
								if(count==0){
									grandParent.children("a").children("i").remove();
								}
							}
						}
						else{
							alert("하위 파일이 있으면 삭제할 수 없습니다.");
						}
				});
			}
			else{
				alert("삭제할 파일을 선택해주세요.");				
			}
		});
		
		setTreeGrid();
		
	});
	function setTreeGrid(){
		//전체 리스트에서 ul을 가지고 있는 li에 클래스를 추가한다
		//ul 왼쪽 대쉬 보더를 준다.
		$("#ctgr_content ul").each(function(){
			$(this).find("li").has("ul").addClass("hasSubmenu");
			$(this).closest("ul").css("border-left", "1px dashed #cccccc");
		});
		
		//li에 굵기를 준다.
		$("#ctgr_content ul li").each(function(){
			$(this).mouseenter(function(){
				$(this).children("a").css({"font-weight":"bold","color":"#336b9b"});
		  	});
			
			$(this).mouseleave(function(){
				$(this).children("a").css({"font-weight":"normal","color":"#428bca"});
		  	});
		});
		
		// hasSubmenu 클래스를 가지고 있는 태그에 prepend한다.
		$("#ctgr_content ul li.hasSubmenu").each(function(){
			//마이너스 이미지와 플러스 이미지를 추가한다.
			$(this).prepend("<a href='javascript:void(0);'><i class='fa fa-minus-circle'></i><i style='display:none;' class='fa fa-plus-circle'></i></a>");
			$(this).children("a").not(":last").removeClass().addClass("toogle");
		});
		
		//a 태그를 클릭했을 때 이벤트
		$("#ctgr_content ul li.hasSubmenu a.toogle").click(function(){
			// 클릭하면 하위 ul은 toggle 효과를 준다.
			$(this).closest("li").children("ul").toggle("slow");
			//toogle 클래스가 추가된 a 태그의 하위 i태그에 toggle효과를 준다.
			$(this).children("i").toggle();
		 	return false;
		});
	}
	
	function addCategory(categoryId){
		//li가 id를 가진다.
		var category = $("#ctgr"+categoryId);
		
		$("#categoryId").val("ctgr"+categoryId);
		$("#parentId").val(category.text());
		
		console.log("click한 데이터 : "+clickedText);			
		console.log("form으로 전달할 데이터 : "+$("#selected_info").val());
		//선택된 태그에 클래스를 표시한다. 			
	
		if (!category.hasClass("selected")){				
			//$(this).closest("li").children("ul").slideDown();
			$("#ctgr_content a").removeClass("selected");
			category.children("a").addClass("selected");
		}	
		else {
			//$(this).closest("li").children("ul").slideUp();
			category.children("a").removeClass("selected");
		}
	}
</script>
<body>
	<h3>카테고리관리</h3>

	<form id="categoryForm" name="categoryForm">
		<div id="ctgr_view">
			<div id="ctgr_title">
				<div class="left">카테고리 미리보기</div>
				<div class="right">
					<input type="text" id="ctgr_input" name="categoryName">
					<input type="button" id="addBtn" value="추가"/>
					<input type="button" id="modifyBtn" value="수정"/>
					<input type="button" id="deleteBtn" value="삭제"/>
				</div>
				<div class="clear"></div>
			</div>
		
		<input type="text" id="parentId" name="parentId">
		<!-- name:<input type="text" id="selected_info" name="selected_info"> -->
		<input type="text" id= "level" name="level">
		<!-- cateId:<input type="text" id="categoryId" name="categoryId"> -->
	</form>
	<!-- 이전 레벨과 현재 레벨이 다를 경우 ul -->
	<div id="ctgr_content" >
	<ul id='start_tree'>
		<li id='ctgr0'><input type="hidden" class="level" value="0"><a href='javascript:void(0);'>ROOT</a>
		<c:set var='pr' value='0' />
		<c:forEach items='${categories }' var='category' >
 	
			<c:set var='nr' value='${category.level }' />
				<c:choose>
				<c:when test='${pr lt nr }'>
					<ul><li id='${category.id }'><input type="hidden" class="level" value="${category.level }"><a href='javascript:void(0);'>${category.categoryName}</a></c:when>
				<c:when test='${pr gt nr }'>
					<c:forEach begin='1' end='${pr-nr }' step='1'>
						</li></ul>
					</c:forEach>
					<li id='${category.id }'><input type="hidden" class="level" value="${category.level }"><a href='javascript:void(0);'>${category.categoryName}</a></c:when>
					<c:otherwise>
					</li>
					<li id='${category.id }'><input type="hidden" class="level" value="${category.level }"><a href='javascript:void(0);'>${category.categoryName}</a></c:otherwise>
			</c:choose>
				<c:set var='pr' value='${nr}'/>
		</c:forEach>
		</li>
	</ul>
	</div>
	</div>
</body>
</html>