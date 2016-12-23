<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../common/header.jsp"></jsp:include>
<script type="text/javascript" src="<c:url value="/js/jquery-3.1.1.min.js"/>"></script>
<script type="text/javascript">
	$().ready(function(){
		$("#deleteBtn").click(function(){
			var selected = $(".users:checked").val();
			var checkCount =  $(".users:checked").length;
			if(checkCount > 0){
				$("#checkBoxForm").attr({
					"method": "post",
					"action": "<c:url value="/user/doDelete"/>"
				}).submit();
			}
		});
	});
</script>
</head>
<body>
	<table>
		<tr>
			<td></td>
			<td>아이디</td>
			<td>이름</td>
			<!-- <td>생년월일</td> -->
			<td>성별</td>
			<td>성적</td>
			<td>전화번호</td>
			<td>생성일</td>
			<td>수정일</td>
		</tr>
		<form id="checkBoxForm" name="checkBoxForm">
			<c:forEach items="${userList.pageList}" var="user" >
				<tr>	
					<td><input type="checkbox" name="users" class="users" value="${user.id}"></td>
					<td><a href="<c:url value="/user/detail/"/>${user.id}">${user.userId}</a></td>
					<td>${user.userName}</td>
					<%-- <td>${user.birthday}</td> --%>
					<td>${user.gender}</td>
					<td>${user.address}</td>
					<td>${user.phoneNumber}</td>
					<td>${user.createdDate}</td>
					<td>${user.modifiedDate}</td>
				</tr>
			</c:forEach>
		</form>
	</table>
		<input type="button" value="삭제" id="deleteBtn">
	<form name="searchForm" id="searchForm">
		${paging}
		<select name="searchType" id="searchType">
			<option value="1"${search.searchType eq 1 ? 'selected' : ''}>유저아이디</option>
			<option value="2"${search.searchType eq 2 ? 'selected' : ''}>유저이름</option>
		</select>
		<input type="text" name="searchKeyword" id="searchKeyword">
		<input type="button" id="searchBtn" value="검색" onclick="movePage(0)">
	</form>

<jsp:include page="../common/footer.jsp"></jsp:include>