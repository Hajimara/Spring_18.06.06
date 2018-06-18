<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>login</title>

<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<%-- <%@include file="../include/header.jsp"%> --%>
</head>

<body>
<%-- 	<%@include file="../include/nav.jsp"%> --%>
 

<br/><br/><br/><br/>
 
	 <form>
	ADDRESS<input type="text" name="userAddress" id="userAddress" />
	PW<input type="password" name="userPassword" id="userPassword" />
	<input class="btn btn-default" type="button" id="Login" value="로그인"/>
	<!-- <a href="/user/createUserp">회원가입</a>  -->
	<input class="btn btn-default" type="button" value="회원가입" id="Create" /> 
	<br/><br/><br/><br/>

	</form> 
	
<%-- <%@include file="../include/footer.jsp"%> --%>

<script type="text/javascript">
	$(function() {

		$("#userId").focus();

		$("#Login").on("click", function() {
					var id = $("input:text").val();
					var pw = $("input:password").val();

					console.log("check......!!")

					if (id == null || id.length < 1) {
						alert('ID 를 입력하지 않으셨습니다.');
						$("#userId").focus();
						return;
					}

					if (pw == null || pw.length < 1) {
						alert('패스워드를 입력하지 않으셨습니다.');
						$("#password").focus();
						return;
					}

					$("form").attr("method", "POST").attr("action",
							"/user/login").submit();
				});
		
		
	});

	$(function() {
		$("input:password").on('keydown', function(event) {

			if (event.keyCode == 13) {
				event.preventDefault();
				$("#Login").click();
			}

		})

	})
	
	function fncGetList(currentPage) {
		$("#currentPage").val(currentPage)
		$("form").attr("method" , "GET").attr("action" , "/main/mainModule").submit();
	}
	
	
	$(function(){
		
	$("#Create").on("click",function(){
		self.location="/user/createUserPage";	
	})
	})
	
	
	
	
	
	
</script>

</body>
</html>
