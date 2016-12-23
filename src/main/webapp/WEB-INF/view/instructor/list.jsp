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
					"action": "<c:url value="/instructor/doDelete"/>"
				}).submit();
			}
		});
		
		$("#addBtn").click(function(){
			location.href="<c:url value="/instructor/instructorRegister"/>";
		});
	});
</script>
	<table>
		<tr>
			<td></td>
			<td>아이디</td>
			<td>이름</td>
			<!-- <td>생년월일</td> -->
			<td>성별</td>
			<td>성적</td>
			<td>전화번호</td>
			<td>소속</td>
			<td>생성일</td>
			<td>수정일</td>
		</tr>
		<form id="checkBoxForm" name="checkBoxForm">
			<c:forEach items="${instructorList.pageList}" var="instructor" >
				<tr>	
					<td><input type="checkbox" name="users" class="users" value="${instructor.id}"></td>
					<td><a href="<c:url value="/instructor/detail/"/>${instructor.id}">${instructor.user.userId}</a></td>
					<td>${instructor.user.userName}</td>
					<%-- <td>${instructor.user.birthday}</td> --%>
					<td>${instructor.user.gender}</td>
					<td>${instructor.user.address}</td>
					<td>${instructor.user.phoneNumber}</td>
					<td>${instructor.agency}</td>
					<td>${instructor.user.createdDate}</td>
					<td>${instructor.user.modifiedDate}</td>
				</tr>
			</c:forEach>
		</form>
	</table>
		<input type="button" value="등록" id="addBtn"/>
		<input type="button" value="삭제" id="deleteBtn">
	<form name="searchForm" id="searchForm">
		${paging}
		<select name="searchType" id="searchType">
			<option value="1"${search.searchType eq 1 ? 'selected' : ''}>강사아이디</option>
			<option value="2"${search.searchType eq 2 ? 'selected' : ''}>강사이름</option>
		</select>
		<input type="text" name="searchKeyword" id="searchKeyword">
		<input type="button" id="searchBtn" value="검색" onclick="movePage(0)">
	</form>

<jsp:include page="../common/footer.jsp"></jsp:include>