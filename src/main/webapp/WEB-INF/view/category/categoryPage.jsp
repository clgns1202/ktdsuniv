<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<script type="text/javascript" src="<c:url value="/js/jquery-3.1.1.js"/>"></script>
<script type="text/javascript">

	$().ready(function() {
		
		$("#insertButton").click(function() {
			$.post("<c:url value="/category/doAddcategory"/>"
					, $("#categoryForm").serialize()
					, function(data) {
						for ( var i in data ) {
							var categoryList = $("<div class='categoryList' data-id='"+ data[i].id + "'></div>");
							categoryList.append($("<p>" + data[i].roomNumber + "</p>"));
							$("#categoryList").append(categoryList);
						}
					}
			);
		});
		
		
		
		
	});

</script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h3>Category management</h3>
	<hr/>
	
	<form id="categoryForm" name="categoryForm">
		
		<input type="text" id="categoryName" name="categoryName">
		<input type="button" id="insertButton" value="추가"/>
		<input type="button" id="deleteButton" value="삭제"/>
		<input type="button" id="updateButton" value="수정"/>
	
		<input type="hidden" id="selected_info" name="selected_info" />
		<input type="hidden" id="categoryId" name="categoryId" />

	</form>
	<div id="categoryList"></div>

</body>
</html>