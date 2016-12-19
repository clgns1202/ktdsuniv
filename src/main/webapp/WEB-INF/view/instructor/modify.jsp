<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../common/header.jsp"></jsp:include>
<script type="text/javascript" src="<c:url value="/js/jquery-3.1.1.min.js"/>"></script>
<script type="text/javascript">
	$().ready(function(){
		$("#modifyBtn").click(function(){
			if($("#userId").val() == ""){
				alert("아이디를 입력하세요");
				return;
			}
			if($("#userPassword").val()==""){
				alert("비밀번호를 입력하세요");
				return;
			}
			if($("#userName").val()==""){
				alert("이름을 입력하세요");
				return;
			}
			if($("#birthday").val()=="" || $("#gender").val()==""){
				alert("주민등록번호를 입력하세요");
				return;
			}
			if($("#phoneNumber").val()==""){
				alert("핸드폰번호를 입력하세요");
				return;
			}
			if($("#address").val()==""){
				alert("주소를 입력하세요");
				return;
			}
			if($("#agency").val()==""){
				alert("소속를 입력하세요");
				return;
			}
			
			if(confirm("수정하시겠습니까?")){
				$("#modifyForm").attr({
					"method": "post",
					"action": "<c:url value="/user/doModify"/>"
				}).submit();
			}
		});
	});
</script>
	<form id="modifyForm" name="modifyForm">
		아이디 : <input type="text" name="userId" id="userId" value="${instructor.user.userId}" /><br/>
		비밀번호 : <input type="password" name="userPassword" id="userPassword"/><br/>
		이름 : <input type="text" name="userName" id="userName" style="width: 100px;" value="${instructor.user.userName}" /><br/>
		주민번호 : <input type="text" name="birthday" id="birthday" style="width: 80px;" value="${instructor.user.birthday}"/> - <input type="text" name="gender" id="gender" style="width: 15px;" value="${instructor.user.gender}"/>* * * * * * ex) 1988-12-13<br/>
		핸드폰 : <input type="text" name="phoneNumber" id="phoneNumber" value="${instructor.user.phoneNumber}" /><br/>		
		주소 : <input type="text" name="address" id="address" style="width: 500px;" value="${instructor.user.address}"/><br/>	
		소속 : <input type="text" name="agency" id="agency" value="${instructor.agency}" /><br/><br/>	
		<input type="button" id="modifyBtn" value="수정" /><br/>
	</form>

<jsp:include page="../common/footer.jsp"></jsp:include>