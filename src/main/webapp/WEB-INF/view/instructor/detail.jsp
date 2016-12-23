<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../common/header.jsp"></jsp:include>
<script type="text/javascript" src="<c:url value="/js/jquery-3.1.1.min.js"/>"></script>
<script type="text/javascript">
	$().ready(function(){
		$("#deleteBtn").click(function(){
			if(comfirm("정말로 삭제하시겠습니까?")){
				location.href="<c:url value="/instructor/doDelete/${instructor.id}"/>";
			}
		});
		$("#modifyBtn").click(function(){
			location.href="<c:url value="/instructor/modify/${instructor.id}"/>";
		});
	});
</script>
	<p>강사 디테일</p>
	아이디: ${instructor.user.userId}<br/>
	이름 :	${instructor.user.userName}<br/>
	<%-- 생년월일 : ${instructor.user.birthday}<br/> --%>
	성별 : 
	<c:choose>
		<c:when test="${instructor.user.gender eq 1 or instructor.user.gender eq 3}">
			남성
		</c:when>
		<c:otherwise>
			여성
		</c:otherwise>
	</c:choose> <br/>
	주소 : ${instructor.user.address}<br/>
	핸드폰 번호 : ${instructor.user.phoneNumber}<br/>
	소속 : ${instructor.agency}<br/>
	생성일 : ${instructor.user.createdDate}<br/>
	수정일 : ${instructor.user.modifiedDate}<br/>
	<input type="button" value="수정" id="modifyBtn">
	<input type="button" value="삭제" id="deleteBtn">
<jsp:include page="../common/footer.jsp"></jsp:include>