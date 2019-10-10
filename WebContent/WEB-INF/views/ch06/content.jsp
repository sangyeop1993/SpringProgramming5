<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<script type="text/javascript" src="<%=application.getContextPath()%>/resources/js/jquery-3.4.1.min.js"></script>
		<link rel="stylesheet" type="text/css" href="<%=application.getContextPath()%>/resources/bootstrap-4.3.1-dist/css/bootstrap.min.css">
		<script type="text/javascript" src="<%=application.getContextPath()%>/resources/bootstrap-4.3.1-dist/js/bootstrap.min.js"></script>
		<script>
			function btnLogin(){
				if($("#mid").val() == "") return false;
				if($("#mpassword").val() == "") return false;
				return true;
			}
			function btnLogout(){
				location.href = "logout";	
			}
		</script>
	</head>
	<body>
		<h5>[HttpSession을 이용해서 로그인 구현]</h5>
		<div>
			<c:if test="${loginResult != 'success'}">
				<form id="loginForm" method="post" action="login">
				  <div class="form-group">
				    <label for="mid">아이디</label>
				    <input type="text" class="form-control" id="mid" name="mid">
				    <c:if test="${loginResult == 'wrongMid'}">
				    	<span style="color:red;">로그인 아이디가 없습니다.</span>
				    </c:if>
				    
				  </div>
				  <div class="form-group">
				    <label for="mpassword">패스워드</label>
				    <input type="password" class="form-control" id="mpassword" name="mpassword">
				    <c:if test="${loginResult == 'wrongMpassword'}">
				    	<span style="color:red;">비밀번호가 틀립니다.</span>
				    </c:if>
				  </div>
				  <input onclick="return btnLogin()" type="submit" value="로그인" class="btn btn-primary"/>
				</form>	
			</c:if>
			
			<c:if test="${loginResult == 'success'}">
				<div id="logoutDiv">
					<input onclick="btnLogout()" type="submit" value="로그아웃" class="btn btn-danger"/>
				</div>
			</c:if>
		</div>
		
		<h5>[OutputStream을 이용해서 파일 다운로드 구현]</h5>
		<div>
			<a href="fileDownload?fname=Penguins.jpg">파일 다운로드</a>
		</div>
	</body>
</html>